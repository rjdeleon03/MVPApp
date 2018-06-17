package com.cpu.quikdata.Modules.NewDnca.FormDetails.InterviewDetails.InterviewDetailsItem.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import com.cpu.quikdata.Modules.NewDnca.Base.RowBasedModules.Dialog.BaseEnumDialogFragment;
import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.FormInterviewDialogBinding;

public class InterviewDetailsDialogFragment extends BaseEnumDialogFragment {

    private FormInterviewDialogBinding mBinding;

    public static InterviewDetailsDialogFragment newInstance() {
        return new InterviewDetailsDialogFragment();
    }

    public InterviewDetailsDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.form_interview_dialog, null, false);
        mBinding.setViewModel((InterviewDetailsDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        return super.createDialog(view);
    }
}
