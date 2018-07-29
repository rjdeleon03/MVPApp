package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.databinding.Bindable;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;

import java.lang.ref.WeakReference;

import io.realm.OrderedRealmCollection;
import io.realm.RealmResults;

public abstract class TemplateListDataViewModel<A extends IBaseInterface, LI> extends BaseViewModel<A>  implements IFormListDataManager<LI> {

    @Nullable
    protected WeakReference<A> mActivity;
    protected OrderedRealmCollection<LI> mItems = null;
    protected FormListAdapter mAdapter;

    /**
     * Constructor
     *
     * @param dncaFormRepository
     */
    public TemplateListDataViewModel(DNCAFormRepository dncaFormRepository) {
        super(dncaFormRepository);
    }

    /**
     * Sets the activity interface
     * @param activity
     */
    public void setActivity(A activity) {
        mActivity = new WeakReference<>(activity);
    }

    /**
     * Handles reception of forms
     * @param items
     */
    @Override
    public void onListDataRetrieved(OrderedRealmCollection<LI> items) {
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
    public OrderedRealmCollection<LI> getForms() {
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
    public abstract void navigateOnAddButtonPressed();
}
