package com.example.bonfire.vacinpet.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.bonfire.vacinpet.interfaces.GetAnimalInterface;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.models.Animal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Filipe on 30/05/2016.
 */
public class GetImagemAnimal extends AsyncTask<Animal, String, Animal> {

    private GetAnimalInterface getAnimalInterface;
    private ProgressDialog progress;
    private Context contexto;

    public GetImagemAnimal(GetAnimalInterface getAnimalInterface, Context contexto) {
        this.getAnimalInterface = getAnimalInterface;
        this.contexto = contexto;
    }

    @Override
    protected void onPreExecute() {
       /* progress = new ProgressDialog(contexto);
        progress.setMessage("Buscando Imagens dos animais...");
        progress.show();*/
    }

    @Override
    protected Animal doInBackground(Animal... params) {
        Bitmap img = null;
        try{
            URL url = new URL(params[0].getUrlImagem());
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            InputStream input = conexao.getInputStream();
            img = BitmapFactory.decodeStream(input);
            params[0].setImagem(img);
        }
        catch(IOException e){}

        return(params[0]);
    }

    @Override
    protected void onPostExecute(Animal animal) {
        //progress.dismiss();
        getAnimalInterface.getImagemAnimal(animal);
    }
}
