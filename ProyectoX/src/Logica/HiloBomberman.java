package Logica;

import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase hilo para el bomberman
 */
public class HiloBomberman extends Thread {

	
	
		private Bomberman b;
		
		@SuppressWarnings("unused")
		private volatile boolean mDetener;
		
		public HiloBomberman(Bomberman b) {
			this.b = b;
			this.mDetener = false;
			
		}
		public Bomberman getB() {
			return b;
		}
		public void setB(Bomberman b) {
			this.b = b;
		}
		public void run(Lugar l) {
		
		//while(!this.mDetener){
				
		//try {
			//		Thread.sleep(1000);
					
					
					b.Mover(l);
				//} catch (InterruptedException e) { }
			//}
		}
		
		/**public void run(){
			this.mDetener=false;
		}*/
		
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
			b.Morir();
		}


}
