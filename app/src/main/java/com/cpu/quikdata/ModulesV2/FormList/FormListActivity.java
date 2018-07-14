package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Injection;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineFamilies;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHouses;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHousesRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulation;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import io.realm.Realm;
import io.realm.RealmList;

public class FormListActivity extends AppCompatActivity implements IFormListActivity {

    public static final String FORM_LIST_VIEWMODEL_TAG = "FORM_LIST_VIEWMODEL_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_list_activity);

        FormListFragment formListFragment = findOrCreateViewFragment();
        final FormListViewModel formListViewModel = findOrCreateViewModel();
        formListFragment.setViewModel(formListViewModel);

        ImageButton settingsButton = findViewById(R.id.toolbar_settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formListViewModel.navigateOnSettingsButtonPressed();
            }
        });
    }

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private FormListFragment findOrCreateViewFragment() {

        FormListFragment formListFragment = (FormListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (formListFragment == null) {
            formListFragment = FormListFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formListFragment, R.id.fragment_container, false);
        }

        return formListFragment;
    }

    /**
     * Finds or creates the viewModel
     * @return
     */
    @NonNull
    private FormListViewModel findOrCreateViewModel() {

        ViewModelHolder<FormListViewModel> retainedViewModel = (ViewModelHolder<FormListViewModel>) getSupportFragmentManager().findFragmentByTag(FORM_LIST_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            // Create viewModel if it does not exist yet
            FormListViewModel formListViewModel = new FormListViewModel(Injection.provideDncaRepository(this));
            formListViewModel.setFormListActivity(this);

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(formListViewModel),
                    FORM_LIST_VIEWMODEL_TAG);

            return formListViewModel;
        }
    }

    /**
     * Handles add button pressed event
     */
    @Override
    public void onAddButtonPressed() {
        ViewFactory.startNewFormActivity(this);
    }

    /**
     * Handles settings button pressed event
     */
    @Override
    public void onSettingsButtonPressed() {
        ViewFactory.startPrefilledActivity(this);
    }
}
