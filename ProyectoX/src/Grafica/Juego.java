package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enemigo.Enemigos;
import Logica.*;
import Lugar.*;
import PowerUps.Powerup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.border.BevelBorder;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Juego extends JFrame  {

private JPanel contentPane;

	private JuegoLogica j;
	@SuppressWarnings("unused")
	private Nivel n;
	JLabel lblPuntaje,lblVidas,lblBombas,lblContador,lblAlcance;
	Contador cont;
	static Juego frame ;
	Esperador esp;
	Esperador2 esp2;
	int cont3=0;
	
	GridBagLayout gbl_panel = new GridBagLayout();
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	ArrayList<ArrayList<JLabel>> misLabels = new ArrayList<ArrayList<JLabel>>();
	Panel panel = new Panel();
	private JLabel lblVelocidad;
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
				{ moverAbajo();
				  
				}
				if(s==KeyEvent.VK_LEFT)
				{ moverIzq();
					
				}
				if(s==KeyEvent.VK_UP){
					{ moverArriba();
						
						
					}
				}
				if(s==KeyEvent.VK_RIGHT){
					
					{ moverDerecha();
						
					  }							
				}
				if(s==KeyEvent.VK_B)
				{	
					esp=new Esperador(0.5f,frame);
					int  x=j.getNivel().getHb().getB().getPosicionX();
				 
					int  y=j.getNivel().getHb().getB().getPosicionY();
				  
				if(j.getNivel().getHb().getB().cantBombas()>=1)	
				 
					{ 
				  
						Lugar l=lugarDisponible(x,y); 
				  
						if (l!=null)
						{
					 
							Bombas b=j.getNivel().colocarBombas(l);
					        j.getNivel().setBombaActual(b);
					  
							x=l.getPosicionX();
							
							y=l.getPosicionY();
						{
				//	   System.out.println(j.getNivel().getHb().getB().cantBombas());
					 	
					   
					 
					  misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomba.png")));
				
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
			
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B)
				{ 
					esp=new Esperador(0.5f,frame);
					esp2=new Esperador2(0.5f,frame);
					Bombas b=j.getNivel().getHb().getB().getMisBombas();
					if(j.getNivel().getHb().getB().cantBombas()>0)	
					{
				 esp2.start();
					}
					 else 
						 if (j.getNivel().getHb().getB().cantBombas()==0)
						 {	
						 JOptionPane.showMessageDialog(null,"No Puede Colocar Más Bombas!!!!!!");
						 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
						 j.getNivel().setBombaActual(new Bombas(1,23));
						 }
				
					}
				
			}catch(Exception e3){}
				setearLabels2();

			}
			
			
			
			@Override
			public void keyTyped(KeyEvent e) {
			try{esp=new Esperador(0.5f,frame);
				 esp.start();
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B){
					
				Bombas b=j.getNivel().getHb().getB().getMisBombas();
				@SuppressWarnings("unused")
				Lugar l=new Lugar(b.getPosicionX(),b.getPosicionY(),1);
				if(j.getNivel().getHb().getB().cantBombas()>0)	{
			   misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomba.png")));
					
				
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
	
	protected void armarTablero()
	{j=new JuegoLogica(this);
	n=j.getNivel();
	if(cont!=null)
	 {
		cont.interrupt();
	 }
	cont=new Contador(this);
	esp=new Esperador(0.5f,this);
	esp2=new Esperador2(0.5f,this);
	pintarTablero();
		lblBombas.setText("Bombas ="+j.getNivel().getHb().getB().cantBombas());
		lblVidas.setText("Vidas ="+j.getNivel().getHb().getB().getCantVidas());
		lblPuntaje.setText("Puntaje = "+j.getNivel().getHb().getB().getPuntaje());
		lblVelocidad.setText("Velocidad="+j.getNivel().getHb().getB().getVelocidad());
		lblAlcance.setText("Alcance="+j.getNivel().getHb().getB().getMisBombas().getAlcance());
		cont.start();
		
	/**	List<Powerup>list=j.getNivel().obtenerPowerUps();
    	for(Powerup p:list)
    	{
    		misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(p.getI());
    	}
		*/
	    misLabels.get(1).get(1).setIcon(j.getNivel().getHb().getB().getI());
	  
	    
	   j.getNivel().obtenerEnemigos().get(0).start();
	   j.getNivel().obtenerEnemigos().get(1).start();
   j.getNivel().obtenerEnemigos().get(2).start();
 //  setearEnemigo2(); 
	
		
		
	}
	protected void pintarTableroInicial()
	{	j=new JuegoLogica(this);
	n=j.getNivel();
		for(int i=0;i<=24;i++)
		{	misLabels.add(i,new ArrayList<JLabel>());
			for(int j=0;j<=12;j++)
			{	JLabel l= new JLabel();
			l.setBackground(new Color(0, 128, 0));
			l.setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				misLabels.get(i).add(j,l);						
				gbc_lblNewLabel.gridx = i;
				gbc_lblNewLabel.gridy = j;
				panel.add(l, gbc_lblNewLabel);
				
			}
			
		}
		pintarTablero();
	}
	protected void pintarTablero()
	{
		for(int i=0;i<=24;i++)
		{	
			for(int j=0;j<=12;j++)
			{	JLabel l= misLabels.get(i).get(j);
			l.setBackground(new Color(0, 128, 0));
			l.setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
							
			}
			
			
		}
		
		for(int i=0;i<24;i++){
			for(int j=0;j<12;j++){
				
			misLabels.get(i).get(j).setIcon(null);
			misLabels.get(i).get(j).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png")));
		  repaint();
		  j+=2;
		}
			i+=2;
		}
		
		for(int j=0;j<=12;j++)
		{	misLabels.get(0).get(j).setIcon(null);
		
			misLabels.get(0).get(j).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png")));
				
		     repaint();	
		
		
	}
	
		for(int i=0;i<=24;i++)
		{	misLabels.get(i).get(0).setIcon(null);
			misLabels.get(i).get(0).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png")));
				repaint();	
		
		
	}
		for(int j=0;j<=12;j++)
		{	misLabels.get(24).get(j).setIcon(null);
			misLabels.get(24).get(j).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png")));
				repaint();	
		
		
		}
		for(int i=0;i<=24;i++)
		{	misLabels.get(i).get(12).setIcon(null);
			misLabels.get(i).get(12).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared indestructible.png")));
				repaint();	
		
		
	      }
		agregarDestruibles();
	}
	protected void mostrarTablero(String s)
	{
		
	 lblContador.setText("Contador = "+ s);
	
	}
	
	//Movimientos
	private void moverAbajo() {
		setearLabels2();
		int x=j.getNivel().getHb().getB().getPosicionX();
		  int y=j.getNivel().getHb().getB().getPosicionY();
		  int extra=0;
		  if((y<=10 && y>=1)&&(x<=23 && x>=1))
				{
			  	
				
				Powerup colision=(hayColisionPowerUp(x,y+1,j.getNivel().obtenerPowerUps()));
			    Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
			   Pared colision3=hayColisionPared(x,y+1,j.getNivel().obtenerIndestructibles(),j.getNivel().obtenerDestructibles());
			   Bombas colision4=hayColisionBomba(x,y+1);	 
				 
			   if(colision!=null )
						{	
						j.getNivel().colisionarBombermaPowerUp(colision);
						j.getNivel().obtenerPowerUps().remove(colision);
						}	
				else if(colision2!=null)
				{extra=-1;
					j.getNivel().colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{extra=-1;
				
			
			}
				else if(colision4!=null)
				{
					extra=-1;
				}
			if(j.getNivel().getHb().getB().getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				
			    j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman inicial.png")));
				
				
			    y=y+1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
		      else{      j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
		      misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
		      j.getNivel().getHb().destruir();
		      j.getNivel().obtenerEnemigos().get(0).destruir();
		      setearLabels2();
		      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
		  	
		      armarTablero();	
		      }
			setearLabels2();

				}	
		 
	}
	private void moverIzq() {
		{  setearLabels2();
			int x=j.getNivel().getHb().getB().getPosicionX();
		  int y=j.getNivel().getHb().getB().getPosicionY();
		int extra=0;
		  if((y<=11 && y>=0)&&(x<=23 && x>1))
				{
			     
				Powerup colision=(hayColisionPowerUp(x-1,y,j.getNivel().obtenerPowerUps()));
				  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
				  Pared colision3=hayColisionPared(x-1,y,j.getNivel().obtenerIndestructibles(),j.getNivel().obtenerDestructibles());
				  Bombas colision4=hayColisionBomba(x-1,y);	 
				  if(colision!=null )
					{
					j.getNivel().colisionarBombermaPowerUp(colision);
					j.getNivel().obtenerPowerUps().remove(colision);
					}	
				else	if(colision2!=null)
					{extra=1;
					j.getNivel().colisionarBombermaEnemigo(colision2);
					}
				else if(colision3!=null)
				    {
					extra=1;
				    }
				else if(colision4!=null)
				{
					extra=1;
				}
				if(j.getNivel().getHb().getB().getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman izq2.png")));
				
			
				x=x-1+extra;
				{generarMovimientoBomberman(x,y);}
				
				}
				 
				else{     j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      j.getNivel().getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				}
				
		}	
		
	}
	private void moverArriba() 
	{setearLabels2();
		
		 int x=j.getNivel().getHb().getB().getPosicionX();
		  int y=j.getNivel().getHb().getB().getPosicionY();
		 int extra=0;
		  if((y<=11 && y>1)&&(x<=23 && x>=1))
				{								
				Powerup colision=(hayColisionPowerUp(x,y-1,j.getNivel().obtenerPowerUps()));
				  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
				  Pared colision3=hayColisionPared(x,y-1,j.getNivel().obtenerIndestructibles(),j.getNivel().obtenerDestructibles());
				  Bombas colision4=hayColisionBomba(x,y-1);	 
					 
					
				  if(colision!=null)
					{
					j.getNivel().colisionarBombermaPowerUp(colision);
					j.getNivel().obtenerPowerUps().remove(colision);
					}	
				else if(colision2!=null)
				{   extra=1;
					j.getNivel().colisionarBombermaEnemigo(colision2);
				}
				else if(colision3!=null)
				{ 
					extra=1;
				}
				else if(colision4!=null)
				{
					extra=1;
				}
				if(j.getNivel().getHb().getB().getCantVidas()>=1)	
				{
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman espalda.png")));
				
				y=y-1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
				  else{     j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      j.getNivel().getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
		 
	}
	private void moverDerecha() {
		{setearLabels2();
			int x=j.getNivel().getHb().getB().getPosicionX();
		  int y=j.getNivel().getHb().getB().getPosicionY();
		 int extra=0;
		  if((y<=11 && y>=0)&&(x<=22 && x>=1))
				{Powerup colision=(hayColisionPowerUp(x+1,y,j.getNivel().obtenerPowerUps()));
				  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
				  Pared colision3=hayColisionPared(x+1,y,j.getNivel().obtenerIndestructibles(),j.getNivel().obtenerDestructibles());
				  Bombas colision4=hayColisionBomba(x+1,y);	 
					 
				  if(colision!=null)
				{
				j.getNivel().colisionarBombermaPowerUp(colision);
				j.getNivel().obtenerPowerUps().remove(colision);
				}
				else if(colision2!=null)
				{  extra=-1;
					j.getNivel().colisionarBombermaEnemigo(colision2);
				
				}
				else if(colision3!=null)
				{
					 extra=-1;
				}
				else if(colision4!=null)
				   {
					extra=-1;
				   }
				 if(j.getNivel().getHb().getB().getCantVidas()>=1 )	
				{
				misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman derecha1.png")));
				
						
				 x=x+1+extra;
				{generarMovimientoBomberman(x,y);
				}
				}
				else {j.getNivel().getHb().getB().setI(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomberman muerto.png")));
			      j.getNivel().getHb().destruir();
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
		      }
				setearLabels2();
				
				}
				
										
				}
				
		 
		
	}
	
	//Colisiones
	
	protected Powerup hayColisionPowerUp(int x, int y, List<Powerup> pw) {
	Powerup r=null;	
		for(int i=0;i<pw.size();i++)
		{Powerup p=pw.get(i);
			
		if(p.getPosicionX()==x &&p.getPosicionY()==y)
			{r=p;
		     break;}
		}
		return r;
	}
	private Enemigos hayColisionEnemigo(int x, int i, List<HiloEnemigo> en) {
		   Enemigos e=null;	
		  
			
			for(int k=0;k<en.size();k++)
			{Enemigos e1=en.get(k).getE();
			
			
			if(e1.getPosicionX()==x &&e1.getPosicionY()==i)
				{
				e=e1;
			
				break;}
			}
			return e;
			
		}
	private Pared hayColisionPared(int x, int i, List<Pared> en, List<Pared> des) {
		 Pared e=null;	
		  
			
			for(int k=0;k<en.size();k++)
			{Pared e1=en.get(k);
	//		System.out.println(x);
	//	System.out.println(i);
			
			if(e1.getPosicionX()==x &&e1.getPosicionY()==i)
				{
				e=e1;
			
				break;}
			}
			for(int j=0;j<des.size();j++)
			{Pared d1=des.get(j);
			if(d1.getPosicionX()==x && d1.getPosicionY()==i)
			{
				e=d1;
				break;
			}
			}
			return e;
	}
	private void Afectar()
	{
	try{
	int alcance=j.getNivel().getHb().getB().getAlcance();
	Lugar l=new Lugar(j.getNivel().getBombaActual().getPosicionX(),j.getNivel().getBombaActual().getPosicionY(),1);
	Lugar p=hayParedAlrededor(l,j.getNivel().obtenerDestructibles());
	Enemigos e=noHayEnemigo(l,j.getNivel().obtenerEnemigos());
	
	
	
	if(hayBomberman(l))
		  {
			j.getNivel().colisionarBombermaBomba(j.getNivel().getHb().getB(), j.getNivel().getHb().getB().getMisBombas());
			setearLabels2();
			
		
		  }
	verAlcanceBomberman();
		 if(p!=null )
		     {p.destruirPared(j.getNivel().getBombaActual());
		     p.serDestruido(j.getNivel().getHb().getB());
		   if(p.getTransitable()==0 )
			    {
				 {j.getNivel().RemoverDestructibles(p);
				  p.setTransitable(1);
				  Powerup pw=hayColisionPowerUp(p.getPosicionX(),p.getPosicionY(),j.getNivel().obtenerPowerUps());
				 if(pw!=null)
					 {
					 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(pw.getI());
						
					 }
				 else {
					 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
					 
				 }
				 } 
				 }
		    verConAlcancePW(j.getNivel().obtenerDestructibles());
			if(j.getNivel().obtenerDestructibles().isEmpty())
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
			 j.getNivel().colisionarEnemigoBomba(e, j.getNivel().getBombaActual());
			 misLabels.get(p.getPosicionX()).get(p.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
			// esp.start();
			 misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(e.getI());
			
			 e.serDestruido(j.getNivel().getHb().getB());
		     
		 }		 
		 verAlcanceEnemigo(j.getNivel().obtenerEnemigos());
		
	}catch(Exception e){}
	}
	
	
	private void verAlcanceBomberman() {
		int x1;
		int y1;
		int x=j.getNivel().getHb().getB().getMisBombas().getPosicionX();
		int y=j.getNivel().getHb().getB().getMisBombas().getPosicionY();
		int alcance=j.getNivel().getHb().getB().getAlcance();
		
		
		{x1=j.getNivel().getHb().getB().getPosicionX();
		y1=j.getNivel().getHb().getB().getPosicionY();
		for(int i=1;i<=alcance;i++)
		{
		if((x+i==x1 && y==y1)|| (x-i==x1 && y==y1) || (x==x1 && y+i==y1) || (x==x1 && y-i==y1))
		{
			j.getNivel().colisionarBombermaBomba(j.getNivel().getHb().getB(), j.getNivel().getHb().getB().getMisBombas());
			setearLabels2();
		}
		}
		}
		
		
	}

	private void verAlcanceEnemigo(List<HiloEnemigo> list ){
		Enemigos e=null;
		int x1;
		int y1;
		int x=j.getNivel().getHb().getB().getMisBombas().getPosicionX();
		int y=j.getNivel().getHb().getB().getMisBombas().getPosicionY();
		int alcance=j.getNivel().getHb().getB().getAlcance();
		
		for(HiloEnemigo e2:list)
		{x1=e2.getE().getPosicionX();
		y1=e2.getE().getPosicionY();
		for(int i=1;i<=alcance;i++)
		{
		if((x+i==x1 && y==y1)|| (x-i==x1 && y==y1) || (x==x1 && y+i==y1) || (x==x1 && y-i==y1))
		{
			j.getNivel().colisionarEnemigoBomba(e2.getE(), j.getNivel().getBombaActual());
		//	System.out.println("Estoy colisionando enemigo");
			 misLabels.get(e2.getE().getPosicionX()).get(e2.getE().getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
			// esp.start();
			 misLabels.get(e2.getE().getPosicionX()).get(e2.getE().getPosicionY()).setIcon(e2.getE().getI());
			
			 e2.getE().serDestruido(j.getNivel().getHb().getB());
		}
		}
		}
		
	}

	private void verConAlcancePW(List<Pared> list) {
		Pared p=null;
		int x1;
		int y1;
		int x=j.getNivel().getHb().getB().getMisBombas().getPosicionX();
		int y=j.getNivel().getHb().getB().getMisBombas().getPosicionY();
		for(Pared p2:list)
		{x1=p2.getPosicionX();
		y1=p2.getPosicionY();
	//	System.out.println(x1+" "+y1);
	//	System.out.println(x+" "+y);
		int alcance=j.getNivel().getHb().getB().getAlcance();
		for(int i=1;i<=alcance;i++)
		{
		if((x+i==x1 && y==y1)|| (x-i==x1 && y==y1) || (x==x1 && y+i==y1) || (x==x1 && y-i==y1))
		{
			p2.destruirPared(j.getNivel().getBombaActual());
		
	     p2.serDestruido(j.getNivel().getHb().getB());
	     if(p2.getTransitable()==0)
		    {
			 {
				 j.getNivel().RemoverDestructibles(p2);
			 
			  p2.setTransitable(1);
			  Powerup pw=hayColisionPowerUp(p2.getPosicionX(),p2.getPosicionY(),j.getNivel().obtenerPowerUps());
			 if(pw!=null)
				 {
				 misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(pw.getI());
					
				 }
			 else {
				 misLabels.get(p2.getPosicionX()).get(p2.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				 
		          }
			 }
		   }
	     }
		}
		}
	}

	private Enemigos noHayEnemigo(Lugar l, List<HiloEnemigo> list) {
		Enemigos h2=null;
		int x;
		int y;
		int x1=l.getPosicionX();
		int y1=l.getPosicionY();
		for(HiloEnemigo h:list)
		{x=h.getE().getPosicionX();
		y=h.getE().getPosicionY();
	//	System.out.println(x1+" "+y1);
	//	System.out.println(x+" "+y);
		if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
		{h2=h.getE();
		break;}
		}
		//System.out.println(l.getPosicionX()+" "+l.getPosicionY());
	//	System.out.println(p.getPosicionX()+" "+p.getPosicionY());
		return h2;
	}

	private Lugar hayParedAlrededor(Lugar l, List<Pared> list) {
		Pared p=null;
		int x;
		int y;
		int x1=l.getPosicionX();
		int y1=l.getPosicionY();
		for(Pared p2:list)
		{x=p2.getPosicionX();
		y=p2.getPosicionY();
	//	System.out.println(x1+" "+y1);
	//	System.out.println(x+" "+y);
		if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
		{p=p2;
		break;}
		}
		//System.out.println(l.getPosicionX()+" "+l.getPosicionY());
	//	System.out.println(p.getPosicionX()+" "+p.getPosicionY());
		return p;
	}

	//Lugar Disponible

private Pared BuscarDestructible(List<Pared> d, Lugar p) {
		Pared p2=null;
		for(Pared p3:d)
		  {
			if(p3.getPosicionX()==p.getPosicionX()&&p3.getPosicionY()==p.getPosicionY())
				p2=p3;
			break;
		  }
		return p2;
	}

private boolean hayBomberman(Lugar l) {
	int x=j.getNivel().getHb().getB().getPosicionX();
	int y=j.getNivel().getHb().getB().getPosicionY();
	int x1=l.getPosicionX();
	int y1=l.getPosicionY();
		if((x+1==x1 && y==y1)|| (x-1==x1 && y==y1) || (x==x1 && y+1==y1) || (x==x1 && y-1==y1))
		return true;
		else
		return false;
	}

private Lugar lugarDisponible(int x, int y) {
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
	
//No hay nadie alrededor
	private boolean noHayEnemigos(int x, int i) {
		boolean res=true;
		List<HiloEnemigo> lista=j.getNivel().obtenerEnemigos();
		for(int k=0;k<lista.size();k++)
			if((lista.get(k).getE().getPosicionX()==x)&&(lista.get(k).getE().getPosicionY()==i)){
				res=false;
				break;}
		return res;
	}
	private boolean noHayPowerUp(int i, int y) {
		boolean res=true;
		List<Powerup> lista=j.getNivel().obtenerPowerUps();
		for(int k=0;k<lista.size();k++)
			if((lista.get(k).getPosicionX()==i)&&(lista.get(k).getPosicionY()==y)){
				res=false;
				break;}
		return res;
	}
	private boolean noHayParedIndestructible(int i,int y){
		boolean res=true;
		List<Pared> lista=j.getNivel().obtenerIndestructibles();
		for(int k=0;k<lista.size();k++)
			if((lista.get(k).getPosicionX()==i) && (lista.get(k).getPosicionY()==y)){
				res=false;
				break;
			}
		return res;
	}
	private boolean noHayParedDestructible(int i,int y){
		boolean res=true;
		List<Pared> lista=j.getNivel().obtenerDestructibles();
		for(int k=0;k<lista.size();k++)
			if((lista.get(k).getPosicionX()==i) && (lista.get(k).getPosicionY()==y)){
				res=false;
				break;
			}
		return res;
	}
	private Bombas hayColisionBomba(int x,int i)
	
	{
		if(j.getNivel().getBombaActual().getPosicionX()==x && j.getNivel().getBombaActual().getPosicionY()==i)
	//  if( j.getNivel().getHb().getB().getMisBombas().getPosicionX()==x && j.getNivel().getHb().getB().getMisBombas().getPosicionY()==i)
		  return j.getNivel().getHb().getB().getMisBombas();
	  else return null;
	}
	
	
	//Setear Labels
		private void generarMovimientoBomberman(int x, int y)
		{
			Lugar l=new Lugar(x,y,1);
			j.getNivel().moverBomberman(l);
			
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
			Lugar l=lugarDisponible(h.getPosicionX(),h.getPosicionY());
				
			if(l2!=null)
			{
				h.setPosicionX(l2.getPosicionX());
				h.setPosicionY(l2.getPosicionY());
					Icon i=misLabels.get(h.getPosicionX()).get(h.getPosicionY()).getIcon();
					Icon i2=misLabels.get(l2.getPosicionX()).get(l2.getPosicionY()).getIcon();
					  
					misLabels.get(l2.getPosicionX()).get(l2.getPosicionY()).setIcon(i);
					misLabels.get(h.getPosicionX()).get(h.getPosicionY()).setIcon(i2);
					
				//	misLabels.get(h.getPosicionX()).get(h.getPosicionY()).repaint();
				}
			//	else misLabels.get(h.getPosicionX()).get(h.getPosicionY()).setIcon(h.getI());
		
			this.repaint();
				
		}
		public void setearEnemigo2() {
			for(HiloEnemigo h:j.getNivel().obtenerEnemigos()){
					Icon i=h.getE().getI();
				//	System.out.println(h.getE().getPosicionX()+""+h.getE().getPosicionY());
				    misLabels.get(h.getE().getPosicionX()).get(h.getE().getPosicionY()).setIcon(i);
					//misLabels.get(h.getPosicionX()).get(h.getPosicionY()).setIcon(h.getI());
				}
			//	else misLabels.get(h.getPosicionX()).get(h.getPosicionY()).setIcon(h.getI());
		
				
		}


		
		
 //Esperadores
		public void despuesDeEsperar(){
			try{
			 Bombas b=j.getNivel().getHb().getB().getMisBombas();
			 b.setAlcance(j.getNivel().getHb().getB().getAlcance());
			 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
			}catch(Exception e){}
		}
		public void despuesDeEsperar2() {
			Bombas b=j.getNivel().getHb().getB().getMisBombas();
			 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
				Afectar();
			 JOptionPane.showMessageDialog(null,"Explosión de Bomba!!!!!!");
			
				 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				 j.getNivel().setBombaActual(new Bombas(1,23));
				
		}
		
		//Metodo privado para agregar las paredes destructibles
		private void agregarDestruibles(){
			for(int i=3;i<=6;i++)
			{ misLabels.get(i).get(2).setIcon(null);
		      misLabels.get(i).get(2).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=5;i<=8;i++)
			{ misLabels.get(2).get(i).setIcon(null);
			misLabels.get(2).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=9;i<=10;i++)
			{ misLabels.get(i).get(7).setIcon(null);
			misLabels.get(i).get(7).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=16;i<=18;i++)
			{ misLabels.get(i).get(2).setIcon(null);
		      misLabels.get(i).get(2).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=16;i<=18;i++)
			{ misLabels.get(i).get(4).setIcon(null);
		      misLabels.get(i).get(4).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=3;i<=3;i++)
			{ misLabels.get(16).get(i).setIcon(null);
		      misLabels.get(16).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=3;i<=3;i++)
			{ misLabels.get(17).get(i).setIcon(null);
		      misLabels.get(17).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=1;i<=3;i++)
			{ misLabels.get(10).get(i).setIcon(null);
		      misLabels.get(10).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=5;i<=9;i++)
			{ misLabels.get(20).get(i).setIcon(null);
		      misLabels.get(20).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
		//	for(int i=19;i<=21;i++)
		//	{ misLabels.get(19).get(7).setIcon(null);
		 //     misLabels.get(19).get(7).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
		//	}
			{ misLabels.get(21).get(7).setIcon(null);
		      misLabels.get(21).get(7).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=21;i<=23;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=2;i<=6;i++)
			{ misLabels.get(23).get(i).setIcon(null);
		      misLabels.get(23).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=10;i<=11;i++)
			{ misLabels.get(17).get(i).setIcon(null);
		      misLabels.get(17).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=9;i<=11;i++)
			{ misLabels.get(10).get(i).setIcon(null);
		      misLabels.get(10).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=8;i<=9;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=11;i<=12;i++)
			{ misLabels.get(11).get(i).setIcon(null);
		      misLabels.get(11).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=4;i<=10;i++)
			{ misLabels.get(7).get(i).setIcon(null);
		      misLabels.get(7).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=5;i<=9;i++)
			{ misLabels.get(8).get(i).setIcon(null);
		      misLabels.get(8).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=10;i<=16;i++)
			{ misLabels.get(i).get(8).setIcon(null);
		      misLabels.get(i).get(8).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=10;i<=11;i++)
			{ misLabels.get(4).get(i).setIcon(null);
		      misLabels.get(4).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=21;i<=23;i++)
			{ misLabels.get(i).get(8).setIcon(null);
		      misLabels.get(i).get(8).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=3;i<=5;i++)
			{ misLabels.get(13).get(i).setIcon(null);
		      misLabels.get(13).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=14;i<=16;i++)
			{ misLabels.get(i).get(5).setIcon(null);
		      misLabels.get(i).get(5).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=11;i<=16;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=9;i<=10;i++)
			{ misLabels.get(19).get(i).setIcon(null);
		      misLabels.get(19).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=4;i<=8;i++)
			{ misLabels.get(i).get(1).setIcon(null);
		      misLabels.get(i).get(1).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=9;i<=11;i++)
			{ misLabels.get(i).get(5).setIcon(null);
		      misLabels.get(i).get(5).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			i++;
			}
			for(int i=2;i<=3;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=8;i<=10;i++)
			{ misLabels.get(14).get(i).setIcon(null);
		      misLabels.get(14).get(i).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
			for(int i=21;i<=22;i++)
			{ misLabels.get(i).get(11).setIcon(null);
		      misLabels.get(i).get(11).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/pared destruible2.png")));
			}
		}

		public void setearEnemigo3(Enemigos e) {
		//	System.out.println("En enemigo 3");
			//System.out.println(e.getPosicionX()+" "+e.getPosicionY());
			Lugar l=lugarDisponible2(e.getPosicionX(),e.getPosicionY());
			
	    //	System.out.println(l.getClass().getName());
			System.out.println(l.getPosicionX()+" "+l.getPosicionY());
			if(l!=null)
			 {
				Icon i=misLabels.get(e.getPosicionX()).get(e.getPosicionY()).getIcon();
				Icon i2=misLabels.get(l.getPosicionX()).get(l.getPosicionY()).getIcon();
				  
				misLabels.get(l.getPosicionX()).get(l.getPosicionY()).setIcon(i);
				misLabels.get(e.getPosicionX()).get(e.getPosicionY()).setIcon(i2);
				 e.setPosicionX(l.getPosicionX());
			     e.setPosicionY(l.getPosicionY());
			 }
			
			// TODO Auto-generated method stub
			
		}

		private Lugar lugarDisponible2(int x, int y) {
			Lugar l=null;
			
			Lugar l2=null;
			Lugar l3=null;
			Lugar l4=null;
			Lugar l5=null;
			if  (noHayPowerUp(x+1,y)&&(noHayParedIndestructible(x+1,y))&&(x+1<24)&&noHayParedDestructible(x+1,y))
				l2=new Lugar(x+1,y,1);
		  
				if(noHayPowerUp(x-1,y)&&(noHayParedIndestructible(x-1,y))&&noHayParedDestructible(x-1,y)&&x-1>0)
					l3=new Lugar(x-1,y,1);
			
				if(noHayPowerUp(x,y+1)&&(noHayParedIndestructible(x,y+1))&&noHayParedDestructible(x,y+1))
					l4=new Lugar(x,y+1,1);
				if(noHayPowerUp(x,y-1)&&(noHayParedIndestructible(x,y-1))&&noHayParedDestructible(x,y-1))
					l5=new Lugar(x,y-1,1);
			/**	Random r=new Random();
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
					break;}}*/
				if(l2!=null)
					l=l2;
				else if(l3!=null)
					 l=l3;
				else	 if(l4!=null)
					 l=l4;
				else	 if(l5!=null)
					l=l5;
				else l=new Lugar(x,y,1);
		//	System.out.println(l.getClass().getName());
			return l;
		}

		
}
