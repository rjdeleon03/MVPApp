package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class PopulationDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, PopulationDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<PopulationDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    /**
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(PopulationDataRow data) {
        mRow = data;
        mType = mRow.getActualType();

        mDataManager.generateQuestions(mQuestions, mRow);
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        if (mRowIndex == -1) mRow.setId(AppUtil.generateId());

        QuestionItemModelGenderTuple affectedVM = (QuestionItemModelGenderTuple) mQuestions.get(0).getModel();
        mRow.setAffectedMale(affectedVM.getMale());
        mRow.setAffectedFemale(affectedVM.getFemale());

        QuestionItemModelGenderTuple displacedVM = (QuestionItemModelGenderTuple) mQuestions.get(1).getModel();
        mRow.setDisplacedMale(displacedVM.getMale());
        mRow.setDisplacedFemale(displacedVM.getFemale());

        mDataManager.saveRow(mRow);
    }
}
