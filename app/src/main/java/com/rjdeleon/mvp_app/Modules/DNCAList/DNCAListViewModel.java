package com.rjdeleon.mvp_app.Modules.DNCAList;

import android.content.Context;

import com.rjdeleon.mvp_app.Models.DNCAFormRepository;
import com.rjdeleon.mvp_app.Modules.DNCAList.Item.DNCAListNavigator;

public class DNCAListViewModel {

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

}
