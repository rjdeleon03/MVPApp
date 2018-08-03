package com.cpu.quikdata.ModulesV2.FormList;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.cpu.quikdata.BaseActivity;
import com.cpu.quikdata.Injection;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewFactory;
import com.cpu.quikdata.ViewModelHolder;
import com.novoda.merlin.Merlin;
import com.novoda.merlin.registerable.connection.Connectable;

import io.realm.Realm;

public class FormListActivity extends BaseActivity implements IFormListActivity {

    public static final String FORM_LIST_VIEWMODEL_TAG = "FORM_LIST_VIEWMODEL_TAG";
    private static int FRAGMENT_CONTAINER = R.id.fragment_container;

    private Merlin mMerlin;

    public FormListActivity() {
        super("", FRAGMENT_CONTAINER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_list_activity);

        // Setup network change listener (Merlin)
        mMerlin = new Merlin.Builder().withConnectableCallbacks().build(this);
        mMerlin.registerConnectable(new Connectable() {
            @Override
            public void onConnect() {
                // call DNCA form repository for syncing files to server
                // Do something you haz internet!
            }
        });

        // Setup the toolbar
        setupToolbar(false);

        FormListFragment formListFragment = findOrCreateViewFragment();
        final FormListViewModel formListViewModel = findOrCreateViewModel();
        formListFragment.setViewModel(formListViewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMerlin.bind();
    }

    @Override
    protected void onPause() {
        mMerlin.unbind();
        super.onPause();
    }

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private FormListFragment findOrCreateViewFragment() {

        FormListFragment formListFragment = (FormListFragment) getSupportFragmentManager().findFragmentById(FRAGMENT_CONTAINER);

        if (formListFragment == null) {
            formListFragment = FormListFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formListFragment, FRAGMENT_CONTAINER, false);
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
            formListViewModel.setViewComponent(this);

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
     * Handles item edit button pressed event
     */
    @Override
    public void onItemEditButtonPressed(String id) {
        ViewFactory.startNewFormActivity(this, id);
    }

    /**
     * Handles item delete button pressed event
     */
    @Override
    public void onItemDeleteButtonPressed(String id) {
        // TODO: Add confirmation dialog
    }
}
