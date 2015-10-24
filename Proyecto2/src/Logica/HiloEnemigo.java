package Logica;

import Enemigo.*;
import Lugar.Lugar;

public class HiloEnemigo extends Thread{
	private Enemigos e;
	
	private volatile boolean mDetener;
	public HiloEnemigo(Enemigos e) {
		
		this.e  = e;
		this.mDetener = false;
	}
	public void run(Lugar l) {
		
		while(!this.mDetener){
			
			try {
				Thread.sleep(0);
				
				
				e.mover(l);
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecución.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecución.
		this.mDetener = true;
	}
	
	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		e.Morir();
	}
	public Enemigos getE() {
		return e;
	}
	public void setE(Enemigos e) {
		this.e = e;
	}


}
