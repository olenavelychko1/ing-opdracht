package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Zebra extends Animal implements Herbivore, TrickPerformer {
    public Zebra(String name) {
        super(name);
    }

    @Override
    public String getHelloText() {
        return "'zebra zebra'";
    }

    @Override
    public String getLeavesText() {
        return "'munch munch zank yee bra'";
    }

    @Override
    public String getTrickText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(2);

        String trick;

        if (rnd == 0) {
            trick = "*stands on its hind legs*";
        } else {
            trick = "'...... zebraaaa'";
        }
        return trick;
    }
}
