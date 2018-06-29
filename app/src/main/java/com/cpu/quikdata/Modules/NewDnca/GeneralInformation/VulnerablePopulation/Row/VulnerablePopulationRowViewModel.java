package com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.Row;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.RowViewModel;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.VulnerablePopulation.VulnerablePopulationRepositoryManager;

public class VulnerablePopulationRowViewModel extends RowViewModel implements DialogItemDataSource {

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

    /**
     * Constructor
     * @param vulnerablePopulationRepositoryManager
     * @param baseEnumNavigator
     * @param rowIndex
     */
    public VulnerablePopulationRowViewModel(VulnerablePopulationRepositoryManager vulnerablePopulationRepositoryManager,
                                            BaseEnumNavigator baseEnumNavigator,
                                            int rowIndex) {

        super(baseEnumNavigator, rowIndex);
        mVulnerablePopulationRepositoryManager = vulnerablePopulationRepositoryManager;

        VulnerablePopulationDataRow vulnerablePopulationDataRow = mVulnerablePopulationRepositoryManager.getVulnerablePopulationRow(mRowIndex);
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
                new DialogItemModelGenderTuple(mQuestions[4], vulnerablePopulationDataRow.getChildHeadedHouseholds().male, vulnerablePopulationDataRow.getChildHeadedHouseholds().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[5], vulnerablePopulationDataRow.getIndigenous().male, vulnerablePopulationDataRow.getIndigenous().female)));
        mItemViewModels.add(new DialogItemViewModelGenderTuple(
                new DialogItemModelGenderTuple(mQuestions[6], vulnerablePopulationDataRow.getDisabled().male, vulnerablePopulationDataRow.getDisabled().female)));
        mItemViewModels.add(new DialogItemViewModelRemarks(
                new DialogItemModelRemarks(mQuestions[7], vulnerablePopulationDataRow.getRemarks())));

        // TODO: Set visibility of fields such as pregnant, lactating, and lgbt, remarks (if empty)
//        shouldShowOtherFields.set(type.get().getOrdinal() >= GenericEnumDataRow.AgeGroup.AGE_10_12.getOrdinal());
//        shouldShowRemarks.set(remarks.get().trim().length() > 0);
    }

    /**
     * Handle navigation when card is deleted
     */
    @Override
    public void navigateOnDeleteCardButtonPressed() {
        mVulnerablePopulationRepositoryManager.deleteVulnerablePopulationRow(mRowIndex);
        super.navigateOnDeleteCardButtonPressed();
    }
}
