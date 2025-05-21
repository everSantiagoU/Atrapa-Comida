/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

/**
 *
 * @author ACER
 */
import java.util.Random;

public class HiloVeneno extends Thread {
    private Juego juego;
    private boolean activo = true;
    private Random rand = new Random();

    public HiloVeneno(Juego juego) {
        this.juego = juego;
    }

    public void detener() {
        activo = false;
    }

    @Override
    public void run() {
        while (activo) {
            int x = rand.nextInt(400); 
            int y = rand.nextInt(400); 
            juego.agregarVeneno(new Veneno(x, y));
            try {
                Thread.sleep(2000); // cada 2 segundos
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
