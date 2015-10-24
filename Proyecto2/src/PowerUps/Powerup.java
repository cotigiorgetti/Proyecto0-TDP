package PowerUps;
import Logica.*;

/**
 * @author Giorgetti,Constanza; Heinrich,Maria Eugenia
 */
public abstract class Powerup extends Item {
	
	 protected Nivel Nivel;

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