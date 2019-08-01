package com.example.bonfire.vacinpet.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.interfaces.ImagemCameraInterface;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.task.PostAnimalAsyncTask;
import com.example.bonfire.vacinpet.task.PutAnimalAsyncTask;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 0118431 on 19/05/2016.
 */
public class PerfilAnimal extends Fragment implements ImagemCameraInterface {

    private ImageView ivImgAnimal;
    private ImageView iv_calendario;
    private EditText edtNomeAnimal;
    private EditText edt_dataAnimal;
    private Spinner spn_sexoAnimal;
    private Button btnCadastrar;
    private AutoCompleteTextView edt_racaAnimal;

    private List<String> list_sexo;
    private List<String> listRaca;
    private Bitmap imgSelecionada;
    private Date dataSelecionada;

    private static final int CAMERA_REQUEST = 1888;
    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil_pet, container, false);

        ivImgAnimal         = (ImageView) view.findViewById(R.id.ivImgAnimal);
        iv_calendario       = (ImageView) view.findViewById(R.id.iv_calendario);
        edtNomeAnimal       = (EditText) view.findViewById(R.id.edtNomeAnimal);
        edt_dataAnimal      = (EditText) view.findViewById(R.id.edt_dataAnimal);
        edt_racaAnimal      = (AutoCompleteTextView) view.findViewById(R.id.edt_racaAnimal);
        spn_sexoAnimal      = (Spinner) view.findViewById(R.id.spn_sexoAnimal);
        btnCadastrar        = (Button) view.findViewById(R.id.btnCadastrar);

        VariaveisEstaticas.setImagemCameraInterface(this);

        listRaca = new ArrayList<>();
        listRaca.add("Beagle");
        listRaca.add("Poodle");
        listRaca.add("Shih Tzu");
        listRaca.add("Pastor Alemão");
        listRaca.add("Maltês");
        listRaca.add("Vira-Lata");

        ArrayAdapter<String> dropDownAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,listRaca);
        edt_racaAnimal.setAdapter(dropDownAdapter);

        list_sexo = new ArrayList<>();
        list_sexo.add("Macho");
        list_sexo.add("Fêmea");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list_sexo); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_sexoAnimal.setAdapter(spinnerArrayAdapter);

        if(VariaveisEstaticas.getAnimalSelecioando() != null){
            if(VariaveisEstaticas.getAnimalSelecioando().getImagem() != null){
                ivImgAnimal.setImageBitmap(MetodosBasicos.getRoundedShape(VariaveisEstaticas.getAnimalSelecioando().getImagem()));
            }
            btnCadastrar.setText("ATUALIZAR");
            edtNomeAnimal.setText(VariaveisEstaticas.getAnimalSelecioando().getNomeani());
            imgSelecionada = VariaveisEstaticas.getAnimalSelecioando().getImagem();
        }else{
            btnCadastrar.setText("CADASTRAR");
        }

        acoes();

        return view;
    }

    private void acoes(){
        ivImgAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(v.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_escolher_imagem);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                ImageView ivCamera = (ImageView) dialog.findViewById(R.id.ivCamera);
                ImageView ivImagem = (ImageView) dialog.findViewById(R.id.ivImagem);

                ivCamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST);
                        dialog.dismiss();
                    }
                });

                ivImagem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent galeriaIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galeriaIntent,RESULT_LOAD_IMAGE);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(VariaveisEstaticas.getAnimalSelecioando() == null){
                    if(edtNomeAnimal.getText().toString().isEmpty() || edtNomeAnimal.getText().toString().trim().equals("")){
                        edtNomeAnimal.setError("Campo Vazio!");
                        return;
                    }

                    if(imgSelecionada == null){
                        Toast.makeText(getContext(),"Selecione uma imagem!",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Animal animal = new Animal();
                    animal.setNomeani(edtNomeAnimal.getText().toString());
                    animal.setImagem(imgSelecionada);

                    PostAnimalAsyncTask postAnimalAsyncTask = new PostAnimalAsyncTask(animal,getContext());
                    postAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/");
                    limpaCampos();
                }else{

                    if(edtNomeAnimal.getText().toString().isEmpty() || edtNomeAnimal.getText().toString().trim().equals("")){
                        edtNomeAnimal.setError("Campo Vazio!");
                        return;
                    }

                    if(imgSelecionada == null){
                        Toast.makeText(getContext(),"Selecione uma imagem!",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    VariaveisEstaticas.getAnimalSelecioando().setNomeani(edtNomeAnimal.getText().toString());
                    VariaveisEstaticas.getAnimalSelecioando().setImagem(imgSelecionada);

                    PutAnimalAsyncTask putAnimalAsyncTask = new PutAnimalAsyncTask(getContext(), VariaveisEstaticas.getAnimalSelecioando());
                    putAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/"+VariaveisEstaticas.getAnimalSelecioando().getCodigoani()+"/");
                    /*DeleteAnimalAsyncTask deleteAnimalAsyncTask = new DeleteAnimalAsyncTask(getContext());
                    deleteAnimalAsyncTask.execute("http://hlsvalle.pythonanywhere.com/api/animal/"+VariaveisEstaticas.getAnimalSelecioando().getCodigoani()+"/");*/
                }
            }
        });

        iv_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(v.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_calendario);

                final CalendarView calendar = (CalendarView) dialog.findViewById(R.id.calendar);

                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                        Calendar calendario = Calendar.getInstance();
                        calendario.set(year,month,dayOfMonth);

                        dataSelecionada = calendario.getTime();

                        Toast.makeText(getContext(), "Data selecionada - " + MetodosBasicos.DateToString(dataSelecionada), Toast.LENGTH_SHORT).show();
                        edt_dataAnimal.setText(MetodosBasicos.DateToString(dataSelecionada));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void limpaCampos(){
        edtNomeAnimal.setText("");
        ivImgAnimal.setImageResource(R.drawable.ico_perfil);
        imgSelecionada = null;
    }

    @Override
    public void requestImagem(int requestCode, int resultCode, Intent data) {

        Log.i("Request",requestCode + "");

        if (resultCode == getActivity().RESULT_OK) {
            if(!data.hasExtra("data")){
                /*Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();*/

                Uri selectedImage = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                    imgSelecionada = bitmap;
                    ivImgAnimal.setImageBitmap(MetodosBasicos.getRoundedShape(imgSelecionada));
                }catch (IOException e){
                    e.printStackTrace();
                }

            }else {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgSelecionada = photo;
                ivImgAnimal.setImageBitmap(MetodosBasicos.getRoundedShape(photo));
            }

        }
    }
}
