package com.cpu.quikdata.Modules.NewDnca.FormDetails;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.cpu.quikdata.R;
import com.cpu.quikdata.databinding.NewDncaFormDetailsFragmentBinding;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewDncaFormDetailsFragment extends Fragment {

    private NewDncaFormDetailsViewModel mViewModel;
    private NewDncaFormDetailsFragmentBinding mBinding;
    private Button mSetDateButton;

    public static NewDncaFormDetailsFragment newInstance() {
        return new NewDncaFormDetailsFragment();
    }

    public NewDncaFormDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull NewDncaFormDetailsViewModel viewModel) {
        mViewModel = viewModel;
    }

    /**
     * Creates the view and binds the viewModel
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.new_dnca_form_details_fragment, container, false);
        if (mBinding == null) {
            mBinding = NewDncaFormDetailsFragmentBinding.bind(root);
        }
        mViewModel.refreshViewModel();
        mBinding.setViewModel(mViewModel);

        // Setup set date button
        setupSetDateButton(root);

        return root;
    }

    /**
     * Sets up the Set Date button
     * @param view
     */
    private void setupSetDateButton(View view) {
        mSetDateButton = view.findViewById(R.id.nd_details_date_button);
        mSetDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    /**
     * Shows the DatePickerDialog
     */
    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mViewModel.onAssessmentDateSet(year, month, dayOfMonth);
                    }
                },
                mViewModel.assessmentDate.get().getYear(),
                mViewModel.assessmentDate.get().getMonth(),
                mViewModel.assessmentDate.get().getDayOfMonth());
        datePickerDialog.show();
    }

}
