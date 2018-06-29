package com.cpu.quikdata.Modules.NewDnca.Base;

import android.content.Context;

import com.cpu.quikdata.Modules.NewDnca.NewDncaNavigator;

public abstract class NewDncaBaseViewModel {

    protected NewDncaNavigator mNewDncaNavigator;

    public NewDncaBaseViewModel() {
    }

    public void setNewDncaNavigator(NewDncaNavigator newDncaNavigator) {
        mNewDncaNavigator = newDncaNavigator;
    }
}
