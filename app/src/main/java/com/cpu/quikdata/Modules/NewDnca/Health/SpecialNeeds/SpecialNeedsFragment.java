package com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.SpecialNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Dialog.SpecialNeedsDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.SpecialNeeds.Row.SpecialNeedsRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_SPECIAL_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialNeedsFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<SpecialNeedsRowViewModel> mSpecialNeedsAdapter;

    public static SpecialNeedsFragment newInstance() {
        return new SpecialNeedsFragment();
    }

    public SpecialNeedsFragment() {
        setFragmentTag(HEALTH_SPECIAL_NEEDS.toString());
    }

    /**
     * Show special needs data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        SpecialNeedsDialogViewModel dialogViewModel = new SpecialNeedsDialogViewModel(
                (BaseEnumRepositoryManager<SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType>) mViewModel,
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
        SpecialNeedsDialogViewModel dialogViewModel = new SpecialNeedsDialogViewModel(
                (BaseEnumRepositoryManager<SpecialNeedsDataRow, GenericEnumDataRow.SpecialNeedsType>) mViewModel,
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
        mSpecialNeedsAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mSpecialNeedsAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                SpecialNeedsRowViewModel.class,
                this,
                (SpecialNeedsViewModel) mViewModel);
        mRowRecycler.setAdapter(mSpecialNeedsAdapter);
    }
}
