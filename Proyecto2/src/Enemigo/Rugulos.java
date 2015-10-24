package Enemigo;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Rugulos extends Enemigos {

	/**
     * Constructor, crea un Enemigo
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del enemigo
     * @param inteligencia inteligencia del enemigo
     */
    public Rugulos(int x, int y, int velocidad, int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    }
    
    /**
     * Bomberman destruye al Rugulos y este lo beneficia aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	b.setPuntaje(15);
    }


	@Override
	public void seguirBomberman(Bomberman b) {
		// TODO Auto-generated method stub
		
	}

}