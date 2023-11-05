package telran.homeprinter;

import telran.game.Race;
import telran.game.RaceAppl;
import telran.game.Racer;
import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;
import telran.view.Item;
import telran.view.Menu;

public class PrinterSynchronizationApp {
	private static final int MAX_NUMBERS_OF_PRINTER = 10;
	private static final int MIN_NUMBERS_OF_PRINTER = 3;
	private static final int MIN_AMOUNT_PRINTS_NUMBERS = 10;
	private static final int MAX_AMOUNT_PRINTS_NUMBERS = 200;
	private static final int MIN_NUMBERS_IN_LINE = 1;
	private static final int MAX_NUMBERS_IN_LINE = MAX_AMOUNT_PRINTS_NUMBERS;
	
	
	public static void main(String[] args) {
        InputOutput io = new ConsoleInputOutput();
        startGame(io);
    }

    static void startGame(InputOutput io) {
    	io.writeObjectLine("Start Program");
        int numberOfPrinters = io.readInt("Enter number of printers ", "Wrong number of printers",
                MIN_NUMBERS_OF_PRINTER, MAX_NUMBERS_OF_PRINTER);
        int amountNUMBERS = io.readInt("How many times to print the printer name?", "Wrong. Must be from 10 until 200", MIN_AMOUNT_PRINTS_NUMBERS, MAX_AMOUNT_PRINTS_NUMBERS);
        int numberInLine = io.readInt("How many numbers to print in one line?", "Wrong. Must be from 1 until 200",
                MIN_NUMBERS_IN_LINE, MAX_NUMBERS_IN_LINE);
        PrinterThread[] printers = new PrinterThread[numberOfPrinters];
        for (int i = 0; i < numberOfPrinters; i++) {
            printers[i] = new PrinterThread(i + 1, amountNUMBERS, numberInLine);
            if (i > 0) {
                printers[i - 1].setNextPrinter(printers[i]);
            }
        }
        printers[numberOfPrinters - 1].setNextPrinter(printers[0]);
        for (PrinterThread printer : printers) {
            printer.start();
        }
        printers[0].interrupt();
        result();
    }
	
	private static void result() {
	System.out.println("Showing the result ");
	
}


}
