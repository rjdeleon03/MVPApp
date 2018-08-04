package com.cpu.quikdata.ModulesV2.Base.ListData;

import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.IBaseInterface;
import com.cpu.quikdata.ModulesV2.FormList.FormListAdapter;
import com.cpu.quikdata.ModulesV2.FormList.IFormListDataManager;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmResults;

public abstract class TemplateListDataViewModel<A extends IBaseInterface, LI, LS> extends BaseViewModel<A>  implements IFormListDataManager<LI, LS> {

    @Nullable
    protected WeakReference<A> mActivity;
    protected OrderedRealmCollection<LI> mItems = null;
    protected FormListAdapter mAdapter;
    protected List<LS> mListeners = new ArrayList<>();
    public ObservableBoolean controlsEnabled = new ObservableBoolean(true);

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

    /**
     * Adds a listener to the list
     * @param listener
     */
    @Override
    public void addListener(LS listener) {
        mListeners.add(listener);
    }
}
