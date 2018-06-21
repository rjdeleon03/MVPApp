package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel.DialogItemViewModel;

import java.util.List;

public interface DialogItemDataSource {

    /**
     * Gets all item viewModels
     * @return
     */
    List<DialogItemViewModel> getItemViewModels();

}
