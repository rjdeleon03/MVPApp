package com.rjdeleon.mvp_app.Modules.NewDnca.Base;

import android.content.Context;

import com.rjdeleon.mvp_app.Modules.NewDnca.NewDncaNavigator;

public abstract class NewDncaBaseViewModel {

    protected final Context mContext; // Application context

    protected NewDncaNavigator mNewDncaNavigator;

    public NewDncaBaseViewModel(Context context) {

        // Force use of application context
        mContext = context.getApplicationContext();
    }

    public void setNewDncaNavigator(NewDncaNavigator newDncaNavigator) {
        mNewDncaNavigator = newDncaNavigator;
    }
}
