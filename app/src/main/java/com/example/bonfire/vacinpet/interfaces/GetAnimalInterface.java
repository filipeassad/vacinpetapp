package com.example.bonfire.vacinpet.interfaces;

import com.example.bonfire.vacinpet.models.Animal;

import java.util.List;

/**
 * Created by Filipe on 30/05/2016.
 */
public interface GetAnimalInterface {
    public void getAnimal(List<Animal> animais);
    public void getImagemAnimal(Animal animal);
    public void deleteAnimal();
}
