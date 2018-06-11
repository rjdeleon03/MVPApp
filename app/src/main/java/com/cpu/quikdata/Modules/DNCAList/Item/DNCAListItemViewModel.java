package com.cpu.quikdata.Modules.DNCAList.Item;

import android.content.Context;
import android.support.annotation.Nullable;

import com.cpu.quikdata.Models.DNCAFormRepository;

import java.lang.ref.WeakReference;

public class DNCAListItemViewModel {

    private Context mContext;
    private DNCAFormRepository mDncaFormRepository;
    // This navigator is s wrapped in a WeakReference to avoid leaks because it has references to an
    // activity. There's no straightforward way to clear it for each item in a list adapter.
    @Nullable
    private WeakReference<DNCAListItemNavigator> mNavigator;

    /**
     * Constructor
     * @param context
     * @param dncaFormRepository
     */
    public DNCAListItemViewModel(Context context, DNCAFormRepository dncaFormRepository) {
        mContext = context;
        mDncaFormRepository = dncaFormRepository;
    }

    /**
     * Sets the navigator
     * @param navigator
     */
    public void setNavigator(DNCAListItemNavigator navigator) {
        mNavigator = new WeakReference<>(navigator);
    }

    /**
     * Navigate when a DNCA list item is clicked
     */
    public void navigateOnDncaListItemClicked() {
        if (mNavigator != null && mNavigator.get() != null) {
            mNavigator.get().openDncaForm(0);
        }
    }
}
