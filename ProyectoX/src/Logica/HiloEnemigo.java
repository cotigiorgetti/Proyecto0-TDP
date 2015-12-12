package Logica;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Enemigo.*;
import Grafica.Juego;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para los enemigos
 */
public abstract class HiloEnemigo extends Thread{
	protected Enemigos e;
	protected Juego j;
	@SuppressWarnings("unused")
	private volatile boolean mDetener = false;
	protected Nivel nivel;
	Lugar L=null;
	public HiloEnemigo(Enemigos e,Nivel n,Juego j) {
		nivel=n;
		this.j=j;
		this.e = e;
		this.mDetener = false;
		L=new Lugar(e.getPosicionX(),e.getPosicionY(),1);
		j=null;
	}
	public boolean ismDetener() {
		return mDetener;
	}
	public void setmDetener(boolean mDetener) {
		this.mDetener = mDetener;
	}
	public  abstract void run() ;
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
	public void setearJuego(Juego juego) {
		j=juego;
		
	}


}
