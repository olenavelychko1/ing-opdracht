package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.Random;

public class Parrot extends Animal implements Herbivore, TrickPerformer {

    public Parrot(String name) {
        super(name);
    }

    @Override
    public String getTrickText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(2);

        if (rnd == 0) {
            return "*flies around in circles*";
        } else {
            return "*mimics your voice*";
        }
    }

    @Override
    public String getHelloText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(4);

        if (rnd == 0) {
            return "*squawk* 'Hello!'";
        }
        else if (rnd == 1) {
            return "Polly the III welcomes you, human, in my humble abode";
        }
        else if (rnd == 2) {
            return "*sings the iPhone alarm sound*";
        }
        else {
            return "*squeaks*";
        }
    }

    @Override
    public String getLeavesText() {
        // make a random number from 0 to 1
        Random random = new Random();
        int rnd = random.nextInt(2);

        if (rnd == 0) {
            return "'munch munch seeds'";
        }
        else {
            return "'Thank you, human, for this gracious feast...'";
        }
    }
}
