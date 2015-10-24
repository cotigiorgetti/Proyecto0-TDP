package PowerUps;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Masacrality extends Powerup {

	protected int tiempo;
    /**
     * Constructor para el Masacrality
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Masacrality(int x,int y) {
    	super(x,y);
    }

    /**
     * Bomberman es afectado por Masacrality
     * @param b bomberman
     * @return power up
     */
    public Powerup devolverPowerUp(Bomberman b) {
    	 b.setPuntaje(b.getPuntaje()+50);
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