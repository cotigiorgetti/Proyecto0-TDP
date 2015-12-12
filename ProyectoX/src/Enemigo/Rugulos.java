package Enemigo;

import java.util.Random;

import Logica.Bomberman;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Rugulos extends Enemigos {

	/**
     * Constructor, crea un Enemigo
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del enemigo
     * @param inteligencia inteligencia del enemigo
     */
    public Rugulos(int x, int y, int velocidad, int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    	   this.setI(coleccionI[0]);
    }
    
    /**
     * Bomberman destruye al Rugulos y este lo beneficia aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	System.out.println(b.getPuntaje());
    	int puntaje=b.getPuntaje()+15;
        b.setPuntaje(puntaje);
    	System.out.println("Estoy en serDestruido");
    	System.out.println(b.getPuntaje());
    	
    }


	@Override
	public void seguirBomberman(Bomberman b) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * movimiento del rugulos 
	 * @param x posicion x en el campo 
	 * @param y posicion y en el campo
	 * @param n nivel
	 * @return nuevo lugar
	 */
	public Lugar mover(int x, int y, Logica.Nivel n) {

		Lugar l=null;
		
		Lugar l2=null;
		Lugar l3=null;
		Lugar l4=null;
		Lugar l5=null;
		try{
		if (n.noHayPowerUp(x+1,y)&&(n.noHayParedIndestructible(x+1,y))&&n.noHayParedDestructible(x+1,y)&&n.noHayEnemigos(x+1,y))
			l2=new Lugar(x+1,y,1);
	  
			if(n.noHayPowerUp(x-1,y)&&(n.noHayParedIndestructible(x-1,y))&&n.noHayParedDestructible(x-1,y)&&n.noHayEnemigos(x-1,y))
				l3=new Lugar(x-1,y,1);
		
			if(n.noHayPowerUp(x,y+1)&&(n.noHayParedIndestructible(x,y+1))&&n.noHayParedDestructible(x,y+1)&&n.noHayEnemigos(x,y+1))
				l4=new Lugar(x,y+1,1);
			if(n.noHayPowerUp(x,y-1)&&(n.noHayParedIndestructible(x,y-1))&&n.noHayParedDestructible(x,y-1)&&n.noHayEnemigos(x,y-1))
				l5=new Lugar(x,y-1,1);
			Random r=new Random();
	    	int dir=r.nextInt(4);
	    	switch (dir) {
			case 0 :{ l=l2;//Arriba
				break;}
			case 1 : //Abajo
				{l=l3;
				break;}
			case 2 : //Izquierda
			{	l=l4;
				break;}
			case 3 : //Derecha
				{l=l5;
				break;}
			default :{l=new Lugar(x,y,1);
			         break;}}
	
		}catch(NullPointerException  e){}
	    	return l;
	}

}