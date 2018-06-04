package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage;

import android.view.View;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.LivelihoodsDamageDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog.LivelihoodsDamageDialogViewModel;

public class LivelihoodsDamageFragment extends BaseEnumFragment {

    private LivelihoodsDamageFragmentAdapter mLivelihoodsDamageFragmentAdapter;

    public static LivelihoodsDamageFragment newInstance() {
        return new LivelihoodsDamageFragment();
    }

    public LivelihoodsDamageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsDamageDialogViewModel dialogViewModel = new LivelihoodsDamageDialogViewModel(
                getContext(),
                (LivelihoodsDamageRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = LivelihoodsDamageDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");

    }

    @Override
    public void onCardSelected(int rowIndex) {
        if (super.dialogIsAlreadyShown()) return;
        LivelihoodsDamageDialogViewModel dialogViewModel = new LivelihoodsDamageDialogViewModel(
                getContext(),
                (LivelihoodsDamageRepositoryManager) mViewModel,
                rowIndex,
                false);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = LivelihoodsDamageDialogFragment.newInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");
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
