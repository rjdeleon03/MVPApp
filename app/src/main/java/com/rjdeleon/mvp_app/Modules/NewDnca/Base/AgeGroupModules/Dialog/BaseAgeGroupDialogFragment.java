package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

public abstract class BaseAgeGroupDialogFragment extends DialogFragment {

    protected BaseAgeGroupDialogViewModel mViewModel;

    /**
     * Sets the viewModel
     * @param viewModel
     */
    protected void setViewModel(BaseAgeGroupDialogViewModel viewModel) {
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

        return dialog;
    }
}
