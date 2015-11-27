package Logica;

import javax.swing.ImageIcon;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public abstract class Item {
	
	protected int posicionX;
    protected int posicionY;
    protected ImageIcon i=new ImageIcon();

    /**
     * Constructor del item
     * @param x posicion x del item
     * @param y posicion y del item
     */
    public Item(int x,int y) {
    	posicionX=x;
    	posicionY=y;
    } 
    /**
     * Obtiene la imagen del item
     * @return imagen
     */
    public ImageIcon getI() {
		return i;
	}
    /**
     * Setea la imagen del item
     * @param i imagen
     */
	public void setI(ImageIcon i) {
		this.i = i;
	}

    /**
     * Setea la posicion x del item
     * @param x posicion
     */
    public void setPosicionX(int x) {
    	this.posicionX = x;
    }
    /**
     * Setea la posicion y del item
     * @param Y posicion
     */
    public void setPosicionY(int Y) {
		this.posicionY = Y;
	}
   
    /**
     * Retorna la posicion x del item
     * @return posicion x
     */
    public int getPosicionX() {
        // TODO implement here
        return posicionX;
    }

    /**
     * Retorna la posicion y del item
     * @return posicion y
     */
    public int getPosicionY() {
        // TODO implement here
        return posicionY;
    }

}