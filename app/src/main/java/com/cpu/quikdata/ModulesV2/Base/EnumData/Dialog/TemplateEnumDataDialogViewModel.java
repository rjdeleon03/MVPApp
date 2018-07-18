package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public abstract class TemplateEnumDataDialogViewModel<AC extends IBaseInterface, D, E extends GenericEnum> extends TemplateQuestionViewModel<AC, D> {

    protected E mType;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataDialogViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Gets the type
     * @return
     */
    @Bindable
    public E getType() {
        return mType;
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public abstract void navigateOnOkButtonPressed();
}
