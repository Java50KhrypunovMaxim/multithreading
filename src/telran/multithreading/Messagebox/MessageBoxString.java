package telran.multithreading.Messagebox;


public class MessageBoxString implements MessageBox{
	private String message;
	@Override
	synchronized public void put(String message) {
		while(this.message  != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				
			}
		}
		this.message = message;
		this.notify();
		
	}

	@Override
	synchronized public String take() throws InterruptedException {
		while(message == null) {
			this.wait();
		}
		String res = message;
		message = null;
		notify();
		return res;
	}

	@Override
	synchronized public String pull() {
		
		String str = message;
		message = null;
		notify();
		return str;
	}

}