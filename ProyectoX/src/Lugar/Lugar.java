package Lugar;

import javax.swing.ImageIcon;

import Logica.Bombas;
import Logica.Bomberman;
import Logica.Item;
import Logica.Nivel;

/**
 * @author Giorgetti,Constanza,Heinrich,Maria Eugenia
 */
public class Lugar extends Item {
	
	 protected int transitable;
	 public ImageIcon[] getColeccionI() {
		return coleccionI;
	}
	 /**
	  * Setea la coleccion de lugares
	  * @param coleccionI
	  */

	public void setColeccionI(ImageIcon[] coleccionI) {
		this.coleccionI = coleccionI;
	}
	protected Nivel Nivel;
	 protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Lugar.class.getResource("/Imagenes/piso.png"))),
	    		new ImageIcon((Lugar.class.getResource("/Imagenes/pared indestructible.png"))),
	    		new ImageIcon((Lugar.class.getResource("/Imagenes/pared destruible2.png")))};
	 
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

   
    public  void destruirPared(Bombas b){
    	
    }
    
    public void serDestruido(Bomberman b){
    	
    }
}