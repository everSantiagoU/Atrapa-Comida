/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

/**
 *
 * @author ACER
 */
public abstract class Elemento {
    protected int x;
    protected int y;

    public Elemento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean esClicDentro(int clicX, int clicY) {
        // Cambia el tamaño del área de colisión a 50x50 px
        return clicX >= x && clicX <= x + 100 &&
               clicY >= y && clicY <= y + 100;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void moverAbajo(int velocidad) {
        this.y += velocidad;
    }
}