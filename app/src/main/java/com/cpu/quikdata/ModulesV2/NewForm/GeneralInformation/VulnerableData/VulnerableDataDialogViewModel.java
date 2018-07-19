package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.VulnerableData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.VulnerableDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelSingleNumber;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;

public class VulnerableDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, VulnerableDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     * @param rowIndex
     */
    public VulnerableDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    /**
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(VulnerableDataRow data) {
        mRow = data;
        mType = GenericEnumDataRow.AgeGroup.valueOf(mRow.getAgeGroup());

        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(new QuestionItemModelSingleNumber("Pregnant Women", mRow.getPregnant())));
        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(new QuestionItemModelSingleNumber("Lactating Mothers", mRow.getLactating())));
        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(new QuestionItemModelSingleNumber("LGBT", mRow.getLgbt())));
        mQuestions.add(new TemplateQuestionItemViewModelSingleNumber(new QuestionItemModelSingleNumber("Female-Headed Households", mRow.getFemaleHeadedHouseholds())));
        mQuestions.add(new TemplateQuestionItemViewModelGenderTuple(new QuestionItemModelGenderTuple("Child Headed Households", mRow.getChildHeadedHouseholdsMale(), mRow.getChildHeadedHouseholdsFemale())));
        mQuestions.add(new TemplateQuestionItemViewModelGenderTuple(new QuestionItemModelGenderTuple("Indigenous People", mRow.getIndigenousMale(), mRow.getIndigenousFemale())));
        mQuestions.add(new TemplateQuestionItemViewModelGenderTuple(new QuestionItemModelGenderTuple("Disabled", mRow.getDisabledMale(), mRow.getDisabledFemale())));
        mQuestions.add(new TemplateQuestionItemViewModelString(new QuestionItemModelString("Remarks", mRow.getRemarks())));

    }

    @Override
    public void navigateOnOkButtonPressed() {
        if (mRowIndex == -1) mRow.setId(AppUtil.generateId());

        mRow.setPregnant(((QuestionItemModelSingleNumber) mQuestions.get(0).getModel()).getValue());
        mRow.setLactating(((QuestionItemModelSingleNumber) mQuestions.get(1).getModel()).getValue());
        mRow.setLgbt(((QuestionItemModelSingleNumber) mQuestions.get(2).getModel()).getValue());
        mRow.setFemaleHeadedHouseholds(((QuestionItemModelSingleNumber) mQuestions.get(3).getModel()).getValue());

        QuestionItemModelGenderTuple childHeadedVM = (QuestionItemModelGenderTuple) mQuestions.get(4).getModel();
        mRow.setChildHeadedHouseholdsMale(childHeadedVM.getMale());
        mRow.setChildHeadedHouseholdsFemale(childHeadedVM.getFemale());

        QuestionItemModelGenderTuple indigenousVM = (QuestionItemModelGenderTuple) mQuestions.get(4).getModel();
        mRow.setIndigenousMale(indigenousVM.getMale());
        mRow.setIndigenousFemale(indigenousVM.getFemale());

        QuestionItemModelGenderTuple disabledVM = (QuestionItemModelGenderTuple) mQuestions.get(4).getModel();
        mRow.setDisabledMale(disabledVM.getMale());
        mRow.setDisabledFemale(disabledVM.getFemale());

        mDataManager.saveRow(mRow);
    }
}
