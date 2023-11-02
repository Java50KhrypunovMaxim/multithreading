package telran.game;

import java.util.Random;

public class Racer extends Thread {
	private Race race;
	private int racerNumber;
	private static final int SLEEP_TIME = rundomNumber();
	
	public Racer (Race race, int racerId) {
		this.race = race;
		this.racerNumber = racerId;
		
	}
	@Override
	public void run() {
		int distance = race.getDistance();
		for (int i = 0; i < distance; i++) {
			try {
				sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println(racerNumber);
		}
		race.setWinner(racerNumber);
	}
	public static int rundomNumber() {
	    Random number = new Random();
	    int random = number.nextInt(4) + 2;
	    return random;
}
}

