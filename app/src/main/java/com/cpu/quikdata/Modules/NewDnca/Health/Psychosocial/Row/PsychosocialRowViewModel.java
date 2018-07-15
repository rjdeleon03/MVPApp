package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row;

import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;

public class PsychosocialRowViewModel extends RowViewModel {

    private String[] mQuestions = {
            "Manifestations of Mental Stress or Trauma",
            "Cases",
            "Needs"
    };

    /**
     * Generates new instance
     * @return
     */
    public static PsychosocialRowViewModel newInstance() {
        return new PsychosocialRowViewModel();
    }

    /**
     * Constructor
     * @return
     */
    public PsychosocialRowViewModel() {
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

        PsychosocialDataRow psychosocialDataRow = (PsychosocialDataRow) mRepositoryManager.getRow(rowIndex);
        type.set(psychosocialDataRow.getType());

        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[0], psychosocialDataRow.getManifestations())));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(new DialogItemModelGenderTuple(mQuestions[1], psychosocialDataRow.getCases().male, psychosocialDataRow.getCases().female)));
        mItemViewModels.add(new DialogItemViewModelRemarks(new DialogItemModelRemarks(mQuestions[2], psychosocialDataRow.getNeeds())));
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
