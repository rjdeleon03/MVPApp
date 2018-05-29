package com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.BaseEnumFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.DamageCostDialogFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.Livelihoods.DamageCost.Dialog.DamageCostDialogViewModel;

public class DamageCostFragment extends BaseEnumFragment {

    private DamageCostFragmentAdapter mDamageCostFragmentAdapter;

    public static DamageCostFragment newInstance() {
        return new DamageCostFragment();
    }

    public DamageCostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAddButtonPressed() {
        if (super.dialogIsAlreadyShown()) return;
        DamageCostDialogViewModel dialogViewModel = new DamageCostDialogViewModel(
                getContext(),
                (DamageCostRepositoryManager) mViewModel,
                mAgeGroupSpinner.getSelectedItemPosition(),
                true);
        dialogViewModel.setBaseAgeGroupNavigator(this);
        mDialogFragment = DamageCostDialogFragment.getInstance();
        mDialogFragment.setViewModel(dialogViewModel);
        mDialogFragment.show(getFragmentManager(), "");

    }

    @Override
    public void onCardSelected(int rowIndex) {

    }
}
