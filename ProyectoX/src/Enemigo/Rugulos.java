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
    	   this.setI(coleccionI[0]);
    }
    
    /**
     * Bomberman destruye al Rugulos y este lo beneficia aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	int puntaje=b.getPuntaje()+15;
        b.setPuntaje(puntaje);
    	
    }


	@Override
	public void seguirBomberman(Bomberman b) {
		// TODO Auto-generated method stub
		
	}

}