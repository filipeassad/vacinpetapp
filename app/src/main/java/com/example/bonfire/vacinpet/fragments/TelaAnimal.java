package com.example.bonfire.vacinpet.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.adapters.ProximaVacinaAdapter;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.models.Vacina;
import com.example.bonfire.vacinpet.models.Vacinacao;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Filipe on 18/05/2016.
 */
public class TelaAnimal extends Fragment{

    private TextView tv_NomeAnimal;
    private ImageView iv_perfilAnimal;
    private ImageView iv_vacinaAnimal;
    private ImageView iv_proprietarioAnimal;
    private ImageView iv_vermifogoAnimal;
    private ImageView iv_animal;
    private Spinner spn_sexoAnimal;
    private ListView lv_proxvacinas;
    private List<String> list_sexo;
    private ListView lv_proxvermifugacao;

    private FragPrincInterface fragPrincInterface;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_pet,container, false);

        iv_animal               = (ImageView) view.findViewById(R.id.iv_animal);
        tv_NomeAnimal           = (TextView) view.findViewById(R.id.tv_NomeAnimal);
        iv_perfilAnimal         = (ImageView) view.findViewById(R.id.iv_perfilAnimal);
        iv_vacinaAnimal         = (ImageView) view.findViewById(R.id.iv_vacinaAnimal);
        iv_proprietarioAnimal   = (ImageView) view.findViewById(R.id.iv_proprietarioAnimal);
        iv_vermifogoAnimal      = (ImageView) view.findViewById(R.id.iv_vermifogoAnimal);
        lv_proxvacinas          = (ListView) view.findViewById(R.id.lv_proxvacinas);
        lv_proxvermifugacao     = (ListView) view.findViewById(R.id.lv_proxvermifugacao);


        List<Vacinacao> listaProximasVac = new ArrayList<>();
        Vacinacao vac1 = new Vacinacao();
        Vacinacao vac2 = new Vacinacao();
        Vacina vacina = new Vacina();
        Vacina vacina2 = new Vacina();
        vacina.setNomevacina("Leish");
        vacina2.setNomevacina("Raiva");
        vac1.setVacina(vacina);
        vac2.setVacina(vacina2);
        vac1.setDtproxvacin(new Date());
        vac2.setDtproxvacin(new Date());
        listaProximasVac.add(vac1);
        listaProximasVac.add(vac2);
        ProximaVacinaAdapter proximaVacinaAdapter = new ProximaVacinaAdapter(getContext(),R.layout.list_adapter_proxvacina,listaProximasVac);
        lv_proxvacinas.setAdapter(proximaVacinaAdapter);
        lv_proxvermifugacao.setAdapter(proximaVacinaAdapter);



        if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
            iv_animal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
        }
        tv_NomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());

        acoes();
        return view;
    }

    private void acoes(){

        iv_perfilAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("Perfil");
            }
        });

        iv_vacinaAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("Vacina");
            }
        });

        iv_proprietarioAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("Proprietario");
            }
        });

        iv_vermifogoAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("Vermifogo");
            }
        });

    }

}
