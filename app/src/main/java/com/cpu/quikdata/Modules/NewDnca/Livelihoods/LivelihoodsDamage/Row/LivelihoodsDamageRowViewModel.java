package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row;

import android.content.Context;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.LivelihoodsDamageRepositoryManager;

public class LivelihoodsDamageRowViewModel extends RowViewModel {

    private LivelihoodsDamageRepositoryManager mLivelihoodsDamageRepositoryManager;

    private String[] mQuestions = {
            "Kinds of Affected Livelihoods",
            "Estimated Damage Cost (PHP)",
            "Remarks"
    };

    /**
     * Constructor
     * @param livelihoodsDamageRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public LivelihoodsDamageRowViewModel(LivelihoodsDamageRepositoryManager livelihoodsDamageRepositoryManager,
                                         BaseEnumNavigator baseEnumNavigator,
                                         int rowIndex) {
        super(baseEnumNavigator, rowIndex);
        mLivelihoodsDamageRepositoryManager = livelihoodsDamageRepositoryManager;

        LivelihoodsDamageDataRow damageDataRow = mLivelihoodsDamageRepositoryManager.getLivelihoodsDamageRow(rowIndex);
        type.set(damageDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[0], damageDataRow.getAffectedLivelihoodsString())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], damageDataRow.getDamageCost(), true)));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[2], damageDataRow.getRemarks())));

        // TODO: Hide remarks if empty
//        shouldShowRemarks.set(remarks.get().trim().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mLivelihoodsDamageRepositoryManager.deleteLivelihoodsDamageRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
