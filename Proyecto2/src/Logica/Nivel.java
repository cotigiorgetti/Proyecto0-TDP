package Logica;
import java.util.*;

import Enemigo.*;
import Lugar.*;
import PowerUps.*;

/**
 * Clase Nivel 
 * @author Giorgetti, Constanza; Heinrich, Maria Eugenia
 */
public class Nivel {
	
	 protected Bomberman miBomberman;
	 protected HiloBomberman hb;
	 protected HiloEnemigo he;
	 protected List<Powerup> misPowerUps= new ArrayList<Powerup>();
	 protected List<HiloEnemigo> misEnemigos= new ArrayList<HiloEnemigo>();
	 protected List<Lugar> lugares=new ArrayList<Lugar>();
	 protected ArrayList<ArrayList<ArrayList<Item>>> mapa = new ArrayList<ArrayList<ArrayList<Item>>>();
	    
    /**
     * Constructor por defecto
     */
    public Nivel() {
    	crearNivel();
    }

   /**
    * Crea un nuevo nivel
    */
    public void crearNivel() {
    	
    	for(int i=0; i<=12; i++)
    	{mapa.add(i,new ArrayList<ArrayList<Item>> ());
    		for(int j=0;j<=24;j++)
    		{	ArrayList<Item> l=new ArrayList<Item> ();
    				Lugar lu=new Lugar(i,j,1);
    				l.add(lu);
    				lugares.add(lu);
    				mapa.get(i).add(j,l);
    			}
       	
    	}
    	miBomberman=new Bomberman(1,1,10,0,5,1);
    	hb=new HiloBomberman(miBomberman);
    	hb.start();
    	mapa.get(1).get(1).add(miBomberman);
    	Enemigos r=new Rugulos(22,11,2,0);
    	he=new HiloEnemigo(r);
    	he.start();
    	misEnemigos.add(he);
    	mapa.get(11).get(22).add(r);
    	Powerup sp=new Speedup(10,6);
    	Powerup b=new Bombality(20,8);
    	misPowerUps.add(sp);
    	misPowerUps.add(b);
    	mapa.get(6).get(10).add(sp);
    	mapa.get(8).get(20).add(b);
       
    }

    /**
     * 
     */
    protected void crearPerimetro() {

        
    }

    /**
     * Remueve del nivel el powerUp
     * @param p power up
     */
    public void RemoverPowerUp(Powerup p) {
        // TODO implement here
    }

    /**
     * Remueve del nivel el enemigo
     * @param p enemigo
     */
    public void RemoverEnemigo(Enemigos p) {
        // TODO implement here
    }

    /**
     * Devuelve la lista de enemigos del nivel
     * @return lista de enemigos
     */
    public List<HiloEnemigo> obtenerEnemigos() {
        // TODO implement here
        return misEnemigos;
    }

    public HiloBomberman getHb() {
		return hb;
	}

	public void setHb(HiloBomberman hb) {
		this.hb = hb;
	}

	/**
	 * Devuelve la lista de power ups
     * @return lista de power ups
     */
    public List<Powerup> obtenerPowerUps() {
        // TODO implement here
        return misPowerUps;
    }

    /**
     * @return
     */
    public Lugar[] obtenerLugares() {
        // TODO implement here
        return null;
    }

    /**
     * Devuelve el bomberman
     * @return bomberman
     */
    public Bomberman obtenerBomberman() {
       
        return miBomberman;
    }

    /**
     * Finaliza el nivel
     */
    public void finalizarNivel() {
        // TODO implement here
    }

    /**
     * @param l
     */
    public void moverBomberman(Lugar l) {
     //   if(l.getPosicionX()>0 &&l.getPosicionX()<24 &&l.getPosicionY()>0 &&l.getPosicionY()<12)
          {
        	hb.run(l);
        	
          }       	
    }
    public void detenerBomberman()
    {
    	hb.detener();
    }

    /**
     * @param l
     */
    public void moverEnemigo(Lugar l,Enemigos e) {
    	 if(l.getPosicionX()>0 &&l.getPosicionX()<12 &&l.getPosicionY()>0&&l.getPosicionY()<24)
         {
    		 he.run(l);
       	 
         }       	
    }

    /**
     * @param b
     */
    public void destruirPared(Bombas b) {
        // TODO implement here
    }

    /**
     * @param b 
     * @param pw
     */
    public void colisionarBombermaPowerUp(Powerup pw) {
       miBomberman.Afectar(pw);
       
    }

    /**
     * @param b 
     * @param e
     */
    public void colisionarBombermaEnemigo(Enemigos e) {
        if ((miBomberman.getPosicionX()==e.getPosicionX()) &&(miBomberman.getPosicionY()==e.getPosicionY()))
        	  	if (miBomberman.getCantVidas()==0)
        			miBomberman.Morir();
        		else miBomberman.removeVidasEn1();
        
    }

    /**
     * @param b 
     * @param bb
     */
    public void colisionarBombermaBomba(Bomberman b, Bombas bb) {
    	if (miBomberman.getCantVidas()==0 ||bb.alcanzarBomberman(miBomberman)==true)
			miBomberman.Morir();
		else miBomberman.removeVidasEn1();
    }

    /**
     * @param b 
     * @param l
     */
    public void colisionarBombermaPared(Lugar l) {
      Pared p=(Pared)(l);
      miBomberman.destruirPared(p);
    }

    /**
     * @param e 
     * @param b
     */
    public void colisionarEnemigoBomba(Enemigos e, Bombas b) {
        miBomberman.destruirEnemigo(e);
        e.Morir();
        
    }

    /**
     * @param e 
     * @param b
     */
    public void colisionarEnemigoBomberman(Enemigos e) {
    	 if ((miBomberman.getPosicionX()==e.getPosicionX()) &&(miBomberman.getPosicionY()==e.getPosicionY()))
     		if (miBomberman.getCantVidas()==0)
     			miBomberman.Morir();
     		else miBomberman.removeVidasEn1();

     
    }
    public Bombas colocarBombas(Lugar l){
    	return miBomberman.colocarBomba(l);
    }

}