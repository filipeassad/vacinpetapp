package com.example.bonfire.vacinpet.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.List;

/**
 * Created by Filipe on 17/05/2016.
 */
public class AnimalListAdapter extends ArrayAdapter<Animal>{

    private Context mContext;
    private int mResource;

    public AnimalListAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource,  objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mResource, parent, false);
        }

        ImageView imgIconItem = (ImageView) convertView.findViewById(R.id.iv_animal);
        /*Bitmap bm = null;

        if(getItem(position).getNomeani().equals("Luffy")){
            bm = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.luffy);
        }else if(getItem(position).getNomeani().equals("Nanda")){
            bm = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.nanda);
        }else if(getItem(position).getNomeani().equals("Tufao")){
            bm = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.tufao);
        }else{
            bm = BitmapFactory.decodeResource(convertView.getResources(), R.drawable.filipe);
        }*/

        if(getItem(position).getImagem() != null){
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(getItem(position).getImagem()));
        }

        TextView textView = (TextView) convertView.findViewById(R.id.tv_NomeAnimal);
        textView.setText(getItem(position).getNomeani());

        return convertView;
    }
}
