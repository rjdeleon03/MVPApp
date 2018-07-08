package com.cpu.quikdata.ModulesV2.FormList;

public class FormListViewModel {

    private IFormListActivity mIFormListActivity;

    /**
     * Constructor
     */
    public FormListViewModel() {

    }

    /**
     * Sets the form list activity interface
     * @param iFormListActivity
     */
    public void setFormListActivity(IFormListActivity iFormListActivity) {
        mIFormListActivity = iFormListActivity;
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mIFormListActivity != null) {
            mIFormListActivity.onAddButtonPressed();
        }
    }
}
