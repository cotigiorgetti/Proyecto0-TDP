package PowerUps;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Fatality extends Powerup {


    /**
     * Constructor para el Fatality
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Fatality(int x,int y) {
    	super(x,y);
    }

    /**
     * Bomberman es afectado por el power up
     * @param b bomberman
     * @return power up
     */
    public Powerup devolverPowerUp (Bomberman b) {
    	 b.setPuntaje(b.getPuntaje()+35);
       	 b.incrementarAlcance(2);
        return this;
    }

}