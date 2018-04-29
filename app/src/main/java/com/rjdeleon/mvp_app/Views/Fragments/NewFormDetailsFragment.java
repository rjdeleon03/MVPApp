package com.rjdeleon.mvp_app.Views.Fragments;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormDetailsContract;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GenderTuple;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;
import com.rjdeleon.mvp_app.Presenters.NewFormDetailsPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewFormDetailsFragmentBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewFormDetailsFragment extends BaseFragment implements NewFormDetailsContract.View {

    private NewFormDetailsPresenter mPresenter;

    public NewFormDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mPresenter = new NewFormDetailsPresenter(this, (NewFormContract.Presenter)navigationPresenter);
        NewFormDetailsFragmentBinding binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.new_form_details_fragment, container, false);
        binding.setPresenter(mPresenter);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onSaveButtonClick(View view) {
        navigationPresenter.closeFragment(this);
    }

    @Override
    public void onSetDateButtonClick(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                mPresenter.getDatePickerListener(),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
