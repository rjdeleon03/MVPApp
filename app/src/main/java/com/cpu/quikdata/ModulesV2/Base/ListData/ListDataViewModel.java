package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModelsV2.Form.Form;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.IFormListActivity;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;

import java.lang.ref.WeakReference;

import io.realm.RealmResults;

public abstract class ListDataViewModel<A extends IBaseInterface, LI> extends BaseViewModel<A>  implements IFormListDataManager<LI> {

    @Nullable
    protected WeakReference<A> mActivity;
    protected RealmResults<LI> mItems = null;
    protected FormListAdapter mAdapter;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public ListDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets the form list activity interface
     * @param activity
     */
    public void setFormListActivity(A activity) {
        mActivity = new WeakReference<>(activity);
    }

    /**
     * Handles reception of forms
     * @param items
     */
    @Override
    public void onFormListDataRetrieved(RealmResults<LI> items) {
        mItems = items;
        setupAdapter();
    }

    /**
     * Sets up the adapter
     */
    protected abstract void setupAdapter();

    /**
     * Gets all forms
     * @return
     */
    @Bindable
    @Override
    public RealmResults<LI> getForms() {
        return mItems;
    }

    /**
     * Gets the number of items
     * @return
     */
    @Override
    public int getItemsCount() {
        return mItems.size();
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
     * Handles navigation when add button is pressed
     */
    protected abstract void navigateOnAddButtonPressed();
}
