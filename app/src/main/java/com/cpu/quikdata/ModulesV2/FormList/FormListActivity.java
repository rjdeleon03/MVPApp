package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cpu.quikdata.ModelsV2.Form.DncaForm;
import com.cpu.quikdata.ModelsV2.Form.FormDetails;
import com.cpu.quikdata.Modules.DNCAList.DNCAListFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;

import java.util.UUID;

import io.realm.Realm;

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

        FormListFragment formListFragment = (FormListFragment) getSupportFragmentManager().findFragmentByTag(FORM_LIST_VIEWMODEL_TAG);

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
//        Realm realm = Realm.getDefaultInstance();
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                FormDetails tempFormDetails = realm.createObject(FormDetails.class, UUID.randomUUID().toString());
//                tempFormDetails.setSitio("Sitio Something");
//                realm.createObject(DncaForm.class, UUID.randomUUID().toString()).setFormDetails(tempFormDetails);
//            }
//        });
//        realm.close();
        ViewFactory.startNewDncaActivity(this);
    }
}
