package com.ing.zoo.behaviours;

public interface Herbivore {
    String getLeavesText();

    default void eatLeaves() {
        System.out.println(getName() + ": " + getLeavesText());
    }

    // uses the getName() method from animal
    String getName();
}
