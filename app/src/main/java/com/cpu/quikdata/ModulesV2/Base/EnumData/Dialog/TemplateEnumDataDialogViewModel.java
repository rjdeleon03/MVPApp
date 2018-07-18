package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public abstract class TemplateEnumDataDialogViewModel<AC extends IBaseInterface, D, E extends GenericEnum, DM extends ITemplateEnumDataManager> extends TemplateQuestionViewModel<AC, D> {

    protected E mType;
    protected int mRowIndex;
    protected DM mDataManager;
    protected D mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataDialogViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository);
        mRowIndex = rowIndex;
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(DM dataManager) {
        mDataManager = dataManager;
        if (mRowIndex == -1) {
            mDataManager.getNewRow(this);
        } else {
            mDataManager.getRowAtIndex(this, mRowIndex);
        }
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
