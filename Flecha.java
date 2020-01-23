package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	
	private double x;
	private double y;
	private double angulo;
	private Image dibuFlecha;
	
	public Flecha(double x , double y){
		this.x = x;
		this.y = y;
		this.dibuFlecha = Herramientas.cargarImagen("Flecha.png");
	}
	
	public void dibujar(Entorno e , double x , double y){
		e.dibujarImagenConCentro (this.dibuFlecha, x , y , 0 , 13, this.angulo , 1);
	}
	
	public void girarAntihorario (){
		this.angulo = this.angulo + 0.02;
	}
	
	public void girarHorario(){
		this.angulo = this.angulo - 0.02;
	}
	
	public void posicionate(int x, int y) {
		this.x = x;
		this.y = y;
}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getAngulo(){
		return this.angulo;
	}

}