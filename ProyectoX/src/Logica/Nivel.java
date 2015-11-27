package Logica;
import java.util.*;

import javax.swing.ImageIcon;

import Enemigo.*;
import Grafica.Juego;
import Lugar.*;
import PowerUps.*;

/**
 * Clase Nivel 
 * @author Giorgetti, Constanza; Heinrich, Maria Eugenia
 */
public class Nivel {
	
	 protected Bomberman miBomberman;
	 protected HiloBomberman hb;
	 protected HiloEnemigo he,he1,he2;
	 protected List<Powerup> misPowerUps= new ArrayList<Powerup>();
	 protected List<HiloEnemigo> misEnemigos= new ArrayList<HiloEnemigo>();
	 protected List<Lugar> lugares=new ArrayList<Lugar>();
	 protected ArrayList<ArrayList<ArrayList<Item>>> mapa = new ArrayList<ArrayList<ArrayList<Item>>>();
	 protected List<Pared> indestructibles=new ArrayList<Pared>();
	 protected List<Pared> destructibles=new ArrayList<Pared>();
	 protected Bombas BombaActual=new Bombas(1,23);
     protected Juego juego;
	 /**
     * Constructor por defecto
     */
    public Nivel(Juego j) {
    	this.juego=j;
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
    	miBomberman=new Bomberman(1,1,10,0,100,15);
    	hb=new HiloBomberman(miBomberman);
    	hb.start();
    	mapa.get(1).get(1).add(miBomberman);
    	
    	
    	Powerup sp=new Speedup(10,7);
    	Powerup b=new Bombality(21,8);
    	Powerup f=new Fatality(17,2);
    	Powerup m=new Masacrality(14,10);
    	misPowerUps.add(f);
    	misPowerUps.add(m);
    	misPowerUps.add(sp);
    	misPowerUps.add(b);
    	mapa.get(6).get(10).add(sp);
    	mapa.get(8).get(20).add(b);
    	
       agregarIndestructibles();
    	agregarDestructibles();
    	agregarPerimetro();
    	Enemigos s=new Sirius(23,11,6,0);
    	Enemigos r=new Rugulos(14,6,2,0);
    	Enemigos a=new Altair(19,1,2,0);
    	he=new HiloEnemigoS(s,this,juego);
    //	he.start();
    	misEnemigos.add(he);
    	
        he1=new HiloEnemigoR(r,this,juego);
    //	he1.start();
    	misEnemigos.add(he1);
    
 
    	he2=new HiloEnemigoA(a,this,juego);
    	///he2.start();
    	misEnemigos.add(he2);
    	
    	//he.run();
    	mapa.get(11).get(22).add(s);
    	mapa.get(5).get(13).add(r);
    	mapa.get(1).get(18).add(a);
    	
    	   
    	   
    }

    private void agregarPerimetro() {
    	
	
		
		for(int j=0;j<=12;j++){
			Pared p=new Indestructible(0,j,0);
			indestructibles.add(p);
		
		
	}
	
		for(int i=0;i<=24;i++)
		{	Pared p=new Indestructible(i,0,0);
		indestructibles.add(p);
		
		
	}
		for(int j=0;j<=12;j++)
		{	Pared p=new Indestructible(24,j,0);
		indestructibles.add(p);
		
		
		}
		for(int i=0;i<=23;i++)
		{	Pared p=new Indestructible(i,12,0);
		indestructibles.add(p);	
		
		
	      }
	
	
}

	/**
     * 
     */
    protected void agregarIndestructibles(){
    	for(int i=3;i<23;i++){
    		for(int j=0;j<11;j++){
    			Pared pared=new Indestructible(i,j,0);
    			indestructibles.add(pared);
    			mapa.get(j).get(i).add(pared);
    			j+=2;
    	//	System.out.println(i+" "+j);
    		}
    		i+=2;
    	//	System.out.println();
    	}
    	
    }
    protected void crearPerimetro() {

        
    }

    /**
     * Remueve del nivel el powerUp
     * @param p power up
     */
    public void RemoverPowerUp(Powerup p) {
        // TODO implement here
    }

    public Bombas getBombaActual() {
		return BombaActual;
	}

