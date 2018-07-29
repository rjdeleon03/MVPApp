package com.cpu.quikdata.ModulesV2.FormList;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.ListData.ListDataViewModel;

import java.lang.ref.WeakReference;

import io.realm.Realm;
import io.realm.RealmResults;

public class FormListViewModel extends ListDataViewModel<IFormListActivity, Form> {

    /**
     * Constructor
     */
    public FormListViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
        mFormRepository.getAllForms(this);
    }

    @Override
    protected void setupAdapter() {
        mAdapter = new FormListAdapter(mItems, true, this);
    }

    /**
     * Handles navigation when add button is pressed
     */
    @Override
    public void navigateOnAddButtonPressed() {
        if (mActivity.get() != null) {
            mActivity.get().onAddButtonPressed();
        }
    }

    /**
     * Handles navigation when settings button is pressed
     */
    public void navigateOnSettingsButtonPressed() {
        if (mActivity.get() != null) {
            mActivity.get().onSettingsButtonPressed();
        }
    }
}
