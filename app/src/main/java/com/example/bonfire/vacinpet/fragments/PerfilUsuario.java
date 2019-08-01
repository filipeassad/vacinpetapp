package com.example.bonfire.vacinpet.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.bonfire.vacinpet.R;

import com.example.bonfire.vacinpet.interfaces.FragPrincInterface;
import com.example.bonfire.vacinpet.interfaces.ImagemCameraInterface;
import com.example.bonfire.vacinpet.utilitarios.MetodosBasicos;
import com.example.bonfire.vacinpet.utilitarios.VariaveisEstaticas;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Filipe on 28/06/2016.
 */
public class PerfilUsuario extends Fragment implements ImagemCameraInterface {

    private ImageView ivImgPerfil;
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtCpf;
    private EditText edtDataNascimento;
    private ImageView ivCalendario;
    private CheckBox chkVeterinario;
    private LinearLayout llCRMV;
    private Spinner spn_EstadoCRMV;
    private EditText edtNumeroCRMV;
    private Button btnCadastrar;

    private FragPrincInterface fragPrincInterface;

    private Date dataSelecionada;
    private Bitmap imgSelecionada;

    private static final int CAMERA_REQUEST = 1888;
    private static int RESULT_LOAD_IMAGE = 1;

    public void setFragPrincInterface(FragPrincInterface fragPrincInterface) {
        this.fragPrincInterface = fragPrincInterface;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil_usuario,container, false);

        ivImgPerfil         = (ImageView) view.findViewById(R.id.ivImgPerfil);
        edtNome             = (EditText) view.findViewById(R.id.edtNome);
        edtEmail            = (EditText) view.findViewById(R.id.edtEmail);
        edtCpf              = (EditText) view.findViewById(R.id.edtCpf);
        edtDataNascimento   = (EditText) view.findViewById(R.id.edtDataNascimento);
        ivCalendario        = (ImageView) view.findViewById(R.id.ivCalendario);
        chkVeterinario      = (CheckBox) view.findViewById(R.id.chkVeterinario);
        llCRMV              = (LinearLayout) view.findViewById(R.id.llCRMV);
        spn_EstadoCRMV      = (Spinner) view.findViewById(R.id.spn_EstadoCRMV);
        edtNumeroCRMV       = (EditText) view.findViewById(R.id.edtNumeroCRMV);
        btnCadastrar        = (Button) view.findViewById(R.id.btnCadastrar);

        ivImgPerfil.setImageBitmap(MetodosBasicos.getRoundedShape(BitmapFactory.decodeResource(getResources(), R.drawable.filipe)));
        VariaveisEstaticas.setImagemCameraInterface(this);
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

        chkVeterinario.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llCRMV.setVisibility(View.VISIBLE);
                } else {
                    llCRMV.setVisibility(View.GONE);
                }
            }
        });

        ivCalendario.setOnClickListener(new View.OnClickListener() {
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
                        calendario.set(year, month, dayOfMonth);

                        dataSelecionada = calendario.getTime();

                        //Toast.makeText(getContext(), "Data selecionada - " + MetodosBasicos.DateToString(dataSelecionada), Toast.LENGTH_SHORT).show();
                        edtDataNascimento.setText(MetodosBasicos.DateToString(dataSelecionada));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        ivImgPerfil.setOnClickListener(new View.OnClickListener() {
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

    }

    @Override
    public void requestImagem(int requestCode, int resultCode, Intent data) {
        Log.i("Request", requestCode + "");

        if (resultCode == getActivity().RESULT_OK) {
            if(!data.hasExtra("data")){
                Uri selectedImage = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);
                    imgSelecionada = bitmap;
                    ivImgPerfil.setImageBitmap(MetodosBasicos.getRoundedShape(imgSelecionada));
                }catch (IOException e){
                    e.printStackTrace();
                }

            }else {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                imgSelecionada = photo;
                ivImgPerfil.setImageBitmap(MetodosBasicos.getRoundedShape(photo));
            }

        }

    }
}
