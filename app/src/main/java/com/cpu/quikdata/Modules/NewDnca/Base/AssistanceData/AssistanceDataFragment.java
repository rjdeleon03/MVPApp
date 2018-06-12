package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Dialog.AssistanceDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Dialog.AssistanceDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class AssistanceDataFragment extends BaseEnumFragment {

    private AssistanceDataFragmentAdapter mAssistanceDataAdapter;

    public AssistanceDataFragment() {
        // Required empty public constructor
    }

    /**
     * Show assistance data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        AssistanceDialogViewModel dialogViewModel = new AssistanceDialogViewModel(
                getContext(),
                (AssistanceDataRepositoryManager) mViewModel);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = AssistanceDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        AssistanceDialogViewModel dialogViewModel = new AssistanceDialogViewModel(
                getContext(),
                (AssistanceDataRepositoryManager) mViewModel,
                rowIndex);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = AssistanceDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mAssistanceDataAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying assistance data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mAssistanceDataAdapter = new AssistanceDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (AssistanceDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mAssistanceDataAdapter);
    }
}
