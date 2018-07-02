package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import android.content.Context;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;

//TODO: Use generics
public abstract class RowViewModel extends DialogViewModel {

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
