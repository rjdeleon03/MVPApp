package com.cpu.quikdata.Modules.DNCAList;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;

import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAFormRepository;
import com.cpu.quikdata.Models.DNCAListItem;
import com.cpu.quikdata.Modules.DNCAList.Item.DNCAListNavigator;

import java.util.ArrayList;
import java.util.List;

public class DNCAListViewModel implements DNCAFormDataSource.LoadDncaFormsCallback {

    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    public final ObservableList<DNCAListItem> dncaListItems = new ObservableArrayList<>();

    private Context mContext;
    private DNCAFormRepository mDncaFormRepository;
    private DNCAListNavigator mDncaListNavigator;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public DNCAListViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        mContext = context;
        mDncaFormRepository = dncaFormRepository;
    }

    /**
     * Sets the navigator once the activity has been created
     * @param dncaListNavigator
     */
    public void onActivityCreated(DNCAListNavigator dncaListNavigator) {
        mDncaListNavigator = dncaListNavigator;
    }

    /**
     * Starts DNCA list retrieval
     */
    public void start() {

        // Forms retrieval is ongoing, no need to do anything
        if (isLoading.get()) {
            return;
        }

        // Perform form retrieval
        isLoading.set(true);
        mDncaFormRepository.loadAllDncaForms(this);
    }

    /**
     * Navigates when Add New DNCA button is pressed
     */
    public void navigateOnNewDncaButtonPressed() {
        mDncaListNavigator.onNewDncaButtonPressed();
    }

    @Override
    public void onDncaFormsLoaded(List<DNCAListItem> forms) {
        isLoading.set(false);

        if (forms != null && forms.size() > 0) {
            dncaListItems.clear();
            dncaListItems.addAll(forms);
        }
    }

    @Override
    public void onDataNotAvailable() {

    }
}