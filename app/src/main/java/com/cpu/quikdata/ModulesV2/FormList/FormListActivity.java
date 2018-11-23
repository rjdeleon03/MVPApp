package com.cpu.quikdata.ModulesV2.FormList;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.cpu.quikdata.AppUtil;
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
    private FormListFragment mFormListFragment;
    private FormListViewModel mFormListViewModel;

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

        mFormListFragment = findOrCreateViewFragment();
        mFormListViewModel = findOrCreateViewModel();
        mFormListFragment.setViewModel(mFormListViewModel);

        mFormListViewModel.onActivityCreated();
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
    public void onItemSubmitButtonPressed(String id) {
        // TODO: Show information in user that it is being submitted
    }

    /**
     * Handles form submission completion event
     * @param success
     */
    @Override
    public void onItemSubmitFinished(boolean success) {
        if (success) {
            displayToastMessage("Form successfully submitted!", Toast.LENGTH_LONG);
            return;
        }
        displayToastMessage("Failed to submit form. Please check your Internet connection.", Toast.LENGTH_LONG);
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
    public void onItemDeleteButtonPressed(final String id) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        mFormListViewModel.deletedItemWithId(id);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this form?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }
}
