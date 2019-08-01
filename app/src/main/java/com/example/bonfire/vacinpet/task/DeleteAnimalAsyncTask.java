package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.bonfire.vacinpet.interfaces.GetAnimalInterface;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Filipe on 25/06/2016.
 */
public class DeleteAnimalAsyncTask extends AsyncTask<String, String, String> {

    private Context myContext;
    private ProgressDialog progress;
    private GetAnimalInterface getAnimalInterface;

    public DeleteAnimalAsyncTask(Context myContext , GetAnimalInterface getAnimalInterface) {
        this.getAnimalInterface = getAnimalInterface;
        this.myContext = myContext;
    }

    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(myContext);
        progress.setMessage("Buscando Animais...");
        progress.show();
    }


    @Override
    protected String doInBackground(String... params) {
        int httpResponse = 0;

        try {

            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("DELETE");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            httpResponse = conn.getResponseCode();

            Log.i("HTTP - Resposta", conn.getResponseMessage());

        } catch (IOException e) {
            Log.i("HTTP", e.getMessage());
            e.printStackTrace();
        }

        if (httpResponse == HttpURLConnection.HTTP_OK){
            Log.i("HTTP", "Deu certo!");
            return "enviou";
        }
        else{
            Log.i("HTTP", " --> Deu ruim mano");
            return "naoenviou";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        getAnimalInterface.deleteAnimal();
        progress.dismiss();
    }
}
