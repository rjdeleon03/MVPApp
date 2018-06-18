package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog;

import java.util.List;

public interface DialogItemDataSource {

    /**
     * Gets number of items
     * @return
     */
    int getItemCount();

    /**
     * Gets item at specified index
     * @return
     */
    DialogItemViewModelGenderTuple getItemViewModel(int index);

    /**
     * Gets all item viewModels
     * @return
     */
    List<DialogItemViewModelGenderTuple> getItemViewModels();

}
