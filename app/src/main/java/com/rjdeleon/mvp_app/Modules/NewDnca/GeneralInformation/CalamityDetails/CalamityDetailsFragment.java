package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.CalamityDetails;



import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.BaseSubFragment;
import com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.GenInfoFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.CalamityDetailsFragmentBinding;

import static com.rjdeleon.mvp_app.AppConstants.GenInfoComponent.GEN_INFO_CALAMITY;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalamityDetailsFragment extends BaseSubFragment {

    private CalamityDetailsViewModel mViewModel;
    private CalamityDetailsFragmentBinding mBinding;

    private Button mSetDateButton;

    public static CalamityDetailsFragment newInstance() {
        return new CalamityDetailsFragment();
    }

    public CalamityDetailsFragment() {
        setFragmentTag(GEN_INFO_CALAMITY.toString());
    }

    /**
     * Sets the viewModel
     * @param viewModel
     */
    public void setViewModel(@NonNull CalamityDetailsViewModel viewModel) {
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
        View root = inflater.inflate(R.layout.calamity_details_fragment, container, false);
        if (mBinding == null) {
            mBinding = CalamityDetailsFragmentBinding.bind(root);
        }
        mBinding.setViewModel(mViewModel);

        setupSetDateButton(root);

        return root;
    }

    /**
     * Sets up the Set Date button
     * @param view
     */
    private void setupSetDateButton(View view) {
        mSetDateButton = view.findViewById(R.id.nd_calamity_date_button);
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
                        mViewModel.onDateOccurredSet(year, month, dayOfMonth);
                    }
                },
                mViewModel.dateOccurred.get().getYear(),
                mViewModel.dateOccurred.get().getMonth(),
                mViewModel.dateOccurred.get().getDayOfMonth());
        datePickerDialog.show();
    }

}
