package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;

/**
 * Created by Filipe on 28/06/2016.
 */
public class EnderecoUsuario extends Fragment {

    private EditText edtCep;
    private EditText edtBairro;
    private EditText edtRua;
    private EditText edtComplemento;
    private EditText edtNumero;
    private EditText edtTelefone;
    private EditText edtCelular;
    private Button btnCadastrar;

    private FragPrincInterface fragPrincInterface;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_endereco,container, false);

        edtCep          = (EditText) view.findViewById(R.id.edtCep);
        edtBairro       = (EditText) view.findViewById(R.id.edtBairro);
        edtRua          = (EditText) view.findViewById(R.id.edtRua);
        edtComplemento  = (EditText) view.findViewById(R.id.edtComplemento);
        edtNumero       = (EditText) view.findViewById(R.id.edtNumero);
        edtTelefone     = (EditText) view.findViewById(R.id.edtTelefone);
        edtCelular      = (EditText) view.findViewById(R.id.edtCelular);
        btnCadastrar    = (Button) view.findViewById(R.id.btnCadastrar);

        acoes();

        return view;
    }

    public void acoes(){

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.voltaTela();
            }
        });

    }
}
