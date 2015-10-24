package PowerUps;

import javax.swing.ImageIcon;

import Logica.Bomberman;

/**
 * @author Giorgetti,Constanza,Heinrich,Maria Eugenia
 */
public class Bombality extends Powerup {

    /**
     * Constructor para el Bombality
     * @param x posicion x del power up
     * @param y posicion y del power up
     */
    public Bombality(int x,int y) {
    	super(x,y);
    	this.setI(new ImageIcon(Bombality.class.getResource("/Imagenes/power up bombaility.png")));
    }

    /**
     * El bomberman es afectado por el power up
     * @param b bomberman
     * @return power up
     */
    public Powerup devolverPowerUp(Bomberman b) {
        b.setPuntaje(b.getPuntaje()+35);
        b.aumentarCantBombasEnUno();
        return this;
    }


}