package Grafica;

public class Contador extends Thread {

	public Contador() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}


}
