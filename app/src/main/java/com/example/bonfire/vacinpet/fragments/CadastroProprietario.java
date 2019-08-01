package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;

/**
 * Created by Filipe on 28/06/2016.
 */
public class CadastroProprietario extends Fragment {

    private Button btnCadastrar;
    private MultiAutoCompleteTextView edtNomeProprietario;
    private FragPrincInterface fragPrincInterface;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pet_proprietario, container, false);


        btnCadastrar                = (Button) view.findViewById(R.id.btnCadastrar);
        edtNomeProprietario         = (MultiAutoCompleteTextView) view.findViewById(R.id.edtNomeProprietario);

        acoes();

        return view;
    }

    private void acoes(){

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.voltaTela();
            }
        });

    }
}
