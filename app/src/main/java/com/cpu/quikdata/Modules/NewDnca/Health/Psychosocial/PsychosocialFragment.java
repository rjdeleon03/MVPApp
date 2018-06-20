package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Dialog.PsychosocialDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_PSYCHOSOCIAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class PsychosocialFragment extends BaseEnumFragment {

    private PsychosocialFragmentAdapter mPsychosocialAdapter;

    public static PsychosocialFragment newInstance() {
        return new PsychosocialFragment();
    }

    public PsychosocialFragment() {
        setFragmentTag(HEALTH_PSYCHOSOCIAL.toString());
    }

    /**
     * Show psychosocial data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        PsychosocialDialogViewModel dialogViewModel = new PsychosocialDialogViewModel(
                getContext(),
                (PsychosocialRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        PsychosocialDialogViewModel dialogViewModel = new PsychosocialDialogViewModel(
                getContext(),
                (PsychosocialRepositoryManager) mViewModel,
                rowIndex,
                false);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mPsychosocialAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mPsychosocialAdapter = new PsychosocialFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (PsychosocialViewModel) mViewModel);
        mRowRecycler.setAdapter(mPsychosocialAdapter);
    }
}
