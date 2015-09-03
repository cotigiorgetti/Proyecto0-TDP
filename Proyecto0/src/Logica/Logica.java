package Logica;

import javax.swing.ImageIcon;
/**
 * @author Constanza Giorgetti,María Eugenia Heinrich.
 * */
public class Logica {
/**
 * Constructor de la clase Logica
 * */
	public Logica() {
		// TODO Auto-generated constructor stub
	}
/**
 * @return ImageIcon :devuelve un objeto de la clase ImageIcon con la imagen correspondiente a mostrar por pantalla en la clase Inter.
 * */
	public ImageIcon mostrarImagen()
	{
		return new ImageIcon(Logica.class.getResource("/Imagenes/Lisa_simpson_1.gif"));
	}
	/**
	 * @return String:devuelve un objeto de la clase String utilizado para mostrar la frase correspondiente en la clase Inter. 
	 * */
	public String mostrarTexto()
	{
		return "Es mejor estar callado y ser"+"\n"+""
		    + "tomado por tonto que abrir la "+"\n"+""
		    + "boca y despejar las dudas";
	}

}
