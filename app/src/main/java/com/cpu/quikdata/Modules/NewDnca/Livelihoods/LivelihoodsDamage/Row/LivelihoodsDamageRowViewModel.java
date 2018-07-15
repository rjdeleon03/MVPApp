package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class LivelihoodsDamageRowViewModel extends RowViewModel implements DialogItemDataSource {

    private String[] mQuestions = {
            "Kinds of Affected Livelihoods",
            "Estimated Damage Cost (PHP)",
            "Remarks"
    };

    /**
     * Generates new instance
     * @return
     */
    public static LivelihoodsDamageRowViewModel newInstance() {
        return new LivelihoodsDamageRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public LivelihoodsDamageRowViewModel() {
        super();
    }

    /**
     * Sets the relevant variables to obtain data row
     * @param baseEnumNavigator
     * @param repositoryManager
     * @param rowIndex
     */
    @Override
    public void setData(BaseEnumNavigator baseEnumNavigator, BaseEnumRepositoryManager repositoryManager, int rowIndex) {
        super.setData(baseEnumNavigator, repositoryManager, rowIndex);

        LivelihoodsDamageDataRow damageDataRow = (LivelihoodsDamageDataRow) mRepositoryManager.getRow(rowIndex);
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
        mRepositoryManager.deleteRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
