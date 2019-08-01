package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

/**
 * Created by Filipe on 19/05/2016.
 */
public class DetalheVacina extends Fragment {

    private ImageView iv_animal;
    private TextView tv_NomeAnimal;
    private EditText edtDescVacina;
    private EditText edtLoteVacina;
    private EditText edtFabricacaoVacina;
    private EditText edtDataVencimentoVacina;
    private EditText edtPesoVacina;
    private EditText edtProprietarioVacina;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_det_vacinvermi, container, false);

        iv_animal = (ImageView) view.findViewById(R.id.iv_animal);
        tv_NomeAnimal = (TextView) view.findViewById(R.id.tv_NomeAnimal);
        edtDescVacina = (EditText) view.findViewById(R.id.edtDescVacina);
        edtLoteVacina = (EditText) view.findViewById(R.id.edtLoteVacina);
        edtFabricacaoVacina = (EditText) view.findViewById(R.id.edtFabricacaoVacina);
        edtDataVencimentoVacina = (EditText) view.findViewById(R.id.edtDataVencimentoVacina);
        edtPesoVacina = (EditText) view.findViewById(R.id.edtPesoVacina);
        edtProprietarioVacina = (EditText) view.findViewById(R.id.edtProprietarioVacina);

        if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
            iv_animal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
        }

        if(VariaveisEstaticas.getVacinacaoSelecionada()!=null) {
            tv_NomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());
            edtDescVacina.setText(VariaveisEstaticas.getVacinacaoSelecionada().getVacina().getDescricaovaci());
            edtLoteVacina.setText(VariaveisEstaticas.getVacinacaoSelecionada().getLotevacin());
            edtFabricacaoVacina.setText(VariaveisEstaticas.getVacinacaoSelecionada().getFabricacaovacin());
            edtDataVencimentoVacina.setText(MetodosBasicos.DateToString(VariaveisEstaticas.getVacinacaoSelecionada().getVencimentovacin()));
            edtPesoVacina.setText(VariaveisEstaticas.getVacinacaoSelecionada().getPesovacin().toString());
            edtProprietarioVacina.setText(VariaveisEstaticas.getVacinacaoSelecionada().getCodigousuprop());
        }
        return view;
    }
}
