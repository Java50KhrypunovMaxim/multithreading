package telran.homeprinter;

public class PrinterThread extends Thread {
	private int numberOfPrinter;
	private int timesShoudPrint;
	private int amountNumbersInLine;
	private int amountOfLine;
	private PrinterThread nextPrinter;
	
	
	public PrinterThread(int numberOfPrinter, int timesShoudPrint, int amountNumbersInLine) {
		this.numberOfPrinter = numberOfPrinter;
		this.timesShoudPrint = timesShoudPrint;
		this.amountNumbersInLine = amountNumbersInLine;
		this.amountOfLine = timesShoudPrint/amountNumbersInLine;
	}


	public void setTimesShoudPrint(int timesShoudPrint) {
		this.timesShoudPrint = timesShoudPrint;
	}

	public void setAmountNumbersInLine(int amountNumbersInLine) {
		this.amountNumbersInLine = amountNumbersInLine;
	}


	public void setAmountOfLine(int amountOfLine) {
		this.amountOfLine = amountOfLine;
	}


	public void setNextPrinter(PrinterThread nextPrinter) {
		this.nextPrinter = nextPrinter;
	}
	
	@Override
	public void run() {
		int counter = 0;
		String writeInLine = (" " + numberOfPrinter).repeat(amountNumbersInLine);
		while (counter < amountOfLine) {
			try {
				join();
			} catch (InterruptedException e) {
				System.out.println(writeInLine);
				nextPrinter.interrupt();
				counter++;
			}
		}
	}
	
}