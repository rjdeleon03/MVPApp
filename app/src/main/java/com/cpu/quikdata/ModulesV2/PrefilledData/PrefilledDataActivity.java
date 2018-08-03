package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.cpu.quikdata.BaseActivity;
import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

public class PrefilledDataActivity extends BaseActivity implements IPrefilledDataActivity {

    public static final String TEMPLATE_QUESTION_VIEWMODEL_TAG = "TEMPLATE_QUESTION_VIEWMODEL_TAG";
    private static final String TOOLBAR_TITLE = "Settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefilled_data_activity);

        // Setup the toolbar
        mToolbarTitle = TOOLBAR_TITLE;
        setupToolbar(true);

        TemplateQuestionFragment templateQuestionFragment = findOrCreateViewFragment();
        TemplateQuestionViewModel templateQuestionViewModel = findOrCreateViewModel();
        templateQuestionFragment.setViewModel(templateQuestionViewModel);

    }

    /**
     * Inflates the menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /**
     * Finds or creates the fragment
     * @return
     */
    @NonNull
    private PrefilledDataFragment findOrCreateViewFragment() {

        PrefilledDataFragment formListFragment = (PrefilledDataFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        if (formListFragment == null) {
            formListFragment = PrefilledDataFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), formListFragment, R.id.fragment_container, false);
        }

        return formListFragment;
    }

    /**
     * Finds or creates the viewModel
     * @return
     */
    @NonNull
    private TemplateQuestionViewModel findOrCreateViewModel() {

        ViewModelHolder<TemplateQuestionViewModel> retainedViewModel = (ViewModelHolder<TemplateQuestionViewModel>) getSupportFragmentManager().findFragmentByTag(TEMPLATE_QUESTION_VIEWMODEL_TAG);

        if (retainedViewModel != null && retainedViewModel.getViewmodel() != null) {

            // Return viewModel if retained
            return retainedViewModel.getViewmodel();
        } else {

            // Create viewModel if it does not exist yet
            PrefilledDataViewModel formListViewModel = new PrefilledDataViewModel(Injection.provideDncaRepository(this));
            formListViewModel.setViewComponent(this);

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(formListViewModel),
                    TEMPLATE_QUESTION_VIEWMODEL_TAG);

            return formListViewModel;
        }
    }
}
