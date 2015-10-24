package PowerUps;
import javax.swing.ImageIcon;

import Logica.*;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Speedup extends Powerup {

	/**
     * Constructor para el Speed up
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Speedup(int x,int y) {
    	super(x,y);
    	this.setI(new ImageIcon(Speedup.class.getResource("/Imagenes/power up speed up.png")));
    	
    }
    /**
     * Bomberman es afectado por el power up
     * @param b bombermna
     * @return power up
     */
    public Powerup devolverPowerUp(Bomberman b) {
        b.setPuntaje(b.getPuntaje()+30);
        float v=b.getVelocidad();
        if(v==0) 
        {
        	v=1;
        	}
        b.setVelocidad(v*2);
        
        return this;
    }
}