package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.google.gson.Gson;

public class FormListItemViewModel {

    private IFormListDataManager<Form> mDataManager;
    private String mFormId = "";

    public final ObservableField<String> sitio = new ObservableField<>("");

    /**
     * Constructor
     * @param form
     */
    public FormListItemViewModel(Form form, int itemIndex) {
        mFormId = form.getId();
        QuestionItemModelDate date = form.getFormDetails().getAssessmentDate();
        if (date != null) {
            int month = date.getMonth()+1;
            sitio.set(date.getYear() + "/" + month + "/" + date.getDayOfMonth());
        }
    }

    /**
     * Sets the data manager
     * @param dataManager
     */
    public void setDataManager(IFormListDataManager<Form> dataManager) {
        mDataManager = dataManager;
    }

    /**
     * Handles navigation when submit button is pressed
     */
    public void navigateOnSubmitButtonPressed() {
        if(mDataManager != null) {
            mDataManager.navigateOnItemSubmitButtonPressed(mFormId);
        }
    }

    /**
     * Handles navigation when edit button is pressed
     */
    public void navigateOnEditButtonPressed() {
        if(mDataManager != null) {
            mDataManager.navigateOnItemEditButtonPressed(mFormId);
        }
    }

    /**
     * Handles navigation when delete button is pressed
     */
    public void navigateOnDeleteButtonPressed() {
        if(mDataManager != null) {
            mDataManager.navigateOnItemDeleteButtonPressed(mFormId);
        }
    }
}
