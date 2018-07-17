package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.EnumData.TemplateEnumDataComponentViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;

public abstract class TemplateEnumDataRowViewModel<AC extends IBaseInterface, D, E extends GenericEnum>
        extends TemplateEnumDataComponentViewModel<AC, D, E> {

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataRowViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Handles navigation when card is selected
     */
    public void navigateOnCardSelected() {

    }

    /**
     * Handles navigation when delete card button is pressed
     */
    public void navigateOnDeleteCardButtonPressed() {

    }
}
