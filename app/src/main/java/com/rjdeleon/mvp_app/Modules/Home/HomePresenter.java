package com.rjdeleon.mvp_app.Modules.Home;

import android.view.View;

import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Modules.Home.HomeContract;
import com.rjdeleon.mvp_app.Tasks.PostNewDncaTask;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void handleNewDncaClick(View view) {
        this.mView.navigateToNewDnca();
    }

    @Override
    public void handleTestApiClick(View view) {

        // Submit new DNCA form using POST API at localhost:3000/dnca
        PostNewDncaTask task = new PostNewDncaTask();
        task.execute(AppConstants.URL + AppConstants.ROUTE_DNCA);
    }
}
