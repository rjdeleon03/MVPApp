package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumDialogBinding;
import com.cpu.quikdata.databinding.BaseEnumGenderTupleBinding;

public class EnumDialogFragment extends BaseEnumDialogFragment {

    protected DialogViewModel mViewModel;
    private BaseEnumDialogBinding mBinding;

    public static EnumDialogFragment newInstance() {
        return new EnumDialogFragment();
    }

    public EnumDialogFragment(){}

    public void setViewModel(DialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_dialog, null, false);
        mBinding.setViewModel((DialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        TableLayout itemLayout = view.findViewById(R.id.base_enum_dialog_table);
        for(DialogItemViewModelGenderTuple itemViewModel : mViewModel.getItemViewModels()) {
            BaseEnumGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_gender_tuple, null, false);
            itemBinding.setViewModel(itemViewModel);

            TableRow itemView = (TableRow)itemBinding.getRoot();
            itemLayout.addView(itemView);
        }

        return super.createDialog(view);
    }
}
