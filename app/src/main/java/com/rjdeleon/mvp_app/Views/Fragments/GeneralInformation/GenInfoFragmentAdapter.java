package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

import java.util.List;

public class GenInfoFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragmentList;

    public GenInfoFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
