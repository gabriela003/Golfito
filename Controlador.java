package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Controlador {
	
	public int estado;
	public Image fondo;   //   <---  Se me ocurrio dibujar los mismos fondos para todos los niveles (cambiandole el color), asi solo cambiamos esta variable.
	
	public Controlador(int estado , Image fondo) {
		this.estado = estado;
		this.fondo = fondo;
	}
	
	
	public void dibujarFondo(Entorno e , int estado) {
		
		if (estado == 1) {
			this.fondo = Herramientas.cargarImagen("pastito.jpg");
			e.dibujarImagen(this.fondo, 0, 0, 0);
		}
		
		if (estado == 2) {
//			this.fondo = y aca pasar la imagen de el fobdo del juego
			e.dibujarImagen(this.fondo , 0 , 0 , 0);
		}
		
		if (estado == 3) {
//			this.fondo = y aca pasar la imagen de los creditos
			e.dibujarImagen(this.fondo , 0 , 0 , 0);
		}
	}
	
	
	
	
}
