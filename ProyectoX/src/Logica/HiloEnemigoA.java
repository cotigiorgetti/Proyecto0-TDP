package Logica;

import java.util.ConcurrentModificationException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Enemigo.Enemigos;
import Grafica.Juego;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para el Altair
 */
public class HiloEnemigoA extends HiloEnemigo {
	//private Enemigos e;
	//private Juego j;
	@SuppressWarnings("unused")
	private volatile boolean mDetener = false;
	private Item l=null;
	private Icon icono=null;

	public HiloEnemigoA(Enemigos e,Nivel n,Juego j) {
		super(e,n,j);
	//	this.e=e;
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")

	public  void run() {
		try {	
		while(!mDetener)	

			{
				try{
			
					{
						if(l!=null)
						{
							j.setearLabel(l,icono);
						}
						
					 L=e.mover(e.getPosicionX(), e.getPosicionY(), nivel);//nivel.lugarDisponible3(e.getPosicionX(),e.getPosicionY());
					 l=L;
					 icono=j.encontrarIcono(l);
					
					 j.setearEnemigo4(e,L);
					 
					   Thread.sleep((long) (5000*0.5));
					   
					}  
					
						
					  }	catch(NullPointerException e){}
				catch(ConcurrentModificationException e2){}
				
			}
		
		} catch (InterruptedException e1) { 
			System.out.println("error Altair");
		//	e.printStack
			}
		
			
		}
	
}
