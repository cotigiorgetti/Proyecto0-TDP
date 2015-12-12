package Logica;

import Enemigo.Enemigos;
import Grafica.Juego;
/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para el Sirius
 */
public class HiloEnemigoS extends HiloEnemigo {
	//private Enemigos e;
	//private Juego j;
	private volatile boolean mDetener = false;
	public HiloEnemigoS(Enemigos e,Nivel n,Juego j) {
		super(e,n,j);
	//	this.e=e;
		// TODO Auto-generated constructor stub
	}
	public  void run() {
		try {
		while(!mDetener)	

			{
				
					
					{
						
					
					 L=e.mover(e.getPosicionX(), e.getPosicionY(),nivel);
					 j.setearEnemigo3(e,L);
				
					   Thread.sleep((long) (50*0.5));
						   
				   }
					
			
			}
		} catch (InterruptedException e) { 
			System.out.println("error Sirius");
			//e.printStackTrace();
			
		}
		}
}
