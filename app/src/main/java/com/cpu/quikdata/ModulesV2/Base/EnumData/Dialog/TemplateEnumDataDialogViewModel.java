package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataComponentViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public abstract class TemplateEnumDataDialogViewModel<AC extends IBaseInterface, D, E extends GenericEnum>
        extends TemplateEnumDataComponentViewModel<AC, D, E> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataDialogViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public abstract void navigateOnOkButtonPressed();
}
