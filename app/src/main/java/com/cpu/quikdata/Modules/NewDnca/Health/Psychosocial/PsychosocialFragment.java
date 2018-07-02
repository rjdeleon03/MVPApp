package com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.PsychosocialDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Dialog.PsychosocialDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.Psychosocial.Row.PsychosocialRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_PSYCHOSOCIAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class PsychosocialFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<PsychosocialRowViewModel> mPsychosocialAdapter;

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
                (BaseEnumRepositoryManager<PsychosocialDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
                (BaseEnumRepositoryManager<PsychosocialDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mPsychosocialAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                PsychosocialRowViewModel.class,
                this,
                (PsychosocialViewModel) mViewModel);
        mRowRecycler.setAdapter(mPsychosocialAdapter);
    }
}
