package juego;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

	//Hacer una trampa para las de arena y una para las de agua o todo una sola????

public class TrampaDeArena {
	
	private double x;
	private double y;
	private Image dibuDeTrampaArena;
	
	TrampaDeArena(double x , double y){
		this.x = x;
		this.y = y;
		this.dibuDeTrampaArena = Herramientas.cargarImagen("TrampaDeArena.png");
	}
	
	public void dibujarTrampaArena (Entorno e) {
		e.dibujarImagen(dibuDeTrampaArena, this.x , this.y , 0);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
}
