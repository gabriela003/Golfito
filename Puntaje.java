package juego;

import java.awt.Color;

import entorno.Entorno;

public class Puntaje {
	
	private int golpes;
	private String ganaste;
	
	public Puntaje() {
		this.golpes = 0;
	}
	
	public void sumarGolpe() {
		this.golpes = this.golpes + 1;
		this.ganaste = "GANASTE";
	}
	
	public void dibujarGolpesActuales(Entorno e){
		String golpesEnString = String.valueOf(this.golpes);
		e.cambiarFont("Snap ITC", 35 , Color.BLACK);
		e.escribirTexto(golpesEnString, 730, 57);
	}
	
	public void dibujarJugadorArctual(Entorno e){
		e.cambiarFont("Snap ITC", 40 , Color.BLACK);
		e.escribirTexto("1", 187, 57);
	}
	
	public void sumarTotalAlNivel () {
		//this.totalNivel1Jugador1
	}
	
	public void dibujarTotalNivel1Jugador1(){
		
	}
	
	public void ganaste(Entorno e){
		e.cambiarFont("Snap ITC", 100 , Color.BLACK);
		e.escribirTexto(this.ganaste, 170, 300);
	}

}
