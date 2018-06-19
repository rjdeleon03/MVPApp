package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.View;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModel;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelBoolean;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelRemarks;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelSingleNumber;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumBooleanBinding;
import com.cpu.quikdata.databinding.BaseEnumDialogBinding;
import com.cpu.quikdata.databinding.BaseEnumGenderTupleBinding;
import com.cpu.quikdata.databinding.BaseEnumSingleNumberBinding;
import com.cpu.quikdata.databinding.BaseEnumRemarksBinding;

public class EnumDialogFragment extends DialogFragment {

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
        mBinding.setViewModel(mViewModel);
        View view = mBinding.getRoot();

        // Add dialog items according to type
        TableLayout itemLayout = view.findViewById(R.id.base_enum_dialog_table);
        for(DialogItemViewModel itemViewModel : mViewModel.getItemViewModels()) {

            TableRow itemView = null;

            if (itemViewModel instanceof  DialogItemViewModelGenderTuple) {

                // If gender tuple field will be displayed
                BaseEnumGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_gender_tuple, null, false);
                itemBinding.setViewModel((DialogItemViewModelGenderTuple) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelSingleNumber) {

                // If single number field will be displayed
                BaseEnumSingleNumberBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_single_number, null, false);
                itemBinding.setViewModel((DialogItemViewModelSingleNumber) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelBoolean) {

                // If boolean field will be displayed
                BaseEnumBooleanBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_boolean, null, false);
                itemBinding.setViewModel((DialogItemViewModelBoolean) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            } else if (itemViewModel instanceof DialogItemViewModelRemarks) {

                // If remarks field will be displayed
                BaseEnumRemarksBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_remarks, null, false);
                itemBinding.setViewModel((DialogItemViewModelRemarks) itemViewModel);
                itemView = (TableRow) itemBinding.getRoot();

            }

            itemLayout.addView(itemView);
        }

        // Build dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        if (mViewModel.type.get() != null) builder.setTitle(mViewModel.type.get().toString());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mViewModel.navigateOnOkButtonPressed();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return dialog;
    }
}
