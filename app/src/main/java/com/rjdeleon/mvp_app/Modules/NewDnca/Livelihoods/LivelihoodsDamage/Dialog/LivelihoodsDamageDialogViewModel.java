package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageRepositoryManager;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxParentViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxViewModel;

import java.util.ArrayList;
import java.util.List;

public class LivelihoodsDamageDialogViewModel extends BaseEnumDialogViewModel implements LivelihoodsDamageCheckboxParentViewModel {

    private LivelihoodsDamageRepositoryManager mLivelihoodsDamageRepositoryManager;

    private List<LivelihoodsDamageCheckboxViewModel> mCheckboxViewModels;
    private List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> mAffectedLivelihoods = new ArrayList<>();
    public final ObservableInt damageCost = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     *
     * @param context
     */
    public LivelihoodsDamageDialogViewModel(Context context,
                                            LivelihoodsDamageRepositoryManager livelihoodsDamageRepositoryManager,
                                            int livelihoodsTypeIndex,
                                            boolean isNewRow) {
        super(context);
        mLivelihoodsDamageRepositoryManager = livelihoodsDamageRepositoryManager;

        LivelihoodsDamageDataRow damageDataRow;
        if (isNewRow) {
            damageDataRow = new LivelihoodsDamageDataRow(mLivelihoodsDamageRepositoryManager.getLivelihoodsType(livelihoodsTypeIndex));
        } else {
            damageDataRow = mLivelihoodsDamageRepositoryManager.getLivelihoodsDamageRow(livelihoodsTypeIndex);
        }
        type.set(damageDataRow.getType());
        damageCost.set(damageDataRow.getDamageCost());
        remarks.set(damageDataRow.getRemarks());
        mAffectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());

        mCheckboxViewModels = new ArrayList<>();
        for(LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple affectedLivelihood : mAffectedLivelihoods) {
            mCheckboxViewModels.add(new LivelihoodsDamageCheckboxViewModel(affectedLivelihood));
        }
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {

        // Update affected livelihoods
        for (int i = 0; i < mAffectedLivelihoods.size(); i++) {
            mAffectedLivelihoods.get(i).isAffected = mCheckboxViewModels.get(i).isAffected.get();
        }

        LivelihoodsDamageDataRow damageDataRow = new LivelihoodsDamageDataRow(
                (GenericEnumDataRow.LivelihoodsType) type.get(),
                mAffectedLivelihoods,
                damageCost.get(),
                remarks.get());
        mLivelihoodsDamageRepositoryManager.addLivelihoodsDamageRow(damageDataRow);
        super.navigateOnOkButtonPressed();
    }

    /**
     * Gets the affected livelihoods at the specified index
     * @param index
     * @return
     */
    @Override
    public LivelihoodsDamageCheckboxViewModel getAffectedLivelihoodViewModel(int index) {
        return mCheckboxViewModels.get(index);
    }

    /**
     * Gets the number of affected livelihoods
     * @return
     */
    @Override
    public int getAffectedLivelihoodsCount() {
        return mAffectedLivelihoods.size();
    }
}
