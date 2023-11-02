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
		Item[]items = getItems();
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
		int numberOfThreads = io.readInt("Enter number of the runners","Wrong number of the runners",
				MIN_THREADS, MAX_THREADS);
		int distance = io.readInt("Enter distance", "Wrong Distance",MIN_DISTANCE, MAX_DISTANCE);
		Race race = new Race (distance);
		Racer[] runners = new Racer[numberOfThreads];
		startRunners(runners, race);
		joinRunners(runners);
		displayWinner(race);
	}

	private static void displayWinner(Race race) {
		System.out.println("Congratulations to runner " + race.getWinner());
		
	}

	private static void joinRunners(Racer[] racers) {
		for (int i = 0; i < racers.length; i++) {
			try {
				racers[i].join();
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
		}
		
		
	}

	private static void startRunners(Racer[] runners, Race race) {
		for (int i = 0; i < runners.length; i++)
		{
			runners[i] = new Racer (race, i + 1);
			runners[i].start();
		}
	}

}

 


