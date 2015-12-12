package Enemigo;

import java.util.Random;

import javax.swing.ImageIcon;

import Logica.Bomberman;
import Logica.Item;
import Logica.Nivel;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza; Heinrich, Maria Eugenia
 */
public abstract class Enemigos extends Item {
	protected int velocidad;
	protected int inteligencia;
	   protected ImageIcon [] coleccionI=new ImageIcon[]{new ImageIcon((Enemigos.class.getResource("/Imagenes/rugulos.png"))),
			   new ImageIcon((Enemigos.class.getResource("/Imagenes/altair.png"))),
			   new ImageIcon((Enemigos.class.getResource("/Imagenes/sirius.png")))};
	   protected Nivel Nivel;  
	   /**
	     * Constructor, crea un Enemigo
	     * @param x posicion x en el mapa
	     * @param y posicion y en el mapa
	     * @param velocidad velocidad del enemigo
	     * @param inteligencia inteligencia del enemigo
	     */
    public Enemigos(int x,int y,int velocidad,int inteligencia) {
    	 super(x,y);
         this.velocidad=velocidad;
         this.inteligencia=inteligencia;
      
    }
    /**
     * Retorna la coleccion de imagenes
     * @return coleccion de imagenes de los enemigos
     */

    public ImageIcon[] getColeccionI() {
		return coleccionI;
	}
    /**
     * Sete la coleccion de imagenes 
     * @param coleccionI coleccion de imagenes de los enemigos
     */

	public void setColeccionI(ImageIcon[] coleccionI) {
		this.coleccionI = coleccionI;
	}

	/**
     * Bomberman destruye el enemigo y este lo beneficia segun el tipo del mismo
     * @param b Bomberman
     */
    public abstract void serDestruido(Bomberman b);

    /**
     * @param b 
     * @return
     */
    public boolean tocarBomberman(Bomberman b) {
        // TODO implement here
        return false;
    }

    /**
     * retorna el nivel
     * @return nivel
     */
    public Nivel getNivel() {
        // TODO implement here
        return null;
    }

    /**
     * Movimiento del enemigo de forma aleatoria
     * @return nuevo lugar
     */
    public abstract Lugar mover(int x,int y,Logica.Nivel n);/**{
    	int posX= this.getPosicionX();
    	int posY=this.getPosicionY();
    	Random r=new Random();
    	int dir=r.nextInt(4);
    	Lugar lugar=null;
    	Lugar l=null;
    	//System.out.println(this.getPosicionX()+"  "+this.getPosicionY()+" - "+dir);
    	switch (dir) {
				case 0 : //Arriba
					if (((posX-1)>0) && (n.esTransitable(posX-1, posY)))
					lugar=new Lugar(posX-1,posY,1);
					break;
				case 1 : //Abajo
					if (((posX+1)<12) && (n.esTransitable(posX+1, posY)))
					lugar=new Lugar(posX+1,posY,1);
					break;
				case 2 : //Izquierda
					if (((posY-1)>0) && (n.esTransitable(posX, posY-1)))
    					lugar=new Lugar(posX,posY-1,1);
					break;
				case 3 : //Derecha
					if (((posY+1)<24) && (n.esTransitable(posX, posY+1)))
    					lugar=new Lugar(posX,posY+1,1);
					break;
	}
    	return lugar;

}*/
 /**   public Lugar mover() {
    	// this.setPosicionX(l.getPosicionX());
         //this.setPosicionY(l.getPosicionY());
    	int posX=this.getPosicionX();
    	int posY=this.getPosicionY();
    	Lugar lugar=null;//new Lugar(posX,posY,1);
    //	do{
    		Random r = new Random();
    		int dir = r.nextInt(4);

 {		switch (dir) {
    			case 0 : //Arriba
    				if ((posX-1)>0){
    					lugar=new Lugar(posX-1,posY,1);
    					//lugar.setPosicionX(posX-1);
    					//lugar.setPosicionY(posY);
    					
    					//System.out.println("Hacia Arriba");
    				     
    			}
    			break;
    			case 1 : //Abajo
    				if ((posX+1)<12){
    					lugar=new Lugar(posX+1,posY,1);
    					//lugar.setPosicionX(posX+1);
    					//lugar.setPosicionY(posY);
    				//	System.out.println("Hacia Abajo");
    				}
    			break;
    			case 2 : //Izquierda
    				if ((posY-1)>0){
    					lugar=new Lugar(posX,posY-1,1);
    					//lugar.setPosicionY(posY-1);
    					//lugar.setPosicionX(posX);
    					
    				//	System.out.println("Hacia La Izquierda");
    				}
    				break;
    			case 3 : //Derecha
    				if ((posY+1)<24){
    					lugar=new Lugar(posX,posY+1,1);
    					//lugar.setPosicionY(posY+1);
    					//lugar.setPosicionX(posX);
    					//System.out.println("Hacia La Derecha");
    				}
    				break;
    		}
 }//}
// while(lugar!=null);

    	
return lugar;
 }

    /**
     * El enemigo es destruido
     */
    public void Morir() {
        
    }

    /**
     * @param b
     */
    public abstract void seguirBomberman(Bomberman b);

}