package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.FormList.IFormListParentViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

        Form form = mIFormListParentViewModel.getFormAtIndex(mIndex);
        Gson gson = new Gson();
//        DNCAForm dncaForm = gson.fromJson(form.getData(), DNCAForm.class);
        sitio.set(form.getData());

    }
}
