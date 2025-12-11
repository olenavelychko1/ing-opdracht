package com.ing.zoo;

import com.ing.zoo.animals.*;
import com.ing.zoo.base.Animal;
import com.ing.zoo.behaviours.Carnivore;
import com.ing.zoo.behaviours.Herbivore;
import com.ing.zoo.behaviours.TrickPerformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {
    private final List<Animal> animals = new ArrayList<>();

    public Zoo() {
        animals.add(new Lion("Henk, the lion"));
        animals.add(new Hippo("Elsa, the hippo"));
        animals.add(new Pig("Dora, the pig"));
        animals.add(new Tiger("Wally, the tiger"));
        animals.add(new Zebra("Marty, the zebra"));
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.run();
    }

    /**
     * Main loop
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fill in your command: ");

        String input = scanner.nextLine().trim().toLowerCase();
        handleCommand(input);
    }

    /**
     * Determines which command to run
     */
    private void handleCommand(String input) {
        if (input.startsWith("hello")) {
            handleHello(input);
        } else if (input.startsWith("give")) {
            handleGive(input);
        } else if (input.startsWith("perform trick")) {
            handlePerform(input);
        } else {
            System.out.println("Unknown command: " + input);
        }
    }

    // --------------- Hello Command ---------------

    private void handleHello(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 1) {
            // hello -> all animals
            sayHelloToAll();
        } else {
            // hello henk -> single animal
            sayHelloTo(parts[1]);
        }
    }

    private void sayHelloToAll() {
        animals.forEach(Animal::sayHello);
    }

    private void sayHelloTo(String name) {
        Animal animal = animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (animal != null) {
            animal.sayHello();
        } else {
            System.out.println("Animal not found.");
        }
    }

    // ----------------- Eat Command -----------------

    private void handleGive(String input) {
        if (input.contains("leaves")) {
            giveLeaves();
        } else if (input.contains("meat")) {
            giveMeat();
        } else {
            System.out.println("Unknown food.");
        }
    }

    private void giveLeaves() {
        animals.stream()
                .filter(a -> a instanceof Herbivore)
                .map(a -> (Herbivore) a)
                .forEach(Herbivore::eatLeaves);
    }

    private void giveMeat() {
        animals.stream()
                .filter(a -> a instanceof Carnivore)
                .map(a -> (Carnivore) a)
                .forEach(Carnivore::eatMeat);
    }

    // ---------------- Perform Command ---------------

    private void handlePerform(String input) {
        performTricks();
    }

    private void performTricks() {
        animals.stream()
                .filter(a -> a instanceof TrickPerformer)
                .map(a -> (TrickPerformer) a)
                .forEach(TrickPerformer::performTrick);
    }
}
