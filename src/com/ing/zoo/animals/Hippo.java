package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Herbivore;

public class Hippo extends Animal implements Herbivore {
    public Hippo(String name) {
        super(name);
    }

    @Override
    protected String getHelloText() {
        return "*splash*";
    }

    @Override
    public String getLeavesText() {
        return "'munch munch lovely'";
    }
}
