package juego;


import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	//public Controlador controlador;
	private Pelota pelota;
	private TrampaDeArena [] trampasDeArena;
	private TrampaDeAgua [] trampasDeAgua;
	private Flecha flecha;
	private Image fondo;
	private Hoyo hoyo;
	private BarraDeFuerza barraDeFuerza;
	private Puntaje puntaje;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Golfito 100% real NO FAKE FULL HD/BD 4K [PARCHEADO] --> Krsteff Monzon Crevatin - V0.01", 1000, 600);
		
		// Inicializar lo que haga falta para el juego
		// ...
		
		this.fondo = Herramientas.cargarImagen("FondoJuego.jpg");
		
		this.pelota = new Pelota (100, 150);
		
		this.flecha = new Flecha (100 , 100);
		
		this.hoyo = new Hoyo (700 , 530);
		
		this.trampasDeArena = new TrampaDeArena [4];
		
		this.trampasDeArena[0] = new TrampaDeArena(100, 400);
		this.trampasDeArena[1] = new TrampaDeArena(500, 200);
		this.trampasDeArena[2] = new TrampaDeArena(250, 250);
		this.trampasDeArena[3] = new TrampaDeArena(600, 500);
		
		this.trampasDeAgua = new TrampaDeAgua [2];
		
		this.trampasDeAgua[0] = new TrampaDeAgua(300, 400);
		this.trampasDeAgua[1] = new TrampaDeAgua(600, 150);
		
		this.barraDeFuerza = new BarraDeFuerza (500, 50);
		
		this.puntaje = new Puntaje ();
		

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		
		this.entorno.dibujarImagen(fondo, entorno.ancho()/2 , entorno.alto()/2, 0);
		
		hoyo.dibujar(entorno);
		
		barraDeFuerza.dibujar(entorno);
		
		for (int i = 0; i < trampasDeArena.length; i++) {
			this.trampasDeArena[i].dibujarTrampaArena(entorno);
			
		}
		
		for (int i = 0; i < trampasDeAgua.length; i++) {
			this.trampasDeAgua[i].dibujarTrampaAgua(entorno);
		}
		
		pelota.dibujar(entorno);
		
		puntaje.dibujarJugadorArctual(entorno);
		
		puntaje.dibujarGolpesActuales(entorno);
		
		if (!pelota.seEstaMoviendo()) {
			
			if (pelota.estaCercaDeHoyo(hoyo.getX(), hoyo.getY())){
				puntaje.ganaste(entorno);
			}
			
			flecha.dibujar(entorno , pelota.getX() , pelota.getY());
			
			if (entorno.estaPresionada(entorno.TECLA_DERECHA)){
				flecha.girarHorario();
			}
			
			if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)){
				flecha.girarAntihorario();
			}
			
			if (entorno.estaPresionada(entorno.TECLA_ESPACIO)) {
				barraDeFuerza.cambiarFuerza();
			}
			if (entorno.sePresiono(entorno.TECLA_ENTER)) {
				pelota.golpear(flecha.getAngulo(), barraDeFuerza.getFuerza());
				puntaje.sumarGolpe();
			}
		}
		
		if (pelota.seEstaMoviendo()) {
			
			if (pelota.estaCercaDeHoyo(hoyo.getX(), hoyo.getY())){
				pelota.moverHaciaHoyo(hoyo.getX(), hoyo.getY());
			}
			
			for (int i = 0; i < trampasDeArena.length; i++) {
				if (pelota.estaEnTrampaDeArena(trampasDeArena[i].getX() , trampasDeArena[i].getY())){
					pelota.disminuirVelocidad();
				}
			}
			
			for (int i = 0; i < trampasDeAgua.length; i++) {
				if (pelota.estaEnTrampaDeArena(trampasDeAgua[i].getX(), trampasDeAgua[i].getY())){
					pelota.reaparecer(100 , 150);
				}
			}
			
		}
		
		// Procesamiento de un instante de tiempo
		// ...
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Juego juego = new Juego();
		
	}
}
