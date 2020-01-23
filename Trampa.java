package juego;

import java.awt.Image;

import entorno.Entorno;

	//Hacer una trampa para las de arena y una para las de agua o todo una sola????

public class Trampa {
	
	public int x;
	public int y;
	public Image trampaArena;
	
	Trampa(int x , int y ){
		this.x = x;
		this.y = y;
	}
	
	void dibujarTrampaArena (Entorno e , int x , int y) {
		
		e.dibujarImagen(trampaArena, x, y, 0);
		
	}
	
	
}
