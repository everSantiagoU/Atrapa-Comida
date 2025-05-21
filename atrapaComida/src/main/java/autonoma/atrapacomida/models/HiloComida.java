/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class HiloComida extends Thread {
    private Juego juego;
    private boolean activo = true;
    private Random rand = new Random();

    public HiloComida(Juego juego) {
        this.juego = juego;
    }

    public void detener() {
        activo = false;
    }

    @Override
    public void run() {
        while (activo) {
            int x = rand.nextInt(400); // ancho del panel (ajustable)
            int y = rand.nextInt(400); // altura del panel (ajustable)
            juego.agregarComida(new Comida(x, y));
            try {
                Thread.sleep(1500); // cada 1.5 segundos
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
