/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

/**
 *
 * @author ACER
 */
public class ControladorPuntaje {
    private int puntaje = 0;

    public void sumarPunto() {
        puntaje += 1;
    }

    public void restarDosPuntos() {
        puntaje -= 2;
    }

    public int getPuntaje() {
        return puntaje;
    }
}