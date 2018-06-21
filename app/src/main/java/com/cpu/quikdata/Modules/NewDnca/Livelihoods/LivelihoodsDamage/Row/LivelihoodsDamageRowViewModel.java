package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Row.BaseEnumRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.RowViewModel;
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
     * @param context
     * @param livelihoodsDamageRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public LivelihoodsDamageRowViewModel(Context context,
                                         LivelihoodsDamageRepositoryManager livelihoodsDamageRepositoryManager,
                                         BaseEnumNavigator baseEnumNavigator,
                                         int rowIndex) {
        super(context, baseEnumNavigator, rowIndex);
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
