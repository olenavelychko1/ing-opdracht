package com.ing.zoo.behaviours;

public interface Carnivore {
    String getMeatText();

    default void eatMeat() {
        System.out.println(getName() + ": " + getMeatText());
    }

    // uses the getName() method from animal
    String getName();
}
