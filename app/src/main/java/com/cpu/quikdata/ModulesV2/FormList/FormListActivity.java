package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpu.quikdata.AppUtil;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineFamilies;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHouses;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselineHousesRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulation;
import com.cpu.quikdata.ModelsV2.PrefilledData.BaselinePopulationRow;
import com.cpu.quikdata.ModelsV2.PrefilledData.PrefilledData;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
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
        FormListViewModel formListViewModel = findOrCreateViewModel();
        formListFragment.setViewModel(formListViewModel);

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
            FormListViewModel formListViewModel = new FormListViewModel();
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
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                seedData(realm);
            }
        });
        realm.close();
//        ViewFactory.startNewDncaActivity(this);
    }

    private void seedData(Realm realm) {

        PrefilledData prefilledData = realm.createObject(PrefilledData.class, AppUtil.generateId());

        {
            BaselinePopulation baselinePopulation = realm.createObject(BaselinePopulation.class, AppUtil.generateId());
            RealmList<BaselinePopulationRow> rows = new RealmList<>();
            for (GenericEnumDataRow.AgeGroup ageGroup : GenericEnumDataRow.AgeGroup.values()) {
                if (ageGroup == GenericEnumDataRow.AgeGroup.ALL) continue;

                BaselinePopulationRow row = realm.createObject(BaselinePopulationRow.class, AppUtil.generateId());
                row.setAgeGroup(ageGroup.toString());
                row.setMale(13);
                row.setFemale(25);
                rows.add(row);
            }
            baselinePopulation.setRows(rows);
            prefilledData.setBaselinePopulation(baselinePopulation);
        }

        {
            BaselineFamilies baselineFamilies = realm.createObject(BaselineFamilies.class, AppUtil.generateId());
            baselineFamilies.setFamilies(11);
            baselineFamilies.setHouseholds(22);
            prefilledData.setBaselineFamilies(baselineFamilies);
        }

        {
            BaselineHouses baselineHouses = realm.createObject(BaselineHouses.class, AppUtil.generateId());
            RealmList<BaselineHousesRow> rows = new RealmList<>();
            for (GenericEnumDataRow.HouseType houseType : GenericEnumDataRow.HouseType.values()) {
                if (houseType == GenericEnumDataRow.HouseType.ALL) continue;

                BaselineHousesRow row = realm.createObject(BaselineHousesRow.class, AppUtil.generateId());
                row.setNumber(33);
                rows.add(row);
            }
            baselineHouses.setRows(rows);
            prefilledData.setBaselineHouses(baselineHouses);
        }
    }
}
