package Grafica;

public class Esperador2 extends Thread {
	private Juego juego;
	private float tiempo;
	public Esperador2(float t,Juego j){
		tiempo=t;
		juego=j;
	}
	
	public void run(){
		try {
			Thread.sleep((long) (1000*tiempo));
			juego.despuesDeEsperar2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
