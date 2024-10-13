package juego;
import java.awt.Color;

import entorno.Entorno;

public class Pep {
	private int x, y;
	private int ancho;
	private int alto;
	private double velocidadVertical;
    private boolean enSalto;
    private static final double GRAVEDAD = 0.5;
    private static final int ALTURA_SALTO = 120;
	public Pep(int x, int y) 
	{
		this.x = x;
		this.y = y;
		this.ancho = 10;
		this.alto = 70;
		this.enSalto = false;
        this.velocidadVertical = 0;
	}

	public void moverIzquierda() 
	{
        if (!enSalto) { // Solo se mueve si no está en salto
            this.x -= 3;
        }
    }
	
	public void moverDerecha() 
	{
		if (!enSalto) { // Solo se mueve si no está en salto
            this.x += 3;
        }
    }
	public void saltar() {
        if (!enSalto) {
            velocidadVertical = -ALTURA_SALTO / 10; // Ajusta el salto
            enSalto = true;
        }
    }
	public void actualizar() {
        // Aplica la gravedad si está en salto
        if (enSalto) {
            y += velocidadVertical;
            velocidadVertical += GRAVEDAD;

            // Verifica si Pep ha aterrizado
            if (y >= 450) { // Nivel del suelo o la plataforma
                y = 450; // Asegúrate de que se quede en el nivel del suelo
                enSalto = false; // Ya no está en salto
                velocidadVertical = 0;
            }
        }
    }

	public void dibujarse(Entorno entorno) 
	{
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.red);
	}
	
	public int getX() 
	{
		return this.x;
	}
	public int getY() 
	{
		return this.y;
	}
	public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
	public void actualizar(Isla isla) {
    // Aplica la gravedad si está en salto
    if (enSalto) {
        y += velocidadVertical;
        velocidadVertical += GRAVEDAD;

        // Verifica si Pep ha aterrizado
        if (isla.colision(this)) {
            y = isla.getY() - getAlto() / 2; // Asegúrate de que se quede en la parte superior de la isla
            enSalto = false; // Ya no está en salto
            velocidadVertical = 0;
        }
    }
}
}

