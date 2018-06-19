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

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogItemViewModelGenderTuple;
import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModulesV2.Dialog.ViewModel.DialogViewModel;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.BaseEnumDialogBinding;
import com.cpu.quikdata.databinding.BaseEnumGenderTupleBinding;

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
        mBinding.setViewModel((DialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        TableLayout itemLayout = view.findViewById(R.id.base_enum_dialog_table);
        for(DialogItemViewModelGenderTuple itemViewModel : mViewModel.getItemViewModels()) {
            BaseEnumGenderTupleBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.base_enum_gender_tuple, null, false);
            itemBinding.setViewModel(itemViewModel);

            TableRow itemView = (TableRow)itemBinding.getRoot();
            itemLayout.addView(itemView);
        }

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
