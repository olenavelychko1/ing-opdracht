package com.ing.zoo.animals;

import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Carnivore;

public class Lion extends Animal implements Carnivore {
    public Lion(String name) {
        super(name);
    }

    @Override
    public String getHelloText() {
        return "'roooaoaaaaar'";
    }

    @Override
    public String getMeatText() {
        return "'nomnomnom thx mate'";
    }
}
