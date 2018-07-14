package com.cpu.quikdata.ModulesV2.NewForm;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

public class NewFormActivity extends AppCompatActivity implements INewFormActivity {

    public static final String NEW_FORM_VIEWMODEL_TAG = "NEW_FORM_VIEWMODEL_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_form_activity);

        NewFormFragment newFormFragment = findOrCreateViewFragment();
        final NewFormViewModel newFormViewModel = findOrCreateViewModel();
        newFormFragment.setViewModel(newFormViewModel);
    }

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

    }

    @Override
    public void onGenInfoButtonPressed() {

    }
}
