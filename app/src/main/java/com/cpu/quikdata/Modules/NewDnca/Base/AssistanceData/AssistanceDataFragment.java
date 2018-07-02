package com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData;

import android.support.v4.app.Fragment;
import android.view.View;

import com.cpu.quikdata.Models.Generics.AssistanceDataRow;
import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.AssistanceData.Dialog.AssistanceDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class AssistanceDataFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<AssistanceRowViewModel> mAssistanceDataAdapter;

    public AssistanceDataFragment() {
        // Required empty public constructor
    }

    /**
     * Show assistance data dialog when add button is pressed
     */
    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        AssistanceDialogViewModel dialogViewModel = new AssistanceDialogViewModel(
                (BaseEnumRepositoryManager<AssistanceDataRow, GenericEnumDataRow.Assistance>) mViewModel);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Handle when card is selected
     * @param rowIndex
     */
    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        AssistanceDialogViewModel dialogViewModel = new AssistanceDialogViewModel(
                (BaseEnumRepositoryManager<AssistanceDataRow, GenericEnumDataRow.Assistance>) mViewModel,
                rowIndex);
        super.setupDialog(dialogViewModel);
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mAssistanceDataAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying assistance data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mAssistanceDataAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                AssistanceRowViewModel.class,
                this,
                (AssistanceDataViewModel) mViewModel);
        mRowRecycler.setAdapter(mAssistanceDataAdapter);
    }
}
