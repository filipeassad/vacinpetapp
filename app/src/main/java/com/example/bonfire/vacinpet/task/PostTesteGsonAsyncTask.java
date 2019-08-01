package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.bonfire.vacinpet.models.Animal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 0118431 on 23/06/2016.
 */
public class PostTesteGsonAsyncTask extends AsyncTask<String, String, String>  {

    private Context myContext;
    private ProgressDialog progress;
    private Animal animal;
    private String _responseMain;

    public PostTesteGsonAsyncTask(Context myContext, Animal animal) {
        this.myContext = myContext;
        this.animal = animal;
    }

    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(myContext);
        progress.setMessage("Enviando...");
        progress.show();
    }

    @Override
    protected String doInBackground(String... params) {

        HttpURLConnection urlConnection;
        String result = "";
        try {
            String data ="";
            //data = jsonObj.toString();
            //          String temp=URLEncoder.encode(uri, "UTF-8");
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) ((url.openConnection()));
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setChunkedStreamingMode(1024);

            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();

            //Write
            OutputStream outputStream = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(data);
            writer.close();
            outputStream.close();

            //Read
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Uploading............");
                sb.append(line);
            }

            bufferedReader.close();
            _responseMain = sb.toString();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(myContext,s,Toast.LENGTH_SHORT).show();
        progress.dismiss();
    }

}
