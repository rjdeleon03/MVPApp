package com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation;

import android.support.v4.app.FragmentManager;
import android.view.View;

import com.cpu.quikdata.ModulesV2.Base.MultiPage.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.NewFormActivity;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataFragment;
import com.cpu.quikdata.ModulesV2.NewForm.ShelterInformation.DamageData.DamageDataViewModel;
import com.cpu.quikdata.ViewFactory;

public class ShelterInformationFragment extends TemplateMultiPageFragment<ShelterInformationViewModel> {

    public ShelterInformationFragment() {
        // Required empty public constructor
        mTag = NewFormActivity.NewFormComponent.SHELTER_INFO.toString();
    }

    /**
     * Gets new instance
     * @return
     */
    public static ShelterInformationFragment newInstance() {
        return new ShelterInformationFragment();
    }

    /**
     * Sets up the custom view
     * @param view
     */
    @Override
    protected void setupCustomView(View view) {
        FragmentManager fragmentManager = getChildFragmentManager();
        
        {
            // Setup damage data fragment
            DamageDataFragment damageDataFragment =
                    (DamageDataFragment) ViewFactory.findOrCreateFragment(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_DAMAGE);
            DamageDataViewModel damageDataViewModel =
                    (DamageDataViewModel) ViewFactory.findOrCreateViewModel(fragmentManager, NewFormActivity.NewFormComponent.SHELTER_INFO_DAMAGE, null, getContext());
            damageDataViewModel.setViewComponent(damageDataFragment);
            damageDataFragment.setViewModel(damageDataViewModel);
            mAdapter.addFragment(damageDataFragment);
        }
    }
}
