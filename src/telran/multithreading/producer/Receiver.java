package telran.multithreading.producer;

import telran.multithreading.Messagebox.MessageBox;

public class Receiver extends Thread {
	private MessageBox messageBox;

	public Receiver(MessageBox messageBox) {
		this.messageBox = messageBox;
	
	}
	@Override
	public void run() {
	    String message = null;
	    try {
	        while (true) {
	            message = messageBox.take();
	            System.out.printf("Thread %d has got message: %s\n", getId(), message);
	        }
	    } catch (InterruptedException e) {
	        
	        message = messageBox.pull();
	        while (message != null) {
	            System.out.printf("Thread %d has got message: %s\n", getId(), message);
	            message = messageBox.pull(); 
	        }
	    }
	}}
