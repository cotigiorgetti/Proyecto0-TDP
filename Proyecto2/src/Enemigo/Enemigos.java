package Enemigo;

import javax.swing.ImageIcon;

import Logica.Bomberman;
import Logica.Item;
import Logica.Nivel;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza; Heinrich, Maria Eugenia
 */
public abstract class Enemigos extends Item {
	protected int velocidad;
	protected int inteligencia;
	   protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Enemigos.class.getResource("/Imagenes/rugulos.png")))};
	   protected Nivel Nivel;  
	   /**
	     * Constructor, crea un Enemigo
	     * @param x posicion x en el mapa
	     * @param y posicion y en el mapa
	     * @param velocidad velocidad del enemigo
	     * @param inteligencia inteligencia del enemigo
	     */
    public Enemigos(int x,int y,int velocidad,int inteligencia) {
    	 super(x,y);
         this.velocidad=velocidad;
         this.inteligencia=inteligencia;
         this.setI(coleccionI[0]);
    }

    /**
     * Bomberman destruye el enemigo y este lo beneficia segun el tipo del mismo
     * @param b Bomberman
     */
    public abstract void serDestruido(Bomberman b);

    /**
     * @param b 
     * @return
     */
    public boolean tocarBomberman(Bomberman b) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Nivel getNivel() {
        // TODO implement here
        return null;
    }

    /**
     * Movimiento del enemigo de forma aleatoria
     * @param l Lugar
     */
    public void mover(Lugar l) {
    	 this.setPosicionX(l.getPosicionX());
         this.setPosicionY(l.getPosicionY());
    }

    /**
     * El enemigo es destruido
     */
    public void Morir() {
        // TODO implement here
    }

    /**
     * @param b
     */
    public abstract void seguirBomberman(Bomberman b);

}