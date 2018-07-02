package com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Shelter.ShelterNeedsDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Dialog.ShelterNeedsDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Shelter.ShelterNeedsData.Row.ShelterNeedsRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_NEEDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShelterNeedsFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<ShelterNeedsRowViewModel> mShelterNeedsFragmentAdapter;

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
                (BaseEnumRepositoryManager<ShelterNeedsDataRow, GenericEnumDataRow.NeedsType>) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        ShelterNeedsDialogViewModel dialogViewModel = new ShelterNeedsDialogViewModel(
                (BaseEnumRepositoryManager<ShelterNeedsDataRow, GenericEnumDataRow.NeedsType>) mViewModel,
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
        mShelterNeedsFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mShelterNeedsFragmentAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                ShelterNeedsRowViewModel.class,
                this,
                (ShelterNeedsViewModel) mViewModel);
        mRowRecycler.setAdapter(mShelterNeedsFragmentAdapter);
    }
}
