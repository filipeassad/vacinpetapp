package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.bonfire.vacinpet.models.Animal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Filipe on 24/06/2016.
 */
public class PutAnimalAsyncTask extends AsyncTask<String, String, String> {

    private Context myContext;
    private ProgressDialog progress;
    private Animal animal;

    public PutAnimalAsyncTask(Context myContext, Animal animal) {
        this.myContext = myContext;
        this.animal = animal;
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
            conn.setRequestMethod("PUT");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            JSONObject jsonParam = new JSONObject();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            animal.getImagem().compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);

            jsonParam.put("id", animal.getCodigoani());
            jsonParam.put("fotoAnimal", encodedImage);
            jsonParam.put("nomeAnimal", animal.getNomeani());
            jsonParam.put("usuarioAnimal", 1);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(jsonParam.toString());
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            httpResponse = conn.getResponseCode();

            Log.i("HTTP - Resposta", conn.getResponseMessage());

        } catch (IOException e) {
            Log.i("HTTP", e.getMessage());
            e.printStackTrace();
        } catch (JSONException e) {
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
        //Toast.makeText(myContext, s, Toast.LENGTH_SHORT).show();
        progress.dismiss();
    }

}
