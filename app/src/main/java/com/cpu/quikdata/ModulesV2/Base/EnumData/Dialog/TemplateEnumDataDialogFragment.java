package com.cpu.quikdata.ModulesV2.Base.EnumData.Dialog;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.cpu.quikdata.ModulesV2.Base.BaseDialogFragment;
import com.cpu.quikdata.ModulesV2.Base.EnumData.ITemplateEnumDataFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.TemplateEnumDataDialogFragmentBinding;

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
        View view = inflater.inflate(R.layout.template_enum_data_dialog_fragment, null, false);
        TemplateEnumDataDialogFragmentBinding binding = TemplateEnumDataDialogFragmentBinding.bind(view);
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

//        Dialog dialog = builder.create();
//        Window window = dialog.getWindow();
//        if (window != null) {
////            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
////            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        }


        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        return dialog;
    }
}
