package com.rjdeleon.mvp_app.Presenters;

import android.os.AsyncTask;
import android.view.View;

import com.google.gson.Gson;
import com.rjdeleon.mvp_app.Contracts.HomeContract;
import com.rjdeleon.mvp_app.Models.FormInfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePresenter implements HomeContract.Presenter {

    public class GetDncaTask extends AsyncTask<String, Void, String> {

        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(String... strings) {
            FormInfo formInfo = new FormInfo("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");
            Gson formJson = new Gson();
            String x  = formJson.toJson(formInfo);


            mView.displayShortToast("Performing background task...");

            String urlString = strings[0];
            String result = new String();
            String inputLine;

            try {
                // Create URL object
                URL url = new URL(urlString);

                //Create a connection
                HttpURLConnection connection =(HttpURLConnection) url.openConnection();

                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();

                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());

                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();

                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }

                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();

                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return result;
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
