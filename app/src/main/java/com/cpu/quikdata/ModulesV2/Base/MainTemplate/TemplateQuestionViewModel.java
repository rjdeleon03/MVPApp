package com.cpu.quikdata.ModulesV2.Base.MainTemplate;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;

public abstract class TemplateQuestionViewModel<AC extends IBaseInterface, D>
        extends TemplateMainViewModel<AC, D> {

    /**
     * Constructor
     * @param dncaFormRepository
     */
    public TemplateQuestionViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Automatically saves updated data when view is paused
     */
    public void onViewPaused() {
        for(TemplateQuestionItemViewModel model : mQuestions) {
            model.updateModel();
        }
    }
}
