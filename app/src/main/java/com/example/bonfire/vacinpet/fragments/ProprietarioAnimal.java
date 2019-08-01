package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.adapters.UsuarioListAdapter;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.models.AnimalUsu;
import com.example.bonfire.vacinpet.models.Usuario;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wmkts on 21/05/16.
 */
public class ProprietarioAnimal extends Fragment {

    private ListView lv_proprietarios;
    private ImageView iv_animal;
    private TextView txtNomeAnimal;
    private ImageView ivIncluir;

    private FragPrincInterface fragPrincInterface;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proprietario_pet, container, false);

        lv_proprietarios    = (ListView) view.findViewById(R.id.lv_proprietarios);
        iv_animal           = (ImageView) view.findViewById(R.id.iv_animal);
        txtNomeAnimal       = (TextView) view.findViewById(R.id.txtNomeAnimal);
        ivIncluir           = (ImageView) view.findViewById(R.id.ivIncluir);

        List<AnimalUsu> listAnimalUsu = new ArrayList<>();

        AnimalUsu animalUsu1 = new AnimalUsu();
        Usuario usuario1 = new Usuario();

        usuario1.setNomeusu("Mayara");
        animalUsu1.setUsuario(usuario1);

        AnimalUsu animalUsu2 = new AnimalUsu();
        Usuario usuario2 = new Usuario();

        usuario2.setNomeusu("Mayara");
        animalUsu2.setUsuario(usuario2);

        AnimalUsu animalUsu3 = new AnimalUsu();
        Usuario usuario3 = new Usuario();

        usuario3.setNomeusu("Mayara");
        animalUsu3.setUsuario(usuario3);

        listAnimalUsu.add(animalUsu1);
        listAnimalUsu.add(animalUsu2);
        listAnimalUsu.add(animalUsu3);

        UsuarioListAdapter usuarioListAdapter = new UsuarioListAdapter(view.getContext(),R.layout.list_adapter_proprietario, listAnimalUsu);

        if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
            iv_animal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
        }
        txtNomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());

        lv_proprietarios.setAdapter(usuarioListAdapter);
        acoes();


        return view;
    }


    private void acoes(){
        ivIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("CadastroProprietario");
            }
        });
    }

}
