package com.rjdeleon.mvp_app.Modules.NewDnca.Base.MultiPageFragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.AppUtil;
import com.rjdeleon.mvp_app.R;

public abstract class BaseMultiPageFragment extends Fragment {

    protected BaseMultiPageFragmentAdapter mAdapter;
    protected ViewPager mPager;

    public BaseMultiPageFragment() {
        // Required empty public constructor
    }

    /**
     * Creates the view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.new_dnca_gen_info_fragment, container, false);

        // Initialize adapter
        mAdapter = new BaseMultiPageFragmentAdapter(getChildFragmentManager());

        return root;
    }

    protected void setupViewPager(View view, int pagerId) {

        // Initialize viewPager
        mPager = view.findViewById(pagerId);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        AppUtil.hideSoftKeyboard(getActivity());
                    }
                }, 300);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
