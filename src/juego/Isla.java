package juego;

import java.awt.Color;
import entorno.Entorno;

public class Isla {
    private int x, y;  // Coordenadas de la isla
    private int ancho, alto;  // Tamaño de la isla

    // Constructor que inicializa la posición y el tamaño de la isla
    public Isla(int x, int y) {
        this.x = x - ancho/2;  // Desplazar la isla a la izquierda 
        this.y = y;
        this.ancho = 100;  // Ancho fijo de la isla
        this.alto = 30;    // Alto fijo de la isla
    }

    // Método para dibujar la isla en el entorno
    public void dibujarse(Entorno entorno) {
        entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.GREEN);
    }

    // Métodos para obtener las coordenadas y tamaño de la isla (si es necesario)
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }
}

 public boolean colision(Pep pep) {
        // Verifica si Pep está sobre la isla
        return pep.getX() + pep.getAncho() / 2 > this.x - this.ancho / 2 &&
               pep.getX() - pep.getAncho() / 2 < this.x + this.ancho / 2 &&
               pep.getY() + pep.getAlto() / 2 > this.y - this.alto / 2 &&
               pep.getY() + pep.getAlto() / 2 < this.y + this.alto / 2;
    }
}




























