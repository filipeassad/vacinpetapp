package com.example.bonfire.vacinpet.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.models.Vacinacao;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;

import java.util.List;

/**
 * Created by Mayara on 25/06/2016.
 */
public class ProximaVacinaAdapter extends ArrayAdapter<Vacinacao> {

    private Context context;
    private int myresource;

    public ProximaVacinaAdapter(Context context, int resource, List<Vacinacao> objects) {
        super(context, resource, objects);
        this.context = context;
        this.myresource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(myresource, parent, false);
        }

        TextView tv_ProcVacinaNome = (TextView) convertView.findViewById(R.id.tv_ProcVacinaNome);
        TextView tv_ProcVacinaData = (TextView) convertView.findViewById(R.id.tv_ProcVacinaData);

        tv_ProcVacinaNome.setText(getItem(position).getVacina().getNomevacina());
        tv_ProcVacinaData.setText(MetodosBasicos.DateToString(getItem(position).getDtproxvacin()));

        return convertView;
    }
}
