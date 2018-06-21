package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;

import java.util.List;

public interface DialogItemDataSource {

    /**
     * Gets all item viewModels
     * @return
     */
    List<DialogItemViewModel> getItemViewModels();

}
