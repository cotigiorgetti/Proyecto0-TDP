package Logica;

import Enemigo.Enemigos;
import Grafica.Juego;
import Lugar.Lugar;

public class HiloEnemigoS extends HiloEnemigo {
	private Enemigos e;
	//private Juego j;
	@SuppressWarnings("unused")
	private volatile boolean mDetener = false;
	public HiloEnemigoS(Enemigos e,Nivel n,Juego j) {
		super(e,n,j);
		this.e=e;
		// TODO Auto-generated constructor stub
	}
	/**public void run(Juego juego) {
		j=juego;
//	for(int i=0;i<=100;i++)
//	while(!mDetener)	
	//	while(L!=null)
		{
			
			try {
				
			  // System.out.println("Pre While");
		//   while(!mDetener)	
				{
			//	   System.out.println("While");
				//	Lugar l2=new Lugar(e.getPosicionX(),e.getPosicionY(),1);
				 //  L= e.mover();
				// e.setPosicionX(l2.getPosicionX());
				//  e.setPosicionY(l2.getPosicionY());
				  j.setearEnemigo3(e);//,l2);
				//  Thread.sleep(0);
			   }
				
			} catch (Exception e) { }
		}
	}
	
*/
}
