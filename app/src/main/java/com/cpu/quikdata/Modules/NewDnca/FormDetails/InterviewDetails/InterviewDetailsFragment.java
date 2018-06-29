package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails;

import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Dialog.InterviewDetailsDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.FORM_INTERVIEW_DETAILS;

public class InterviewDetailsFragment extends BaseEnumFragment {

    private InterviewDetailsFragmentAdapter mInterviewDetailsAdapter;

    public static InterviewDetailsFragment newInstance() {
        return new InterviewDetailsFragment();
    }

    public InterviewDetailsFragment() {
        setFragmentTag(FORM_INTERVIEW_DETAILS.toString());
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        InterviewDetailsDialogViewModel dialogViewModel = new InterviewDetailsDialogViewModel(
                (InterviewDetailsRepositoryManager) mViewModel);
        setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        InterviewDetailsDialogViewModel dialogViewModel = new InterviewDetailsDialogViewModel(
                (InterviewDetailsRepositoryManager) mViewModel,
                rowIndex);
        setupDialog(dialogViewModel);
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mInterviewDetailsAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mInterviewDetailsAdapter = new InterviewDetailsFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (InterviewDetailsViewModel) mViewModel);
        mRowRecycler.setAdapter(mInterviewDetailsAdapter);
    }
}
