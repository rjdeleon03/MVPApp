package com.cpu.quikdata.ModulesV2.Base;

import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    protected String mTag;

    public String getType() {
        return mTag;
    }
}
