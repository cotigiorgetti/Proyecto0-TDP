package Logica;
/**
 * @author Giorgetti,Constanza;Heinrich,Maria Eugenia
 * Clase Thread para el modoDios del bomberman cuando obtiene el Masacrality
 */
public class MasacralityThread extends Thread {
	
	private Bomberman bomberman;
	private int i;
	public MasacralityThread(Bomberman b) {
		this.bomberman = b;
	    i=0;
	}

	public void run() {
		while(i<=5)	
		{	bomberman.setModoDios(true);
			bomberman.atravesarPared=1;
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.bomberman.setModoDios(false);
			bomberman.atravesarPared=0;
		i++;
		}
	}
}
