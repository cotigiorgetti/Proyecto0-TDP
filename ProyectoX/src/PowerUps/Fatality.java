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
    	 this.setI(coleccionI[1]);
    }

    /**
     * Bomberman es afectado por el power up
     * @param b bomberman
     * @return power up
     */
    public Powerup devolverPowerUp (Bomberman b) {
    	 b.setPuntaje(b.getPuntaje()+35);
       	 b.setAlcance(2);
        return this;
    }

}