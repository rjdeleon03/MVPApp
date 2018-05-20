package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData;


import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog.CasualtiesDataDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CasualtiesData.Dialog.CasualtiesDataDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CasualtiesDataFragment extends BaseEnumFragment {

    private CasualtiesDataFragmentAdapter mCasualtiesDataAdapter;

    public static CasualtiesDataFragment getInstance() {
        return new CasualtiesDataFragment();
    }

    public CasualtiesDataFragment() {
        // Required empty public constructor
    }

    /**
     * Show Casualties Data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        CasualtiesDataDialogViewModel dialogViewModel = new CasualtiesDataDialogViewModel(
                getContext(),
                (CasualtiesDataRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = CasualtiesDataDialogFragment.getInstance();
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
        CasualtiesDataDialogViewModel dialogViewModel = new CasualtiesDataDialogViewModel(
                getContext(),
                (CasualtiesDataRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = CasualtiesDataDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mCasualtiesDataAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mCasualtiesDataAdapter = new CasualtiesDataFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (CasualtiesDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mCasualtiesDataAdapter);
    }
}
