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

import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.List;

/**
 * Created by wmkts on 21/05/16.
 */
public class MenuListAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private int mResource;

    public MenuListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(mResource, parent, false);
        }

        ImageView imgIconItem = (ImageView) convertView.findViewById(R.id.iv_menu);

        TextView textView = (TextView) convertView.findViewById(R.id.tv_nomemenu);
        textView.setText(getItem(position));

        if(getItem(position).equals("Dados Pessoais")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_dadospessoais);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Endereço")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_endereco);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Vacinação")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_vacinacao);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Vermifugação")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_vermifugacao);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Vacina")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_vacina);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Vermífugo")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_vermifugo);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else if(getItem(position).equals("Laboratório")){
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_laboratorio);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }else{
            Bitmap bMap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ico_proprietario);
            imgIconItem.setImageBitmap(MetodosBasicos.getRoundedShape(bMap));
        }



        return convertView;
    }
}
