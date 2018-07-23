package com.cpu.quikdata.ModulesV2.Base.EnumData.Row;

import android.databinding.Bindable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.Base.IEnumDataRow;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataManager;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateReadonlyViewModel;

public abstract class TemplateEnumDataRowViewModel<AC extends ITemplateEnumDataFragment, R extends IEnumDataRow<E>, E extends GenericEnum, DM extends ITemplateEnumDataManager<R>>
        extends TemplateReadonlyViewModel<AC, R> {

    protected E mType;
    protected int mRowIndex;
    protected DM mDataManager;
    protected R mRow;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateEnumDataRowViewModel(DNCAFormRepository dncaFormRepository, int rowIndex) {
        super(dncaFormRepository);
        mRowIndex = rowIndex;
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
     * Handles navigation when card is selected
     */
    public void navigateOnCardSelected() {
        mDataManager.selectedRowAtIndex(mRowIndex);
    }

    /**
     * Handles navigation when delete card button is pressed
     */
    public void navigateOnDeleteCardButtonPressed() {
        mDataManager.deletedRowAtIndex(mRowIndex);
    }
}