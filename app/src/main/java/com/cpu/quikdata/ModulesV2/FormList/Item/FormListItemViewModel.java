package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.google.gson.Gson;

public class FormListItemViewModel {

    public final ObservableField<String> sitio = new ObservableField<>("");

    /**
     * Constructor
     * @param form
     */
    public FormListItemViewModel(Form form) {
        sitio.set(form.getData());

    }
}
