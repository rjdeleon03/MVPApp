package com.cpu.quikdata.ModulesV2.FormList.Item;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.cpu.quikdata.ModelsV2.Form.CaseStories.CaseStories;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.Models.QuestionItemModelDate;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;
import com.google.gson.Gson;

public class FormListItemViewModel implements IFormListItemViewModel {

    private IFormListDataManager<Form> mDataManager;
    private String mFormId;

    public final ObservableField<String> sitio = new ObservableField<>("");
    public final ObservableField<String> imagePath = new ObservableField<>("");
    public final ObservableBoolean isSyncing = new ObservableBoolean(false);

    /**
     * Constructor
     * @param form
     */
    public FormListItemViewModel(Form form) {
        mFormId = form.getId();
        QuestionItemModelDate date = form.getFormDetails().getAssessmentDate();
        if (date != null) {
            int month = date.getMonth()+1;
            sitio.set(date.getYear() + "/" + month + "/" + date.getDayOfMonth());
        }

        if (form.getCaseStories() != null) {
            CaseStories caseStories = form.getCaseStories();
            if (caseStories.getImagePaths() != null && caseStories.getImagePaths().size() >= 1) {
                imagePath.set(caseStories.getImagePaths().get(0));
            }
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
        isSyncing.set(true);
        if(mDataManager != null) {
            mDataManager.navigateOnItemSubmitButtonPressed(mFormId, this);
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
            mDataManager.navigateOnItemDeleteButtonPressed(mFormId, true);
        }
    }

    /**
     * Callback function for when submission is finished
     * @param success
     */
    @Override
    public void onItemSubmitFinished(boolean success) {
        if(mDataManager != null) {
            mDataManager.navigateOnItemSubmitFinished(success);
//            if(success) {
//                mDataManager.navigateOnItemDeleteButtonPressed(mFormId, false);
//            } else {
                isSyncing.set(false);
//            }
        }
    }
}
