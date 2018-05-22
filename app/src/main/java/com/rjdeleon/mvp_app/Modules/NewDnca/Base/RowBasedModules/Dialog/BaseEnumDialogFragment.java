package com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog;

import android.app.Dialog;
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
        Dialog dialog = builder.create();

        // Set transparent background to dialog
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return dialog;
    }
}