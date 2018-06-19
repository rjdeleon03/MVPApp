package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel;

import android.content.Context;
import android.databinding.ObservableField;

import com.cpu.quikdata.Models.GeneralInformation.PopulationDataRow;
import com.cpu.quikdata.Models.Generics.GenderTuple;
import com.cpu.quikdata.Models.Generics.GenericEnum;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.NewDncaBaseViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumNavigator;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.DialogItemDataSource;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.Model.DialogItemModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataRepositoryManager;

import java.util.ArrayList;
import java.util.List;

public abstract class DialogViewModel extends NewDncaBaseViewModel implements DialogItemDataSource {

    public final ObservableField<GenericEnum> type = new ObservableField<>();
    protected List<DialogItemViewModel> mItemViewModels = new ArrayList<>();
    protected BaseEnumNavigator mBaseEnumNavigator;

    /**
     * Constructor
     * @param context
     */
    public DialogViewModel(Context context) {

        super(context);
    }

    /**
     * Sets the base age group navigator
     * @param baseEnumNavigator
     */
    public void setBaseAgeGroupNavigator(BaseEnumNavigator baseEnumNavigator) {
        mBaseEnumNavigator = baseEnumNavigator;
    }

    /**
     * Handles navigation when OK button is pressed
     */
    public void navigateOnOkButtonPressed() {
        mBaseEnumNavigator.onDialogOkButtonPressed();
    }

    /**
     * Handles navigation when cancel button is pressed
     */
    public void navigateOnCancelButtonPressed() {
        mBaseEnumNavigator.onDialogCloseButtonPressed();
    }


    /**
     * Gets all item viewModels
     * @return
     */
    @Override
    public List<DialogItemViewModel> getItemViewModels() {
        return mItemViewModels;
    }
}
