package Lugar;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public abstract class Pared extends Lugar {

    /**
     * Constructor para pared
     * @param x posicion x de la pared
     * @param y posicion y de la pared
     * @param t determina si la pared es o no transitable
     */
    public Pared(int x,int y,int t) {
    	super(x,y,t);
    }

    /**
     * @param b
     */
    public void serAtravesada(Bomberman b) {
        // TODO implement here
    }


}