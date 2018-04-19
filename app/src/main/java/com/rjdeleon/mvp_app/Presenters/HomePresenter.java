package com.rjdeleon.mvp_app.Presenters;

import android.os.AsyncTask;
import android.view.View;

import com.google.gson.Gson;
import com.rjdeleon.mvp_app.AppConstants;
import com.rjdeleon.mvp_app.Contracts.HomeContract;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Tasks.PostNewDncaTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

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
