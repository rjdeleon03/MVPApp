package com.rjdeleon.mvp_app.Modules.NewDnca.GeneralInformation.PopulationData.Dialog;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Models.Generics.AgeGroupDataRow;
import com.rjdeleon.mvp_app.Modules.NewDnca.Base.AgeGroupModules.Dialog.BaseAgeGroupDialogFragment;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.PopulationDataDialogBinding;

public class PopulationDataDialogFragment extends BaseAgeGroupDialogFragment {

    private PopulationDataDialogBinding mBinding;
    private Spinner mAgeGroupSpinner;
    protected ArrayAdapter<AgeGroupDataRow.AgeGroup> mSpinnerAdapter;

    public static PopulationDataDialogFragment getInstance() {
        return new PopulationDataDialogFragment();
    }

    public PopulationDataDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initialize view
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        mBinding = DataBindingUtil.inflate(inflater, R.layout.population_data_dialog, null, false);
        mBinding.setViewModel((PopulationDataDialogViewModel) mViewModel);
        View view = mBinding.getRoot();

        setupSpinner(view, R.id.nd_population_dlg_age_spinner);

        return super.createDialog(view);
    }



    /**
     * Sets up AgeGroup spinner
     * @param view
     * @param controlId
     */
    protected void setupSpinner(View view, int controlId) {
        mAgeGroupSpinner = view.findViewById(controlId);
        mSpinnerAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                ((PopulationDataDialogViewModel) mViewModel).getAgeGroupList()
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAgeGroupSpinner.setAdapter(mSpinnerAdapter);
    }
}
