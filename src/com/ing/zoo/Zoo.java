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

    /** Initializes the zoo with animals */
    public Zoo() {
        animals.add(new Lion("Henk"));
        animals.add(new Hippo("Elsa"));
        animals.add(new Pig("Dora"));
        animals.add(new Tiger("Wally"));
        animals.add(new Zebra("Marty"));
        animals.add(new Parrot("Polly"));
        animals.add(new Monkey("Bert"));
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.run();
    }

    /**
     * Main loop to read user input and execute commands
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fill in your command: ");

        String input = scanner.nextLine().trim().toLowerCase();
        handleCommand(input);
    }

    /**
     * Determines which command to execute based on user input
     *
     * @param input user command
     */
    private void handleCommand(String input) {
        if (input.startsWith("hello")) {
            handleHello(input);
        } else if (input.startsWith("give")) {
            handleGive(input);
        } else if (input.startsWith("perform trick")) {
            handlePerform();
        } else {
            System.out.println("Unknown command: " + input);
        }
    }

    // --------------- Hello Command ---------------

    /**
     * Handles the 'hello' command
     *
     * @param input full user input
     */
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

    /** Make all animals say hello */
    private void sayHelloToAll() {
        animals.forEach(Animal::sayHello);
    }

    /**
     * Make a single animal say hello
     *
     * @param name the name of the animal
     */
    private void sayHelloTo(String name) {
        Animal animal = animals.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        if (animal != null) {
            animal.sayHello();
        } else {
            System.out.println("Animal not found.");
        }
    }

    // ----------------- Eat Command -----------------

    /**
     * Handles the 'give' command
     *
     * @param input full user input
     */
    private void handleGive(String input) {
        if (input.contains("leaves")) {
            giveLeaves();
        } else if (input.contains("meat")) {
            giveMeat();
        } else {
            System.out.println("Unknown food.");
        }
    }

    /** Give leaves to all herbivores */
    private void giveLeaves() {
        animals.stream()
                .filter(a -> a instanceof Herbivore)
                .map(a -> (Herbivore) a)
                .forEach(Herbivore::eatLeaves);
    }

    /** Give meat to all carnivores */
    private void giveMeat() {
        animals.stream()
                .filter(a -> a instanceof Carnivore)
                .map(a -> (Carnivore) a)
                .forEach(Carnivore::eatMeat);
    }

    // ---------------- Perform Command ---------------

    /**
     * Handles the 'perform trick' command
     *
     */
    private void handlePerform() {
        performTricks();
    }

    /** Make all animals that can perform tricks do so */
    private void performTricks() {
        animals.stream()
                .filter(a -> a instanceof TrickPerformer)
                .map(a -> (TrickPerformer) a)
                .forEach(TrickPerformer::performTrick);
    }
}
