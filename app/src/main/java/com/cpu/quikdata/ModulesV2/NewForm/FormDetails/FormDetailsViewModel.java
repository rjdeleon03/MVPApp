package com.cpu.quikdata.ModulesV2.NewForm.FormDetails;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.FormDetails;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelString;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.INewFormDataManager;

public class FormDetailsViewModel extends TemplateQuestionViewModel<INewFormDataManager, FormDetails>{

    private FormDetails mFormDetails;

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public FormDetailsViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getFormDetails(this);
    }

    /**
     * Handles reception of form details
     * @param data
     */
    @Override
    public void onDataReceived(FormDetails data) {
        mFormDetails = data;

        int i = 0;
        for(QuestionItemModelString model : data.getStringFields()) {
            if (i == 1) {
                mQuestions.add(new TemplateQuestionItemViewModelDate(data.getDateFields().get(0)));
            }

            mQuestions.add(new TemplateQuestionItemViewModelString(model));
            i++;
        }
    }
}
