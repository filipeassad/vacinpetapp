package com.example.bonfire.vacinpet.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.models.AnimalUsu;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.List;

public class UsuarioListAdapter extends ArrayAdapter<AnimalUsu> {

    private Context mContext;
    private int mResource;


    public UsuarioListAdapter(Context context, int resource, List<AnimalUsu> objects) {
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

        ImageView iv_dono = (ImageView) convertView.findViewById(R.id.iv_dono);
        TextView tv_nomeDono = (TextView) convertView.findViewById(R.id.tv_nomeDono);

        iv_dono.setImageBitmap(MetodosBasicos.getRoundedShape(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.filipe)));
        tv_nomeDono.setText(getItem(position).getUsuario().getNomeusu());

        return convertView;
    }
}
