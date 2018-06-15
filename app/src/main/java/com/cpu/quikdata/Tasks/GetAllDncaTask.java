package com.cpu.quikdata.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.cpu.quikdata.Models.DNCAListItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetAllDncaTask extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    private DNCAFormDataSource.LoadDncaFormsCallback mDelegate;

    public GetAllDncaTask (DNCAFormDataSource.LoadDncaFormsCallback delegate) {
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

                if (isCancelled()) return result;
            }

            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();

            if (isCancelled()) return result;

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

            // Deserialize JSON here
            Gson gson = new Gson();
            List<DNCAListItem> listItems = gson.fromJson(result, new TypeToken<List<DNCAListItem>>(){}.getType());
            mDelegate.onDncaFormsLoaded(listItems);
        }
    }
}
