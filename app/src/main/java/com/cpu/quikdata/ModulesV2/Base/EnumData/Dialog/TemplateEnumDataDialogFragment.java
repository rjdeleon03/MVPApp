package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.cpu.quikdata.ModulesV2.Base.BaseDialogFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateEnumDataDialogFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class TemplateEnumDataDialogFragment extends BaseDialogFragment<TemplateEnumDataDialogViewModel> {

    private View mView;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.template_enum_data_dialog_fragment, container, false);
        TemplateEnumDataDialogFragmentBinding binding = TemplateEnumDataDialogFragmentBinding.bind(mView);
        binding.setViewModel(mViewModel);
        return mView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mView);

//        if (mViewModel.type.get() != null) builder.setTitle(mViewModel.type.get().toString());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                mViewModel.navigateOnOkButtonPressed();
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
