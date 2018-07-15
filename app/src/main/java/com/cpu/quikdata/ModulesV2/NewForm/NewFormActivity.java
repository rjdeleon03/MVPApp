package com.cpu.quikdata.ModulesV2.NewForm;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.BaseViewModel;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.NewForm.Base.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationFragment;
import com.cpu.quikdata.ModulesV2.NewForm.GeneralInformation.GeneralInformationViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

public class NewFormActivity extends AppCompatActivity implements INewFormActivity {

    public enum NewFormComponent {
        MENU,
        FORM_DETAILS,

        GEN_INFO,
        GEN_INFO_CALAMITY,

        SHELTER_INFO,
        FOOD_SECURITY,
        LIVELIHOODS,
        HEALTH,
        WASH,
        EVACUATION,
        EVACUATION_ITEM,
        CASE_STORIES
    }

    private static int FRAGMENT_CONTAINER = R.id.new_form_fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        NewFormFragment newFormFragment = (NewFormFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.MENU, FRAGMENT_CONTAINER);
        final NewFormViewModel newFormViewModel = (NewFormViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.MENU, this, this);
        newFormFragment.setViewModel(newFormViewModel);
    }

    @Override
    public void onFormDetailsButtonPressed() {
        FormDetailsFragment formDetailsFragment = (FormDetailsFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.FORM_DETAILS, FRAGMENT_CONTAINER);
        final FormDetailsViewModel formDetailsViewModel = (FormDetailsViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.FORM_DETAILS, this, this);
        formDetailsFragment.setViewModel(formDetailsViewModel);
    }

    @Override
    public void onGenInfoButtonPressed() {
        GeneralInformationFragment generalInformationFragment = (GeneralInformationFragment) ViewFactory.findOrCreateFragment(getSupportFragmentManager(), NewFormComponent.GEN_INFO, FRAGMENT_CONTAINER);
        final GeneralInformationViewModel generalInformationViewModel = (GeneralInformationViewModel) ViewFactory.findOrCreateViewModel(getSupportFragmentManager(), NewFormComponent.GEN_INFO, this, this);
        generalInformationFragment.setViewModel(generalInformationViewModel);
    }
}
