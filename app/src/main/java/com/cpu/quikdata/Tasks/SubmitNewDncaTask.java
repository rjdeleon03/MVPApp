package com.cpu.quikdata.Tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.cpu.quikdata.Models.DNCAForm;
import com.cpu.quikdata.Models.DNCAFormDataSource;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitNewDncaTask extends AsyncTask<String, Void, String> {
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    private DNCAForm mDncaForm;
    private DNCAFormDataSource.SubmitDncaFormCallback mCallback;

    public SubmitNewDncaTask(DNCAForm dncaForm, DNCAFormDataSource.SubmitDncaFormCallback callback) {
        mDncaForm = dncaForm;
        mCallback = callback;
    }

    @Override
    protected String doInBackground(String... strings) {

        // Normalize DNCA form data first
        mDncaForm.normalize();

        // Serialize to JSON
        Gson formJson = new Gson();
        String x = formJson.toJson(mDncaForm);

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
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Fill post request with necessary JSON data
            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            os.writeBytes(x);
            os.flush();
            os.close();

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
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (mCallback != null) {
            mCallback.onDncaFormSubmitted();
        }
    }
}
