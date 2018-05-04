package com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rd.PageIndicatorView;
import com.rjdeleon.mvp_app.Modules.NewForm.NewFormContract;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.CalamityDetails.CalamityDetailsFragment;
import com.rjdeleon.mvp_app.Base.BaseFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.Casualties.CasualtiesFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.DeathCause.DeathCauseFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.FamilyData.FamilyDataFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.InfraDamage.InfraDamageFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.PopulationData.PopulationDataFragment;
import com.rjdeleon.mvp_app.Modules.NewForm.GeneralInformation.VulnerablePopulation.VulnerablePopulationFragment;
import com.rjdeleon.mvp_app.databinding.NewFormGenInfoFragmentBinding;

public class NewFormGenInfoFragment extends BaseFragment implements NewFormGenInfoContract.View {

    private NewFormGenInfoPresenter mPresenter;
    private GenInfoFragmentAdapter mAdapter;
    private ViewPager mPager;
    private PageIndicatorView mPageIndicator;

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

        // Initialize pager and adapter
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

        // Initialize page indicator
        mPageIndicator = view.findViewById(R.id.nf_gen_info_stepper);

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
                // TODO: If fragment is filled out completely, set color to green
                //    mPageIndicator.setSelectedColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_dark));
                // TODO: Else set color to default (yellow)
                //    mPageIndicator.setSelectedColor(ContextCompat.getColor(getContext(), R.color.yellow));
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
