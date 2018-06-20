package com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Shelter.HouseDamageData.Dialog.HouseDamageDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.SHELTER_HOUSE_DAMAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseDamageFragment extends BaseEnumFragment {

    private HouseDamageFragmentAdapter mHouseDamageAdapter;

    public static HouseDamageFragment newInstance() {
        return new HouseDamageFragment();
    }

    public HouseDamageFragment() {
        setFragmentTag(SHELTER_HOUSE_DAMAGE.toString());
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        HouseDamageDialogViewModel dialogViewModel = new HouseDamageDialogViewModel(
                getContext(),
                (HouseDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        HouseDamageDialogViewModel dialogViewModel = new HouseDamageDialogViewModel(
                getContext(),
                (HouseDamageRepositoryManager) mViewModel,
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
