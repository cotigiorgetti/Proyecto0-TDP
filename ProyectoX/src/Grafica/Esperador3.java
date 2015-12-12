package Grafica;


/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Esperador3 extends Thread{

	private Juego juego;
	private float tiempo;
	public Esperador3(float t,Juego j){
		tiempo=t;
		juego=j;
	}
	
	public void run(){
		try {
			Thread.sleep((long) (1000*tiempo));
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
