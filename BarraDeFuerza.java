package juego;

import java.awt.Color;
import entorno.Entorno;

public class BarraDeFuerza {
	
	//Pocisiones
	private double x;
	private double y;
	
	//Fuerza
	private double fuerza;
	private boolean disminuyendo;
	
	//Ancho del rectangulo Negro
	private int anchoRectanguloNegro;
	
	public BarraDeFuerza (double x , double y){
		// en X = 402 el rectangulo esta centrado en la pantalla.
		this.x = 398;
		this.y = 48;
		this.anchoRectanguloNegro = 335;
		this.disminuyendo = false;
	}
	
	public void cambiarFuerza(){
		if (this.disminuyendo && this.anchoRectanguloNegro < 335) {
			this.fuerza = this.fuerza - 0.05;
			this.anchoRectanguloNegro = this.anchoRectanguloNegro + 2;
			this.x = this.x - 1;
			if (this.anchoRectanguloNegro >= 335) {
				this.disminuyendo = false;
			}
		}
		else if (this.anchoRectanguloNegro > 0) {
			this.fuerza = this.fuerza + 0.05;
			this.anchoRectanguloNegro = this.anchoRectanguloNegro - 2;
			this.x = this.x + 1;
			if (this.anchoRectanguloNegro <= 0) {
				this.disminuyendo = true;
			}
		}
	}
	
	public boolean seMueveHaciaHoyo() {
		return false;
	}
	
	public void dibujar(Entorno e ){
		e.dibujarRectangulo(this.x, this.y, this.anchoRectanguloNegro , 14, 0, Color.BLACK);
	}
	
	public double getFuerza(){
		return this.fuerza;
	}
	
	public void reestrablecer() {
		this.x = 402;
		this.anchoRectanguloNegro = 335;
	}
}
