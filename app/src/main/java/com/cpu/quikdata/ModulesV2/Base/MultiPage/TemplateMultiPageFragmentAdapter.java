package com.cpu.quikdata.ModulesV2.Base.MultiPage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cpu.quikdata.ModulesV2.Base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class TemplateMultiPageFragmentAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> mFragmentList;

    public TemplateMultiPageFragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
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
}
