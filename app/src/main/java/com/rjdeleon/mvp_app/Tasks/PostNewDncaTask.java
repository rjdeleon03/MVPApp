package com.rjdeleon.mvp_app.Tasks;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.rjdeleon.mvp_app.Models.FormInfo;
import com.rjdeleon.mvp_app.Models.GenderTuple;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CalamityDesc;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.CasualtiesDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.DeathCauseDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.FamilyData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.GenInfo;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.InfrastructureDamageDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.PopulationDataRow;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationData;
import com.rjdeleon.mvp_app.Models.GeneralInformation.VulnerablePopulationDataRow;

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

        Gson formJson = new Gson();
        String x = formJson.toJson(seedData());

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

    private FormInfo seedData() {

        List<PopulationDataRow> rows = new ArrayList<>();
        List<VulnerablePopulationDataRow> vpRows = new ArrayList<>();
        List<CasualtiesDataRow> cdRows = new ArrayList<>();
        List<DeathCauseDataRow> dcdRows = new ArrayList<>();
        List<InfrastructureDamageDataRow> iddRows = new ArrayList<>();

        for (int i = 0; i < PopulationData.AgeGroup.values().length; i++) {
            PopulationData.AgeGroup ageGroup = PopulationData.AgeGroup.values()[i];
            PopulationDataRow row = new PopulationDataRow(ageGroup,
                    new GenderTuple(1,2),
                    new GenderTuple(3,4),
                    new GenderTuple(5,6));
            rows.add(row);

            GenderTuple gt = new GenderTuple(55, 66);

            VulnerablePopulationDataRow vpRow = new VulnerablePopulationDataRow(ageGroup, 11, 22, 33, 44, gt, gt, gt, "vpRow");
            vpRows.add(vpRow);

            CasualtiesDataRow cdRow = new CasualtiesDataRow(ageGroup, gt, gt, gt);
            cdRows.add(cdRow);

            DeathCauseDataRow dcdRow = new DeathCauseDataRow(ageGroup, gt, gt, gt, gt, gt, gt, gt, gt, gt);
            dcdRows.add(dcdRow);
        }

        for (int i = 0; i < InfrastructureDamageData.InfraType.values().length; i++) {
            InfrastructureDamageDataRow iddRow = new InfrastructureDamageDataRow(InfrastructureDamageData.InfraType.values()[i], 77, true, "damagedInfra");
            iddRows.add(iddRow);
        }

        PopulationData populationData = new PopulationData(rows);
        CalamityDesc calamityDesc = new CalamityDesc("xxx", "yyy", "zzz");
        FamilyData familyData = new FamilyData(11, 22, 33, 44, 55, 66);
        VulnerablePopulationData vulnerablePopulationData = new VulnerablePopulationData(vpRows);
        CasualtiesData casualtiesData = new CasualtiesData(cdRows);
        DeathCauseData deathCauseData = new DeathCauseData(dcdRows);
        InfrastructureDamageData infrastructureDamageData = new InfrastructureDamageData(iddRows);

        GenInfo genInfo = new GenInfo(calamityDesc, "affectedArea", populationData, familyData, vulnerablePopulationData, casualtiesData, deathCauseData, infrastructureDamageData);
        return new FormInfo("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", genInfo);
    }
}
