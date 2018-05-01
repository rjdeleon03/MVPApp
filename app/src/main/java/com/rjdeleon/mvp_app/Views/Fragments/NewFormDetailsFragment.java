package com.rjdeleon.mvp_app.Views.Fragments;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.NewFormContract;
import com.rjdeleon.mvp_app.Contracts.NewFormDetailsContract;
import com.rjdeleon.mvp_app.Presenters.NewFormDetailsPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.databinding.NewFormDetailsFragmentBinding;

public class NewFormDetailsFragment extends BaseFragment implements NewFormDetailsContract.View {

    private NewFormDetailsPresenter mPresenter;

    public NewFormDetailsFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Form Details";
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
    public void onSetDateButtonClick(View view, int year, int month, int day) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                mPresenter.getDatePickerListener(),
                year, month, day);
        datePickerDialog.show();
    }
}
