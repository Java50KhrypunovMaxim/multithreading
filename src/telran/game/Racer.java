package telran.game;

import java.util.Random;

public class Racer extends Thread {
	private Race race;
	private int racerNumber;
	
	
	public Racer (Race race, int racerId) {
		this.race = race;
		this.racerNumber = racerId;
	}
	@Override
	public void run() {
		int distance = race.getDistance();
		for (int i = 0; i < distance; i++) {
			try {
				sleep(rundomNumber());
			} catch (InterruptedException e) {
				throw new IllegalStateException();
			}
			System.out.println( racerNumber);
		}
		race.setWinner(racerNumber);
	}
	public int rundomNumber() {
	    Random number = new Random();
	    int random = number.nextInt(3) + 2;
	    return random;
}
}

