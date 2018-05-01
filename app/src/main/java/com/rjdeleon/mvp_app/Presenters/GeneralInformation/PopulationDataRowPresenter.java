package com.rjdeleon.mvp_app.Presenters.GeneralInformation;

import com.rjdeleon.mvp_app.Contracts.FragmentNavigationContract;
import com.rjdeleon.mvp_app.Contracts.GeneralInformation.PopulationDataRowContract;

public class PopulationDataRowPresenter implements PopulationDataRowContract.Presenter {

    private FragmentNavigationContract.Presenter mParentPresenter;

    public PopulationDataRowPresenter(FragmentNavigationContract.Presenter parentPresenter) {
        this.mParentPresenter = parentPresenter;
    }
}
