package Logica;

import Grafica.Juego;

public class Esperador extends Thread{
	
	private Juego juego;
	@SuppressWarnings("unused")
	private float tiempo;
	
	public Esperador(float t,Juego j){
		tiempo=t;
		juego=j;
	}
	
	public void run(){
		try {
			Thread.sleep(1000);
			juego.despuesDeEsperar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
