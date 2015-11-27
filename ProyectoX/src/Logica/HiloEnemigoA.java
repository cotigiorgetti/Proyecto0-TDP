package Logica;

import Enemigo.Enemigos;
import Grafica.Juego;
import Lugar.Lugar;

public class HiloEnemigoA extends HiloEnemigo {
	private Enemigos e;
	private Juego j;
	
	public HiloEnemigoA(Enemigos e,Nivel n,Juego j) {
		super(e,n,j);
		this.e=e;
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private volatile boolean mDetener = false;
	/**public void run(Juego juego) {
		j=juego;
//	for(int i=0;i<=100;i++)
//	while(!mDetener)	
	///while(L!=null)
		{
			
			try {
				
			  // System.out.println("Pre While");
		//   while(!mDetener)	
				{
			//	   System.out.println("While");
					Lugar l2=new Lugar(e.getPosicionX(),e.getPosicionY(),1);
					
				 //    L= e.mover();
				   //  e.setPosicionX(L.getPosicionX());
				  // e.setPosicionY(L.getPosicionY());
				//	System.out.println(j.getName());
				//	System.out.println("antes setear enemigo");
					
				   j.setearEnemigo(e,l2);//,l2);
			//	 System.out.println("pase setear enemigo");
				   Thread.sleep(0);
			   }
				
			} catch (Exception e) { }
		}}
	public void run()
	{   try {
	//	System.out.println(j.getName());
	//	  j.setearEnemigo3(this.getE());//,l2);
		
			Thread.sleep(1000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	*/
}
