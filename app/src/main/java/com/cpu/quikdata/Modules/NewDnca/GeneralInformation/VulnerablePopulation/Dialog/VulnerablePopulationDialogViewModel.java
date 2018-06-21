package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Dialog;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public class VulnerablePopulationDialogViewModel extends DialogViewModel {

    private VulnerablePopulationRepositoryManager mVulnerablePopulationRepositoryManager;

    private String[] mQuestions = {
            "Pregnant Women",
            "Lactating Mothers",
            "LGBT",
            "Female-headed Households",
            "Child-headed Households",
            "Indigenous People",
            "Persons with Disabilities",
            "Remarks"
    };

    private String[] mComments = {
            "(Specify conditions; e.g. unable to go back to school)"
    };

    /**
     * Constructor
     * @param context
     * @param vulnerablePopulationRepositoryManager
     * @param ageGroupIndex
     * @param isNewRow
     */
    public VulnerablePopulationDialogViewModel(Context context,
                                               VulnerablePopulationRepositoryManager vulnerablePopulationRepositoryManager,
                                               int ageGroupIndex,
                                               boolean isNewRow) {

        super(context);
        mVulnerablePopulationRepositoryManager = vulnerablePopulationRepositoryManager;

        VulnerablePopulationDataRow vulnerablePopulationDataRow;
        if (isNewRow) {
            vulnerablePopulationDataRow = new VulnerablePopulationDataRow(mVulnerablePopulationRepositoryManager.getVulnerablePopulationAgeGroup(ageGroupIndex));
        } else {
            vulnerablePopulationDataRow = mVulnerablePopulationRepositoryManager.getVulnerablePopulationRow(ageGroupIndex);
        }

        type.set(vulnerablePopulationDataRow.getType());
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[0], vulnerablePopulationDataRow.getPregnant())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[1], vulnerablePopulationDataRow.getLactating())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[2], vulnerablePopulationDataRow.getLgbt())));
        mItemViewModels.add(new DialogItemViewModelSingleNumber(
                new DialogItemModelSingleNumber(mQuestions[3], vulnerablePopulationDataRow.getFemaleHeadedHouseholds())));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[4],
                        vulnerablePopulationDataRow.getChildHeadedHouseholds().male,
                        vulnerablePopulationDataRow.getChildHeadedHouseholds().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[5],
                        vulnerablePopulationDataRow.getIndigenous().male,
                        vulnerablePopulationDataRow.getIndigenous().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[6],
                        vulnerablePopulationDataRow.getDisabled().male,
                        vulnerablePopulationDataRow.getDisabled().female)));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[7], mComments[0], vulnerablePopulationDataRow.getRemarks())));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        DialogItemViewModelGenderTuple childHeadedHouseholds = (DialogItemViewModelGenderTuple)mItemViewModels.get(4);
        DialogItemViewModelGenderTuple indigenous = (DialogItemViewModelGenderTuple)mItemViewModels.get(5);
        DialogItemViewModelGenderTuple disabled = (DialogItemViewModelGenderTuple)mItemViewModels.get(6);

        VulnerablePopulationDataRow vulnerablePopulationDataRow = new VulnerablePopulationDataRow(
                (GenericEnumDataRow.AgeGroup) type.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(0)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(1)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(2)).value1.get(),
                ((DialogItemViewModelSingleNumber) mItemViewModels.get(3)).value1.get(),
                new GenderTuple(childHeadedHouseholds.value1.get(), childHeadedHouseholds.value2.get()),
                new GenderTuple(indigenous.value1.get(), indigenous.value2.get()),
                new GenderTuple(disabled.value1.get(), disabled.value2.get()),
                ((DialogItemViewModelRemarks) mItemViewModels.get(7)).value1.get()
        );
        mVulnerablePopulationRepositoryManager.addVulnerablePopulationRow(vulnerablePopulationDataRow);
        super.navigateOnOkButtonPressed();
    }
}
