package com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Presenters.GeneralInformation.PopulationDataPresenter;
import com.rjdeleon.mvp_app.R;
import com.rjdeleon.mvp_app.Views.Fragments.BaseFragment;
import com.rjdeleon.mvp_app.databinding.PopulationDataFragmentBinding;

public class PopulationDataFragment extends BaseFragment implements PopulationDataContract.View {

    private PopulationDataPresenter mPresenter;
    private GridLayout mGrid;

    public PopulationDataFragment() {
        // Required empty public constructor
        this.fragmentTitle = "Population Data";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.mPresenter = new PopulationDataPresenter(this);
        PopulationDataFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.population_data_fragment, container, false);
        binding.setPresenter(mPresenter);

        View view = binding.getRoot();
        this.mGrid = view.findViewById(R.id.nf_population_grid);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAddButtonClick(View view) {

        getLayoutInflater().inflate(R.layout.age_group_card, mGrid);
        View newCard = mGrid.getChildAt(mGrid.getChildCount() - 1);
        ((GridLayout.LayoutParams) newCard.getLayoutParams()).columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
    }
}
