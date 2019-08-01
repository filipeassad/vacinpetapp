package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.adapters.VacinacaoListAdapter;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.models.Vacinacao;
import com.example.bonfire.vacinpet.models.Vermifugo;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wmkts on 21/05/16.
 */
public class VermifogoAnimal extends Fragment {

    private ListView lv_vermifogo;
    private FragPrincInterface fragPrincInterface;
    private ImageView iv_animal;
    private TextView tv_NomeAnimal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vermifogo_pet,container, false);

        lv_vermifogo = (ListView) view.findViewById(R.id.lv_vermifogo);
        iv_animal = (ImageView) view.findViewById(R.id.iv_animal);
        tv_NomeAnimal = (TextView) view.findViewById(R.id.tv_NomeAnimal);

        if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
            iv_animal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
        }
        tv_NomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());


        List<Vacinacao> listVacinacao = new ArrayList<>();

        Vacinacao vacinacao1 = new Vacinacao();
        Vermifugo vermifugo1 = new Vermifugo();

        vacinacao1.setDatavacin(new Date());
        vacinacao1.setDtproxvacin(new Date());
        vermifugo1.setNomevermi("Vermifugo");
        vacinacao1.setVermifugo(vermifugo1);


        Vacinacao vacinacao2 = new Vacinacao();
        Vermifugo vermifugo2 = new Vermifugo();

        vacinacao2.setDatavacin(new Date());
        vacinacao2.setDtproxvacin(new Date());
        vermifugo2.setNomevermi("Vermifugo");
        vacinacao2.setVermifugo(vermifugo2);

        Vacinacao vacinacao3 = new Vacinacao();
        Vermifugo vermifugo3 = new Vermifugo();

        vacinacao3.setDatavacin(new Date());
        vacinacao3.setDtproxvacin(new Date());
        vermifugo3.setNomevermi("Vermifugo");
        vacinacao3.setVermifugo(vermifugo3);

        listVacinacao.add(vacinacao1);
        listVacinacao.add(vacinacao2);
        listVacinacao.add(vacinacao3);

        VacinacaoListAdapter adapter = new VacinacaoListAdapter(view.getContext(), R.layout.list_adapter_vacina, listVacinacao);

        lv_vermifogo.setAdapter(adapter);

        acoes();

        return view;
    }

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    private void acoes(){
        lv_vermifogo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragPrincInterface.mudaTela("DetalheVacina");
            }
        });
    }

}
