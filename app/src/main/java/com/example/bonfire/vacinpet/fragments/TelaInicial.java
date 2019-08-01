package com.example.bonfire.vacinpet.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bonfire.vacinpet.R;
import com.example.bonfire.vacinpet.adapters.AnimalListAdapter;
import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.interfaces.GetAnimalInterface;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.task.DeleteAnimalAsyncTask;
import com.example.bonfire.vacinpet.task.GetAnimalAsyncTask;
import com.example.bonfire.vacinpet.task.GetImagemAnimal;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TelaInicial extends Fragment implements GetAnimalInterface{

    private ListView lv_animais;
    private FragPrincInterface fragPrincInterface;
    private Context context;
    private List<Animal> listaAnimais;
    private List<Animal> listaAnimaisImagem;
    private ImageView img_addanimal;
    private ProgressDialog progress;

    private GetAnimalInterface getAnimalInterface;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pets,container,false);

        lv_animais = (ListView) view.findViewById(R.id.lv_animais);
        img_addanimal = (ImageView) view.findViewById(R.id.img_addanimal);

        context = view.getContext();

        getAnimalInterface = this;

        listaAnimaisImagem = new ArrayList<>();

        populaPets();

        AnimalListAdapter adapter = new AnimalListAdapter(getContext(), R.layout.list_adapter_pet, listaAnimaisImagem);
        lv_animais.setAdapter(adapter);

        /*

        GetAnimalAsyncTask getAnimalAsyncTask = new GetAnimalAsyncTask(view.getContext(),this);

        progress = new ProgressDialog(getContext());
        progress.setMessage("Buscando os Pets...");
        progress.show();

        getAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/");

        */
        acoes();

        return view;
    }


    // # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
    // # GAMBIRRA PARA POPULAR OS PETS                                                             #
    // # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
    private void populaPets(){

        Animal animal = new Animal();

        animal.setCodigoani(1);
        animal.setNomeani("Churupita");
        animal.setDtnascani(new Date());
        animal.setSexoani("M");
        animal.setCodigoraca(1);
        animal.setCodigopel(1);
        animal.setUsualt("Filipe");
        animal.setDatalt(new Date());
        animal.setCodigopet(1);
        animal.setCodigoani(1);
        animal.setUrlImagem("666");
        animal.setImagem(BitmapFactory.decodeResource(getResources(), R.drawable.img_dog1));

        Animal animal1 = new Animal();

        listaAnimaisImagem.add(animal);

        animal1.setCodigoani(1);
        animal1.setNomeani("Irineu");
        animal1.setDtnascani(new Date());
        animal1.setSexoani("M");
        animal1.setCodigoraca(1);
        animal1.setCodigopel(1);
        animal1.setUsualt("Filipe");
        animal1.setDatalt(new Date());
        animal1.setCodigopet(1);
        animal1.setCodigoani(1);
        animal1.setUrlImagem("666");
        animal1.setImagem(BitmapFactory.decodeResource(getResources(), R.drawable.img_dog2));

        Animal animal2 = new Animal();
        listaAnimaisImagem.add(animal1);

        animal2.setCodigoani(1);
        animal2.setNomeani("Filho de Buiuia");
        animal2.setDtnascani(new Date());
        animal2.setSexoani("M");
        animal2.setCodigoraca(1);
        animal2.setCodigopel(1);
        animal2.setUsualt("Filipe");
        animal2.setDatalt(new Date());
        animal2.setCodigopet(1);
        animal2.setCodigoani(1);
        animal2.setUrlImagem("666");
        animal2.setImagem(BitmapFactory.decodeResource(getResources(), R.drawable.img_dog3));

        Animal animal3 = new Animal();
        listaAnimaisImagem.add(animal2);

        animal3.setCodigoani(1);
        animal3.setNomeani("Juliana?");
        animal3.setDtnascani(new Date());
        animal3.setSexoani("M");
        animal3.setCodigoraca(1);
        animal3.setCodigopel(1);
        animal3.setUsualt("Filipe");
        animal3.setDatalt(new Date());
        animal3.setCodigopet(1);
        animal3.setCodigoani(1);
        animal3.setUrlImagem("666");
        animal3.setImagem(BitmapFactory.decodeResource(getResources(), R.drawable.img_dog4));

        listaAnimaisImagem.add(animal3);
    }

    @Override
    public void onResume() {
        super.onResume();
        VariaveisEstaticas.setAnimalSelecioando(null);
    }

    private void acoes(){

        lv_animais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragPrincInterface.mudaTela("telaAnimal");
                VariaveisEstaticas.setAnimalSelecioando((Animal) lv_animais.getItemAtPosition(position));
            }
        });

       lv_animais.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

               final Dialog dialog = new Dialog(view.getContext());
               dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
               dialog.setContentView(R.layout.dialog_excluir);

               Button btnSim = (Button) dialog.findViewById(R.id.btnSim);
               Button btnNao = (Button) dialog.findViewById(R.id.btnNao);

               btnSim.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       VariaveisEstaticas.setAnimalSelecioando((Animal) lv_animais.getItemAtPosition(position));
                       DeleteAnimalAsyncTask deleteAnimalAsyncTask = new DeleteAnimalAsyncTask(getContext(), getAnimalInterface);
                       deleteAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/" + VariaveisEstaticas.getAnimalSelecioando().getCodigoani() + "/");
                       dialog.dismiss();
                   }
               });

               btnNao.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       dialog.dismiss();
                   }
               });

               dialog.show();


               return true;
           }
       });

        img_addanimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragPrincInterface.mudaTela("Perfil");
            }
        });
    }

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public void getAnimal(List<Animal> animais) {
        if(animais != null &&
                animais.size() != 0){
            listaAnimais = animais;
            GetImagemAnimal getImagemAnimal = new GetImagemAnimal(this, context);
            getImagemAnimal.execute(listaAnimais.remove(0));
        }
    }

    @Override
    public void getImagemAnimal(Animal animal) {

        listaAnimaisImagem.add(animal);

        if(listaAnimais.size() != 0){
            GetImagemAnimal getImagemAnimal = new GetImagemAnimal(this, context);
            getImagemAnimal.execute(listaAnimais.remove(0));
        }else{
            AnimalListAdapter adapter = new AnimalListAdapter(getContext(), R.layout.list_adapter_pet, listaAnimaisImagem);
            lv_animais.setAdapter(adapter);
            progress.dismiss();
            //lv_animais.setDivider(null);
        }


    }

    @Override
    public void deleteAnimal() {
        listaAnimaisImagem = new ArrayList<>();
        GetAnimalAsyncTask getAnimalAsyncTask = new GetAnimalAsyncTask(getContext(), getAnimalInterface);
        getAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/");
    }
}
