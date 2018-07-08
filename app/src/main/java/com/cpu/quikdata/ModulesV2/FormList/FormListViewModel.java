package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.Nullable;

import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModelsV2.Form.Form;

import java.lang.ref.WeakReference;

import io.realm.Realm;
import io.realm.RealmResults;

public class FormListViewModel implements IFormListParentViewModel {

    @Nullable
    private WeakReference<IFormListActivity> mIFormListActivity;

    private RealmResults<Form> mForms = null;


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
        mIFormListActivity = new WeakReference<>(iFormListActivity);
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mIFormListActivity.get() != null) {
            mIFormListActivity.get().onAddButtonPressed();
        }
    }

    /**
     * Gets all forms
     * @return
     */
    public RealmResults<Form> getAllForms() {
        if (mForms == null) {
            Realm realm = Realm.getDefaultInstance();
            mForms = realm.where(Form.class).findAll();
//            realm.close();
        }
        return mForms;
    }

    @Override
    public Form getFormAtIndex(int index) {
        return mForms.get(index);
    }
}
