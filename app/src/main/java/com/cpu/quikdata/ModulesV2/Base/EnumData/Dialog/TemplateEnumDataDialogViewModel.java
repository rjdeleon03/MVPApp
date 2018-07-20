package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;

import android.databinding.Bindable;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IFieldHolder;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ItemViewModels.TemplateQuestionItemViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;

public abstract class TemplateEnumDataDialogViewModel<AC extends IBaseInterface, R extends IEnumDataRow<E>, E extends GenericEnum, DM extends ITemplateEnumDataManager<R>> extends TemplateQuestionViewModel<AC, R> {

    protected E mType;
    protected int mRowIndex;
    protected DM mDataManager;
    protected R mRow;

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
     * Handles reception of population data row
     * @param data
     */
    @Override
    public void onDataReceived(R data) {
        mRow = data;
        mType = mRow.getActualType();

        mDataManager.generateQuestions(mQuestions, mRow);
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
    public void navigateOnOkButtonPressed() {
        if (mRowIndex == -1) mRow.setId(AppUtil.generateId());

        for(TemplateQuestionItemViewModel model : mQuestions) {
            model.updateModel();
        }

        mDataManager.saveRow(mRow);
    }
}
