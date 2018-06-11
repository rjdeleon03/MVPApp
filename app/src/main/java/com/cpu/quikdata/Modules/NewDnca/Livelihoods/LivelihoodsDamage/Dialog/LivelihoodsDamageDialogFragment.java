package com.cpu.quikdata.Modules.NewDnca.Livelihoods.LivelihoodsDamage.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.LivelihoodsDamageDialogBinding;

public class LivelihoodsDamageDialogFragment extends BaseEnumDialogFragment {

    private LivelihoodsDamageDialogBinding mBinding;
    private RecyclerView mCheckboxRecycler;
    private LivelihoodsDamageDialogFragmentAdapter mLivelihoodsDamageDialogFragmentAdapter;

    public static LivelihoodsDamageDialogFragment newInstance() {
        return new LivelihoodsDamageDialogFragment();
    }

    public LivelihoodsDamageDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.livelihoods_damage_dialog, null, false);
        mBinding.setViewModel((LivelihoodsDamageDialogViewModel) mViewModel);
        View view = mBinding.getRoot();
        setupCheckboxGrid(view);

        return super.createDialog(view);
    }

    private void setupCheckboxGrid(View view) {
        mCheckboxRecycler = view.findViewById(R.id.nd_lh_damage_dlg_checkbox_grid);
        mCheckboxRecycler.setHasFixedSize(true);
        mCheckboxRecycler.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        ((StaggeredGridLayoutManager) mCheckboxRecycler.getLayoutManager()).setSpanCount(2);

        // Setup adapter and use with fragment
        mLivelihoodsDamageDialogFragmentAdapter = new LivelihoodsDamageDialogFragmentAdapter((LivelihoodsDamageDialogViewModel) mViewModel);
        mCheckboxRecycler.setAdapter(mLivelihoodsDamageDialogFragmentAdapter);
    }
}
