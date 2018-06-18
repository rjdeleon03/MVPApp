package com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;

public abstract class BaseEnumDialogFragment extends DialogFragment {

    protected BaseEnumDialogViewModel mViewModel;

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(BaseEnumDialogViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the dialog using a view
     * @param view
     * @return
     */
    protected Dialog createDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

//        if (mViewModel.type.get() != null) builder.setTitle(mViewModel.type.get().toString());

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                mViewModel.navigateOnOkButtonPressed();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                mViewModel.navigateOnCancelButtonPressed();
            }
        });

        Dialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return dialog;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        mViewModel.navigateOnCancelButtonPressed();
    }
}
