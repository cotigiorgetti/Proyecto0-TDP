package Enemigo;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constnaza;Heinrich,Maria Eugenia
 */
public class Sirius extends Enemigos {

	/**
     * Constructor, crea un Enemigo
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del Sirius
     * @param inteligencia inteligencia del Sirius
     */
    public Sirius(int x,int y,int velocidad,int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    }

    /**
     * Bomberman destruye al Sirius y este lo beneficia aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	b.setPuntaje(50);
    }

    /**
     * Sirius durante toda la partida sigue el movimiento del Bomberman
     * @param b Bomberman
     */
    public void seguirBomberman(Bomberman b) {
        // TODO implement here
    }


}