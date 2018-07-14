package com.cpu.quikdata.ModulesV2.NewForm;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.NewForm.Base.TemplateMultiPageFragment;
import com.cpu.quikdata.ModulesV2.NewForm.FormDetails.FormDetailsViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

public class NewFormActivity extends AppCompatActivity implements INewFormActivity {

    public static final String NEW_FORM_VIEWMODEL_TAG = "NEW_FORM_VIEWMODEL_TAG";
    public static final String FORM_DETAILS_VIEWMODEL_TAG = "FORM_DETAILS_VIEWMODEL_TAG";

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

        NewFormFragment newFormFragment = findOrCreateViewFragment();
        final NewFormViewModel newFormViewModel = findOrCreateViewModel();
        newFormFragment.setViewModel(newFormViewModel);
    }

    /** TEMP CODE **/
    private TemplateMultiPageFragment findOrCreateFormDetailsFragment() {

        TemplateMultiPageFragment multiPageFragment = null;

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.new_form_fragment_container);
        if(fragment instanceof TemplateMultiPageFragment) {
            multiPageFragment = (TemplateMultiPageFragment)fragment;
        }

        if (multiPageFragment == null) {
            multiPageFragment = TemplateMultiPageFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), multiPageFragment, R.id.new_form_fragment_container, true);
        }
        return multiPageFragment;
    }

    private FormDetailsViewModel findOrCreateFormDetailsViewModel() {

        ViewModelHolder<FormDetailsViewModel> retainedViewModel = (ViewModelHolder<FormDetailsViewModel>) getSupportFragmentManager().findFragmentByTag(FORM_DETAILS_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            // Create viewModel if it does not exist yet
            FormDetailsViewModel formDetailsViewModel = new FormDetailsViewModel();
//            formDetailsViewModel.setNewFormActivity(this);

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(formDetailsViewModel),
                    FORM_DETAILS_VIEWMODEL_TAG);

            return formDetailsViewModel;
        }
    }
    /** --------- **/

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private NewFormFragment findOrCreateViewFragment() {

        NewFormFragment formListFragment = (NewFormFragment) getSupportFragmentManager().findFragmentById(R.id.new_form_fragment_container);

        if (formListFragment == null) {
            formListFragment = NewFormFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formListFragment, R.id.new_form_fragment_container, false);
        }

        return formListFragment;
    }

    /**
     * Finds or creates the viewModel
     * @return
     */
    @NonNull
    private NewFormViewModel findOrCreateViewModel() {

        ViewModelHolder<NewFormViewModel> retainedViewModel = (ViewModelHolder<NewFormViewModel>) getSupportFragmentManager().findFragmentByTag(NEW_FORM_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            // Create viewModel if it does not exist yet
            NewFormViewModel newFormViewModel = new NewFormViewModel(Injection.provideDncaRepository(this));
            newFormViewModel.setNewFormActivity(this);

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(newFormViewModel),
                    NEW_FORM_VIEWMODEL_TAG);

            return newFormViewModel;
        }
    }

    @Override
    public void onFormDetailsButtonPressed() {
        TemplateMultiPageFragment formDetailsFragment = findOrCreateFormDetailsFragment();
        final FormDetailsViewModel formDetailsViewModel = findOrCreateFormDetailsViewModel();
        formDetailsFragment.setViewModel(formDetailsViewModel);
    }

    @Override
    public void onGenInfoButtonPressed() {

    }
}
