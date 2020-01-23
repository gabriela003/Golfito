package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Hoyo {
	
	private double x;
	private double y;
	private Image dibuHoyo;
	
	public Hoyo(int x , int y){
		this.x = x;
		this.y = y;
		dibuHoyo = Herramientas.cargarImagen("Hoyo.png");
	}
	
	public void dibujar(Entorno e) {
		e.dibujarImagen(dibuHoyo, this.x, this.y, 0);
	}
	
	public void posicionate(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	
	
	

}
