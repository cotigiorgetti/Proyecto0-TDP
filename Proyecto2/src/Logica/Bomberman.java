
package Logica;
import javax.swing.ImageIcon;

import Enemigo.*;
import Lugar.Lugar;
import Lugar.Pared;
import PowerUps.*;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Bomberman extends Item {
	
	//Imagen por defecto al inicio del juego
    protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Bomberman.class.getResource("/Imagenes/bomberman derecha1.png")))};
    protected int cantVidas;
    protected int puntaje=0;
    protected float velocidad;
    protected int atravesarPared;
    protected int cantBombasParaColocar;
    protected Bombas mis_bombas;
    protected Nivel Nivel;
	protected int alcance;

    /**
     * Constrcutor para Bomberman
     * @param x posicion x del bomberman
     * @param y posicion y del bomberman
     * @param velocidad velocidad del bomberman
     * @param puntaje puntaje que almacena el bomberman
     * @param cantBombasParaColocar cantidad de bombas que tiene almacenado
     * @param cantVidas cantidad de vidas que tiene el bomberman durante la partida
     */
	
    public Bomberman(int x,int y,float velocidad,int puntaje,int cantBombasParaColocar,int cantVidas) {
    	super(x,y);
    	this.puntaje=puntaje;
    	this.cantBombasParaColocar=cantBombasParaColocar;
    	this.cantVidas=cantVidas;
    	this.setI(coleccionI[0]);
    }

    /**
     * Retorna el puntaje del bomberman
     * @return puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Setea el puntaje del bomberman
     * @param p puntaje
     */
    public void setPuntaje(int p) {
        puntaje=p;
    }

    /**
     * Aumenta en 1 la cantidad de vidas del bomberman
     */
    public void addVidasEn1() {
        cantVidas++;
    }

    /**
     * Disminuye en 1 la cantidad de vidas del Bomberman
     */
    public void removeVidasEn1() {
        cantVidas--;
    }

    /**
     * En caso de ser destruible p, el bomberman la destruye
     * @param p pared
     */
    public void destruirPared(Pared p) {
      p.serDestruido(this);
    }

    /**
     * Bomberman destruye al enemigo
     * @param e enemigo
     */
    public void destruirEnemigo(Enemigos e) {
        e.serDestruido(this);
    }

    /**
     * Aumenta en 1 la cantidad de bombas del bomberman
     */
    public void aumentarCantBombasEnUno() {
        cantBombasParaColocar++;
    }

    /**
     * Bomberman coloca una bomba en el lugar
     * @param l lugar
     * @return bomba colocada
     */
    public Bombas colocarBomba(Lugar l) {
       if(cantBombasParaColocar>0)
    	{mis_bombas=new Bombas(l.getPosicionX(),l.getPosicionY());
        cantBombasParaColocar--;}
        //Agregar tiempo para explotar
       return mis_bombas;
    }

    /**
     * Setea atravesarPared
     */
    public void cambiarAtravesarPared() {
        // TODO implement here
    }

    /**
     * Devuelve atravesarPared
     * @return atravesarPared
     */
    public int getAtravesarPared() {
        return atravesarPared;
    }
    /**
     * Devuelve la cantidad de bombas que tiene el Bomberman
     * @return cantBombasParaColocar
     */
    public int cantBombas()
    {
    	return cantBombasParaColocar;
    }

    /**
     * Si la cantidad de vidas es 0 el Bomberman muere 
     * @return true si murio, false caso contrario
     */
    public boolean Morir() {
        cantVidas=0;
      
        return false;
    }

    /**
     * Bomberman es afectado por un Power Up
     * @param p power up
     */
    public void Afectar(Powerup p) {
        @SuppressWarnings("unused")
		Powerup pw=p.devolverPowerUp(this);
    }

    /**
     * Bomberman cambia la posicion en el mapa
     * @param l lugar
     */
    public void Mover(Lugar l) {
    	int t=l.getTransitable();
    	if (t==1){
    		int x=l.getPosicionX();
    		int y=l.getPosicionY();
    	  this.setPosicionX(x);
          this.setPosicionY(y);
    		if(atravesarPared==1){
    			l.serAtravesada(this);
    			int x1=this.getPosicionX();
    			int y1=this.getPosicionY();
    			if(x==x1){
    				if(y<y1)
    					this.setPosicionY(y+2);
    				else this.setPosicionY(y-2);}
    			if(y==y1){
    				if(x<x1)
    					this.setPosicionX(x+2);
    				else this.setPosicionX(x-2);}
    				
    			}
    		}
    	}
    
    	

    /**
     * Setea la velocidad del bomberman
     * @param v velocidad
     */
    public void setVelocidad(float v) {
      velocidad=v;  
    }

    /**
     * Devuelve la velocidad del bomberman
     * @return velocidad
     */
    public float getVelocidad() {
        // TODO implement here
        return velocidad;
    }

    /**
     * Devuelve el nivel
     * @return nivel
     */
    public Nivel getNivel() {
        return Nivel;
    }
    /**
     * Devuelve la cantidad de vidas del bomberman
     * @return cantVidas
     */
    public int getCantVidas(){
    	return cantVidas;
    }
    /**
     * Setea la cantidad de vidas del bomberman
     * @param i cantidad de vidas
     */
	public void setCantVidas(int i) {
		cantVidas=i;		
	}
	/**
	 * Incrementa el alcance de la bomba
	 * @param i alcance
	 */
	public void incrementarAlcance(int i) {
		mis_bombas.duplicarAlcance(i);
		
		
	}
	/**
	 * Devuelve la bomba actual
	 * @return bomba 
	 */
	public Bombas getMisBombas() {
		// TODO Auto-generated method stub
		return mis_bombas;
	}

}