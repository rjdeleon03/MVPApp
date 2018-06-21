package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.ViewModel;

import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Model.DialogItemModelRecycler;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxParentViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.Checkbox.LivelihoodsDamageCheckboxViewModel;

import java.util.ArrayList;
import java.util.List;

public class DialogItemViewModelRecycler extends DialogItemViewModel implements LivelihoodsDamageCheckboxParentViewModel {

    private List<LivelihoodsDamageCheckboxViewModel> values = new ArrayList<>();

    public DialogItemViewModelRecycler(DialogItemModelRecycler model) {
        text.set(model.getText());
        for (LivelihoodsDamageDataRow.LivelihoodsEnumBoolTuple value : model.getValues()) {
            values.add(new LivelihoodsDamageCheckboxViewModel(value));
        }
    }

    /**
     * Gets the affected livelihoods at the specified index
     * @param index
     * @return
     */
    @Override
    public LivelihoodsDamageCheckboxViewModel getAffectedLivelihoodViewModel(int index) {
        return values.get(index);
    }

    /**
     * Gets the number of affected livelihoods
     * @return
     */
    @Override
    public int getAffectedLivelihoodsCount() {
        return values.size();
    }
}
