package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import android.view.View;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataContract;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Views.Fragments.GeneralInformation.PopulationDataFragmentViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PopulationDataPresenter implements PopulationDataContract.Presenter {

    private PopulationDataContract.View mView;
    private FragmentNavigationContract.Presenter mParentPresenter;
    private List<PopulationDataRow> mPopulationDataRows;

    public PopulationDataPresenter(PopulationDataContract.View view, FragmentNavigationContract.Presenter parentPresenter) {
        this.mView = view;
        this.mParentPresenter = parentPresenter;
        this.mPopulationDataRows = new ArrayList<>();
    }

    @Override
    public void handleAddButtonClick(View view) {
        mPopulationDataRows.add(new PopulationDataRow());
        mView.onAddButtonClick(view);
    }

    @Override
    public void onBindItemViewAtPosition(PopulationDataFragmentViewHolder holder, int position) {

        PopulationDataRowPresenter populationDataRowPresenter = new PopulationDataRowPresenter(mParentPresenter);
        holder.bind(populationDataRowPresenter);
    }

    public int getPopulationDataRowsCount() {
        return mPopulationDataRows.size();
    }
}
