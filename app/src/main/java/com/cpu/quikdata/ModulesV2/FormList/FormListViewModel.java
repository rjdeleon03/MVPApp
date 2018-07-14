package com.cpu.quikdata.ModulesV2.FormList;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;

import java.lang.ref.WeakReference;

import io.realm.Realm;
import io.realm.RealmResults;

public class FormListViewModel extends BaseObservable implements IFormListDataManager {

    @Nullable
    private WeakReference<IFormListActivity> mFormListActivity;

    private RealmResults<Form> mForms = null;
    private DNCAFormRepository mDncaFormRepository;
    private FormListAdapter mAdapter;


    /**
     * Constructor
     */
    public FormListViewModel(DNCAFormRepository dncaFormRepository) {
        mDncaFormRepository = dncaFormRepository;
        mDncaFormRepository.getAllForms(this);
    }

    /**
     * Sets the form list activity interface
     * @param formListActivity
     */
    public void setFormListActivity(IFormListActivity formListActivity) {
        mFormListActivity = new WeakReference<>(formListActivity);
    }

    /**
     * Handles reception of forms
     * @param forms
     */
    @Override
    public void onFormListDataRetrieved(RealmResults<Form> forms) {
        mForms = forms;
        mAdapter = new FormListAdapter(mForms, true, this);
    }

    /**
     * Gets all forms
     * @return
     */
    @Bindable
    @Override
    public RealmResults<Form> getForms() {
        return mForms;
    }

    /**
     * Gets adapter
     * @return
     */
    @Override
    public FormListAdapter getAdapter() {
        return mAdapter;
    }

    /**
     * Gets the number of items
     * @return
     */
    @Override
    public int getItemsCount() {
        return mForms.size();
    }

    /**
     * Handles navigation when add button is pressed
     */
    public void navigateOnAddButtonPressed() {
        if (mFormListActivity.get() != null) {
            mFormListActivity.get().onAddButtonPressed();
        }
    }

    /**
     * Handles navigation when settings button is pressed
     */
    public void navigateOnSettingsButtonPressed() {
        if (mFormListActivity.get() != null) {
            mFormListActivity.get().onSettingsButtonPressed();
        }
    }
}
