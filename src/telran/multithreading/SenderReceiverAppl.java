package telran.multithreading;

import telran.multithreading.Messagebox.MessageBox;
import telran.multithreading.Messagebox.MessageBoxString;
import telran.multithreading.producer.Receiver;
import telran.multithreading.producer.Sender;

public class SenderReceiverAppl {
private static final int N_MESSAGES = 20;
private static final int N_RECEIVERS = 10;

public static void main(String[] args) throws InterruptedException
{
	MessageBox messageBox = new MessageBoxString();
	Sender sender = new Sender (messageBox, N_MESSAGES);
	sender.start();
	Receiver[] receivers = new Receiver [N_RECEIVERS];
	for (int i = 0; i < N_RECEIVERS; i++)
	{receivers[i] = new Receiver(messageBox);
	receivers[i].start();
	}
	sender.join();
	for (Receiver receiver: receivers) {
		receiver.interrupt();
	}
}}

