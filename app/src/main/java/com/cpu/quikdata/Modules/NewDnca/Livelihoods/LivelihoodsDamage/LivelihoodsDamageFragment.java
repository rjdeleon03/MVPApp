package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.LivelihoodsDamageDialogViewModel;

import static com.cpu.quikdata.AppConstants.NewDncaComponent.LIVELIHOODS_DAMAGE;

public class LivelihoodsDamageFragment extends BaseEnumFragment {

    private LivelihoodsDamageFragmentAdapter mLivelihoodsDamageFragmentAdapter;

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
                getContext(),
                (LivelihoodsDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        setupDialog(dialogViewModel);
    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsDamageDialogViewModel dialogViewModel = new LivelihoodsDamageDialogViewModel(
                getContext(),
                (LivelihoodsDamageRepositoryManager) mViewModel,
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
        mLivelihoodsDamageFragmentAdapter = new LivelihoodsDamageFragmentAdapter(
                getContext().getApplicationContext(),
                this,
                (LivelihoodsDamageViewModel) mViewModel);
        mRowRecycler.setAdapter(mLivelihoodsDamageFragmentAdapter);
    }
}
