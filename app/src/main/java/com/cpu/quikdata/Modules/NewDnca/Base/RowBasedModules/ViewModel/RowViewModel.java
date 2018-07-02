package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;

public abstract class RowViewModel<T1, T2> extends DialogViewModel {

    protected BaseEnumNavigator mBaseEnumNavigator;
    protected BaseEnumRepositoryManager mRepositoryManager;
    protected int mRowIndex;

    /**
     * Constructor
     * @param baseEnumNavigator
     * @param rowIndex
     */
    // TODO: Delete this
    public RowViewModel(BaseEnumNavigator baseEnumNavigator,
                        int rowIndex) {

        super();
        mBaseEnumNavigator = baseEnumNavigator;
        mRowIndex = rowIndex;
    }

    /**
     * Constructor
     */
    public RowViewModel() {
        super();
    }

    /**
     * Sets the data
     * @param baseEnumNavigator
     * @param repositoryManager
     * @param rowIndex
     */
    public void setData(BaseEnumNavigator baseEnumNavigator, BaseEnumRepositoryManager repositoryManager, int rowIndex) {
        mBaseEnumNavigator = baseEnumNavigator;
        mRepositoryManager = repositoryManager;
        mRowIndex = rowIndex;
    }

    /**
     * Handle navigation when card is selected
     */
    public void navigateOnCardSelected() {
        mBaseEnumNavigator.onCardSelected(mRowIndex);
    }

    /**
     * Handle navigation when card is deleted
     */
    public void navigateOnDeleteCardButtonPressed() {
        mBaseEnumNavigator.onDeleteCardButtonPressed();
    }
}
