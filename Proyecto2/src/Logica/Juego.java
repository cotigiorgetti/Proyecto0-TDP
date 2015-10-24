package Logica;
import Lugar.Lugar;

/**
 * Clase Juego
 * @author Giorgetti,Constanza; Heinrich, Maria Eugenia
 */
public class Juego {
	 protected int miPuntaje;
	 protected int miTiempo;
	 protected Nivel Nivel;

    /**
     * Constructor para el Juego
     * @param n Nivel del juego
     * @param puntaje Puntaje durante el juego
     * @param tiempo Tiempo que transcurre la partida
     */
    public Juego(Nivel n,int puntaje,int tiempo) {
    	Nivel=n;
    	miPuntaje=puntaje;
    	miTiempo=tiempo;	
    }
   
    /**
     * Agrega un nivel
     * @param n nivel
     */
    public void addNivel(Nivel n) {
        Nivel=n;
    }

    /**
     * Modifica el nivel por uno pasado por parametro
     * @param n
     */
    public void ModificarNivel(Nivel n) {
        Nivel=n;
    }

    /**
     * Setea el puntaje del juego
     * @param p puntaje
     */
    public void setPuntaje(int p) {
        miPuntaje=p;
    }

    /**
     * Setea el tiempo de la partida
     * @param t tiempo
     */
    public void setTiempo(int t) {
        miTiempo=t;
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
    public void disparar(Bombas b) {
        // TODO implement here
    }

    /**
     * Devuelve el nivel del juego
     * @return nivel
     */
    public Nivel getNivel() {
        return Nivel;
    }

}