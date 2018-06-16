package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog.ShelterNeedsDialogFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog.ShelterNeedsDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterNeedsFragment extends BaseEnumFragment {

    private ShelterNeedsFragmentAdapter mShelterNeedsFragmentAdapter;

    public static ShelterNeedsFragment newInstance() {
        return new ShelterNeedsFragment();
    }

    public ShelterNeedsFragment() {
        setFragmentTag(SHELTER_NEEDS.toString());
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        ShelterNeedsDialogViewModel dialogViewModel = new ShelterNeedsDialogViewModel(
                getContext(),
                (ShelterNeedsRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = ShelterNeedsDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        ShelterNeedsDialogViewModel dialogViewModel = new ShelterNeedsDialogViewModel(
                getContext(),
                (ShelterNeedsRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = ShelterNeedsDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mShelterNeedsFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mShelterNeedsFragmentAdapter = new ShelterNeedsFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (ShelterNeedsViewModel) mViewModel);
        mRowRecycler.setAdapter(mShelterNeedsFragmentAdapter);
    }
}
