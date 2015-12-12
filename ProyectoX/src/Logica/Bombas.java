package Logica;
import javax.swing.ImageIcon;

import Enemigo.Enemigos;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Bombas extends Item {
	   protected int alcance;
	   protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Bombas.class.getResource("/Imagenes/bomba.png"))),
			   new ImageIcon((Bombas.class.getResource("/Imagenes/fuego medio.png"))),
			   new ImageIcon((Bombas.class.getResource("/Imagenes/fuego horizontal.png"))),
			   new ImageIcon((Bombas.class.getResource("/Imagenes/fuego vertical.png")))};
		
    public ImageIcon[] getColeccionI() {
		return coleccionI;
	}

	public void setColeccionI(ImageIcon[] coleccionI) {
		this.coleccionI = coleccionI;
	}

	/**
     * Constructor para una bomba
     * @param x posicion x de la bomba
     * @param y posicion y de la bomba
     */
    public Bombas(int x,int y) {
    	super(x,y);
    }
    /**
     * Retorna el alcance
     * @return alcance de la bomba
     */

    public int getAlcance() {
		return alcance;
	}
    /**
     * Sete el alcance 
     * @param alcance de la bomba
     */

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	/**
     * En caso que Bomberman sea beneficiado con el Fatality, el alcance de sus bombas se duplica
     * @param i alcance duplicado
     */
    public void duplicarAlcance(int i) {
           	alcance=i;
           this.setPosicionX(this.getPosicionX()*alcance);
           this.setPosicionY(this.getPosicionY()*alcance);
    }

    /**
     * Bomberman es alcanzado por la bomba
     * @param miBomberman Bomberman
     * @return true si es alcanzado, false caso contrario
     */
    public boolean alcanzarBomberman(Bomberman miBomberman) {
    	 if ((miBomberman.getPosicionX()<=this.getPosicionX()*alcance) &&(miBomberman.getPosicionY()<=this.getPosicionY()*alcance) )
            return true;
    	 else
    		 return false;
    }
    public boolean alcanzarEnemigo(Enemigos e) {
      	 if ((e.getPosicionX()<=this.getPosicionX()*alcance) &&(e.getPosicionY()<=this.getPosicionY()*alcance) )
              return true;
      	 else
      		 return false;
      }


    /**
     * Luego de ser colocada, la bomba explota en el lugar pasado por parametro
     * @param l Lugar
     */
    public void explotar(Lugar l) {
       this.setPosicionX(l.getPosicionX());
       this.setPosicionY(l.getPosicionY());
    }

}