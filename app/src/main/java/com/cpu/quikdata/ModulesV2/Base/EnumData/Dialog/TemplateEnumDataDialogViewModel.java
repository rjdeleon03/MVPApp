package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public abstract class TemplateEnumDataDialogViewModel<AC extends IBaseInterface, D> extends TemplateQuestionViewModel<AC, D> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataDialogViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }
}
