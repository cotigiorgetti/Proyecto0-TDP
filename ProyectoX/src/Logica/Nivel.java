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
	 public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	protected HiloEnemigo he,he1,he2;
	 protected List<Powerup> misPowerUps;
	 protected List<HiloEnemigo> misEnemigos;
	 protected List<Lugar> lugares;
	 protected ArrayList<ArrayList<ArrayList<Item>>> mapa ;
	 protected List<Pared> indestructibles;
	 protected List<Pared> destructibles;
	 protected Bombas BombaActual=new Bombas(1,23);
     protected Juego juego;
     protected Enemigos s,r,a;
     protected List<Item>misItems;
     protected List<Item>misItems2;
     protected boolean activo=false;
	 /**
     * Constructor por defecto
     */
    public Nivel(Juego j) {
    	juego=j;
    	crearNivel();
    }

   /**
    * Crea un nuevo nivel
    */
    public void crearNivel() {
    	misItems=new ArrayList<Item>();
    	misItems2=new ArrayList<Item>();
    	misPowerUps= new ArrayList<Powerup>();
    	misEnemigos= new ArrayList<HiloEnemigo>();
    	lugares=new ArrayList<Lugar>();
    	mapa = new ArrayList<ArrayList<ArrayList<Item>>>();
    	indestructibles=new ArrayList<Pared>();
    	destructibles=new ArrayList<Pared>();
    	for(int i=0; i<=12; i++)
    	{mapa.add(i,new ArrayList<ArrayList<Item>> ());
    		for(int j=0;j<=24;j++)
    		{	ArrayList<Item> l=new ArrayList<Item> ();
    				Lugar lu=new Lugar(i,j,1);
    				Lugar lu2=new Lugar(j,i,1);
    				l.add(lu);
    				lu.setI(lu.getColeccionI()[0]);
    				lu2.setI(lu2.getColeccionI()[0]);
    				lugares.add(lu);
    				mapa.get(i).add(j,l);
    				misItems.add(lu2);
    				misItems2.add(lu2);
    			}
       	
    	}
    	miBomberman=new Bomberman(1,1,10,0,100,15);
    	miBomberman.setNivel(this);
    	miBomberman.setI(miBomberman.getColeccionI()[3]);
    	hb=new HiloBomberman(miBomberman);
    	hb.start();
    	mapa.get(1).get(1).add(miBomberman);
    	misItems.add(miBomberman);
    	misItems2.add(miBomberman);
    	
    	
    	Powerup sp=new Speedup(10,7);
    	Powerup b=new Bombality(21,8);
    	Powerup f=new Fatality(17,2);
    	Powerup m=new Masacrality(14,10);
    	misPowerUps.add(f);
    	f.setI(f.getColeccionI()[1]);
    	misPowerUps.add(m);
    	m.setI(m.getColeccionI()[3]);
    	misPowerUps.add(sp);
    	sp.setI(sp.getColeccionI()[0]);
    	misPowerUps.add(b);
    	b.setI(b.getColeccionI()[2]);
    	mapa.get(6).get(10).add(sp);
    	mapa.get(8).get(20).add(b);
    	misItems.add(sp);
    	misItems.add(f);
    	misItems.add(b);
    	misItems.add(m);
    	misItems2.add(sp);
    	misItems2.add(f);
    	misItems2.add(b);
    	misItems2.add(m);
    	
       agregarIndestructibles();
    	agregarDestructibles();
    	agregarPerimetro();
    	CrearEnemigos();
    	
    	   
    	   
    }
    /**
     * Crea los enemigos en el nivel
     */

    public void CrearEnemigos() {
    	
    	misEnemigos= new ArrayList<HiloEnemigo>();
        s=new Sirius(23,11,6,0);
    	r=new Rugulos(14,6,2,0);
    	a=new Altair(19,1,2,0);
    	s.setI(s.getColeccionI()[2]);
    	he=new HiloEnemigoS(s,this,juego);
    //	he.start();
    	misEnemigos.add(he);
    	r.setI(r.getColeccionI()[0]);
        he1=new HiloEnemigoR(r,this,juego);
    //	he1.start();
    	misEnemigos.add(he1);
    
    	a.setI(a.getColeccionI()[1]);
    	he2=new HiloEnemigoA(a,this,juego);
    //	he2.start();
    	misEnemigos.add(he2);
    	
    	//he.run();
    	mapa.get(11).get(22).add(s);
    	mapa.get(5).get(13).add(r);
    	mapa.get(1).get(18).add(a);
    	misItems.add(s);
    	misItems.add(r);
    	misItems.add(a);    	
}

	private void agregarPerimetro() {
    	
	
		
		for(int j=0;j<=12;j++){
			Pared p=new Indestructible(0,j,0);
			indestructibles.add(p);
			p.setI(p.getColeccionI()[1]);
			misItems.add(p);
			
		
	}
	
		for(int i=0;i<=24;i++)
		{	Pared p=new Indestructible(i,0,0);
		indestructibles.add(p);
		p.setI(p.getColeccionI()[1]);
		misItems.add(p);
		
		
	}
		for(int j=0;j<=12;j++)
		{	Pared p=new Indestructible(24,j,0);
		indestructibles.add(p);
		p.setI(p.getColeccionI()[1]);
		misItems.add(p);
		
		
		}
		for(int i=0;i<=24;i++)
		{	Pared p=new Indestructible(i,12,0);
		indestructibles.add(p);	
		p.setI(p.getColeccionI()[1]);
		misItems.add(p);
		
	      }
	
	
}

	/**
     * Agrega las paredes indestructibles al nivel
     */
    protected void agregarIndestructibles(){
    //	for(int i=3;i<23;i++){
    //		for(int j=0;j<11;j++){
    	for(int i=0;i<24;i++){
			for(int j=0;j<12;j++){
		
    	    Pared pared=new Indestructible(i,j,0);
    			indestructibles.add(pared);
    			pared.setI(pared.getColeccionI()[1]);
    			mapa.get(j).get(i).add(pared);
    			j+=2;
    			misItems.add(pared);
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
    /**
     * Retorna la bomba actual
     * @return bomba
     */

    public Bombas getBombaActual() {
		return BombaActual;
	}
    /**
     * Setea la bomba actual
     * @param bombaActual
     */

	public void setBombaActual(Bombas bombaActual) {
		BombaActual = bombaActual;
	}

	/**
     * Remueve del nivel el enemigo
     * @param p enemigo
     */
    public void RemoverEnemigo(Enemigos p) {
        //for(int i=0;i<=misEnemigos.size();i++)
        for(HiloEnemigo h1:misEnemigos)	
    	if(h1.getE().getPosicionX()==p.getPosicionX()&&h1.getE().getPosicionY()==p.getPosicionY()){
        		misEnemigos.remove(h1);
        		misItems.remove(h1.getE());
        		misItems2.remove(h1.getE());
        		h1.detener();
        		}
        
    }
    /**
     * Retorna la lista de items
     * @return lista de items
     */

    public List<Item> getMisItems() {
		return misItems;
	}
    /**
     * Setea la lista de items
     * @param misItems
     */

	public void setMisItems(List<Item> misItems) {
		this.misItems = misItems;
	}
	/**
	 * Retorna la lista 2 de items
	 * @return
	 */

	public List<Item> getMisItems2() {
		return misItems2;
	}
	/**
	 * Setea la lista de items
	 * @param misItems2
	 */

	public void setMisItems2(List<Item> misItems2) {
		this.misItems2 = misItems2;
	}

	/**
     * Devuelve la lista de enemigos del nivel
     * @return lista de enemigos
     */
    public List<HiloEnemigo> obtenerEnemigos() {
        // TODO implement here
        return misEnemigos;
    }
    /**
     * Obtiene el hilo del bomberman
     * @return hilo bomberman
     */

    public HiloBomberman getHb() {
		return hb;
	}
    /**
     * Setea el hilo del bomberman
     * @param hb
     */

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
     * Retorna la lista de paredes indestructibles del nivel
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
     * Mueve al bomberman a un nuevo lugar en el nivel
     * @param l lugar
     */
    public void moverBomberman(Lugar l) {
     //   if(l.getPosicionX()>0 &&l.getPosicionX()<24 &&l.getPosicionY()>0 &&l.getPosicionY()<12)
          {
        	hb.run(l);
        	
          }       	
    }
    /**
     * Detiene el hilo del bomberman
     */
    public void detenerBomberman()
    {
    	hb.detener();
    }

    /**
     * Mueve al enemigo pasado por parametro en el nivel
     * @param l nuevo lugar
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
     * Metodo para cuando colisiona el bomberman con un power up
     * @param pw powerup
     */
    public void colisionarBombermaPowerUp(Powerup pw) {
       miBomberman.Afectar(pw);
       
    }

    /**
     * Metodo para cuando colisiona el bomberman con el enemigo
     * @param e enemigo
     */
    public void colisionarBombermaEnemigo(Enemigos e) {
        if ((miBomberman.getPosicionX()==e.getPosicionX()) &&(miBomberman.getPosicionY()==e.getPosicionY()))
        	  	if (miBomberman.getCantVidas()==0)
        			miBomberman.Morir();
        		else miBomberman.removeVidasEn1();
        
    }

    /**
     * Metodo para cuando colisiona el bomberman con la bomba
     * @param b bomberman
     * @param bb bomba
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
     * Metodo para cuando colisiona el bomberman con la pared
     * @param l lugar
     */
    public void colisionarBombermaPared(Lugar l) {
      Pared p=(Pared)(l);
      miBomberman.destruirPared(p);
    }

    /**
     * Metodo para cuando colisiona el enemigo con la bomba
     * @param e enemigo
     * @param b bomba
     */
    public void colisionarEnemigoBomba(Enemigos e, Bombas b) {
    	//if (b.alcanzarEnemigo(e)==true)
    	{miBomberman.destruirEnemigo(e);
        e.Morir();
        RemoverEnemigo(e);
    	}
    }

    /**
     * Meetodo cuando colisiona enemigo con el bomberman
     * @param e enemigo
     */
    public void colisionarEnemigoBomberman(Enemigos e) {
    	 if ((miBomberman.getPosicionX()==e.getPosicionX()) &&(miBomberman.getPosicionY()==e.getPosicionY()))
     		if (miBomberman.getCantVidas()==0)
     			miBomberman.Morir();
     		else miBomberman.removeVidasEn1();

     
    }
    /**
     * Metodo para colcoar la bomba en el lugar pasado por param
     * @param l lugar
     * @return bomba colocada
     */
    public Bombas colocarBombas(Lugar l){
    	return miBomberman.colocarBomba(l);
    }
    //Metodo para agregar las paredes destructibles en el nivel
    protected void agregarDestructibles(){
    	for(int i=3;i<=6;i++)
		{ Pared pared=new Destruible(i,2,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=5;i<=8;i++)
		{ Pared pared=new Destruible(2,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=9;i<=10;i++)
		{ Pared pared=new Destruible(i,7,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=16;i<=18;i++)
		{ Pared pared=new Destruible(i,2,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=16;i<=18;i++)
		{ Pared pared=new Destruible(i,4,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=3;i<=3;i++)
		{Pared pared=new Destruible(16,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=3;i<=3;i++)
		{ Pared pared=new Destruible(17,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=1;i<=3;i++)
		{ Pared pared=new Destruible(10,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=5;i<=9;i++)
		{ Pared pared=new Destruible(20,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		//for(int i=19;i<=21;i++)
		{ Pared pared=new Destruible(19,7,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		Pared p=new Destruible(21,7,0);
		RemoverDestructibles(pared);
		destructibles.add(p);
		p.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=21;i<=23;i++)
		{ Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=2;i<=6;i++)
		{ Pared pared=new Destruible(23,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=10;i<=11;i++)
		{ Pared pared=new Destruible(17,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=9;i<=11;i++)
		{ Pared pared=new Destruible(10,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=8;i<=9;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=11;i<=11;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=4;i<=10;i++)
		{ Pared pared=new Destruible(7,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
	i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=5;i<=9;i++)
		{ Pared pared=new Destruible(8,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=10;i<=16;i++)
		{ Pared pared=new Destruible(i,8,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=10;i<=11;i++)
		{ Pared pared=new Destruible(4,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=21;i<=23;i++)
		{ Pared pared=new Destruible(i,8,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=3;i<=5;i++)
		{Pared pared=new Destruible(13,i,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=14;i<=16;i++)
		{ Pared pared=new Destruible(i,5,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=11;i<=16;i++)
		{Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=9;i<=10;i++)
		{ Pared pared=new Destruible(19,i,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=4;i<=8;i++)
		{ Pared pared=new Destruible(i,1,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
	i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=9;i<=11;i++)
		{ Pared pared=new Destruible(i,5,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
	i++;
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=2;i<=3;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=8;i<=10;i++)
		{ Pared pared=new Destruible(14,i,0);
		RemoverDestructibles(pared);
			destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		for(int i=21;i<=22;i++)
		{ Pared pared=new Destruible(i,11,0);
		RemoverDestructibles(pared);
		destructibles.add(pared);
		pared.setTransitable(0);
		pared.setI(pared.getColeccionI()[2]);
		misItems.add(pared);
		}
		
		
    }
    /**
     * Metodo para remover la pared destructible
     * @param p lugar donde esta la pared
     */
	public void RemoverDestructibles(Lugar p) {
		try{
         for(Pared p3:destructibles)
         {
        	 if(p.getPosicionX()==p3.getPosicionX() && p.getPosicionY()==p3.getPosicionY())
        	 {          		 
        		 destructibles.remove(p3);
        		 misItems.remove(p3);
        		 p3.setTransitable(1);
              
        	 }
         }
         }catch(Exception e){}
		// TODO Auto-generated method stub
		
	}
	/**
	 * Retorna si el lugar es transitable o no
	 * @param x posicion x
	 * @param y posicion y
	 * @return true si es transitable, false caso contrario
	 */

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
	  /**
	   * Retorna el power up cuando colisiona 
	   * @param x posicio nx
	   * @param y posicion y
	   * @return
	   */

	  public Powerup hayColisionPowerUp(int x, int y) {
			Powerup r=null;	
				for(int i=0;i<misPowerUps.size();i++)
				{Powerup p=misPowerUps.get(i);
					
				if(p.getPosicionX()==x &&p.getPosicionY()==y)
					{r=p;
				     break;}
				}
				return r;
			}
	  //Metodo privado para obtener el power up que este al rededor del bomberman
		protected Powerup hayPowerUpAlRededor(int x, int y) {
			Powerup r=null;	
				for(int i=0;i<misPowerUps.size();i++)
				{Powerup p=misPowerUps.get(i);
					
				if(p.getPosicionX()==x+1 &&p.getPosicionY()==y)
					{r=p;
				     break;}
				if(p.getPosicionX()==x-1 &&p.getPosicionY()==y)
				{r=p;
			     break;}
				if(p.getPosicionX()==x &&p.getPosicionY()==y+1)
				{r=p;
			     break;}
				if(p.getPosicionX()==x &&p.getPosicionY()==y-1)
				{r=p;
			     break;}
				}
				return r;
			}
		/**
		 * Metodo que retorna el enemigo cuando hay colision
		 * @param x posicion x
		 * @param i posicion y 
		 * @return enemigo
		 */
		public Enemigos hayColisionEnemigo(int x, int i) {
			   Enemigos e=null;	
			  
				
				for(int k=0;k<misEnemigos.size();k++)
				{Enemigos e1=misEnemigos.get(k).getE();
				
				
				if(e1.getPosicionX()==x &&e1.getPosicionY()==i)
					{
					e=e1;
				
					break;}
				}
				return e;
				
			}
		/**
		 * Metodo que devuelve la pared cuando hay colision
		 * @param x posicion x
		 * @param i posicion y
		 * @return
		 */
		public Pared hayColisionPared(int x, int i) {
			 Pared e=null;	
			  
				
				for(int k=0;k<indestructibles.size();k++)
				{Pared e1=indestructibles.get(k);
				
				if(e1.getPosicionX()==x &&e1.getPosicionY()==i)
					{
					e=e1;
				
					break;}
				}
				for(int j=0;j<destructibles.size();j++)
				{Pared d1=destructibles.get(j);
				if(d1.getPosicionX()==x && d1.getPosicionY()==i)
				{
					e=d1;
					break;
				}
				}
				return e;
		}
		/**
		 * Metodo que devuelve la pared cuando hay colision
		 * @param x posicion x
		 * @param i posicion y
		 * @return pared
		 */
		public Pared hayColisionPared2(int x, int i) {
			 Pared e=null;	
			  
				
				for(int k=0;k<indestructibles.size();k++)
				{Pared e1=indestructibles.get(k);
				
				if(e1.getPosicionX()==x &&e1.getPosicionY()==i)
					{
					e=e1;
				
					break;}
				}
				
				return e;
		}
		/**
		 * Retorna el enemigo en caso que se encuentre en el lugar
		 * @param l lugar
		 * @return enemigo si está o nulo en caso contrario
		 */
		public Enemigos noHayEnemigo(Lugar l) {
			Enemigos h2=null;
			int x;
			int y;
			
			int x1=l.getPosicionX();
			int y1=l.getPosicionY();
			for(HiloEnemigo h:misEnemigos)
			{x=h.getE().getPosicionX();
			y=h.getE().getPosicionY();
		//	System.out.println(x1+" "+y1);
		//	System.out.println(x+" "+y);
			if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
			{h2=h.getE();
			break;}
			}
			return h2;
		}

		public Lugar hayParedAlrededor(Lugar l, List<Pared> list) {
			Pared p=null;
			int x;
			int y;
			int x1=l.getPosicionX();
			int y1=l.getPosicionY();
			for(Pared p2:list)
			{x=p2.getPosicionX();
			y=p2.getPosicionY();
			if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
			{p=p2;
			break;}
			}
			return p;
		}

		/**
		 * Metodo para determinar si esta el bomberman en el lugar pasado por parametro
		 * @param l lugar
		 * @return true si esta, false caso contrario
		 */

	public boolean hayBomberman(Lugar l) {
		int x=miBomberman.getPosicionX();
		int y=miBomberman.getPosicionY();
		int x1=l.getPosicionX();
		int y1=l.getPosicionY();
			if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
			return true;
			else
			return false;
		}
	/**
	 * Retorna en caso que exista el lugar disponible
	 * @param x posicion x
	 * @param y posicion y 
	 * @return lugar, si esta disponible, nulo en caso contrario
	 */

	public Lugar lugarDisponible(int x, int y) {
			Lugar l=null;
			if (noHayPowerUp(x+1,y)&&(noHayEnemigos(x+1,y))&&(noHayParedIndestructible(x+1,y))&&(x+1<24)&&noHayParedDestructible(x+1,y))
				l=new Lugar(x+1,y,1);
		  else
				if (noHayPowerUp(x-1,y)&&(noHayEnemigos(x-1,y))&&(noHayParedIndestructible(x-1,y))&&noHayParedDestructible(x-1,y)&&x-1>0)
					l=new Lugar(x-1,y,1);
			else
				if (noHayPowerUp(x,y+1)&&(noHayEnemigos(x,y+1))&&(noHayParedIndestructible(x,y+1))&&noHayParedDestructible(x,y+1))
					l=new Lugar(x,y+1,1);
			else
				if (noHayPowerUp(x,y-1)&&(noHayEnemigos(x,y-1))&&(noHayParedIndestructible(x,y-1))&&noHayParedDestructible(x,y-1))
					l=new Lugar(x,y-1,1);
			return l;
		}
		
	/**
	 * Testea si hay enemigo en la posicion pasada por param
	 * @param x posicion x
	 * @param i posicion y 
	 * @return true si no hay enemigo, false en caso contrario
	 */

	public boolean noHayEnemigos(int x, int i) {
			boolean res=true;
			
			for(int k=0;k<misEnemigos.size();k++)
				if((misEnemigos.get(k).getE().getPosicionX()==x)&&(misEnemigos.get(k).getE().getPosicionY()==i)){
					res=false;
					break;}
			return res;
		}
	/**
	 * Teste si hay power up en la posicion
	 * @param i posicion x
	 * @param y posicion y
	 * @return true si no hay power up, false en caso contrario
	 */
		public boolean noHayPowerUp(int i, int y) {
			boolean res=true;
			try{
			for(int k=0;k<misPowerUps.size();k++)
				if((misPowerUps.get(k).getPosicionX()==i)&&(misPowerUps.get(k).getPosicionY()==y)){
					res=false;
					break;}
			}catch(NullPointerException e){}
			return res;
		}
		/**
		 * Teste si hay pared indestructible en la posicion
		 * @param i posicion x
		 * @param y posicion y
		 * @return true si no hay pared, false en caso contrario
		 */
		public boolean noHayParedIndestructible(int i,int y){
			boolean res=true;
			for(int k=0;k<indestructibles.size();k++)
				if((indestructibles.get(k).getPosicionX()==i) && (indestructibles.get(k).getPosicionY()==y)){
					res=false;
					break;
				}
			return res;
		}
		/**
		 * Teste si hay pared destructible en la posicion
		 * @param i posicion x
		 * @param y posicion y
		 * @return true si no hay pared, false en caso contrario
		 */
		public boolean noHayParedDestructible(int i,int y){
			boolean res=true;
			for(int k=0;k<destructibles.size();k++)
				if((destructibles.get(k).getPosicionX()==i) && (destructibles.get(k).getPosicionY()==y)){
					res=false;
					break;
				}
			return res;
		}
		/**
		 * Retorna la bomba csi hay colision en la posicion
		 * @param x posicion x
		 * @param i posicion y
		 * @return la bomba si hay colision, sino nulo
		 */
		public Bombas hayColisionBomba(int x,int i)
		
		{
			if(getBombaActual().getPosicionX()==x && getBombaActual().getPosicionY()==i)
			  return miBomberman.getMisBombas();
		  else return null;
		}
	/**public Lugar lugarDisponible2(int x, int y) {
			
			
			Lugar l=null;
			
			Lugar l2=null;
			Lugar l3=null;
			Lugar l4=null;
			Lugar l5=null;
			try{
			if (noHayPowerUp(x+1,y)&&(noHayParedIndestructible(x+1,y))&&noHayParedDestructible(x+1,y)&&noHayEnemigos(x+1,y))
				l2=new Lugar(x+1,y,1);
		  
				if(noHayPowerUp(x-1,y)&&(noHayParedIndestructible(x-1,y))&&noHayParedDestructible(x-1,y)&&noHayEnemigos(x-1,y))
					l3=new Lugar(x-1,y,1);
			
				if(noHayPowerUp(x,y+1)&&(noHayParedIndestructible(x,y+1))&&noHayParedDestructible(x,y+1)&&noHayEnemigos(x,y+1))
					l4=new Lugar(x,y+1,1);
				if(noHayPowerUp(x,y-1)&&(noHayParedIndestructible(x,y-1))&&noHayParedDestructible(x,y-1)&&noHayEnemigos(x,y-1))
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
*/
		/**
		 * Retorna el lugar disponible en caso que exista
		 * @param x posicion x
		 * @param y posicion y
		 * @return lugar si existe disponible, nulo caso contrario
		 */
		public Lugar lugarDisponible3(int x, int y) {
			Lugar l=null;
			
			Lugar l2=null;
			Lugar l3=null;
			Lugar l4=null;
			Lugar l5=null;
			try{
			if  (noHayPowerUp(x+1,y)&&(noHayParedIndestructible(x+1,y))&&(x+1<24)&&noHayEnemigos(x+1,y))
			
				l2=new Lugar(x+1,y,1);
		  
				if(noHayPowerUp(x-1,y)&&(noHayParedIndestructible(x-1,y))&&x-1>0&&noHayEnemigos(x-1,y))
					l3=new Lugar(x-1,y,1);
			
				if(noHayPowerUp(x,y+1)&&(noHayParedIndestructible(x,y+1))&&noHayEnemigos(x,y+1))
					l4=new Lugar(x,y+1,1);
				if(noHayPowerUp(x,y-1)&&(noHayParedIndestructible(x,y-1))&&noHayEnemigos(x,y-1))
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
		 * Busca el item
		 * @param l2 item
		 * @return retorna el item o nulo si no lo encontro
		 */
		public Item buscarItem(Item l2) {
			Item L=null;
		
			for(Item i:misItems)
			{
				if(i.getPosicionX()==l2.getPosicionX() && i.getPosicionY()==l2.getPosicionY())
					{ 
					L= i;
					}
			}
			return L;
		}
		/**
		 * Busca el item
		 * @param l2 item
		 * @return retorna el item o nulo si no lo encontro
		 */
		public Item buscarItem2(Item l2) {
			Item L=null;
		
			for(Item i:misItems2)
			{
				if(i.getPosicionX()==l2.getPosicionX() && i.getPosicionY()==l2.getPosicionY())
					{ 
					L= i;
					}
			}
			return L;
		}
		
		/**
		 * Determina si el Bomberman esta en modo Masacrality o no
		 * @return false si no está activo el modo Masacrality, true en caso contrario
		 */

		public boolean activoMasacrality() {
			return activo;
		}
		/**
		 * Testea si esta activo 
		 * @return activo
		 */
		public boolean isActivo() {
			return activo;
		}
		/**
		 * Setea el booleano activo
		 * @param activo
		 */

		public void setActivo(boolean activo) {
			this.activo = activo;
		}

		/**
		 * Cambia el estado del booleano a true determinando que el Bomberman esta en modo Masacrality
		 */
		private void cambiarAModoMasacrality(){
			activo=true;
		}

		/**
		 * Cambia el estado del booleano a false determinando que el Bomberman no esta en modo Masacrality
		 */
		public void cambiarAModoNormal(){
			activo=false;
		}
		/**
		 * Metodo para ver si bomberman colision con Masacrality y debe cambiar su modo de juego
		 * @param b
		 */
		public void BombermanMasacrality(Bomberman b){
			int xB=b.getPosicionX();
			int yB=b.getPosicionY();
			int xP=14;
			int yP=10;
			if(xB==xP && yB==yP)
				cambiarAModoMasacrality();
		}
		/**
		 * Setea las paredes destructibles
		 */

		public void setearDestructibles() {
		juego.setearDestructibles();
			
		}
		
		/**       public Lugar LugarDisponible5(int x,int y)
       {
    		String mov=miBomberman.getS();
			Lugar l=null;
			
			Lugar l2=null;
			Lugar l3=null;
			Lugar l4=null;
			Lugar l5=null;
			try{
			if (noHayPowerUp(x+1,y)&&(noHayParedIndestructible(x+1,y))&&noHayParedDestructible(x+1,y)&&noHayEnemigos(x+1,y)&& mov=="Derecha")
				
				l2=new Lugar(x+1,y,1);
		       
				if(noHayPowerUp(x-1,y)&&(noHayParedIndestructible(x-1,y))&&noHayParedDestructible(x-1,y)&&noHayEnemigos(x-1,y)&& mov=="Izquierda")
					l3=new Lugar(x-1,y,1);
			
				if(noHayPowerUp(x,y+1)&&(noHayParedIndestructible(x,y+1))&&noHayParedDestructible(x,y+1)&&noHayEnemigos(x,y+1)&& mov=="Arriba")
					l4=new Lugar(x,y+1,1);
				if(noHayPowerUp(x,y-1)&&(noHayParedIndestructible(x,y-1))&&noHayParedDestructible(x,y-1)&&noHayEnemigos(x,y-1)&& mov=="Abajo")
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
		
       }*/
		/**
		public Item lugarDisponible4(int x,int y)
		{
			Bomberman b=miBomberman;
			int x1=b.getPosicionX();
			int y2=b.getPosicionY();
			Powerup colision=null;
		   Pared ind=null;
			
			if((x1==x+1)||(x1==x-1)||(y==y2+1)||(y==y2-1))
				return b;
		     ind=hayColisionPared(x+1,y);
     	     if(ind!=null)
     	    	    return ind;
     	    ind=hayColisionPared(x+1,y);
     	      if(ind!=null) 
     	    	  return ind;
     	      
     	     ind=hayColisionPared(x+1,y);
     	      if(ind!=null) 
     	    	  return ind;
     	     ind=hayColisionPared(x+1,y);
     	      if(ind!=null) 
     	    	  return ind;
     	      
               colision=hayColisionPowerUp(x+1,y);
            	     if(colision!=null)
            	    	    return colision;
            	     colision=hayColisionPowerUp(x-1,y);
            	      if(colision!=null) 
            	    	  return colision;
            	      
            	      colision=hayColisionPowerUp(x,y+1);
            	      if(colision!=null) 
            	    	  return colision;
            	      colision=hayColisionPowerUp(x,y-1);
            	      if(colision!=null) 
            	    	  return colision;
            	      
            	      
            	      
            return null;	    
              
                   
              }		
		*/
		
		/**
		 * Determina si el Bomberman esta en modo Masacrality o no
		 * @return false si no está activo el modo Masacrality, true en caso contrario
		 */

		//public boolean activoMasacrality() {
			//return activo;
		//}
		/**
		 * Cambia el estado del booleano a true determinando que el Bomberman esta en modo Masacrality
		 */
		//private void cambiarAModoMasacrality(){
			//activo=true;
		//}
		//public void cambiarAModoNormal(){
			//activo=false;
		//}
		/**public void BombermanMasacrality(Bomberman b){
			int xB=b.getPosicionX();
			int yB=b.getPosicionY();
			int xP=14;
			int yP=10;
			if(xB==xP && yB==yP)
				cambiarAModoMasacrality();
		}
		*/
	

}