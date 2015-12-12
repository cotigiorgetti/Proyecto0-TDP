package Grafica;


/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para el contador del juego
 */

public class Contador extends Thread {
Juego j;
int nuHora=0;
int nuMin=0;
int nuSeg=0;
int cont=0;
	public Contador(Juego juego) {
	super();
	this.j=juego;
	 
	}
	public void run() {
	  
	        try {	        	
	        	for(nuHora=0;nuHora<=59;nuHora++)
	        		for(nuMin=0;nuMin<=59;nuMin++)
	        			for(nuSeg=0;nuSeg<=59;nuSeg++)
	        			{
	        				  String s= nuHora+":"+nuMin+":"+nuSeg; 
	        				  cont++;
	        		          j.mostrarTablero(s);
	        	            sleep(999);
	        				
	        			}
	        	//Fin del for infinito             
	        } catch (Exception ex) {
	             System.out.println(ex.getMessage());//Imprima el error
	        }                 
	 }
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	} 

}
