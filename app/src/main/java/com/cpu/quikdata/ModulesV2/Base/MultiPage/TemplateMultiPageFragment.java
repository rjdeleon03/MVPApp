package com.cpu.quikdata.ModulesV2.Base.MultiPage;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.BaseActivity;
import com.cpu.quikdata.ModulesV2.Base.BaseFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateMultiPageFragmentBinding;
import com.rd.PageIndicatorView;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class TemplateMultiPageFragment<VM extends TemplateMultiPageViewModel> extends BaseFragment<VM> {

    private TemplateMultiPageFragmentBinding mBinding;

    protected TemplateMultiPageFragmentAdapter mAdapter;
    protected ViewPager mPager;

    public TemplateMultiPageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.template_multi_page_fragment, container, false);

        // Bind viewModel to view
        if (mBinding == null) {
            mBinding = TemplateMultiPageFragmentBinding.bind(view);
        }
        mBinding.setViewModel(mViewModel);

        // Initialize adapter
        mAdapter = new TemplateMultiPageFragmentAdapter(getChildFragmentManager());

        // Setup the custom view and viewPager
        setupCustomView(view);
        setupViewPager(view);

        return view;
    }

    /**
     * Sets up the view pager
     * @param view
     */
    protected void setupViewPager(View view) {
        final BaseActivity activity = (BaseActivity) getActivity();

        // Initialize viewPager
        mPager = view.findViewById(R.id.nd_multi_page_pager);
        mPager.setAdapter(mAdapter);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (activity != null) {
                    activity.setToolbarSubtitle(mAdapter.getItem(position).getType());
                }

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

        // Set first fragment's title as title
        if (activity != null) {
            activity.setToolbarSubtitle(mAdapter.getItem(0).getType());
        }
    }

    /**
     * Sets up the custom view for whichever fragment extends this class
     * @param view
     */
    protected abstract void setupCustomView(View view);
}
