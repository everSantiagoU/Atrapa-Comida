/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

/**
 * Clase abstracta que representa un elemento que cae en el juego.
 * Puede ser Comida o Veneno.
 *
 * @author Santiago
 * @since 1.0
 * @version 1.0
 */
public abstract class Elemento {
    protected int x;
    protected int y;

    /**
     * Constructor de Elemento.
     * @param x posición horizontal inicial
     * @param y posición vertical inicial
     */
    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Verifica si un clic está dentro del área del elemento.
     * @param clicX coordenada X del clic
     * @param clicY coordenada Y del clic
     * @return true si el clic está dentro del área, false en caso contrario
     */
    public boolean esClicDentro(int clicX, int clicY) {
        return clicX >= x && clicX <= x + 100 &&
               clicY >= y && clicY <= y + 100;
    }

    /**
     * Obtiene la posición horizontal del elemento.
     * @return coordenada X
     */
    public int getX() { return x; }

    /**
     * Obtiene la posición vertical del elemento.
     * @return coordenada Y
     */
    public int getY() { return y; }

    /**
     * Mueve el elemento hacia abajo.
     * @param velocidad cantidad de píxeles a mover
     */
    public void moverAbajo(int velocidad) {
        this.y += velocidad;
    }
}