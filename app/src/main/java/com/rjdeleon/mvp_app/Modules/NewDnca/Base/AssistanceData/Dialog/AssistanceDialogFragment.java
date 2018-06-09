package com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewHolder;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AssistanceData.Row.AssistanceRowViewModel;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.AssistanceDialogBinding;

public class AssistanceDialogFragment extends BaseEnumDialogFragment {

    private AssistanceDialogBinding mBinding;
    private Button mSetDateButton;

    public static AssistanceDialogFragment newInstance() {
        return new AssistanceDialogFragment();
    }

    public AssistanceDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.assistance_dialog, null, false);
        mBinding.setViewModel((AssistanceDialogViewModel) mViewModel);
        View view = mBinding.getRoot();
        setupSetDateButton(view);

        return super.createDialog(view);
    }

    /**
     * Sets up the Set Date button
     * @param view
     */
    private void setupSetDateButton(View view) {
        mSetDateButton = view.findViewById(R.id.nd_assistance_dlg_date_button);
        mSetDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });
    }

    /**
     * Shows the DatePickerDialog
     */
    private void showDatePickerDialog(View view) {
        final AssistanceDialogViewModel viewModel = (AssistanceDialogViewModel) mViewModel;
        DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        viewModel.onDateReceivedSet(year, month, dayOfMonth);
                    }
                },
                viewModel.dateReceived.get().getYear(),
                viewModel.dateReceived.get().getMonth(),
                viewModel.dateReceived.get().getDayOfMonth());
        datePickerDialog.show();
    }
}
