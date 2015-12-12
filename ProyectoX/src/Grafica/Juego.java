package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enemigo.Enemigos;
import Logica.*;
import Lugar.*;
import PowerUps.Bombality;
import PowerUps.Fatality;
import PowerUps.Masacrality;
import PowerUps.Powerup;
import PowerUps.Speedup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.border.BevelBorder;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Juego extends JFrame  {

private JPanel contentPane;
private    ImageIcon i=new ImageIcon(Juego.class.getResource("/Imagenes/piso.png"));
private  ImageIcon i2=new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png"));
private  ImageIcon k=new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png"));

	private JuegoLogica j;
	private Nivel n;
	JLabel lblPuntaje,lblVidas,lblBombas,lblContador,lblAlcance;
	Contador cont;
	static Juego frame ;
	Esperador esp;
	Esperador2 esp2;
	Esperador3 esp3;
	int cont3=0;
	private Icon icono=null;
	GridBagLayout gbl_panel = new GridBagLayout();
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	ArrayList<ArrayList<JLabel>> misLabels = new ArrayList<ArrayList<JLabel>>();
	Panel panel = new Panel();
	private JLabel lblVelocidad;
	private Lugar l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new Juego();
					frame.setVisible(true);
					frame.setResizable(false);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Juego() {
		
		 
		
		addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
				try{
				
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_S)
				{
					armarTablero();			
					
				}
				if(s==KeyEvent.VK_DOWN)
				{// System.out.println(n.activoMasacrality());
					if(j.getNivel().obtenerBomberman().getAtravesarPared()==0)//(!n.activoMasacrality())
						moverAbajo();
				else moverAbajo2();
				  
				}
				if(s==KeyEvent.VK_LEFT)
				{// System.out.println(n.activoMasacrality());
					if(j.getNivel().obtenerBomberman().getAtravesarPared()==0)//(!n.activoMasacrality())
						moverIzq();
				else moverIzq2();
					
				}
				if(s==KeyEvent.VK_UP){
				//	System.out.println(n.activoMasacrality());
					if(j.getNivel().obtenerBomberman().getAtravesarPared()==0)//(!n.activoMasacrality())
					 moverArriba();
					else moverArriba2();
				}
				if(s==KeyEvent.VK_RIGHT){
					//System.out.println(n.activoMasacrality());
					if(j.getNivel().obtenerBomberman().getAtravesarPared()==0)//(!n.activoMasacrality())
						moverDerecha();
					else moverDerecha2();	
				}
				if(s==KeyEvent.VK_B)
				{	Bomberman bom=j.getNivel().getHb().getB();
					esp=new Esperador(0.5f,frame);
					int  x=bom.getPosicionX();
				 
					int  y=bom.getPosicionY();
				  
				if(bom.cantBombas()>=1)	
				 
					{ 
				  
						Lugar l=n.lugarDisponible(x,y); 
				  
						if (l!=null)
						{
					 
							Bombas b=j.getNivel().colocarBombas(l);
					        j.getNivel().setBombaActual(b);
					  
							x=l.getPosicionX();
							
							y=l.getPosicionY();
						{
					 
					  misLabels.get(x).get(y).setIcon(b.getColeccionI()[0]);
				
						}
						
					   
					lblBombas.setText("Bombas ="+j.getNivel().getHb().getB().cantBombas());
					
					b.explotar(l);
					
					
					
				  }
				  
					}
				
				}
				}catch(Exception e2){}
				setearLabels2();

			}


			@Override
			public void keyReleased(KeyEvent e) {
			
				try{
					Bomberman bom=j.getNivel().getHb().getB();
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B)
				{ 
					esp=new Esperador(0.5f,frame);
					esp2=new Esperador2(0.5f,frame);
					Bombas b=bom.getMisBombas();
					if(bom.cantBombas()>0)	
					{
				 esp2.start();
					}
					 else 
						 if (bom.cantBombas()==0)
						 {	
						 JOptionPane.showMessageDialog(null,"No Puede Colocar Más Bombas!!!!!!");
						 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(i);
						 j.getNivel().setBombaActual(new Bombas(1,23));
						 }
				
					}
				
			}catch(Exception e3){}
				//setearLabels2();

			}
			
			
			
			@Override
			public void keyTyped(KeyEvent e) {
			try{
				Bomberman bom=j.getNivel().getHb().getB();
				esp=new Esperador(0.5f,frame);
				 esp.start();
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B){
					
				Bombas b=bom.getMisBombas();
				@SuppressWarnings("unused")
				Lugar l=new Lugar(b.getPosicionX(),b.getPosicionY(),1);
				if(bom.cantBombas()>0)	{
			   misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(b.getColeccionI()[0]);
					
				
				esp.start();
				
				}
				
				}
			}catch(Exception e4){}
			setearLabels2();

			}
		});
		
	   Tablero();
		
		pintarTableroInicial();
				
		
		
	
		
		
		
	
	}

	//Metodos privados
	
	//Tablero
	protected void Tablero()
	{
		j=new JuegoLogica(this);
		n=j.getNivel();
		 j.getNivel().crearNivel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 lblPuntaje = new JLabel("Puntaje=");
			lblPuntaje.setForeground(Color.WHITE);
			lblPuntaje.setBounds(204, 11, 102, 14);
			contentPane.add(lblPuntaje);
			
			lblVidas = new JLabel("Vidas=");
			lblVidas.setForeground(Color.WHITE);
			lblVidas.setBounds(430, 11, 127, 14);
			contentPane.add(lblVidas);
			
			lblBombas = new JLabel("Bombas=");
			lblBombas.setForeground(Color.WHITE);
			lblBombas.setBounds(895, 11, 102, 14);
			contentPane.add(lblBombas);
		
		
		panel.setBackground(new Color(0, 128, 0));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 32, 1028, 440);
		new GridBagConstraints();
		contentPane.add(panel);
		
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE, };
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblVelocidad = new JLabel("Velocidad=");
		lblVelocidad.setForeground(Color.WHITE);
		lblVelocidad.setBounds(719, 11, 116, 14);
		contentPane.add(lblVelocidad);
		

		lblContador = new JLabel("Contador=");
		lblContador.setForeground(Color.WHITE);
		lblContador.setBounds(10, 11, 194, 14);
		contentPane.add(lblContador);
		
		lblAlcance = new JLabel("Alcance=");
		lblAlcance.setForeground(Color.WHITE);
		lblAlcance.setBounds(563, 11, 127, 14);
		contentPane.add(lblAlcance);
		
	}
	/**
	 * Arma el tablero
	 */
	protected void armarTablero()
	{Bomberman bom=j.getNivel().getHb().getB();
	/**if(j!=null)
	  {for(HiloEnemigo e:j.getNivel().obtenerEnemigos())
	  {
          j.getNivel().RemoverEnemigo(e.getE());	
		//  j.getNivel().CrearEnemigos();
	  }
		//j.getNivel().CrearEnemigos();
	  }*/
		  j=new JuegoLogica(this);
		  n=j.getNivel();
		  
		  j.getNivel().crearNivel();
		  j.getNivel().CrearEnemigos();
		  
		
	
		
		if(cont!=null)
		 {   cont.interrupt();
		 }
		cont=new Contador(this);
		esp=new Esperador(0.5f,this);
		esp2=new Esperador2(0.5f,this);
		esp3=new Esperador3(0.5f,this);
		pintarTablero();
			lblBombas.setText("Bombas ="+bom.cantBombas());
			lblVidas.setText("Vidas ="+bom.getCantVidas());
			lblPuntaje.setText("Puntaje = "+bom.getPuntaje());
			lblVelocidad.setText("Velocidad="+bom.getVelocidad());
			lblAlcance.setText("Alcance="+bom.getMisBombas().getAlcance());
			cont.start();
			
		
		    misLabels.get(1).get(1).setIcon(bom.getI());
		 
		    for(int i=0;i<j.getNivel().obtenerEnemigos().size();i++)
			   {
				   j.getNivel().obtenerEnemigos().get(i).start();
				  
			   }
		
	
		
	}
	protected void pintarTableroInicial()
	{
		for(int K=0;K<=24;K++)
		{	misLabels.add(K,new ArrayList<JLabel>());
			for(int j=0;j<=12;j++)
			{	JLabel l= new JLabel();
			l.setBackground(new Color(0, 128, 0));
			l.setIcon(i);
				misLabels.get(K).add(j,l);						
				gbc_lblNewLabel.gridx = K;
				gbc_lblNewLabel.gridy = j;
				panel.add(l, gbc_lblNewLabel);
				
			}
			
		}
		pintarTablero();
	}
	protected void pintarTablero()
	{
		for(int K=0;K<=24;K++)
		{	
			for(int j=0;j<=12;j++)
			{	JLabel l= misLabels.get(K).get(j);
			l.setBackground(new Color(0, 128, 0));
			l.setIcon(i);
							
			}
			
			
		}
		
		for(int k=0;k<24;k++){
			for(int j=0;j<12;j++){
		
	
			misLabels.get(k).get(j).setIcon(null);
			misLabels.get(k).get(j).setIcon(i2);
			repaint();
		  j+=2;
		}
			k+=2;
		}
		
		for(int j=0;j<=12;j++)
		{	misLabels.get(0).get(j).setIcon(null);
		
			misLabels.get(0).get(j).setIcon(i2);
			
		     repaint();	
		
		
	}
	
		for(int k=0;k<=24;k++)
		{	misLabels.get(k).get(0).setIcon(null);
			misLabels.get(k).get(0).setIcon(i2);
			repaint();	
		
		
	}
		for(int j=0;j<=12;j++)
		{	misLabels.get(24).get(j).setIcon(null);
			misLabels.get(24).get(j).setIcon(i2);
			repaint();	
		
		
		}
		for(int k=0;k<=24;k++)
		{	misLabels.get(k).get(12).setIcon(null);
			misLabels.get(k).get(12).setIcon(i2);
			repaint();	
		
		
	      }
		agregarDestruibles();
	}
	protected void mostrarTablero(String s)
	{
		
	 lblContador.setText("Contador = "+ s);
	
	}
	
	//MOVIMIENTOS 
	//Movimientos Bomberman con Masacrality
	/**
	 * Movimiento hacia abajo en modoDios
	 */
