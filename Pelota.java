package juego;

	import java.awt.Image;

	import entorno.Entorno;
	import entorno.Herramientas;

	public class Pelota {
		
		private double x;
		private double y;
		private double velocidadEnX;
		private double velocidadEnY;
		
		//Imagen
		private Image dibuPelota;
		
		public Pelota (int x, int y){
			this.x = x;
			this.y = y;
			this.dibuPelota = Herramientas.cargarImagen("Pelota.png");
		}
		
		public void dibujar(Entorno e){
			e.dibujarImagen(this.dibuPelota, this.x, this.y, 0);
		}
		
		public void golpear (double angulo , double fuerza) {
			this.velocidadEnX = (Math.cos(angulo) * fuerza);
			this.velocidadEnY = (Math.sin(angulo) * fuerza);
		}
		
		public boolean seEstaMoviendo() {
			if (this.velocidadEnX == 0 && this.velocidadEnY == 0) {
				return false;
			}
			else {
				this.x = this.x + this.velocidadEnX; // (Math.cos(angulo) * fuerza);
				this.velocidadEnX = this.velocidadEnX * 0.995;
				this.y = this.y + this. velocidadEnY; //(Math.sin(angulo) * fuerza);
				this.velocidadEnY = this.velocidadEnY * 0.995;
				if (this.x > 770 || this.x < 33) {
					this.velocidadEnX = -this.velocidadEnX; 
				}
				if (this.y > 570 || this.y < 93){
					this.velocidadEnY =  -this.velocidadEnY;
				}
				if (this.velocidadEnX < 0.0055 && this.velocidadEnX > -0.0055) {
					this.velocidadEnX = 0;
				}
				if (this.velocidadEnY < 0.0055 && this.velocidadEnY > -0.0055) {
					this.velocidadEnY = 0;
				}
				return true;
			}
		}
		
		public boolean estaCercaDeHoyo(double x , double y){
			if ((this.x - x < 22 && this.x - x > -22) && (this.y - y < 22 && this.y - y > -22) && this.velocidadEnX < 0.45 && this.velocidadEnY < 0.45){
				return true;
			}
			return false;
		}
		
		public void moverHaciaHoyo(double xDelHoyo , double yDelHoyo) {
			this.velocidadEnX = (xDelHoyo - this.x) * 0.02;
			this.velocidadEnY = (yDelHoyo - this.y) * 0.02;
		}
		
		public boolean estaEnTrampaDeArena(double x , double y){
			if ((this.x - x < 30 && this.x - x > -30) && (this.y - y < 30 && this.y - y > -30)){
				System.out.println("ENTRE EN ARENA");
				return true;
			}
			return false;
		}
		
		public void disminuirVelocidad(){
			this.velocidadEnX = this.velocidadEnX * 0.9;
			this.velocidadEnY = this.velocidadEnY * 0.9;
		}
		
		public boolean estaEnTrampaDeAgua(double x , double y){
			if ((this.x - x < 40 && this.x - x > -40) && (this.y - y < 40 && this.y - y > -40)){
				System.out.println("ENTRE EN AGUA");
				return true;
			}
			return false;
		}
		
		public void reaparecer(double x , double y){
			this.x = x;
			this.y = y;
			this.velocidadEnX = 0;
			this.velocidadEnY = 0;
		}
		
		public double getX() {
			return this.x;
		}
		
		public double getY() {
			return this.y;
		}
		
		public double getVelX() {
			return this.velocidadEnX;
		}
		
		public double getVelY() {
			return this.velocidadEnY;
		}

}
