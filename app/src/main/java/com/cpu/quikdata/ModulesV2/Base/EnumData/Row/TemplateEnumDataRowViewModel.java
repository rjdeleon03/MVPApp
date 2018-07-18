package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog.TemplateEnumDataDialogViewModel;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateReadonlyViewModel;

public abstract class TemplateEnumDataRowViewModel<AC extends IBaseInterface, D, E extends GenericEnum, DM extends ITemplateEnumDataManager>
        extends TemplateReadonlyViewModel<AC, D> {

    protected E mType;
    protected int mRowIndex;
    protected DM mDataManager;
    protected D mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository);
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(DM dataManager) {
        mDataManager = dataManager;
        mDataManager.getRowAtIndex(this, mRowIndex);
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
