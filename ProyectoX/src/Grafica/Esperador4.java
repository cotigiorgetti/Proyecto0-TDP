package Grafica;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Esperador4 extends Thread {
	int nuHora=0;
	int nuMin=0;
	int nuSeg=0;
	int cont=0;
	Bomberman bomberman;
	int cant=0;
	public Esperador4(Bomberman b, int cantBombasBomberman){
	bomberman=b;
	cant=cantBombasBomberman;
	}
	
	public void run(){
		try {
			for(nuHora=0;nuHora<=0;nuHora++)
        		for(nuMin=0;nuMin<=0;nuMin++)
        			for(nuSeg=0;nuSeg<=5;nuSeg++)
        			{
        				  String s= nuHora+":"+nuMin+":"+nuSeg; 
        				  System.out.println(nuHora+" "+nuMin+" "+nuSeg);
        				  cont++;
        		          sleep(999);
        				
        			}
			 bomberman.cambiarAtravesarParedEn0();
			bomberman.setCantBombasParaColocar(cant);
		   bomberman.getNivel().setearDestructibles();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
