package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

import java.util.List;

public class PopulationDataDialogViewModel extends TemplateEnumDataDialogViewModel<IEnumDataManager, PopulationDataRow, GenericEnumDataRow.AgeGroup> {

    private PopulationDataRow mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataDialogViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    @Override
    public void setActivity(IEnumDataManager activity) {
        super.setActivity(activity);
        if (mActivity.get() != null) {
            mActivity.get().getNewRow(this);
        }
    }

    /**
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(PopulationDataRow data) {
        mRow = data;
        mType = GenericEnumDataRow.AgeGroup.valueOf(mRow.getAgeGroup());

        mQuestions.add(new QuestionItemModelGenderTuple("Affected", mRow.getAffectedMale(), mRow.getAffectedFemale()));
        mQuestions.add(new QuestionItemModelGenderTuple("Displaced", mRow.getAffectedMale(), mRow.getAffectedFemale()));
    }

    /**
     * Handles navigation when OK button is pressed
     */
    @Override
    public void navigateOnOkButtonPressed() {
        List<TemplateQuestionItemViewModel> itemViewModels = mAdapter.getItemViewModels();
        mRow.setId(AppUtil.generateId());

        QuestionItemModelGenderTuple affectedVM = (QuestionItemModelGenderTuple) itemViewModels.get(0).getModel();
        mRow.setAffectedMale(affectedVM.getMale());
        mRow.setAffectedFemale(affectedVM.getFemale());

        QuestionItemModelGenderTuple displacedVM = (QuestionItemModelGenderTuple) itemViewModels.get(1).getModel();
        mRow.setDisplacedMale(displacedVM.getMale());
        mRow.setDisplacedFemale(displacedVM.getFemale());

        if (mActivity.get() != null) {
            mActivity.get().saveRow(mRow);
        }
    }
}
