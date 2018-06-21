package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public class LivelihoodsDamageDialogViewModel extends DialogViewModel {

    private LivelihoodsDamageRepositoryManager mLivelihoodsDamageRepositoryManager;
    private List<LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple> mAffectedLivelihoods = new ArrayList<>();

    private String[] mQuestions = {
            "Kinds of Affected Livelihoods",
            "Estimated Damage Cost (PHP)",
            "Remarks"
    };

    private String[] mComments = {
            "(Number of hectares damaged, lost assets, equipment, number of days not able to go back to work, etc)"
    };

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

        mAffectedLivelihoods.addAll(damageDataRow.getAffectedLivelihoods());
        type.set(damageDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRecycler(
                new DialogItemModelRecycler(mQuestions[0], damageDataRow.getAffectedLivelihoods())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], damageDataRow.getDamageCost(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[2], mComments[0], damageDataRow.getRemarks())));

    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {

        // Update affected livelihoods
        DialogItemViewModelRecycler affectedLivelihoods = (DialogItemViewModelRecycler) mItemViewModels.get(0);
        for (int i = 0; i < mAffectedLivelihoods.size(); i++) {
            mAffectedLivelihoods.get(i).isAffected = affectedLivelihoods.getAffectedLivelihoodViewModel(i).isAffected.get();
        }

        // Save row
        LivelihoodsDamageDataRow damageDataRow = new LivelihoodsDamageDataRow(
                (GenericEnumDataRow.LivelihoodsType) type.get(),
                mAffectedLivelihoods,
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelRemarks) mItemViewModels.get(2)).value1.get());

        mLivelihoodsDamageRepositoryManager.addLivelihoodsDamageRow(damageDataRow);
        super.navigateOnOkButtonPressed();
    }
}