	public void setBombaActual(Bombas bombaActual) {
		BombaActual = bombaActual;
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
     * 
     */
    public List<Pared> obtenerIndestructibles(){
    	return indestructibles;
    }
    /**
     * Devuelve la lista de paredes destruibles del nivel
     * @return lista de paredes destruibles
     */
    public List<Pared> obtenerDestructibles(){
    	return destructibles;
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
    //	 if(l.getPosicionX()>0 &&l.getPosicionX()<12 &&l.getPosicionY()>0&&l.getPosicionY()<24)
         {
    		// he.run(l);
       	 
         }       	
    }
    /**
    public void moverEnemigo(Enemigos e){
    	int posX=e.getPosicionX();
    	int posY=e.getPosicionY();
    	Lugar lugar=new Lugar(posX,posY,1);
    	
    		Random r = new Random();
    		int dir = r.nextInt(4);
 
    		switch (dir) {
    			case 0 : //Arriba
    				if ((posX-1)>0){
    					lugar.setPosicionX(posX-1);
    					lugar.setPosicionY(posY);}
    				break;
    			case 1 : //Abajo
    				if ((posX+11)<12){
    					lugar.setPosicionX(posX+1);
    					lugar.setPosicionY(posY);}
    				break;
    			case 2 : //Izquierda
    				if ((posY-1)>0){
    					lugar.setPosicionY(posY-1);
    					lugar.setPosicionX(posX);}
    				break;
    			case 3 : //Derecha
    				if ((posY+1)<24){
    					lugar.setPosicionY(posY+1);
    					lugar.setPosicionX(posX);}
    				break;
    		}
    	//	he.run(lugar);
    }
*/
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
    	if (miBomberman.getCantVidas()>0 ||bb.alcanzarBomberman(miBomberman)==true)
			//miBomberman.Morir();
    		miBomberman.removeVidasEn1();
    		else if(miBomberman.getCantVidas()==0)
    			miBomberman.Morir();
    			//miBomberman.removeVidasEn1();
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
    
    protected void agregarDestructibles(){
    	for(int i=3;i<=6;i++)
		{ Pared pared=new Destruible(i,2,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=5;i<=8;i++)
		{ Pared pared=new Destruible(2,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=9;i<=10;i++)
		{ Pared pared=new Destruible(i,7,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=16;i<=18;i++)
		{ Pared pared=new Destruible(i,2,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=16;i<=18;i++)
		{ Pared pared=new Destruible(i,4,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=3;i<=3;i++)
		{Pared pared=new Destruible(16,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=3;i<=3;i++)
		{ Pared pared=new Destruible(17,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=1;i<=3;i++)
		{ Pared pared=new Destruible(10,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=5;i<=9;i++)
		{ Pared pared=new Destruible(20,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		//for(int i=19;i<=21;i++)
		{ Pared pared=new Destruible(19,7,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		Pared p=new Destruible(21,7,0);
		RemoverDestructibles(pared);
		destructibles.add(p);
		p.setTransitable(0);
		}
		for(int i=21;i<=23;i++)
		{ Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=2;i<=6;i++)
		{ Pared pared=new Destruible(23,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=10;i<=11;i++)
		{ Pared pared=new Destruible(17,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=9;i<=11;i++)
		{ Pared pared=new Destruible(10,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=8;i<=9;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=11;i<=11;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=4;i<=10;i++)
		{ Pared pared=new Destruible(7,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=5;i<=9;i++)
		{ Pared pared=new Destruible(8,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=10;i<=16;i++)
		{ Pared pared=new Destruible(i,8,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=10;i<=11;i++)
		{ Pared pared=new Destruible(4,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=21;i<=23;i++)
		{ Pared pared=new Destruible(i,8,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=3;i<=5;i++)
		{Pared pared=new Destruible(13,i,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=14;i<=16;i++)
		{ Pared pared=new Destruible(i,5,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=11;i<=16;i++)
		{Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=9;i<=10;i++)
		{ Pared pared=new Destruible(19,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=4;i<=8;i++)
		{ Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=9;i<=11;i++)
		{ Pared pared=new Destruible(i,5,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		}
		for(int i=2;i<=3;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=8;i<=10;i++)
		{ Pared pared=new Destruible(14,i,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		}
		for(int i=21;i<=22;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		}
		
		
    }

	
	

	public void RemoverDestructibles(Lugar p) {
		try{
         for(Pared p3:destructibles)
         {
        	 if(p.getPosicionX()==p3.getPosicionX() && p.getPosicionY()==p3.getPosicionY())
        	 {          		 
        		 destructibles.remove(p3);
              
        	 }
         }
         }catch(Exception e){}
		// TODO Auto-generated method stub
		
	}

	  public boolean esTransitable(int x,int y){
	    	boolean es=true;
	    	while(es!=false){
	    	for (int i=0; i<destructibles.size();i++){
	    		if(destructibles.get(i).getPosicionX()==x && destructibles.get(i).getPosicionY()==y)
	    			es=false;
	    	}
	    	for(int j=0;j<indestructibles.size();j++){
	    		if(indestructibles.get(j).getPosicionX()==x && indestructibles.get(j).getPosicionY()==y)
	    			es=false;
	    	}
	    	}
	    	return es;
	    }

}