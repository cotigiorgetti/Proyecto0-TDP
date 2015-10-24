package Grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enemigo.Enemigos;
import Logica.*;
import Lugar.Lugar;
import PowerUps.Powerup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.border.BevelBorder;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Juego extends JFrame {

	private JPanel contentPane;

	private JuegoLogica j;
	@SuppressWarnings("unused")
	private Nivel n;
	JLabel lblPuntaje;
	JLabel lblVidas;
	JLabel lblBombas;
	
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
					Juego frame = new Juego();
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
				{int  x=j.getNivel().getHb().getB().getPosicionX();
				  int  y=j.getNivel().getHb().getB().getPosicionY();
				  if(j.getNivel().getHb().getB().cantBombas()>=1)	
				  { 
				  Lugar l=lugarDisponible(x,y); 
				  if (l!=null){
					 Bombas b=j.getNivel().colocarBombas(l);
					 
					   x=l.getPosicionX();
					   y=l.getPosicionY();
					   
						  System.out.println(j.getNivel().getHb().getB().cantBombas());
					   misLabels.get(x).get(y).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomba.png")));
				
					lblBombas.setText("Bombas ="+j.getNivel().getHb().getB().cantBombas());
					
					b.explotar(l);
			Demorar(0.5);}
				// misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
				
				 
				 
				 
				  }
				}

			
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B)
				{ 
				
					Bombas b=j.getNivel().getHb().getB().getMisBombas();
					if(j.getNivel().getHb().getB().cantBombas()>0)	{
				//	misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomba.png")));
					
					 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
					 Demorar(0.5);	
					 JOptionPane.showMessageDialog(null,"Explosión de Bomba!!!!!!");
					
					 
				 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
				Demorar(0.5);
				}
					 else if (j.getNivel().getHb().getB().cantBombas()==0)
						 {// misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
							
						 JOptionPane.showMessageDialog(null,"No Puede Colocar Más Bombas!!!!!!");
						 misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/piso.png")));
						 }
					//	j.getNivel().detenerBomberman();
			//    MoverEnemigo(j.getNivel().obtenerEnemigos().get(0));
				}

			}
			@SuppressWarnings("unused")
			@Override
			public void keyTyped(KeyEvent e) {
				int s=e.getKeyCode();
				if(s==KeyEvent.VK_B){
					
				Bombas b=j.getNivel().getHb().getB().getMisBombas();
				Lugar l=new Lugar(b.getPosicionX(),b.getPosicionY(),1);
				if(j.getNivel().getHb().getB().cantBombas()>=0)	{
				misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/bomba.png")));
					
				
			Demorar(0.5);}
				// misLabels.get(b.getPosicionX()).get(b.getPosicionY()).setIcon(new ImageIcon(Juego.class.getResource("/Imagenes/fuego medio.png")));
				
				}
			}
		});
		j=new JuegoLogica();
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
		lblPuntaje.setBounds(28, 11, 102, 14);
		contentPane.add(lblPuntaje);
		
		lblVidas = new JLabel("Vidas=");
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setBounds(238, 11, 127, 14);
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
		lblVelocidad.setBounds(514, 11, 116, 14);
		contentPane.add(lblVelocidad);
		
	
		
		pintarTableroInicial();
				
		
		
	
		
		
		
	
	}
	//Metodos privados
	
	
	
	protected void pintarTableroInicial()
	{	j=new JuegoLogica();
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
		
	}
	protected void armarTablero()
	{j=new JuegoLogica();
	n=j.getNivel();
	pintarTablero();
		lblBombas.setText("Bombas ="+j.getNivel().getHb().getB().cantBombas());
		lblVidas.setText("Vidas ="+j.getNivel().getHb().getB().getCantVidas());
		lblPuntaje.setText("Puntaje = "+j.getNivel().getHb().getB().getPuntaje());
		lblPuntaje.setText("Velocidad="+j.getNivel().getHb().getB().getVelocidad());
		List<Powerup> p=j.getNivel().obtenerPowerUps();
		misLabels.get(10).get(6).setIcon(p.get(0).getI());
		misLabels.get(20).get(8).setIcon(p.get(1).getI());
	    misLabels.get(1).get(1).setIcon(j.getNivel().getHb().getB().getI());
	    misLabels.get(23).get(11).setIcon(j.getNivel().obtenerEnemigos().get(0).getE().getI());	
		
		
		
	}

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
	private Lugar lugarDisponible(int x, int y) {
		Lugar l=null;
		if (noHayPowerUp(x+1,y)&&(noHayEnemigos(x+1,y))&& (x+1<24))
			l=new Lugar(x+1,y,1);
	  else
			if (noHayPowerUp(x-1,y)&&(noHayEnemigos(x-1,y)))
				l=new Lugar(x-1,y,1);
		else
			if (noHayPowerUp(x,y+1)&&(noHayEnemigos(x,y+1)))
				l=new Lugar(x,y+1,1);
		else
			if (noHayPowerUp(x,y-1)&&(noHayEnemigos(x,y-1)))
				l=new Lugar(x,y-1,1);
		return l;
	}
	
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

	 private void Demorar(double d)
	    {
	        try
	        {
	            Thread.sleep((long) (1000*d));
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }        
	    }
		private void moverAbajo() {
			int x=j.getNivel().getHb().getB().getPosicionX();
			  int y=j.getNivel().getHb().getB().getPosicionY();
			  int extra=0;
			  if((y<=10 && y>=1)&&(x<=23 && x>=1))
					{
				  	
					
					Powerup colision=(hayColisionPowerUp(x,y+1,j.getNivel().obtenerPowerUps()));
				    Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
				   
				 	if(colision!=null )
							{	
							j.getNivel().colisionarBombermaPowerUp(colision);
							
							}	
					else if(colision2!=null)
					{extra=-1;
						j.getNivel().colisionarBombermaEnemigo(colision2);
					
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
			      setearLabels2();
			      JOptionPane.showMessageDialog(null,"Fin del juego,Intentalo otra vez!");
			  	  armarTablero();	
			      }
				setearLabels2();
					}	
			
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

		private void moverIzq() {
			{ int x=j.getNivel().getHb().getB().getPosicionX();
			  int y=j.getNivel().getHb().getB().getPosicionY();
			int extra=0;
			  if((y<=11 && y>=0)&&(x<=23 && x>1))
					{
				     
					Powerup colision=(hayColisionPowerUp(x-1,y,j.getNivel().obtenerPowerUps()));
					  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
					
					  if(colision!=null )
						{
						j.getNivel().colisionarBombermaPowerUp(colision);
						
						}	
					else	if(colision2!=null)
						{extra=1;
						j.getNivel().colisionarBombermaEnemigo(colision2);
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

		private void moverArriba() {
			 int x=j.getNivel().getHb().getB().getPosicionX();
			  int y=j.getNivel().getHb().getB().getPosicionY();
			 int extra=0;
			  if((y<=11 && y>1)&&(x<=23 && x>=1))
					{								
					Powerup colision=(hayColisionPowerUp(x,y-1,j.getNivel().obtenerPowerUps()));
					  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
					
						
					  if(colision!=null)
						{
						j.getNivel().colisionarBombermaPowerUp(colision);
						
						}	
					else if(colision2!=null)
					{   extra=1;
						j.getNivel().colisionarBombermaEnemigo(colision2);
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
			{ int x=j.getNivel().getHb().getB().getPosicionX();
			  int y=j.getNivel().getHb().getB().getPosicionY();
			 int extra=0;
			  if((y<=11 && y>=0)&&(x<=22 && x>=1))
					{Powerup colision=(hayColisionPowerUp(x+1,y,j.getNivel().obtenerPowerUps()));
					  Enemigos colision2=hayColisionEnemigo(x,y,j.getNivel().obtenerEnemigos());
					 
					  if(colision!=null)
					{
					j.getNivel().colisionarBombermaPowerUp(colision);
					
					}
					else if(colision2!=null)
					{  extra=-1;
						j.getNivel().colisionarBombermaEnemigo(colision2);
					
					}
					if(j.getNivel().getHb().getB().getCantVidas()>=1)	
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
			lblVelocidad.setText("Velociada ="+j.getNivel().getHb().getB().getVelocidad());
		}
}
