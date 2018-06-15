package com.cpu.quikdata.Tasks;

import android.os.AsyncTask;

import com.cpu.quikdata.AppConstants;
import com.cpu.quikdata.Models.DNCAFormDataSource;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UploadImagesTask extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "POST";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    private List<String> mImagePaths;
    private DNCAFormDataSource.UploadImagesCallback mCallback;

    public UploadImagesTask(List<String> imagePaths, DNCAFormDataSource.UploadImagesCallback callback) {
        mImagePaths = imagePaths;
        mCallback = callback;
    }

    @Override
    protected String doInBackground(String... strings) {

        String attachmentName = "image";
        String LINE_FEED = "\r\n";
        String twoHyphens = "--";
        String boundary =  "**QuikDataBoundary**";
        String inputLine;

        String urlString = strings[0];
        String result = new String();
        OutputStream outputStream;

        try {
            // Create URL object
            URL url = new URL(urlString);
            //Create a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.9");
            outputStream = connection.getOutputStream();

            DataOutputStream request = new DataOutputStream(
                    connection.getOutputStream());

            // For every file in file path, do this
            int i = 0;
            for(String imagePath : mImagePaths) {

                String imageFileName = imagePath.substring(imagePath.lastIndexOf('/') + 1);

                request.writeBytes(twoHyphens + boundary + LINE_FEED);
                request.writeBytes("Content-Disposition: form-data; name=\"" +
                        attachmentName + "\";filename=\"" +
                        imageFileName + "\"" + LINE_FEED);
                request.writeBytes("Content-Type: image/jpeg" + LINE_FEED);
                request.writeBytes(LINE_FEED);

                FileInputStream inputStream = new FileInputStream(imagePath);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                inputStream.close();

                request.writeBytes(LINE_FEED);

                i++;

                if (i == mImagePaths.size()) {
                    // If this is the last file, boundary should be as follows:
                    request.writeBytes(twoHyphens + boundary + twoHyphens + LINE_FEED);
                }
            }

            // End
            request.flush();
            request.close();

            // Handle responses
            // Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            // Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            // Check if the line we are reading is not null
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
        if (mCallback != null) {

            // Deserialize JSON here
            Gson gson = new Gson();
            List<String> listItems = gson.fromJson(result, new TypeToken<List<String>>(){}.getType());
            if (listItems != null) {
                for (int i = 0; i < listItems.size(); i++) {
                    listItems.set(i, AppConstants.URL + AppConstants.ROUTE_IMAGES + "/" + listItems.get(i));
                }
            }

            mCallback.onImagesUploaded(listItems);
        }
    }
}
