package Lugar;

import Logica.Bombas;
import Logica.Bomberman;
import Logica.Item;
import Logica.Nivel;

/**
 * @author Giorgetti,Constanza,Heinrich,Maria Eugenia
 */
public class Lugar extends Item {
	
	 protected int transitable;
	 protected Nivel Nivel;
	 
	/**
     * Constructor del lugar
     * @param x posicion x del lugar
     * @param y posicion y del lugar
     * @param t entero que determina si el lugar es transitable
     */
    public Lugar(int x,int y,int t) {
    	super(x,y);
    	transitable=t;
    }

    /**
     * El lugar es atravesado por el bomberman 
     * @param b bomberman
     */
    public void serAtravesada(Bomberman b){
    	
    }

    /**
     * Retorna el nivel
     * @return nivel
     */
    public Nivel getNivel() {
        return Nivel;
    }

    /**
     * Establece que el lugar es transitable o no
     * @param t transitable
     */
    public void setTransitable(int t) {
        transitable=t;
    }
    
    /**
     * Devuelve si el lugar es transitable
     * @return Devuelve 1 si es transitable
     */
    public int getTransitable(){
    	return transitable;
    }

    /**
     * @param b
     */
    public  void destruirPared(Bombas b){
    	
    }
    /**
     */
    public void serDestruido(Bomberman b){
    	
    }
}