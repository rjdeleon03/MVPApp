package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModulesV2.FormList.IFormListParentViewModel;

public class FormListItemViewModel {

    private IFormListParentViewModel mIFormListParentViewModel;
    private int mIndex;

    public final ObservableField<String> sitio = new ObservableField<>("");

    /**
     * Constructor
     * @param iFormListParentViewModel
     * @param index
     */
    public FormListItemViewModel(IFormListParentViewModel iFormListParentViewModel,
                                 int index) {

        mIFormListParentViewModel = iFormListParentViewModel;
        mIndex = index;

        DncaForm form = mIFormListParentViewModel.getFormAtIndex(mIndex);
        sitio.set(form.getFormDetails().getSitio() + " Sitio");

    }
}
