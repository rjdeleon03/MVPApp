package com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds;

import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.Dialog.SpecialNeedsDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.SpecialNeeds.Dialog.SpecialNeedsDialogViewModel;

import static com.rjdeleon.mvp_app.AppConstants.HealthComponent.HEALTH_SPECIAL_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialNeedsFragment extends BaseEnumFragment {

    private SpecialNeedsFragmentAdapter mSpecialNeedsAdapter;

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
                getContext(),
                (SpecialNeedsRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = SpecialNeedsDialogFragment.newInstance();
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
        SpecialNeedsDialogViewModel dialogViewModel = new SpecialNeedsDialogViewModel(
                getContext(),
                (SpecialNeedsRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = SpecialNeedsDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
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
        mSpecialNeedsAdapter = new SpecialNeedsFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (SpecialNeedsViewModel) mViewModel);
        mRowRecycler.setAdapter(mSpecialNeedsAdapter);
    }
}
