package Enemigo;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Altair extends Enemigos {

    /**
     * Constructor, crea un Altair
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del enemigo
     * @param inteligencia inteligencia del enemigo
     */
    public Altair(int x,int y,int velocidad, int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    	   this.setI(coleccionI[1]);
    }

    /**
     * Bomberman destruye al enemigo aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	int puntaje=b.getPuntaje()+20;
        b.setPuntaje(puntaje);
    	
    	
    }

    /**
     * @param b
     */
    public void seguirBomberman(Bomberman b){
 
    }

}