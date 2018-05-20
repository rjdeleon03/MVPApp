package com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataFragmentAdapter;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.PopulationDataViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.Dialog.HouseDamageDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.ShelterInformation.HouseDamageData.Dialog.HouseDamageDialogViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseDamageFragment extends BaseEnumFragment {

    private HouseDamageFragmentAdapter mHouseDamageAdapter;

    public static HouseDamageFragment newInstance() {
        return new HouseDamageFragment();
    }

    public HouseDamageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        HouseDamageDialogViewModel dialogViewModel = new HouseDamageDialogViewModel(
                getContext(),
                (HouseDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = HouseDamageDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        HouseDamageDialogViewModel dialogViewModel = new HouseDamageDialogViewModel(
                getContext(),
                (HouseDamageRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = HouseDamageDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getChildFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mHouseDamageAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mHouseDamageAdapter = new HouseDamageFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (HouseDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mHouseDamageAdapter);
    }
}
