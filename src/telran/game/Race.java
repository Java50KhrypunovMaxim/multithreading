package telran.game;

import java.util.Random;

public class Race {
    private int distance;
    private int winner = -1;

    public Race(int distance) {
        this.distance = distance;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        if (this.winner == -1) {
            this.winner = winner;
        }
    }

    public int getDistance() {
        return distance;
    }
}

