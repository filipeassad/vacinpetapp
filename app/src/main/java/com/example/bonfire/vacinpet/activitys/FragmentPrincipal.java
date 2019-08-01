package com.example.bonfire.vacinpet.activitys;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.adapters.MenuListAdapter;
import com.example.bonfire.vacinpet.fragments.CadastroProprietario;
import com.example.bonfire.vacinpet.fragments.CadastroVacVerm;
import com.example.bonfire.vacinpet.fragments.DetalheVacina;
import com.example.bonfire.vacinpet.fragments.EnderecoUsuario;
import com.example.bonfire.vacinpet.fragments.PerfilAnimal;
import com.example.bonfire.vacinpet.fragments.PerfilUsuario;
import com.example.bonfire.vacinpet.fragments.ProprietarioAnimal;
import com.example.bonfire.vacinpet.fragments.TelaAnimal;
import com.example.bonfire.vacinpet.fragments.TelaInicial;
import com.example.bonfire.vacinpet.fragments.VacinaAnimal;
import com.example.bonfire.vacinpet.fragments.VermifogoAnimal;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.List;

public class FragmentPrincipal extends FragmentActivity implements FragPrincInterface {

    private FragmentManager fm = getSupportFragmentManager();

    private ImageView imgPerfil;
    private ImageView iv_icone;
    private LinearLayout ll_nav;
    private ImageView iv_nav;
    private LinearLayout ll_fragments;
    private ListView lv_menu;
    private ImageView iv_voltar;
    private FragPrincInterface fragPrincInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_principal);

        iv_icone = (ImageView) findViewById(R.id.iv_icone);
        ll_nav = (LinearLayout) findViewById(R.id.ll_nav);
        ll_fragments = (LinearLayout) findViewById(R.id.ll_fragments);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.filipe);


        fragPrincInterface = this;
        View nav_layout =  getLayoutInflater().inflate(R.layout.navegation_menu, ll_nav);

        List<String> listString = new ArrayList<>();


        listString.add("Dados Pessoais");
        listString.add("Endereço");
        listString.add("Vacina");
        listString.add("Vermífugo");
        listString.add("Laboratório");
        listString.add("Vacinação");
        listString.add("Vermifugação");

        iv_nav = (ImageView) nav_layout.findViewById(R.id.iv_nav);
        lv_menu = (ListView) nav_layout.findViewById(R.id.lv_menu);
        iv_voltar = (ImageView) nav_layout.findViewById(R.id.iv_voltar);
        iv_nav.setImageBitmap(MetodosBasicos.getRoundedShape(bm));

        MenuListAdapter adapter = new MenuListAdapter(this,R.layout.list_adapter_menu,listString);
        lv_menu.setAdapter(adapter);
        //ll_nav.addView(nav_layout);

        if(savedInstanceState == null){
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.ll_ContFrag, telaInicial, "telaInicial");
            //ft.addToBackStack("telaInicial");
            ft.commit();
        }

        acoes();
    }

    private void acoes(){

        iv_icone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_nav.setVisibility(View.VISIBLE);
                animaEntrada(ll_nav);
            }
        });

        ll_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll_nav.getVisibility() == View.VISIBLE){
                    animaSaida(ll_nav);
                }
            }
        });

        iv_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ll_nav.getVisibility() == View.VISIBLE){
                    animaSaida(ll_nav);
                }
            }
        });

        ll_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lv_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(( parent.getItemAtPosition(position)).equals("Endereço")){
                    mudaTela("EnderecoUsuario");
                }else if((parent.getItemAtPosition(position)).equals("Dados Pessoais")){
                    mudaTela("PerfilUsuario");
                }else if ((parent.getItemAtPosition(position)).equals("Vacinação")){
                    mudaTela("CadastroVacinacao");
                }
            }
        });

    }

    private void animaEntrada(LinearLayout ll_padrao){
        TranslateAnimation animation = new TranslateAnimation(-1000,0,0,0);
        animation.setDuration(200);
        ll_padrao.startAnimation(animation);
    }

    private void animaSaida(LinearLayout ll_padrao){
        if(ll_nav.getVisibility() == View.VISIBLE){
            TranslateAnimation animation = new TranslateAnimation(0,-1000,0,0);
            animation.setDuration(200);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ll_nav.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            ll_padrao.startAnimation(animation);
        }
    }

    @Override
    public void mudaTela(String nomeTela) {

        if(nomeTela.equals("Perfil")){

            PerfilAnimal perfilAnimal = new PerfilAnimal();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, perfilAnimal, "PerfilAnimal");
            if(fm.findFragmentByTag("PerfilAnimal") != null){
                fm.popBackStack("PerfilAnimal",1);
            }
            ft.addToBackStack("PerfilAnimal");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("telaAnimal")){

            TelaAnimal telaAnimal = new TelaAnimal();
            telaAnimal.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, telaAnimal, "telaAnimal");
            if(fm.findFragmentByTag("telaAnimal") != null){
                fm.popBackStack("telaAnimal",1);
            }
            ft.addToBackStack("telaAnimal");
            ft.commit();
            animaSaida(ll_nav);

        } else if(nomeTela.equals("Vacina")){
            VacinaAnimal vacinaAnimal = new VacinaAnimal();
            vacinaAnimal.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, vacinaAnimal, "vacinaAnimal");
            if(fm.findFragmentByTag("vacinaAnimal") != null){
                fm.popBackStack("vacinaAnimal",1);
            }
            ft.addToBackStack("vacinaAnimal");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("Proprietario")){
            ProprietarioAnimal proprietarioAnimal = new ProprietarioAnimal();
            proprietarioAnimal.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, proprietarioAnimal, "Proprietario");
            if(fm.findFragmentByTag("Proprietario") != null){
                fm.popBackStack("Proprietario",1);
            }
            ft.addToBackStack("Proprietario");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("Vermifogo")){
            VermifogoAnimal vermifogoAnimal = new VermifogoAnimal();
            vermifogoAnimal.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, vermifogoAnimal, "Vermifogo");
            if(fm.findFragmentByTag("Vermifogo") != null){
                fm.popBackStack("Vermifogo",1);
            }
            ft.addToBackStack("Vermifogo");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("DetalheVacina")){
            DetalheVacina detalheVacina = new DetalheVacina();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, detalheVacina, "DetalheVacina");
            if(fm.findFragmentByTag("DetalheVacina") != null){
                fm.popBackStack("DetalheVacina",1);
            }
            ft.addToBackStack("DetalheVacina");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("CadastroProprietario")){
            CadastroProprietario cadastroProprietario = new CadastroProprietario();
            cadastroProprietario.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, cadastroProprietario, "CadastroProprietario");
            if(fm.findFragmentByTag("CadastroProprietario") != null){
                fm.popBackStack("CadastroProprietario",1);
            }
            ft.addToBackStack("CadastroProprietario");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("EnderecoUsuario")){
            EnderecoUsuario enderecoUsuario = new EnderecoUsuario();
            enderecoUsuario.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, enderecoUsuario, "EnderecoUsuario");
            if(fm.findFragmentByTag("EnderecoUsuario") != null){
                fm.popBackStack("EnderecoUsuario",1);
            }
            ft.addToBackStack("EnderecoUsuario");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("PerfilUsuario")){
            PerfilUsuario perfilUsuario = new PerfilUsuario();
            perfilUsuario.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, perfilUsuario, "PerfilUsuario");
            if(fm.findFragmentByTag("PerfilUsuario") != null){
                fm.popBackStack("PerfilUsuario",1);
            }
            ft.addToBackStack("PerfilUsuario");
            ft.commit();
            animaSaida(ll_nav);

        }else if(nomeTela.equals("CadastroVacinacao")){
            CadastroVacVerm cadastroVacVerm = new CadastroVacVerm();
            cadastroVacVerm.setFragPrincInterface(fragPrincInterface);
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, cadastroVacVerm, "CadastroVacinacao");
            if(fm.findFragmentByTag("CadastroVacinacao") != null){
                fm.popBackStack("CadastroVacinacao",1);
            }
            ft.addToBackStack("CadastroVacinacao");
            ft.commit();
            animaSaida(ll_nav);
        }else{
            TelaInicial telaInicial = new TelaInicial();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.ll_ContFrag, telaInicial, "telaInicial");
            if(fm.findFragmentByTag("telaInicial") != null){
                fm.popBackStack("telaInicial",1);
            }
            ft.addToBackStack("telaInicial");
            ft.commit();
            animaSaida(ll_nav);
        }

    }

    @Override
    public void voltaTela() {
        onBackPressed();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        VariaveisEstaticas.getImagemCameraInterface().requestImagem(requestCode,resultCode,data);
    }

    @Override
    public void onBackPressed() {
        if(ll_nav.getVisibility() == View.VISIBLE){
            animaSaida(ll_nav);
        }else{
            super.onBackPressed();
        }
    }

    /*
    Código quando eu precisar tirar um fragment da tela e voltar uma tela
    FragmentManager manager = getActivity().getSupportFragmentManager();
    FragmentTransaction trans = manager.beginTransaction();
    trans.remove(myFrag);
    trans.commit();
    manager.popBackStack();*/
}
