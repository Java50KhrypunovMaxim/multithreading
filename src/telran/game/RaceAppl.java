package telran.game;

import java.util.Scanner;
import java.util.stream.IntStream;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class RaceAppl {
    private static final int MAX_THREADS = 10;
    private static final int MIN_THREADS = 3;
    private static final int MIN_DISTANCE = 100;
    private static final int MAX_DISTANCE = 2000;


    public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();
        Item[] items = getItems();
        Menu menu = new Menu("Threads Race Game", items);
        menu.perform(io);
    }

    private static Item[] getItems() {
        Item[] res = {
                Item.of("Start new game", RaceAppl::startGame),
                Item.exit()
        };
        return res;
    }

    static void startGame(InputOutput io) {
        int numberOfThreads = io.readInt("Enter number of the runners", "Wrong number of runners",
                MIN_THREADS, MAX_THREADS);
        int distance = io.readInt("Enter distance", "Wrong Distance", MIN_DISTANCE, MAX_DISTANCE);
        Race race = new Race(distance);
        Racer[] runners = new Racer[numberOfThreads];
        displayResultsHeader(io);
        startRunners(runners, race);
        joinRunners(runners);
        displayResults(runners);
    }

    private static void displayResults(Racer[] runners) {
        for (Racer racer : runners) {
            try {
                racer.join(); 
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        }
    }

    private static void displayResultsHeader(InputOutput io) {
       io.writeLine("Place\t\tThread Number\t\tTime (ms)");
    }

    private static void joinRunners(Racer[] racers) {
        for (Racer racer : racers) {
            try {
                racer.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        }
    }

    private static void startRunners(Racer[] runners, Race race) {
        for (int i = 0; i < runners.length; i++) {
            runners[i] = new Racer(race, i + 1);
            runners[i].start();
        }
    }
}