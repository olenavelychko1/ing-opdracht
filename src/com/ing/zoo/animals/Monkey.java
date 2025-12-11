package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Monkey extends Animal implements Herbivore, TrickPerformer {

    public Monkey(String name) {
        super(name);
    }

    @Override
    public String getTrickText() {
        // random trick
        Random random = new Random();
        int rnd = random.nextInt(2);

        if (rnd == 0) {
            return "*swings on a branch*";
        } else {
            return "*claps hands excitedly*";
        }
    }

    @Override
    public String getHelloText() {
        return "'oo oo aa aa'";
    }

    @Override
    public String getLeavesText() {
        return "'munch munch banana'";
    }
}