private void moverAbajo2() {
		
		setearLabels2();
		Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		
		
		
		int x=b.getPosicionX();
		  int y=b.getPosicionY();
		  int extra=0;
		  if((y<=10 && y>=1)&&(x<=23 && x>=1))
				{
			  	
				
				Powerup colision=(n.hayColisionPowerUp(x,y+1));
			    Enemigos colision2=n.hayColisionEnemigo(x,y);
			    Pared colision3=n.hayColisionPared2(x,y+1);
			   Bombas colision4=n.hayColisionBomba(x,y+1);	 
				 
			   if(colision!=null )
						{	
						n.colisionarBombermaPowerUp(colision);
						n.obtenerPowerUps().remove(colision);
						
						}	
				else if(colision2!=null)
				{extra=-1;
				//	n.colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{extra=-1;
				
			
			}
				else if(colision4!=null)
				{
					extra=-1;
					
				}
			if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				
			   b.setI(b.getColeccionI()[3]);
				
				
			    y=y+1+extra;
				{generarMovimientoBomberman2(x,y,icono);
				//setearDestructibles();
				}
				}
		      else{      b.setI(b.getColeccionI()[4]);
		      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
		      n.getHb().destruir();
		      setearLabels2();
		      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
		  	
		      armarTablero();	
		      }
			setearLabels2();

				}	
		 
	}
/**
 * Genera el movimiento del Bomberman con el Masacrality 
 * @param x posicion x
 * @param y posicion y
 * @param icono2
 */
	private void generarMovimientoBomberman2(int x, int y, Icon icono2) {
		Lugar l2=new Lugar(x,y,1);
	//	if(icono!=null)
	//	{
	//		setearLabel(l,icono);
	//	}
		
//		l=l2;
		
		System.out.println(n.noHayParedDestructible(x, y));;
		if(n.noHayParedDestructible(x, y)==false) {
			
			icono=misLabels.get(x).get(y).getIcon();
		}
		
		n.moverBomberman(l2);
		
	//	setearEnemigo4(n.obtenerBomberman(),l);
		setearLabels(x,y);
	//	setearDestructibles();
		
	}
		
	


	public void setearDestructibles() {
		for(Pared i:n.obtenerDestructibles())
		   {
			misLabels.get(i.getPosicionX()).get(i.getPosicionY()).setIcon(i.getI());
		   }
		
	}
