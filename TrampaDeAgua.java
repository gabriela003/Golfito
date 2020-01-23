package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class TrampaDeAgua {
	
	private double x;
	private double y;
	private Image dibuDeTrampaDeAgua;
	
	public TrampaDeAgua (double x , double y){
		this.x = x;
		this.y = y;
		this.dibuDeTrampaDeAgua = Herramientas.cargarImagen("TrampaDeAgua.png");
	}
	
	public void dibujarTrampaAgua(Entorno e){
		e.dibujarImagen(dibuDeTrampaDeAgua, this.x, this.y, 0);
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}

}
