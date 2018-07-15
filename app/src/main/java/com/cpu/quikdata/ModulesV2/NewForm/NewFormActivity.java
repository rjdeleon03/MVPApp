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
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

public class NewFormActivity extends AppCompatActivity implements INewFormActivity {

    public enum NewFormComponent {
        MENU,
        FORM_DETAILS,
        GEN_INFO,
        SHELTER_INFO,
        FOOD_SECURITY,
        LIVELIHOODS,
        HEALTH,
        WASH,
        EVACUATION,
        EVACUATION_ITEM,
        CASE_STORIES
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        NewFormFragment newFormFragment = (NewFormFragment) findOrCreateFragment(NewFormComponent.MENU);
        final NewFormViewModel newFormViewModel = (NewFormViewModel) findOrCreateViewModel(NewFormComponent.MENU);
        newFormFragment.setViewModel(newFormViewModel);
    }

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private Fragment findOrCreateFragment(NewFormComponent component) {

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(component.toString());
        boolean addToBackstack = true;

        if (fragment == null) {
            switch (component) {
                case MENU:
                    fragment = NewFormFragment.newInstance();
                    addToBackstack = false;
                    break;
                case FORM_DETAILS:
                    fragment = FormDetailsFragment.newInstance();
                    break;
            }

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.new_form_fragment_container, addToBackstack, component.toString());
        }
        return fragment;

    }

    /**
     * Finds or creates the viewModel
     * @return
     */
    @NonNull
    private BaseViewModel findOrCreateViewModel(NewFormComponent component) {

        String vmTag = component.toString() + "_VIEWMODEL";

        ViewModelHolder<BaseViewModel> retainedViewModel = (ViewModelHolder<BaseViewModel>) getSupportFragmentManager().findFragmentByTag(vmTag);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            BaseViewModel baseViewModel = null;

            switch (component) {
                case MENU:
                    NewFormViewModel newFormViewModel = new NewFormViewModel(Injection.provideDncaRepository(this));
                    newFormViewModel.setNewFormActivity(this);
                    baseViewModel = newFormViewModel;
                    break;
                case FORM_DETAILS:
                    FormDetailsViewModel formDetailsViewModel = new FormDetailsViewModel(Injection.provideDncaRepository(this));
//            formDetailsViewModel.setActivity(this);
                    baseViewModel = formDetailsViewModel;
                    break;

            }

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(baseViewModel),
                    vmTag);

            return baseViewModel;
        }
    }

    @Override
    public void onFormDetailsButtonPressed() {
        FormDetailsFragment formDetailsFragment = (FormDetailsFragment) findOrCreateFragment(NewFormComponent.FORM_DETAILS);
        final FormDetailsViewModel formDetailsViewModel = (FormDetailsViewModel) findOrCreateViewModel(NewFormComponent.FORM_DETAILS);
        formDetailsFragment.setViewModel(formDetailsViewModel);
    }

    @Override
    public void onGenInfoButtonPressed() {

    }
}
