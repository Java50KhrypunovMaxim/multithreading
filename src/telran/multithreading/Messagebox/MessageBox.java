package telran.multithreading.Messagebox;

public interface MessageBox {
	void put(String message);
	String take() throws InterruptedException ;
	String pull();
}
