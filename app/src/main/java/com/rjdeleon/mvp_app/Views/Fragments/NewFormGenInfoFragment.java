package com.rjdeleon.mvp_app.Views.Fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormGenInfoContract;
import com.rjdeleon.mvp_app.Presenters.NewFormGenInfoPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.CasualtiesFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.DeathCauseFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.FamilyDataFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.GenInfoFragmentAdapter;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.InfraDamageFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragment;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.VulnerablePopulationFragment;
import com.rjdeleon.mvp_app.databinding.NewFormGenInfoFragmentBinding;

public class NewFormGenInfoFragment extends BaseFragment implements NewFormGenInfoContract.View {

    private NewFormGenInfoPresenter mPresenter;
    private GenInfoFragmentAdapter mAdapter;
    private ViewPager mPager;

    public NewFormGenInfoFragment() {
        // Required empty public constructor
        this.fragmentTitle = "General Information";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPresenter = new NewFormGenInfoPresenter(this, (NewFormContract.Presenter)navigationPresenter);
        NewFormGenInfoFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.new_form_gen_info_fragment, container, false);
        binding.setPresenter(mPresenter);
        View view = binding.getRoot();

        mAdapter = new GenInfoFragmentAdapter(getActivity().getSupportFragmentManager());
        mAdapter.addFragment(new CalamityDetailsFragment());
        mAdapter.addFragment(new PopulationDataFragment());
        mAdapter.addFragment(new FamilyDataFragment());
        mAdapter.addFragment(new VulnerablePopulationFragment());
        mAdapter.addFragment(new CasualtiesFragment());
        mAdapter.addFragment(new DeathCauseFragment());
        mAdapter.addFragment(new InfraDamageFragment());
        mPager = view.findViewById(R.id.nf_gen_info_pager);
        mPager.setAdapter(mAdapter);

        // Set subtitle in toolbar
        navigationPresenter.updateSubtitle(mAdapter.getItem(0).getFragmentTitle());

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                NewFormGenInfoFragment.this.fragmentTitle = (mAdapter.getItem(position)).getFragmentTitle();
                navigationPresenter.updateSubtitle(NewFormGenInfoFragment.this.fragmentTitle);
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        mAdapter.cleanup(getActivity().getSupportFragmentManager());
        super.onDestroyView();
    }
}
