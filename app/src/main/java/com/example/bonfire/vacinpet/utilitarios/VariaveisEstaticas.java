package com.example.bonfire.vacinpet.utilitarios;

import com.example.bonfire.vacinpet.interfaces.ImagemCameraInterface;
import com.example.bonfire.vacinpet.models.Animal;
import com.example.bonfire.vacinpet.models.Vacina;
import com.example.bonfire.vacinpet.models.Vacinacao;

/**
 * Created by Filipe on 25/05/2016.
 */
public class VariaveisEstaticas {

    public static ImagemCameraInterface imagemCameraInterface;

    public static Animal animalSelecioando;

    public static Vacina vacinaSelecionada;

    public static Vacinacao vacinacaoSelecionada;

    public static Vacinacao getVacinacaoSelecionada() {
        return vacinacaoSelecionada;
    }

    public static void setVacinacaoSelecionada(Vacinacao vacinacaoSelecionada) {
        VariaveisEstaticas.vacinacaoSelecionada = vacinacaoSelecionada;
    }

    public static Vacina getVacinaSelecionada() {
        return vacinaSelecionada;
    }

    public static void setVacinaSelecionada(Vacina vacinaSelecionada) {
        VariaveisEstaticas.vacinaSelecionada = vacinaSelecionada;
    }

    public static Animal getAnimalSelecioando() {
        return animalSelecioando;
    }

    public static void setAnimalSelecioando(Animal animalSelecioando) {
        VariaveisEstaticas.animalSelecioando = animalSelecioando;
    }

    public static ImagemCameraInterface getImagemCameraInterface() {
        return imagemCameraInterface;
    }

    public static void setImagemCameraInterface(ImagemCameraInterface imagemCameraInterface) {
        VariaveisEstaticas.imagemCameraInterface = imagemCameraInterface;
    }
}
