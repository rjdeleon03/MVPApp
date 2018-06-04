package com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries;

import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Dialog.DiseasesInjuriesDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Dialog.DiseasesInjuriesDialogViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiseasesInjuriesFragment extends BaseEnumFragment {

    private DiseasesInjuriesFragmentAdapter mDiseasesInjuriesAdapter;

    public static DiseasesInjuriesFragment newInstance() {
        return new DiseasesInjuriesFragment();
    }

    public DiseasesInjuriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DiseasesInjuriesDialogViewModel dialogViewModel = new DiseasesInjuriesDialogViewModel(
                getContext(),
                (DiseasesInjuriesRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DiseasesInjuriesDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        DiseasesInjuriesDialogViewModel dialogViewModel = new DiseasesInjuriesDialogViewModel(
                getContext(),
                (DiseasesInjuriesRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DiseasesInjuriesDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mDiseasesInjuriesAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mDiseasesInjuriesAdapter = new DiseasesInjuriesFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (DiseasesInjuriesViewModel) mViewModel);
        mRowRecycler.setAdapter(mDiseasesInjuriesAdapter);
    }
}
