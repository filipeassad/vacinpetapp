package com.example.bonfire.vacinpet.fragments;


import android.graphics.Bitmap;
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
import com.example.bonfire.vacinpet.models.Vacina;
import com.example.bonfire.vacinpet.models.Vacinacao;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 0118431 on 19/05/2016.
 */
public class VacinaAnimal extends Fragment {

    private ListView lv_vacina;
    private FragPrincInterface fragPrincInterface;
    private ImageView iv_animal;
    private TextView tv_NomeAnimal;
    private TextView tv_NomeVacina;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vacina_pet, container,false);

        lv_vacina = (ListView) view.findViewById(R.id.lv_vacina);
        iv_animal = (ImageView) view.findViewById(R.id.iv_animal);
        tv_NomeAnimal = (TextView) view.findViewById(R.id.tv_NomeAnimal);
        tv_NomeVacina = (TextView) view.findViewById(R.id.tv_NomeVacina);

        Bitmap bm = null;

        /*if(VariaveisEstaticas.getAnimalSelecioando().getNomeani().equals("Luffy")){
            bm = BitmapFactory.decodeResource(getResources(), R.drawable.luffy);
            tv_NomeAnimal.setText("Luffy");
        }else if(VariaveisEstaticas.getAnimalSelecioando().getNomeani().equals("Nanda")){
            bm = BitmapFactory.decodeResource(getResources(), R.drawable.nanda);
            tv_NomeAnimal.setText("Nanda");
        }else if(VariaveisEstaticas.getAnimalSelecioando().getNomeani().equals("Tufao")){
            bm = BitmapFactory.decodeResource(getResources(), R.drawable.tufao);
            tv_NomeAnimal.setText("Tufao");
        }else{
            bm = BitmapFactory.decodeResource(getResources(), R.drawable.filipe);
            tv_NomeAnimal.setText("Luffy");
        }*/
        if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
            iv_animal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
        }
        tv_NomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());

        List<Vacinacao> listVacinacao = new ArrayList<>();

        Vacinacao vacinacao1 = new Vacinacao();
        Vacina vacina1 = new Vacina();

        vacinacao1.setDatavacin(new Date());
        vacinacao1.setDtproxvacin(new Date());
        vacina1.setNomevacina("Leishmune");
        vacina1.setDescricaovaci("HEUEHUEHUEHUEHUEHEUHEEUEEHEUHEUHUEHEHU");
        vacinacao1.setVacina(vacina1);
        vacinacao1.setLotevacin("15ADP");
        vacinacao1.setFabricacaovacin("fab1");
        vacinacao1.setVencimentovacin(new Date());


        Vacinacao vacinacao2 = new Vacinacao();
        Vacina vacina2 = new Vacina();

        vacinacao2.setDatavacin(new Date());
        vacinacao2.setDtproxvacin(new Date());
        vacina2.setNomevacina("Leishmune");
        vacina2.setDescricaovaci("HEUEHUEHUEHUEHUEHEUHEEUEEHEUHEUHUEHEHU");
        vacinacao2.setVacina(vacina1);
        vacinacao2.setLotevacin("16ADP");
        vacinacao2.setFabricacaovacin("fab2");
        vacinacao2.setVencimentovacin(new Date());

        Vacinacao vacinacao3 = new Vacinacao();
        Vacina vacina3 = new Vacina();

        vacinacao3.setDatavacin(new Date());
        vacinacao3.setDtproxvacin(new Date());
        vacina3.setNomevacina("Leishmune");
        vacina3.setDescricaovaci("HEUEHUEHUEHUEHUEHEUHEEUEEHEUHEUHUEHEHU");
        vacinacao3.setVacina(vacina1);
        vacinacao3.setLotevacin("18ADP");
        vacinacao3.setFabricacaovacin("fab3");
        vacinacao3.setVencimentovacin(new Date());

        listVacinacao.add(vacinacao1);
        listVacinacao.add(vacinacao2);
        listVacinacao.add(vacinacao3);

        VacinacaoListAdapter adapter = new VacinacaoListAdapter(view.getContext(), R.layout.list_adapter_vacina, listVacinacao);

        lv_vacina.setAdapter(adapter);

        acoes();

        return view;
    }


    private void acoes(){

        lv_vacina.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VariaveisEstaticas.setVacinacaoSelecionada((Vacinacao) lv_vacina.getItemAtPosition(position));
                fragPrincInterface.mudaTela("DetalheVacina");
            }
        });

    }

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

}
