package com.rjdeleon.mvp_app.Presenters;

import android.os.AsyncTask;
import android.view.View;

import com.rjdeleon.mvp_app.Contracts.HomeContract;

public class HomePresenter implements HomeContract.Presenter {

    public class GetDncaTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            mView.displayShortToast("Performing background task...");
            return "Done";
        }
    }

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

        // Access GET API at localhost:3000/dnca
        GetDncaTask task = new GetDncaTask();
        task.execute("http://10.0.2.2:3000/dnca");
    }
}
