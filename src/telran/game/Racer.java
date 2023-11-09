package telran.game;

import java.util.Random;

class Racer extends Thread {
    private Race race;
    private int racerNumber;
    private static final int SLEEP_TIME = randomNumber();

    public Racer(Race race, int racerId) {
        this.race = race;
        this.racerNumber = racerId;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        int distance = race.getDistance();
        for (int i = 0; i < distance; i++) {
            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                throw new IllegalStateException();
            }
        }
        race.setWinner(racerNumber);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        ResultsTable.recordResult(racerNumber, totalTime);
    }

    private static int randomNumber() {
        Random number = new Random();
        return number.nextInt(4) + 2;
    }
}