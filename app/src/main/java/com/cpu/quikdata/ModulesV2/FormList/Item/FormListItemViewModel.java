package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.google.gson.Gson;

public class FormListItemViewModel {

    public final ObservableField<String> sitio = new ObservableField<>("");

    /**
     * Constructor
     * @param form
     */
    public FormListItemViewModel(Form form) {
        PrefilledData pd = form.getPrefilledData();
        if (form.getPrefilledData() != null) {
            sitio.set(form.getPrefilledData().getSitio().getValue());
        }

    }
}
