package com.cpu.quikdata.Modules.NewDnca.Base;

import android.support.v4.app.Fragment;

public abstract class BaseSubFragment extends Fragment {

    private String fragmentTag = null;

    public void setFragmentTag(String fragmentTag) {
        this.fragmentTag = fragmentTag;
    }

    public String getFragmentTag() {
        return fragmentTag;
    }
}
