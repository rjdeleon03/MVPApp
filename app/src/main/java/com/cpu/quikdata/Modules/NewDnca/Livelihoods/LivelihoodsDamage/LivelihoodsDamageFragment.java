package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.view.View;

import com.cpu.quikdata.Models.Generics.GenericEnumDataRow;
import com.cpu.quikdata.Models.Livelihoods.LivelihoodsDamageDataRow;
import com.cpu.quikdata.Modules.NewDnca.Base.BaseEnumRepositoryManager;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumRowAdapter;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.LivelihoodsDamageDialogViewModel;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Row.LivelihoodsDamageRowViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_DAMAGE;

public class LivelihoodsDamageFragment extends BaseEnumFragment {

    private BaseEnumRowAdapter<LivelihoodsDamageRowViewModel> mLivelihoodsDamageFragmentAdapter;

    public static LivelihoodsDamageFragment newInstance() {
        return new LivelihoodsDamageFragment();
    }

    public LivelihoodsDamageFragment() {
        setFragmentTag(LIVELIHOODS_DAMAGE.toString());
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsDamageDialogViewModel dialogViewModel = new LivelihoodsDamageDialogViewModel(
                (BaseEnumRepositoryManager<LivelihoodsDamageDataRow, GenericEnumDataRow.LivelihoodsType>) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsDamageDialogViewModel dialogViewModel = new LivelihoodsDamageDialogViewModel(
                (BaseEnumRepositoryManager<LivelihoodsDamageDataRow, GenericEnumDataRow.LivelihoodsType>) mViewModel,
                rowIndex,
                false);
        setupDialog(dialogViewModel);
    }

    /**
     * Refreshes the data displayed
     */
    @Override
    protected void refreshData() {
        super.refreshData();
        mLivelihoodsDamageFragmentAdapter.notifyDataSetChanged();
    }

    /**
     * Initialize RecyclerView grid for displaying population data rows
     * @param view
     */
    @Override
    protected void setupRecyclerGrid(View view) {
        super.setupRecyclerGrid(view);
        mLivelihoodsDamageFragmentAdapter = new BaseEnumRowAdapter(
                getContext().getApplicationContext(),
                LivelihoodsDamageRowViewModel.class,
                this,
                (LivelihoodsDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mLivelihoodsDamageFragmentAdapter);
    }
}