/**
 * Movimiento hacia la izquierda en modoDios
 */
	private void moverIzq2() {
		{  setearLabels2();Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		
		List<HiloEnemigo>enemigos=n.obtenerEnemigos();
		List<Pared>indestructibles=n.obtenerIndestructibles();
		List<Pared>destructibles=n.obtenerDestructibles();
		
			int x=b.getPosicionX();
		  int y=b.getPosicionY();
		int extra=0;
		  if((y<=11 && y>=0)&&(x<=23 && x>1))
				{
			     
				Powerup colision=(n.hayColisionPowerUp(x-1,y));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared2(x-1,y);
				  Bombas colision4=n.hayColisionBomba(x-1,y);	 
				  if(colision!=null )
					{
					n.colisionarBombermaPowerUp(colision);
					n.obtenerPowerUps().remove(colision);
					
					}	
				else	if(colision2!=null)
					{extra=1;
				//	n.colisionarBombermaEnemigo(colision2);
					}
				else if(colision3!=null)
				    {
					extra=1;
				    }
				else if(colision4!=null)
				{
					extra=1;
				}
				if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[1]);
				
			
				x=x-1+extra;
				{generarMovimientoBomberman2(x,y,icono);
			//	setearDestructibles();
				}
				
				}
				 
				else{     b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      j.getNivel().getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				}
				
		}	
		
	}
	/**
	 * Movimiento hacia arriba en modoDios
	 */
	private void moverArriba2() 
	{setearLabels2();
	Nivel n=j.getNivel();
	Bomberman b=n.getHb().getB();
	List<HiloEnemigo>enemigos=n.obtenerEnemigos();
	List<Pared>indestructibles=n.obtenerIndestructibles();
	List<Pared>destructibles=n.obtenerDestructibles();
		 int x=b.getPosicionX();
		  int y=b.getPosicionY();
		 int extra=0;
		  if((y<=11 && y>1)&&(x<=23 && x>=1))
				{								
				Powerup colision=(n.hayColisionPowerUp(x,y-1));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared2(x,y-1);
				  Bombas colision4=n.hayColisionBomba(x,y-1);	 
					 
					
				  if(colision!=null)
					{
					n.colisionarBombermaPowerUp(colision);
					n.obtenerPowerUps().remove(colision);
					}	
				else if(colision2!=null)
				{   extra=1;
				//	n.colisionarBombermaEnemigo(colision2);
				}
				else if(colision3!=null)
				{ 
					extra=1;
				}
				else if(colision4!=null)
				{
					extra=1;
				}
				if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[2]);
				
				y=y-1+extra;
				{generarMovimientoBomberman2(x,y,icono);
				//setearDestructibles();
				}
				}
				  else{     b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      n.getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
		 
	}
	/**
	 * Movimiento hacia la derecha en modoDios
	 */
	private void moverDerecha2() {
		{setearLabels2();
		Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		List<HiloEnemigo>enemigos=n.obtenerEnemigos();
		List<Pared>indestructibles=n.obtenerIndestructibles();
		List<Pared>destructibles=n.obtenerDestructibles();
			int x=b.getPosicionX();
		  int y=b.getPosicionY();
		 int extra=0;
		  if((y<=11 && y>=0)&&(x<=22 && x>=1))
				{Powerup colision=(n.hayColisionPowerUp(x+1,y));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared2(x+1,y);
				  Bombas colision4=n.hayColisionBomba(x+1,y);	 
					 
				  if(colision!=null)
				{
				n.colisionarBombermaPowerUp(colision);
				n.obtenerPowerUps().remove(colision);
				}
				else if(colision2!=null)
				{  extra=-1;
				//	n.colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{
					 extra=-1;
				}
				else if(colision4!=null)
				   {
					extra=-1;
				   }
				 if(b.getCantVidas()>=1 )	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[0]);
				
						
				 x=x+1+extra;
				{generarMovimientoBomberman2(x,y,icono);
			//	setearDestructibles();
				}
				}
				else {b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      n.getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
				
										
				}
				
		 
		
	}
	//Movimientos Bomberman normal
	/**
	 * Movimiento hacia abajo en modo normal
	 */
