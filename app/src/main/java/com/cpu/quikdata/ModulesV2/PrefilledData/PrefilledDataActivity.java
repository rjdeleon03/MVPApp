package com.cpu.quikdata.ModulesV2.PrefilledData;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.cpu.quikdata.Injection;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.TemplateQuestionFragment;
import com.cpu.quikdata.ModulesV2.Base.MainTemplate.ViewModel.TemplateQuestionViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.Utils.ActivityUtils;
import com.cpu.quikdata.ViewModelHolder;

public class PrefilledDataActivity extends AppCompatActivity implements IPrefilledDataActivity {

    public static final String TEMPLATE_QUESTION_VIEWMODEL_TAG = "TEMPLATE_QUESTION_VIEWMODEL_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefilled_data_activity);
        setupBackButton();

        TemplateQuestionFragment templateQuestionFragment = findOrCreateViewFragment();
        TemplateQuestionViewModel templateQuestionViewModel = findOrCreateViewModel();
        templateQuestionFragment.setViewModel(templateQuestionViewModel);

    }

    /**
     * Sets up back button
     */
    public void setupBackButton() {
        ImageButton backButton = findViewById(R.id.dnca_list_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
            formListViewModel.setActivity(this);

            // Bind viewModel to activity
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    ViewModelHolder.createContainer(formListViewModel),
                    TEMPLATE_QUESTION_VIEWMODEL_TAG);

            return formListViewModel;
        }
    }
}
