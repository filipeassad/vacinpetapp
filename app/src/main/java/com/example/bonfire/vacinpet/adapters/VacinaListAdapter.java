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

import java.util.List;


public class VacinaListAdapter extends ArrayAdapter<Vacinacao> {

    private Context mContext;
    private int mResource;

    public VacinaListAdapter(Context context, int resource, List<Vacinacao> objects) {
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

        TextView textView = (TextView) convertView.findViewById(R.id.txtNomeVacina);
        textView.setText(getItem(position).getVacina().getNomevacina());

        TextView text2View = (TextView) convertView.findViewById(R.id.txtDataVacina);
        text2View.setText(getItem(position).dataVacinaFormat());

        TextView text3View = (TextView) convertView.findViewById(R.id.txtProximaVacina);
        text3View.setText(getItem(position).dataProxVacinaFormat());

        return convertView;
    }
}
