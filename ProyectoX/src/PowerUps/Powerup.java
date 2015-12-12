package PowerUps;
import javax.swing.ImageIcon;

import Enemigo.Enemigos;
import Logica.*;

/**
 * @author Giorgetti,Constanza; Heinrich,Maria Eugenia
 */
public abstract class Powerup extends Item {
	
	 protected Nivel Nivel;
	   public ImageIcon[] getColeccionI() {
		return coleccionI;
	}

	public void setColeccionI(ImageIcon[] coleccionI) {
		this.coleccionI = coleccionI;
	}

	protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Powerup.class.getResource("/Imagenes/power up speed up.png"))),
			new ImageIcon((Powerup.class.getResource("/Imagenes/power up fatality.png"))),
			new ImageIcon((Powerup.class.getResource("/Imagenes/power up bombaility.png"))),
			new ImageIcon((Powerup.class.getResource("/Imagenes/power up masacrality.png")))};
		
	/**
     * Constructor para el Power up
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Powerup(int x,int y) {
    	super(x,y);
    }

    /**
     * Bomberman es afectado por el power up
     * @param b bomberman 
     * @return power up
     */
    public abstract Powerup devolverPowerUp(Bomberman b);

    /**
     * Retorna el nivel
     * @return nivel
     */
    public Nivel getNivel() {
        // TODO implement here
        return null;
    }

}