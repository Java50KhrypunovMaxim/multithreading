package telran.game;

class ResultsTable {
    private static final Object mutex = new Object();
    private static int place = 1;

    static void recordResult(int racerNumber, long time) {
        synchronized (mutex) {
            System.out.println(place + "\t\t" + racerNumber + "\t\t\t" + time);
            place++;
        }
    }
}