package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class PopulationDataDialogViewModel extends TemplateEnumDataDialogViewModel<IPopulationDataManager, PopulationDataRow> {

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
    public void setActivity(IPopulationDataManager activity) {
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

        mQuestions.add(new QuestionItemModelGenderTuple("Affected", mRow.getAffectedMale(), mRow.getAffectedFemale()));
        mQuestions.add(new QuestionItemModelGenderTuple("Displaced", mRow.getAffectedMale(), mRow.getAffectedFemale()));
    }
}
