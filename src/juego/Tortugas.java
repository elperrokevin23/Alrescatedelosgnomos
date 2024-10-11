package juego;
import java.awt.Color;
import java.util.Random;
import entorno.Entorno;

public class Tortugas {
	private int x, y;
    private int ancho;
    private int alto;
    private int velocidadVertical;
    private int velocidadHorizontal;
    private boolean cayendo;
    private boolean enIsla;
    private boolean moviendoseIzquierda;
    
    private static final int VELOCIDAD_CAIDA = 3;
    private static final int VELOCIDAD_LATERAL = 5;
    
    public Tortugas(int limiteIzquierdo, int limiteDerecho, Isla primeraIsla) {
        Random random = new Random();
        this.ancho = 20;
        this.alto = 20;
        this.velocidadVertical = VELOCIDAD_CAIDA;
        this.velocidadHorizontal = VELOCIDAD_LATERAL;
        this.cayendo = true;
        this.enIsla = false;
        
        // Genera una posición aleatoria para x, pero que no esté sobre la primera isla
        do {
            this.x = random.nextInt(limiteDerecho - limiteIzquierdo) + limiteIzquierdo;
        } while (this.x + ancho / 2 >= primeraIsla.getX() - primeraIsla.getAncho() / 2 &&
                 this.x - ancho / 2 <= primeraIsla.getX() + primeraIsla.getAncho() / 2);

        this.y = 0; // Aparece en el borde superior
    }

    public void actualizar(Isla[] islas, Pep pep) {
        if (cayendo) {
            y += velocidadVertical;
            
            // Verifica si el cuadrado ha caído sobre alguna isla
            for (Isla isla : islas) {
                if (this.y + this.alto / 2 >= isla.getY() - isla.getAlto() / 2 &&
                    this.y - this.alto / 2 <= isla.getY() + isla.getAlto() / 2 &&
                    this.x + this.ancho / 2 >= isla.getX() - isla.getAncho() / 2 &&
                    this.x - this.ancho / 2 <= isla.getX() + isla.getAncho() / 2) {
                    cayendo = false;
                    enIsla = true;
                    break;
                }
            }
        } else if (enIsla) {
            // Mueve el cuadrado de lado a lado en la isla
            if (moviendoseIzquierda) {
                x -= velocidadHorizontal;
                if (x - ancho / 2 <= islas[0].getX() - islas[0].getAncho()*2) {
                    moviendoseIzquierda = false; // Cambia dirección al llegar al borde izquierdo
                }
            } else {
                x += velocidadHorizontal;
                if (x + ancho / 2 >= islas[0].getX() + islas[0].getAncho()*2)  {
                    moviendoseIzquierda = true; // Cambia dirección al llegar al borde derecho
                }
            }
        }

        // Verifica colisión con Pep
        if (this.y + this.alto / 2 >= pep.getY() - pep.getAlto() / 2 &&
            this.y - this.alto / 2 <= pep.getY() + pep.getAlto() / 2 &&
            this.x + this.ancho / 2 >= pep.getX() - pep.getAncho() / 2 &&
            this.x - this.ancho / 2 <= pep.getX() + pep.getAncho() / 2) {
            // Aniquila a Pep (debes definir cómo manejar esto en tu juego, por ejemplo, eliminando al cuadrado)
            System.out.println("¡Pep ha sido aniquilado por un cuadrado venenoso!");
        }
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.red);
    }

    // Getters para obtener las dimensiones del cuadrado (pueden ser útiles para colisiones)
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getAncho() { return this.ancho; }
    public int getAlto() { return this.alto; }
}
