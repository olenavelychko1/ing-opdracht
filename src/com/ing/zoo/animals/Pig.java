package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Pig extends Animal implements Herbivore, Carnivore, TrickPerformer {
    public Pig(String name) {
        super(name);
    }

    public String getTrickText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(2);

        String trick;

        if (rnd == 0) {
            trick = "rolls in the mud";
        } else {
            trick = "runs in circles";
        }
        return trick;
    }

    @Override
    protected String getHelloText() {
        return "splash";
    }

    @Override
    public String getLeavesText() {
        return "munch munch oink";
    }

    @Override
    public String getMeatText() {
        return "nomnomnom oink thx";
    }
}
