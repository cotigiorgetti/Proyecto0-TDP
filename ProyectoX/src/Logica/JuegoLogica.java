package Logica;
import Grafica.Juego;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class JuegoLogica {
	
	protected int miPuntaje;
    protected int miTiempo;
    protected Nivel Nivel;

    /**
     * Constructor para el juego logica
     * @param n nivel del juego
     * @param puntaje puntaje durante el juego
     * @param tiempo tiempo del juego
     */
    public JuegoLogica(Nivel n,int puntaje,int tiempo) {
    	Nivel=n;
    	miPuntaje=puntaje;
    	miTiempo=tiempo;
    	
    }
    /**
     * Constructor por defecto
     */
    public JuegoLogica(Juego j){
    	Nivel=new Nivel(j);
    	miPuntaje=Nivel.obtenerBomberman().getPuntaje();
    	miTiempo=0;
    }

    /**
     * Agrega el nivel al juego
     * @param n nivel
     */
    public void addNivel(Nivel n) {
        // TODO implement here
    }

    /**
     * Modifica el nivel
     * @param n nivel
     */
    public void ModificarNivel(Nivel n) {
        // TODO implement here
    }

    /**
     * Setea el puntaje del juego
     * @param p puntaje
     */
    public void setPuntaje(int p) {
        // TODO implement here
    }

    /**
     * Setea el tiempo del juego
     * @param t tiempo
     */
    public void setTiempo(int t) {
        // TODO implement here
    }

    /**
     * @param l
     */
    public void Mover(Lugar l) {
        // TODO implement here
    }

    /**
     * @param b
     */
    public void colocarBombas(Bombas b) {
        // TODO implement here
    }

    /**
     * Obtiene el nivel
     * @return nivel
     */
    public Nivel getNivel() {
        // TODO implement here
        return Nivel;
    }
    
    public void colisionar(){
    	
    	
    }
    
    public void destruirPared(){
    	
    }

}