package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Tiger extends Animal implements Carnivore, TrickPerformer {
    public Tiger(String name) {
        super(name);
    }

    public String getTrickText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(2);

        String trick;

        if (rnd == 0) {
            trick = "jumps in tree";
        } else {
            trick = "scratches ears";
        }
        return trick;
    }

    @Override
    protected String getHelloText() {
        return "rraaarww";
    }

    @Override
    public String getMeatText() {
        return "nomnomnom wubalubadubdub";
    }
}
