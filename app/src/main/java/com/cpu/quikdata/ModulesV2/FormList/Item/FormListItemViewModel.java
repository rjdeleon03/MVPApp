package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.google.gson.Gson;

public class FormListItemViewModel {

    private IFormListDataManager mIFormListDataManager;
    private int mIndex;

    public final ObservableField<String> sitio = new ObservableField<>("");

    /**
     * Constructor
     * @param iFormListDataManager
     * @param index
     */
    public FormListItemViewModel(IFormListDataManager iFormListDataManager,
                                 int index) {

        mIFormListDataManager = iFormListDataManager;
        mIndex = index;

        Form form = mIFormListDataManager.getFormAtIndex(mIndex);
        Gson gson = new Gson();
//        DNCAForm dncaForm = gson.fromJson(form.getData(), DNCAForm.class);
        sitio.set(form.getData());

    }
}
