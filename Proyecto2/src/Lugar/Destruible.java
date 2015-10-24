package Lugar;

import Enemigo.*;
import Logica.Bombas;
import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Destruible extends Pared {

    /**
     * Constructor de la pared destruible
     * @param x posicion x de la pared
     * @param y posicion y de la pared
     * @param t entero que determina si el lugar es transitable
     */
    public Destruible(int x,int y,int t) {
    	super(x,y,t);
    }


    /**
     * Bomberman destruye la pared y aumenta su puntaje
     * @param b bomberman
     */
    public void serDestruido(Bomberman b) {
        b.setPuntaje(10);
    }
    /**
     * La pared es atravesada por el Altair
     * @param e enemigo de tipo Altair
     */
    public void serAtravesada(Altair e){
    	
    }

    /**
     * La pared es destruida por una bomba
     * @param b bomba
     */
    public void destruirPared(Bombas b) {
        // TODO implement here
    }



}