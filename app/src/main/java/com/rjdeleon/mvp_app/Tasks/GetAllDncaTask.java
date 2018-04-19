package com.rjdeleon.mvp_app.Tasks;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAllDncaTask extends AsyncTask<String, Void, String> {

    public interface GetAllDncaResult {
        void resultsRetrieved(String result);
    }

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    private GetAllDncaResult mDelegate;

    public GetAllDncaTask (GetAllDncaResult delegate) {
        this.mDelegate = delegate;
    };

    @Override
    protected String doInBackground(String... strings) {

        String urlString = strings[0];
        String result = new String();
        String inputLine;

        try {
            // Create URL object
            URL url = new URL(urlString);

            //Create a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //Check if the line we are reading is not null
            while ((inputLine = reader.readLine()) != null) {
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

    @Override
    protected void onPostExecute(String result) {
        if (mDelegate != null) {
            mDelegate.resultsRetrieved(result);
        }
    }
}
