package com.ing.zoo.behaviours;

public interface TrickPerformer {
    // every animal that can perform a trick should implement this method
    String getTrickText();

    default void performTrick() {
        System.out.println(getName() + ": " + getTrickText());
    }

    // uses the getName() method from animal
    String getName();
}
