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
        // Suponemos que cada elemento tiene un tamaño de 30x30 px
        return clicX >= x && clicX <= x + 30 &&
               clicY >= y && clicY <= y + 30;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}