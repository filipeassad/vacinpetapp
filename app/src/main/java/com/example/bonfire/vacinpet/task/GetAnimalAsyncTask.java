package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.bonfire.vacinpet.interfaces.GetAnimalInterface;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filipe on 30/05/2016.
 */
public class GetAnimalAsyncTask extends AsyncTask<String, String, JSONArray> {

    private Context contexto;
    private GetAnimalInterface getAnimalInterface;
    private ProgressDialog progress;

    public GetAnimalAsyncTask(Context contexto, GetAnimalInterface getAnimalInterface) {
        this.contexto = contexto;
        this.getAnimalInterface = getAnimalInterface;
    }

    @Override
    protected void onPreExecute() {
       /* progress = new ProgressDialog(contexto);
        progress.setMessage("Buscando Animais...");
        progress.show();*/
    }

    @Override
    protected JSONArray doInBackground(String... params) {
        URL url;
        HttpURLConnection urlConnection = null;
        JSONArray response = new JSONArray();

        try {
            url = new URL(params[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                String responseString = readStream(urlConnection.getInputStream());
                Log.v("CatalogClient", responseString);
                response = new JSONArray(responseString);
            }else{
                Log.v("CatalogClient", "Response code:" + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null)
                urlConnection.disconnect();
        }

        return response;
    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }


    @Override
    protected void onPostExecute(JSONArray jsonArray) {

        List<Animal> listAnimais = new ArrayList<Animal>();

        for(int i = 0; i<jsonArray.length(); i++){
            try {
                JSONObject linha = jsonArray.getJSONObject(i);
                Animal ani = new Animal();

                ani.setCodigoani(linha.getInt("id"));
                ani.setNomeani(linha.getString("nomeAnimal"));
                ani.setUrlImagem(linha.getString("fotoAnimal"));

                listAnimais.add(ani);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //progress.dismiss();
        getAnimalInterface.getAnimal(listAnimais);
    }

}
