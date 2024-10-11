package juego;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends InterfaceJuego
{
	private Entorno entorno;
	// otras variables del juego aqui
	Image imgFondo;
	double anguloFondo;
	Isla[] islas;
	Pep pep;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Navecitas-Grupo Nr.", 1280, 720);
		this.entorno.colorFondo(Color.CYAN);
		pep = new Pep(400,450);
		inicializarIslas();  // Método para crear las islas
	    this.entorno.iniciar();
	}

private void inicializarIslas() {
	int totalIslas = 15;  // Total de islas a crear
    islas = new Isla[totalIslas];  // Crea un arreglo de islas
    int islaCount = 0;  // Contador de islas creadas

    // Fila 1: 1 isla
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(640, 100);  // Isla en el centro de la fila superior
    }

    // Fila 2: 2 islas
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(540, 200);  // Isla izquierda
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(740, 200);  // Isla derecha
    }

    // Fila 3: 3 islas
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(440, 300);
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(840, 300);
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(640, 300);
    }
    // Fila 4: 4 islas
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(340, 400); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(540, 400); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(940, 400);
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(740, 400);
    }
    // Fila 5: 5 islas
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(240, 500); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(440, 500); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(640, 500); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(840, 500); 
    }
    if (islaCount < totalIslas) {
        islas[islaCount++] = new Isla(1040, 500); 
    }
    
	}

public void tick()
	{
	entorno.escribirTexto("Barra.x: " + pep.getX(), 20, 40);
	entorno.escribirTexto("Barra.y: " + pep.getY(), 20, 60);
	pep.dibujarse(entorno);
	pep.actualizar();
	 for (Isla isla : islas) {
         isla.dibujarse(entorno);
     }


if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
	pep.moverIzquierda();
if (entorno.estaPresionada(entorno.TECLA_DERECHA))
	pep.moverDerecha();
if (entorno.sePresiono(entorno.TECLA_ARRIBA)) {
    pep.saltar();
}
}
public static void main(String[] args)
{
	Juego juego = new Juego();
}
}