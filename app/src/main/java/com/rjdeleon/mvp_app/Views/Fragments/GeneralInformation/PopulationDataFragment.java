package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;


import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.PopulationDataPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

import java.lang.reflect.Array;
import java.util.List;

public class PopulationDataFragment extends BaseFragment implements PopulationDataContract.View {

    private PopulationDataPresenter mPresenter;
    private RecyclerView mGrid;
    private PopulationDataFragmentAdapter mAdapter;
    private Spinner mSpinner;
    private ArrayAdapter<String> mSpinnerAdapter;

    public PopulationDataFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Population Data";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Initialize presenter
        this.mPresenter = new PopulationDataPresenter(this, navigationPresenter);
        PopulationDataFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_fragment, container, false);
        binding.setPresenter(mPresenter);
        View view = binding.getRoot();

        // Initialize spinner
        List<String> spinnerList = mPresenter.getAgeGroupsList();
        this.mSpinner = view.findViewById(R.id.nf_population_age_spinner);
        mSpinnerAdapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_spinner_item, spinnerList
        );
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mSpinner.setAdapter(mSpinnerAdapter);

        // Initialize adapter
        this.mGrid = view.findViewById(R.id.nf_population_grid);
        mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        this.mAdapter = new PopulationDataFragmentAdapter(mPresenter);
        mGrid.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onAddButtonClick(View view) {
        mSpinnerAdapter.notifyDataSetChanged();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int getAgeGroupSpinnerValue() {
        return (int) mSpinner.getSelectedItemId();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mGrid.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        }
    }
}
