package com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Health.DiseasesInjuriesDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Dialog.DiseasesInjuriesDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Health.DiseasesInjuries.Row.DiseasesInjuriesRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.HEALTH_DISEASES;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiseasesInjuriesFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<DiseasesInjuriesRowViewModel> mDiseasesInjuriesAdapter;

    public static DiseasesInjuriesFragment newInstance() {
        return new DiseasesInjuriesFragment();
    }

    public DiseasesInjuriesFragment() {
        setFragmentTag(HEALTH_DISEASES.toString());
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DiseasesInjuriesDialogViewModel dialogViewModel = new DiseasesInjuriesDialogViewModel(
                (BaseEnumRepositoryManager<DiseasesInjuriesDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        super.setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        DiseasesInjuriesDialogViewModel dialogViewModel = new DiseasesInjuriesDialogViewModel(
                (BaseEnumRepositoryManager<DiseasesInjuriesDataRow, GenericEnumDataRow.AgeGroup>) mViewModel,
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
        mDiseasesInjuriesAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mDiseasesInjuriesAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                DiseasesInjuriesRowViewModel.class,
                this,
                (DiseasesInjuriesViewModel) mViewModel);
        mRowRecycler.setAdapter(mDiseasesInjuriesAdapter);
    }
}
