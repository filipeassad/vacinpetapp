package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;

/**
 * Created by Filipe on 30/06/2016.
 */
public class CadastroVacVerm extends Fragment {

    private FragPrincInterface fragPrincInterface;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cad_vacinvermi, container, false);

        return view;
    }
}
