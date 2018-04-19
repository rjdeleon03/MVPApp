package com.rjdeleon.mvp_app.Tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostNewDncaTask extends AsyncTask<String, Void, String> {
    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    @Override
    protected String doInBackground(String... strings) {

        List<PopulationDataRow> rows = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PopulationData.AgeGroup ageGroup;
            switch(i) {
                case 0:
                    ageGroup = PopulationData.AgeGroup.AGE_0_5;
                    break;
                case 1:
                    ageGroup = PopulationData.AgeGroup.AGE_6_9;
                    break;
                case 2:
                    ageGroup = PopulationData.AgeGroup.AGE_10_12;
                    break;
                case 3:
                    ageGroup = PopulationData.AgeGroup.AGE_13_17;
                    break;
                case 4:
                    ageGroup = PopulationData.AgeGroup.AGE_18_59;
                    break;
                default:
                    ageGroup = PopulationData.AgeGroup.AGE_60_PLUS;
                    break;
            }
            PopulationDataRow row = new PopulationDataRow(ageGroup,1,2,3,4,5,6);
            rows.add(row);
        }

        PopulationData populationData = new PopulationData(rows);
        CalamityDesc calamityDesc = new CalamityDesc("xxx", "yyy", "zzz");
        GenInfo genInfo = new GenInfo(calamityDesc, "123", populationData);
        FormInfo formInfo = new FormInfo("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", genInfo);

        Gson formJson = new Gson();
        String x = formJson.toJson(formInfo);

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
}
