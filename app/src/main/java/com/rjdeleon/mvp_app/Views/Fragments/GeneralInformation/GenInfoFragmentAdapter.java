package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class GenInfoFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragmentList;

    public GenInfoFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.mFragmentList = new ArrayList<>();
    }

    @Override
    public BaseFragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(BaseFragment fragment) {
        mFragmentList.add(fragment);
    }

    public void cleanup(FragmentManager manager) {
        FragmentTransaction transaction = manager.beginTransaction();
        for (Fragment fragment : mFragmentList) {
            transaction.remove(fragment);
        }
        transaction.commit();
    }
}
