package com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.CasualtiesData;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Form.GeneralInformation.CasualtiesDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelGenderTuple;

public class CasualtiesDataDialogViewModel
        extends TemplateEnumDataDialogViewModel<ITemplateEnumDataFragment, CasualtiesDataRow, GenericEnumDataRow.AgeGroup, ITemplateEnumDataManager<CasualtiesDataRow>> {


    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public CasualtiesDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository, rowIndex);
    }

    /**
     * Handles reception of death cause data row
     * @param data
     */
    @Override
    public void onDataReceived(CasualtiesDataRow data) {
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

        for(TemplateQuestionItemViewModel model : mQuestions) {
            model.updateModel();
        }

        mDataManager.saveRow(mRow);
    }
}
