package PowerUps;

import Grafica.Esperador3;
import Grafica.Esperador4;
import Logica.Bomberman;
import Logica.MasacralityThread;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Masacrality extends Powerup {

	protected int tiempo;
	protected int cantBombasBomberman;

    /**
     * Constructor para el Masacrality
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Masacrality(int x,int y) {
    	super(x,y);
    	 this.setI(coleccionI[3]);
   
    }

    /**
     * Bomberman es afectado por Masacrality
     * @param b bomberman
     * @return power up
     */
    public Powerup devolverPowerUp(Bomberman b) {
    	cantBombasBomberman=b.cantBombas();
    	 Esperador4 esp= new Esperador4(b,cantBombasBomberman);
    	b.setPuntaje(b.getPuntaje()+50);
    	
    	 
    	
    //	 b.setActivo(true);
    //	b.cambiarAtravesarPared1();
    	 //MasacralityThread t=new MasacralityThread(b);
      //  for(int i=0;i<=15;i++)
        {
        	//  System.out.println("En el For Masacrality"+b.getAtravesarPared());
         
        	b.cambiarAtravesarParedEn1();
        	b.AumentarCantBombasParaColocar(99);
        	// System.out.println("En el For Masacrality"+b.getAtravesarPared());
        	  esp.start();
        	
        	
        }
      // 
    //    System.out.println("Sali del For Masacrality"+b.getAtravesarPared());
 //   b.setAtravesarPared(0);
    	return this;
    }

    /**
     * Retorna el tiempo del power up
     * @return tiempo
     */
    public int getTiempo() {
 
        return tiempo;
    }

    /**
     * Setea el tiempo del power up
     * @param t tiempo
     */
    public void setTiempo(int t) {
        tiempo=t;
    }

}