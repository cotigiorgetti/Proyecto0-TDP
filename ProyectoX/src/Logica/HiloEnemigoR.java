package Logica;

import javax.swing.JOptionPane;

import Enemigo.Enemigos;
import Grafica.Juego;
import Lugar.Lugar;
/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para el Rugulo
 */
public class HiloEnemigoR extends HiloEnemigo {
	//private Enemigos e;
	//private Juego j;
	@SuppressWarnings("unused")
	private volatile boolean mDetener = false;
	public HiloEnemigoR(Enemigos e,Nivel n,Juego j) {
		super(e,n,j);
	//	this.e=e;
		// TODO Auto-generated constructor stub
	}
	public  void run() {
		try {
		while(!mDetener)	

			{
				
			
					{
						
				
						L=e.mover(e.getPosicionX(),e.getPosicionY() ,nivel);//nivel.lugarDisponible2(e.getPosicionX(),e.getPosicionY());
					 j.setearEnemigo3(e,L);
					   Thread.sleep((long) (5000*0.5));
				   }
					
				
				
			}
		} catch (InterruptedException e) { 
			System.out.println("error Rugulos");
			//e.printStackTrace();
		}
		}
	
}
