package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.PopulationData;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Row.TemplateEnumDataRowViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelGenderTuple;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class PopulationDataRowViewModel
        extends TemplateEnumDataRowViewModel<ITemplateEnumDataFragment, PopulationDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<PopulationDataRow>> {

    private PopulationDataRow mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public PopulationDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    /**
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(PopulationDataRow data) {
        mRow = data;
        mType = GenericEnumDataRow.AgeGroup.valueOf(mRow.getAgeGroup());

        mDataManager.generateQuestions(mQuestions, mRow);
    }
}
