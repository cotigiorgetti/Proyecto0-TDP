package Enemigo;

import java.util.Random;

import Logica.Bomberman;
import Lugar.Lugar;

/**
 * @author Giorgetti,Constnaza;Heinrich,Maria Eugenia
 */
public class Sirius extends Enemigos {

	/**
     * Constructor, crea un Enemigo
     * @param x posicion x en el mapa
     * @param y posicion y en el mapa
     * @param velocidad velocidad del Sirius
     * @param inteligencia inteligencia del Sirius
     */
    public Sirius(int x,int y,int velocidad,int inteligencia) {
    	super(x,y,velocidad,inteligencia);
    	   this.setI(coleccionI[2]);
    }

    /**
     * Bomberman destruye al Sirius y este lo beneficia aumentando su puntaje
     * @param b Bomberman
     */
    public void serDestruido(Bomberman b) {
    	System.out.println(b.getPuntaje());
    	int puntaje=b.getPuntaje()+50;
        b.setPuntaje(puntaje);
        System.out.println("Estoy en serDestruido");
    	System.out.println(b.getPuntaje());
    }

    /**
     * Sirius durante toda la partida sigue el movimiento del Bomberman
     * @param b Bomberman
     */
    public void seguirBomberman(Bomberman b) {
        // TODO implement here
    }

	@Override
	public Lugar mover(int x, int y, Logica.Nivel n) {
		String mov=n.obtenerBomberman().getS();
		Lugar l=null;
		
		Lugar l2=null;
		Lugar l3=null;
		Lugar l4=null;
		Lugar l5=null;
		try{
		if (n.noHayPowerUp(x+1,y)&&(n.noHayParedIndestructible(x+1,y))&&n.noHayParedDestructible(x+1,y)&&n.noHayEnemigos(x+1,y)&& mov=="Derecha"&&(x+1<24))
			
			l2=new Lugar(x+1,y,1);
	       
			if(n.noHayPowerUp(x-1,y)&&(n.noHayParedIndestructible(x-1,y))&&n.noHayParedDestructible(x-1,y)&&n.noHayEnemigos(x-1,y)&& mov=="Izquierda"&&x-1>0)
				l3=new Lugar(x-1,y,1);
		
			if(n.noHayPowerUp(x,y+1)&&(n.noHayParedIndestructible(x,y+1))&&n.noHayParedDestructible(x,y+1)&&n.noHayEnemigos(x,y+1)&& mov=="Arriba")
				l4=new Lugar(x,y+1,1);
			if(n.noHayPowerUp(x,y-1)&&(n.noHayParedIndestructible(x,y-1))&&n.noHayParedDestructible(x,y-1)&&n.noHayEnemigos(x,y-1)&& mov=="Abajo")
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