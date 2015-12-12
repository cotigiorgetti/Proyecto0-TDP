package Enemigo;

import java.util.Random;

import Logica.Bomberman;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 */
public class Altair extends Enemigos {

    /**
     * Constructor, crea un Altair
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del enemigo
     * @param inteligencia inteligencia del enemigo
     */
    public Altair(int x,int y,int velocidad, int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    	   this.setI(coleccionI[1]);
    }

    /**
     * Movimiento del Altair considerando sus cualidades
     * @param x posicion x en el campo
     * @param y posicion y en el campo
     * @param n nivel 
     * @return lugar nuevo para el enemigo
     */
    public Lugar mover(int x,int y,Logica.Nivel n)
    {
    	Lugar l=null;
		
		Lugar l2=null;
		Lugar l3=null;
		Lugar l4=null;
		Lugar l5=null;
		try{
		if  (n.noHayPowerUp(x+1,y)&&(n.noHayParedIndestructible(x+1,y))&&(x+1<24)&&n.noHayEnemigos(x+1,y))
		
			l2=new Lugar(x+1,y,1);
	  
			if(n.noHayPowerUp(x-1,y)&&(n.noHayParedIndestructible(x-1,y))&&x-1>0&& n.noHayEnemigos(x-1,y))
				l3=new Lugar(x-1,y,1);
		
			if(n.noHayPowerUp(x,y+1)&&(n.noHayParedIndestructible(x,y+1))&&n.noHayEnemigos(x,y+1))
				l4=new Lugar(x,y+1,1);
			if(n.noHayPowerUp(x,y-1)&&(n.noHayParedIndestructible(x,y-1))&&n.noHayEnemigos(x,y-1))
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
	    	return  l;	
    	
    }
    /**
     * Método para ser destruido por el bomberman
     * @param b bomberman
     */
    public void serDestruido(Bomberman b) {
    	System.out.println(b.getPuntaje());
    	int puntaje=b.getPuntaje()+20;
        b.setPuntaje(puntaje);
        System.out.println("Estoy en serDestruido");
    	System.out.println(b.getPuntaje());
    	
    }

    /**
     * @param b
     */
    public void seguirBomberman(Bomberman b){
 
    }

}