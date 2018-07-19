package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.cpu.quikdata.ModulesV2.Base.BaseDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateEnumDataDialogBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateEnumDataDialogFragment extends BaseDialogFragment<TemplateEnumDataDialogViewModel> {


    public TemplateEnumDataDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Gets new instance
     * @return
     */
    public static TemplateEnumDataDialogFragment newInstance() {
        return new TemplateEnumDataDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.template_enum_data_dialog, null, false);
        TemplateEnumDataDialogBinding binding = TemplateEnumDataDialogBinding.bind(view);
        binding.setViewModel(mViewModel);

        // Build dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot());

        if (mViewModel.getType() != null) builder.setTitle(mViewModel.getType().toString());

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

        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return dialog;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        super.onDismiss(dialog);
    }
}
