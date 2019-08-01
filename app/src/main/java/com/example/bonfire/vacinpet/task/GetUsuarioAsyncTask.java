package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.bonfire.vacinpet.interfaces.InterfaceTaks;
import com.example.bonfire.vacinpet.models.Usuario;
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
 * Created by hugo on 15/04/16.
 */
public class GetUsuarioAsyncTask extends AsyncTask<String, String, JSONArray> {

    private Context contexto;
    private InterfaceTaks interfaceTaks;
    private ProgressDialog progress;

    public GetUsuarioAsyncTask(Context contexto, InterfaceTaks interfaceTaks) {
        this.contexto = contexto;
        this.interfaceTaks = interfaceTaks;
    }

    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(contexto);
        progress.setMessage("Carregando notícias...");
        progress.show();
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

        List<Usuario> listaNoticias = new ArrayList<Usuario>();

        for(int i = 0; i<jsonArray.length(); i++){
            try {
                JSONObject linha = jsonArray.getJSONObject(i);
                Usuario usu = new Usuario();

                usu.setCodigousu(linha.getInt("codigousu"));
                usu.setNomeusu(linha.getString("nomeusu"));
                usu.setEmailusu(linha.getString("emailusu"));
                usu.setCpfusu(linha.getString("cpfusu"));
                usu.setVeterinariousu(linha.getString("veterinariousu"));
                usu.setNumcrmvusu(linha.getString("numcrmvusu"));
                usu.setEstadocrmvusu(linha.getString("estadocrmvusu"));
                usu.setLogusu(linha.getString("logusu"));
                usu.setUsualt(linha.getString("usualt"));
                usu.setDatalt(MetodosBasicos.stringToDate(linha.getString("datalt")));
                usu.setSenhausu(linha.getString("senhausu"));

                listaNoticias.add(usu);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        progress.dismiss();
    }





}