private void moverAbajo() {
		
		setearLabels2();
		Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		
		
		
		int x=b.getPosicionX();
		  int y=b.getPosicionY();
		  int extra=0;
		  if((y<=10 && y>=1)&&(x<=23 && x>=1))
				{
			  	
				
				Powerup colision=(n.hayColisionPowerUp(x,y+1));
			    Enemigos colision2=n.hayColisionEnemigo(x,y);
			   Pared colision3=n.hayColisionPared(x,y+1);
			   Bombas colision4=n.hayColisionBomba(x,y+1);	 
				 
			   if(colision!=null )
						{	
						n.colisionarBombermaPowerUp(colision);
						n.obtenerPowerUps().remove(colision);
						n.getMisItems().remove(colision);
						n.getMisItems2().remove(colision);
						}	
				else if(colision2!=null)
				{extra=-1;
					n.colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{extra=-1;
				
			
			}
				else if(colision4!=null)
				{
					extra=-1;
					
				}
			if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				
			   b.setI(b.getColeccionI()[3]);
				
				
			    y=y+1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
		      else{      b.setI(b.getColeccionI()[4]);
		      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
		      n.getHb().destruir();
		      setearLabels2();
		      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
		  	
		      armarTablero();	
		      }
			setearLabels2();

				}	
		 
	}
/**
 * Movimiento hacia la izquierda en modo normal
 */
	private void moverIzq() {
		{  setearLabels2();Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		
		List<HiloEnemigo>enemigos=n.obtenerEnemigos();
		List<Pared>indestructibles=n.obtenerIndestructibles();
		List<Pared>destructibles=n.obtenerDestructibles();
		
			int x=b.getPosicionX();
		  int y=b.getPosicionY();
		int extra=0;
		  if((y<=11 && y>=0)&&(x<=23 && x>1))
				{
			     
				Powerup colision=(n.hayColisionPowerUp(x-1,y));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared(x-1,y);
				  Bombas colision4=n.hayColisionBomba(x-1,y);	 
				  if(colision!=null )
					{
					n.colisionarBombermaPowerUp(colision);
					n.obtenerPowerUps().remove(colision);
					n.getMisItems().remove(colision);
					n.getMisItems2().remove(colision);
					}	
				else	if(colision2!=null)
					{extra=1;
					n.colisionarBombermaEnemigo(colision2);
					}
				else if(colision3!=null)
				    {
					extra=1;
				    }
				else if(colision4!=null)
				{
					extra=1;
				}
				if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[1]);
				
			
				x=x-1+extra;
				{generarMovimientoBomberman(x,y);}
				
				}
				 
				else{     b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      j.getNivel().getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				}
				
		}	
		
	}
	/**
	 * Movimiento hacia arriba en modo normal
	 */
	private void moverArriba() 
	{setearLabels2();
	Nivel n=j.getNivel();
	Bomberman b=n.getHb().getB();
	List<HiloEnemigo>enemigos=n.obtenerEnemigos();
	List<Pared>indestructibles=n.obtenerIndestructibles();
	List<Pared>destructibles=n.obtenerDestructibles();
		 int x=b.getPosicionX();
		  int y=b.getPosicionY();
		 int extra=0;
		  if((y<=11 && y>1)&&(x<=23 && x>=1))
				{								
				Powerup colision=(n.hayColisionPowerUp(x,y-1));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared(x,y-1);
				  Bombas colision4=n.hayColisionBomba(x,y-1);	 
					 
					
				  if(colision!=null)
					{
					n.colisionarBombermaPowerUp(colision);
					n.obtenerPowerUps().remove(colision);
					n.getMisItems().remove(colision);
					n.getMisItems2().remove(colision);
					}	
				else if(colision2!=null)
				{   extra=1;
					n.colisionarBombermaEnemigo(colision2);
				}
				else if(colision3!=null)
				{ 
					extra=1;
				}
				else if(colision4!=null)
				{
					extra=1;
				}
				if(b.getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[2]);
				
				y=y-1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
				  else{     b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      n.getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
		 
	}
	/**
	 * Movimiento hacia la derecha en modo normal
	 */
	private void moverDerecha() {
		{setearLabels2();
		Nivel n=j.getNivel();
		Bomberman b=n.getHb().getB();
		List<HiloEnemigo>enemigos=n.obtenerEnemigos();
		List<Pared>indestructibles=n.obtenerIndestructibles();
		List<Pared>destructibles=n.obtenerDestructibles();
			int x=b.getPosicionX();
		  int y=b.getPosicionY();
		 int extra=0;
		  if((y<=11 && y>=0)&&(x<=22 && x>=1))
				{Powerup colision=(n.hayColisionPowerUp(x+1,y));
				  Enemigos colision2=n.hayColisionEnemigo(x,y);
				  Pared colision3=n.hayColisionPared(x+1,y);
				  Bombas colision4=n.hayColisionBomba(x+1,y);	 
					 
				  if(colision!=null)
				{
				n.colisionarBombermaPowerUp(colision);
				n.obtenerPowerUps().remove(colision);
				n.getMisItems().remove(colision);
				n.getMisItems2().remove(colision);
				}
				else if(colision2!=null)
				{  extra=-1;
					n.colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{
					 extra=-1;
				}
				else if(colision4!=null)
				   {
					extra=-1;
				   }
				 if(b.getCantVidas()>=1 )	
				{
				misLabels.get(x).get(y).setIcon(i);
				b.setI(b.getColeccionI()[0]);
				
						
				 x=x+1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
				else {b.setI(b.getColeccionI()[4]);
			      misLabels.get(x).get(y).setIcon(b.getColeccionI()[4]);
			      n.getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
				
										
				}
				
		 
		
	}
	
	//Colisiones
	
	
/**
 * Metodo afectar para cuando Bomberman coloca la bomba y esta explota
 */
	private void Afectar()
	{
		try{
			esp.run();
				}catch(IllegalThreadStateException e){}
				try{
					Bomberman b=n.getHb().getB();
					List<Powerup>powers=n.obtenerPowerUps();
					List<HiloEnemigo>enemigos=n.obtenerEnemigos();
					List<Pared>indestructibles=n.obtenerIndestructibles();
					List<Pared>destructibles=n.obtenerDestructibles();
			int alcance=b.getAlcance();
			Lugar l=new Lugar(n.getBombaActual().getPosicionX(),j.getNivel().getBombaActual().getPosicionY(),1);
			Lugar p=n.hayParedAlrededor(l,destructibles);
			Lugar p2=n.hayParedAlrededor(l,indestructibles);
			Enemigos e=n.noHayEnemigo(l);
			Powerup pw=n.hayColisionPowerUp(p.getPosicionX(),p.getPosicionY());
			
			
		/**	if(n.hayBomberman(l))
				  {
					n.colisionarBombermaBomba(b, b.getMisBombas());
					
					 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(b.getI());
					
				
				  }*/
			verAlcanceBomberman();
				 if(p!=null )
				     {p.destruirPared(n.getBombaActual());
				     p.serDestruido(n.getHb().getB());
				   if(p.getTransitable()==0 )
					    {
						 {n.RemoverDestructibles(p);
						  p.setTransitable(1);
						  
						 if(pw!=null)
							 {
							 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(pw.getI());
								
							 }
						 else {
							 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(p.getColeccionI()[0]);
						 }
						 } 
						 }
				   else if(p.getTransitable()==1)
				   { misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(p.getColeccionI()[0]);
				   if(p!=null)
				   	 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(pw.getI());
				   }
				    verConAlcancePW(destructibles);
					if(destructibles.isEmpty())
					    {
						if(cont3<=cont.getCont())
					    {JOptionPane.showMessageDialog(null,"Ganaste!,Excelente Puntuación ,Vuelve a jugar!!!");
					    }
						else JOptionPane.showMessageDialog(null,"Juega otra vez para obtener una mejor puntuación");
						armarTablero();
					    }
				     }
				 if(e!=null )
				 {
					 n.colisionarEnemigoBomba(e,n.getBombaActual());
					 n.RemoverEnemigo(e);
					
					// n.colisionarBombermaEnemigo(e);
					 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(p.getColeccionI()[0]);
					 // esp.start();
					// misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(e.getI());
					
					// e.serDestruido(b);
				     
				 }		 
				 verAlcanceEnemigo(enemigos);
				
		verAlcancePared(indestructibles);
			}
				
				catch(Exception e){}
				setearLabels2();
	}
	
	
	private void verAlcancePared(List<Pared> list) {
	
		int x1;
		int y1;
		Bomberman b=n.getHb().getB();
		int x=n.getBombaActual().getPosicionX();//b.getMisBombas().getPosicionX();
		int y=n.getBombaActual().getPosicionY();//b.getMisBombas().getPosicionY();

		for(Pared p2:list)
		{x1=p2.getPosicionX();
		y1=p2.getPosicionY();
		int alcance=b.getAlcance();
		for(int k=0;k<=alcance;k++)
		{
		if((x+k==x1 && y==y1)|| (x-k==x1 && y==y1) || (x==x1 && y+k==y1) || (x==x1 && y-k==y1))
		{
			misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(i2);
			p2.destruirPared(n.getBombaActual());
			
		     p2.serDestruido(b);
		     if(p2.getTransitable()==0)
			    {
				 {
					 n.RemoverDestructibles(p2);
					 n.getMisItems().remove(p2);
					 n.getMisItems2().remove(p2);
					 
					 
				 }
		}
	//	else misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(i);
		     
		}	
		
		}
		
		}
		setearLabels2();
	}

	private void verAlcanceBomberman() {
		int x1;
		int y1;
		Bomberman b=n.getHb().getB();
		int x=n.getBombaActual().getPosicionX();//b.getMisBombas().getPosicionX();
		int y=n.getBombaActual().getPosicionY();//b.getMisBombas().getPosicionY();

		int alcance=j.getNivel().getHb().getB().getAlcance();
		
		
		{x1=b.getPosicionX();
		y1=b.getPosicionY();
		for(int i=0;i<=alcance;i++)
		{
		if((x+i==x1 && y==y1)|| (x-i==x1 && y==y1) || (x==x1 && y+i==y1) || (x==x1 && y-i==y1))
		{
			j.getNivel().colisionarBombermaBomba(b, b.getMisBombas());
			
			break;
		}
	
		}
	
		setearLabels2();
		}
		
		
	}
/**
 * Alcance de la bomba con un enemigo
 * @param list enemigos
 */
	private void verAlcanceEnemigo(List<HiloEnemigo> list ){
		Enemigos e=null;
		int x1;
		int y1;
		Bomberman b=n.getHb().getB();
		
		int x=n.getBombaActual().getPosicionX();//b.getMisBombas().getPosicionX();
		int y=n.getBombaActual().getPosicionY();//b.getMisBombas().getPosicionY();
		int alcance=b.getAlcance();
		
		for(HiloEnemigo e2:list)
		{x1=e2.getE().getPosicionX();
		y1=e2.getE().getPosicionY();
		for(int k=0;k<=alcance;k++)
		{
		//if(n.getBombaActual().alcanzarEnemigo(e2.getE())==true)
		//	System.out.println("Posicion Bomba "+x+""+y);
		
	//		System.out.println("Posicion Enemigo"+x1+""+y1);
			if((x+k==x1 && y==y1)|| (x-k==x1 && y==y1) || (x==x1 && y+k==y1) || (x==x1 && y-k==y1))
		{ System.out.println("lo alcanzo");
		
		e2.getE().serDestruido(b);
		 n.colisionarEnemigoBomba(e2.getE(),n.getBombaActual());
		 n.RemoverEnemigo(e2.getE());
		
		// n.colisionarBombermaEnemigo(e);
		//	System.out.println("Estoy colisionando enemigo");
			 misLabels.get(e2.getE().getPosicionX()).get(e2.getE().getPosicionY()).setIcon(i);
			 // esp.start();
			 misLabels.get(e2.getE().getPosicionX()).get(e2.getE().getPosicionY()).setIcon(e2.getE().getI());
			
			// e2.getE().serDestruido(b);
			
		}
		}
		}
		 setearLabels2();
		
	}
	/**
	 * Alcance de la bomba con los powerup
	 * @param list paredes del juego donde se encuentran escondidos los powerup
	 */

	private void verConAlcancePW(List<Pared> list) {
		Pared p=null;
		int x1;
		int y1;
		Bomberman b=n.getHb().getB();
		int x=n.getBombaActual().getPosicionX();//b.getMisBombas().getPosicionX();
		int y=n.getBombaActual().getPosicionY();//b.getMisBombas().getPosicionY();

		for(Pared p2:list)
		{x1=p2.getPosicionX();
		y1=p2.getPosicionY();
	//	System.out.println(x1+" "+y1);
	//	System.out.println(x+" "+y);
		int alcance=b.getAlcance();
		for(int i=0;i<=alcance;i++)
		{
		if((x+i==x1 && y==y1)|| (x-i==x1 && y==y1) || (x==x1 && y+i==y1) || (x==x1 && y-i==y1))
		{
			p2.destruirPared(n.getBombaActual());
		
	     p2.serDestruido(b);
	     if(p2.getTransitable()==0)
		    {
			 {
				 n.RemoverDestructibles(p2);
				
				 
			 
			  p2.setTransitable(1);
			  Powerup pw=n.hayColisionPowerUp(p2.getPosicionX(),p2.getPosicionY());
			 if(pw!=null)
				 {
				 misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(pw.getI());
					
				 }
			 else {
				 misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(p2.getColeccionI()[0]);
				
		          }
			 }
		   }
	    
	     }
		}
		}
		 setearLabels2();
	}

	//Setear Labels
	/**
	 * Genera el movimiento del bomberman
	 * @param x posicion x
	 * @param y posicion y
	 */
	private void generarMovimientoBomberman(int x, int y)
	{
		Lugar l=new Lugar(x,y,1);
		n.moverBomberman(l);
		
		setearLabels(x,y);
		
	}
		private void setearLabels(int x,int y)
		{
			misLabels.get(x).get(y).setIcon(j.getNivel().getHb().getB().getI());
			setearLabels2();
					}
		private void setearLabels2()
		{
			lblBombas.setText("Bombas ="+j.getNivel().getHb().getB().cantBombas());
			lblVidas.setText("Vidas ="+j.getNivel().getHb().getB().getCantVidas());
			lblPuntaje.setText("Puntaje = "+j.getNivel().getHb().getB().getPuntaje());
			lblVelocidad.setText("Velocidad ="+j.getNivel().getHb().getB().getVelocidad());
			lblAlcance.setText("Alcance ="+j.getNivel().getHb().getB().getAlcance());
		}
//Setear Enemigo
		public void setearEnemigo(Enemigos h, Lugar l2) {
			Lugar l=n.lugarDisponible(h.getPosicionX(),h.getPosicionY());
				
			if(l!=null)
			{
				h.setPosicionX(l.getPosicionX());
				h.setPosicionY(l.getPosicionY());
					Icon i=misLabels.get(h.getPosicionX()).get(h.getPosicionY()).getIcon();
					Icon i2=misLabels.get(l.getPosicionX()).get(l.getPosicionY()).getIcon();
					  
					misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(i);
					misLabels.get(h.getPosicionX()).get(h.getPosicionY()).setIcon(i2);
					
					}
			
			this.repaint();
				
		}
		public void setearEnemigo2() {
			try{
			for(HiloEnemigo h:j.getNivel().obtenerEnemigos()){
					Icon i=h.getE().getI();
				   misLabels.get(h.getE().getPosicionX()).get(h.getE().getPosicionY()).setIcon(i);
					}
				}catch(NullPointerException e){}
				
		}


		
		
 //Esperadores
		public void despuesDeEsperar(){
			try{
			 Bombas b=j.getNivel().getHb().getB().getMisBombas();
			 b.setAlcance(j.getNivel().getHb().getB().getAlcance());
			 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(i);
			 }catch(Exception e){}
		}
	/**public void despuesDeEsperar2() {
			try{Bombas b=j.getNivel().getHb().getB().getMisBombas();
			  for(int l=0;l<=j.getNivel().obtenerBomberman().getAlcance();l++)
			  {	 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(b.getColeccionI()[1]);
			//  esp3.start();
			Afectar();
			 
			 if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()-1))
			 { misLabels.get(b.getPosicionX()).get(b.getPosicionY()-l).setIcon(b.getColeccionI()[3]);
			 Afectar();
		//	 esp3.start();
			 misLabels.get(b.getPosicionX()).get(b.getPosicionY()-l).setIcon(i);
			 }
			 //else misLabels.get(b.getPosicionX()).get(b.getPosicionY()-l).setIcon(i2);//);
			 if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()+l))
			 { misLabels.get(b.getPosicionX()).get(b.getPosicionY()+l).setIcon(b.getColeccionI()[3]);
			 Afectar();
			// esp3.start();
		//	 misLabels.get(b.getPosicionX()).get(b.getPosicionY()+l).setIcon(i);
			 }
			// else misLabels.get(b.getPosicionX()).get(b.getPosicionY()+l).setIcon(i2);//);
			if(n.noHayParedIndestructible(b.getPosicionX()-l, b.getPosicionY()))
			 { misLabels.get(b.getPosicionX()-l).get(b.getPosicionY()).setIcon(b.getColeccionI()[2]);
			 Afectar();
		//	 esp3.start();
		//	 misLabels.get(b.getPosicionX()-l).get(b.getPosicionY()).setIcon(i);
			 }
			// else misLabels.get(b.getPosicionX()-l).get(b.getPosicionY()).setIcon(i2);//);
			 if(n.noHayParedIndestructible(b.getPosicionX()+l, b.getPosicionY()))
			 { misLabels.get(b.getPosicionX()+l).get(b.getPosicionY()).setIcon(b.getColeccionI()[2]);
			 Afectar();
			// esp3.start();
			// misLabels.get(b.getPosicionX()+l).get(b.getPosicionY()).setIcon(i);
			 }
		//	 else misLabels.get(b.getPosicionX()+l).get(b.getPosicionY()).setIcon(i2);//);
			 
			// else misLabels.get(b.getPosicionX()+1).get(b.getPosicionY()).setIcon(i2);//);
			 
			  }
			
			 
			 //falta powerups
			 
		//	Afectar(); 
			 j.getNivel().setBombaActual(new Bombas(1,23));
			 for(int i=0;i<=j.getNivel().obtenerBomberman().getAlcance();i++)
				{
				Item it=n.buscarItem2(new Lugar(b.getPosicionX()+1,b.getPosicionY(),1));	
				Item it2=n.buscarItem2(new Lugar(b.getPosicionX()-1,b.getPosicionY(),1));	
				Item it3=n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()+1,1));	
				Item it4=n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()-1,1));	
				misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(it.getI());
				misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(it2.getI());
				misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(it3.getI());
				misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(it4.getI());
				}
			 
			
			 
		
				 //misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(i);
				 //if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()-1))
				 //misLabels.get(b.getPosicionX()).get(b.getPosicionY()-1).setIcon(i);
				 //if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()+1))
				 //misLabels.get(b.getPosicionX()).get(b.getPosicionY()+1).setIcon(i);
				 //if(n.noHayParedIndestructible(b.getPosicionX()-1, b.getPosicionY()))
				 //misLabels.get(b.getPosicionX()-1).get(b.getPosicionY()).setIcon(i);
				 //if(n.lugarDisponible(b.getPosicionX()+1, b.getPosicionY())!=null)
				 //misLabels.get(b.getPosicionX()+1).get(b.getPosicionY()).setIcon(i);
				
			
			}
			catch(IndexOutOfBoundsException e){}
			catch(NullPointerException e2){}
			catch(IllegalThreadStateException e3){}
		}*/
		
		/**
		 * Setea las imagenes de la explosion de la bomba y su consecuencia posterior
		 */
		public void despuesDeEsperar2() {
			
			try{Bombas b=n.getBombaActual();//j.getNivel().getHb().getB().getMisBombas();
			Afectar();
			misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
			 
			 for(int i=1; i<=b.getAlcance();i++){
			 if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()-i))
				
			misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego vertical.png")));
			 Afectar();
			 if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()+i))
				
				 misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego vertical.png")));
			 Afectar();
			 if(n.noHayParedIndestructible(b.getPosicionX()-i, b.getPosicionY()))
				
				 misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego horizontal.png")));
			 Afectar();
			 if(n.noHayParedIndestructible(b.getPosicionX()+i, b.getPosicionY()))
				
				 misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego horizontal.png")));
			 Afectar();
			 
			 	//medio
			 if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()) && (n.noHayPowerUp(b.getPosicionX(),b.getPosicionY())) && (n.noHayEnemigos(b.getPosicionX(),b.getPosicionY())))	 
				//	misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
					misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY(),1)).getI());
				
			
				
				//arriba
				if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()-i) && (n.noHayPowerUp(b.getPosicionX(),b.getPosicionY()-i)) && (n.noHayEnemigos(b.getPosicionX(),b.getPosicionY()-i)))	 
				//misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
					misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()-i,1)).getI());
				
					else{ if (!n.noHayPowerUp(b.getPosicionX(),b.getPosicionY()-i))
								devolverPWlugar(b.getPosicionX(),b.getPosicionY()-i);
						else if(!n.noHayEnemigos(b.getPosicionX(),b.getPosicionY()-i)){
						detenerHiloEnemigo(n.hayColisionEnemigo(b.getPosicionX(),b.getPosicionY()-i));
					//	misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
						misLabels.get(b.getPosicionX()).get(b.getPosicionY()-i).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()-i,1)).getI());
						
							
						}						
						}
						
				//abajo
				if(n.noHayParedIndestructible(b.getPosicionX(), b.getPosicionY()+i)&& (n.noHayPowerUp(b.getPosicionX(),b.getPosicionY()+i))&& (n.noHayEnemigos(b.getPosicionX(),b.getPosicionY()+i)))
				//	misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				//	misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY(),1)).getI());
					misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()+i,1)).getI());
				
					else{ if (!n.noHayPowerUp(b.getPosicionX(),b.getPosicionY()+i))
								devolverPWlugar(b.getPosicionX(),b.getPosicionY()+i);
						else if(!n.noHayEnemigos(b.getPosicionX(),b.getPosicionY()+i)){
							detenerHiloEnemigo(n.hayColisionEnemigo(b.getPosicionX(),b.getPosicionY()+i));
							
							//misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
							misLabels.get(b.getPosicionX()).get(b.getPosicionY()+i).setIcon(n.buscarItem2(new Lugar(b.getPosicionX(),b.getPosicionY()+i,1)).getI());
							
						}						
						}
				//izquierda
				if(n.noHayParedIndestructible(b.getPosicionX()-i, b.getPosicionY())&& (n.noHayPowerUp(b.getPosicionX()-i,b.getPosicionY()))&& (n.noHayEnemigos(b.getPosicionX()-i,b.getPosicionY())))
					//misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
					misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(n.buscarItem2(new Lugar(b.getPosicionX()-i,b.getPosicionY(),1)).getI());
				
					else{ if (!n.noHayPowerUp(b.getPosicionX()-i,b.getPosicionY()))
								devolverPWlugar(b.getPosicionX()-i,b.getPosicionY());
						else if(!n.noHayEnemigos(b.getPosicionX()-i,b.getPosicionY())){
								detenerHiloEnemigo(n.hayColisionEnemigo(b.getPosicionX()-i,b.getPosicionY()));
								//misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
								misLabels.get(b.getPosicionX()-i).get(b.getPosicionY()).setIcon(n.buscarItem2(new Lugar(b.getPosicionX()-i,b.getPosicionY(),1)).getI());
								
						}						
						}
				//derecha
				if(n.noHayParedIndestructible(b.getPosicionX()+i, b.getPosicionY())&& (n.noHayPowerUp(b.getPosicionX()+i,b.getPosicionY()))&& (n.noHayEnemigos(b.getPosicionX()+i,b.getPosicionY())))
				//	misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
					misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(n.buscarItem2(new Lugar(b.getPosicionX()+i,b.getPosicionY(),1)).getI());
				
					else{ if (!n.noHayPowerUp(b.getPosicionX()+i,b.getPosicionY()))
								devolverPWlugar(b.getPosicionX()+i,b.getPosicionY());
						else if(!n.noHayEnemigos(b.getPosicionX()+i,b.getPosicionY())){
							detenerHiloEnemigo(n.hayColisionEnemigo(b.getPosicionX()+i,b.getPosicionY()));
							
						//	misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
							misLabels.get(b.getPosicionX()+i).get(b.getPosicionY()).setIcon(n.buscarItem2(new Lugar(b.getPosicionX()+i,b.getPosicionY(),1)).getI());
							
						}						
						}
			}
				
				
				
					 
			}
			catch(IndexOutOfBoundsException e){}
			 j.getNivel().setBombaActual(new Bombas(1,23));
		}
		
		private void detenerHiloEnemigo(Enemigos e) {
			List<HiloEnemigo> enemigos=n.obtenerEnemigos();
			for(int i=0;i<enemigos.size();i++){
				if (enemigos.get(i).equals(e))//(enemigos.get(i).getE().getPosicionX()==e.getPosicionX() && enemigos.get(i).getE().getPosicionY()==e.getPosicionY())
					enemigos.get(i).detener();
			       // n.RemoverEnemigo(e);	   
				    
				    }
		
	}

		//Metodo privado para setear las imagenes de los powerUp luego de que explote la bomba
		protected void devolverPWlugar(int x,int y){
			if(x==10 && y==7)
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/power up speed up.png")));
			if(x==21 && y==8)
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/power up bombaility.png")));
			if(x==17 && y==2)
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/power up fatality.png")));
			if(x==14 && y==10)
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/power up masacrality.png")));
			}
		
		//Metodo privado para agregar las paredes destructibles
		private void agregarDestruibles(){
			for(int i=3;i<=6;i++)
			{ misLabels.get(i).get(2).setIcon(null);
		      misLabels.get(i).get(2).setIcon(k);
		      }
			for(int i=5;i<=8;i++)
			{ misLabels.get(2).get(i).setIcon(null);
			misLabels.get(2).get(i).setIcon(k);
			}
			for(int i=9;i<=10;i++)
			{ misLabels.get(i).get(7).setIcon(null);
			misLabels.get(i).get(7).setIcon(k);
			}
			for(int i=16;i<=18;i++)
			{ misLabels.get(i).get(2).setIcon(null);
		      misLabels.get(i).get(2).setIcon(k);
		      }
			for(int i=16;i<=18;i++)
			{ misLabels.get(i).get(4).setIcon(null);
		      misLabels.get(i).get(4).setIcon(k);
		      }
			for(int i=3;i<=3;i++)
			{ misLabels.get(16).get(i).setIcon(null);
		      misLabels.get(16).get(i).setIcon(k);
		      }
			for(int i=3;i<=3;i++)
			{ misLabels.get(17).get(i).setIcon(null);
		      misLabels.get(17).get(i).setIcon(k);
		      }
			for(int i=1;i<=3;i++)
			{ misLabels.get(10).get(i).setIcon(null);
		      misLabels.get(10).get(i).setIcon(k);
		      }
			for(int i=5;i<=9;i++)
			{ misLabels.get(20).get(i).setIcon(null);
		      misLabels.get(20).get(i).setIcon(k);
		      }
			{ misLabels.get(21).get(7).setIcon(null);
		      misLabels.get(21).get(7).setIcon(k);
		      }
			for(int i=21;i<=23;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(k);
		      }
			for(int i=2;i<=6;i++)
			{ misLabels.get(23).get(i).setIcon(null);
		      misLabels.get(23).get(i).setIcon(k);
		      }
			for(int i=10;i<=11;i++)
			{ misLabels.get(17).get(i).setIcon(null);
		      misLabels.get(17).get(i).setIcon(k);
		      }
			for(int i=9;i<=11;i++)
			{ misLabels.get(10).get(i).setIcon(null);
		      misLabels.get(10).get(i).setIcon(k);
		      }
			for(int i=8;i<=9;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(k);
		      }
			for(int i=11;i<=12;i++)
			{ misLabels.get(11).get(i).setIcon(null);
		      misLabels.get(11).get(i).setIcon(k);
		      i++;
			}
			for(int i=4;i<=10;i++)
			{ misLabels.get(7).get(i).setIcon(null);
		      misLabels.get(7).get(i).setIcon(k);
		      i++;
			}
			for(int i=5;i<=9;i++)
			{ misLabels.get(8).get(i).setIcon(null);
		      misLabels.get(8).get(i).setIcon(k);
		      i++;
			}
			for(int i=10;i<=16;i++)
			{ misLabels.get(i).get(8).setIcon(null);
		      misLabels.get(i).get(8).setIcon(k);
		      i++;
			}
			for(int i=10;i<=11;i++)
			{ misLabels.get(4).get(i).setIcon(null);
		      misLabels.get(4).get(i).setIcon(k);
		      }
			for(int i=21;i<=23;i++)
			{ misLabels.get(i).get(8).setIcon(null);
		      misLabels.get(i).get(8).setIcon(k);
		      }
			for(int i=3;i<=5;i++)
			{ misLabels.get(13).get(i).setIcon(null);
		      misLabels.get(13).get(i).setIcon(k);
		      }
			for(int i=14;i<=16;i++)
			{ misLabels.get(i).get(5).setIcon(null);
		      misLabels.get(i).get(5).setIcon(k);
		      }
			for(int i=11;i<=16;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(k);
		      i++;
			}
			for(int i=9;i<=10;i++)
			{ misLabels.get(19).get(i).setIcon(null);
		      misLabels.get(19).get(i).setIcon(k);
		      }
			for(int i=4;i<=8;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(k);
		      i++;
			}
			for(int i=9;i<=11;i++)
			{ misLabels.get(i).get(5).setIcon(null);
		      misLabels.get(i).get(5).setIcon(k);
		      i++;
			}
			for(int i=2;i<=3;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(k);
		      }
			for(int i=8;i<=10;i++)
			{ misLabels.get(14).get(i).setIcon(null);
		      misLabels.get(14).get(i).setIcon(k);
		      }
			for(int i=21;i<=22;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(k);
		      }
		}
		/**
		 * Setea el enemigo en el nuevo lugar
		 * @param e enemigo
		 * @param l lugar
		 */

		public void setearEnemigo3(Enemigos e,Lugar l) {
		
			if(l!=null)
			 {
				Icon i=e.getI();
				Icon i2=misLabels.get(l.getPosicionX()).get(l.getPosicionY()).getIcon();
				
				misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(i);
				misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(i2);
				 e.setPosicionX(l.getPosicionX());
			     e.setPosicionY(l.getPosicionY());
				
			 }
			else misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(e.getI());
			
			
			// TODO Auto-generated method stub
			
		}
		/**
		 * Setea el enemigo en el nuevo lugar
		 * @param e item a setear
		 * @param l lugar
		 */
		public void setearEnemigo4(Item e,Lugar l) {
			
			if(l!=null)
			 {
				Icon j=e.getI();
				Icon j2=misLabels.get(l.getPosicionX()).get(l.getPosicionY()).getIcon();
				if(n.noHayParedDestructible(l.getPosicionX(),l.getPosicionY())==true)
				{misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(j);
			
				}
				else
				  {
					misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(j);
				  }
				 
				 e.setPosicionX(l.getPosicionX());
			     e.setPosicionY(l.getPosicionY());
				
			 }
			else misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(e.getI());
			
			
			// TODO Auto-generated method stub
			
		
			
		}
		/**
		 * Retorna el Icon 
		 * @param l item
		 * @return
		 */
		public Icon encontrarIcono(Item l)
		{
			return misLabels.get(l.getPosicionX()).get(l.getPosicionY()).getIcon();
		}
		/**
		 * Setea las paredes destructibles
		 * @param l lugar a donde se va a setear
		 */
		public void setearDestructible(Lugar l) {
			try{
			 esp3.start();
			}catch(IllegalThreadStateException e){}
		//	System.out.println("Antes de Destructible");
			misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(k);
		//	System.out.println("Después de Destructible");
		
			
		}
		/**
		 * Setea el label
		 * @param l item
		 * @param icono
		 */

		public void setearLabel(Item l, Icon icono) {
			try{
			esp3.start();
			}catch(IllegalThreadStateException e){}
			Item l2=n.buscarItem(l);
			misLabels.get(l2.getPosicionX()).get(l2.getPosicionY()).setIcon(icono);
			// TODO Auto-generated method stub
			
		}
}
