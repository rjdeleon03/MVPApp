package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rjdeleon.mvp_app.Models.Generics.GenericEnumDataRow;
import com.rjdeleon.mvp_app.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.DamageCostRepositoryManager;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox.DamageCostCheckboxParentViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.Checkbox.DamageCostCheckboxViewModel;

import java.util.ArrayList;
import java.util.List;

public class DamageCostDialogViewModel extends BaseEnumDialogViewModel implements DamageCostCheckboxParentViewModel {

    private DamageCostRepositoryManager mDamageCostRepositoryManager;

    private List<DamageCostCheckboxViewModel> mCheckboxViewModels;
    private List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> mAffectedLivelihoods = new ArrayList<>();
    public final ObservableInt damageCost = new ObservableInt(0);
    public final ObservableField<String> remarks = new ObservableField<>("");

    /**
     * Constructor
     *
     * @param context
     */
    public DamageCostDialogViewModel(Context context,
                                     DamageCostRepositoryManager damageCostRepositoryManager,
                                     int livelihoodsTypeIndex,
                                     boolean isNewRow) {
        super(context);
        mDamageCostRepositoryManager = damageCostRepositoryManager;

        LivelihoodsDamageDataRow damageDataRow;
        if (isNewRow) {
            damageDataRow = new LivelihoodsDamageDataRow(mDamageCostRepositoryManager.getLivelihoodsType(livelihoodsTypeIndex));
        } else {
            damageDataRow = mDamageCostRepositoryManager.getLivelihoodsDamageRow(livelihoodsTypeIndex);
        }
        type.set(damageDataRow.getType());
        damageCost.set(damageDataRow.getDamageCost());
        remarks.set(damageDataRow.getRemarks());
        mAffectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());

        mCheckboxViewModels = new ArrayList<>();
        for(LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple affectedLivelihood : mAffectedLivelihoods) {
            mCheckboxViewModels.add(new DamageCostCheckboxViewModel(affectedLivelihood));
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
        mDamageCostRepositoryManager.addLivelihoodsDamageRow(damageDataRow);
        super.navigateOnOkButtonPressed();
    }

    /**
     * Gets the affected livelihoods at the specified index
     * @param index
     * @return
     */
    @Override
    public DamageCostCheckboxViewModel getAffectedLivelihoodViewModel(int index) {
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
