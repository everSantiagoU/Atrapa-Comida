/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

/**
 *
 * @author ACER
 */
import java.util.Iterator;
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
            juego.agregarVeneno(new Veneno(x, 0));

            synchronized (juego) {
                Iterator<Veneno> it = juego.getVenenos().iterator();
                while (it.hasNext()) {
                    Veneno v = it.next();
                    v.moverAbajo(2); // Ahora baja de a 2 píxeles
                    if (v.getY() > 500) {
                        it.remove();
                    }
                }
            }

            try {
                Thread.sleep(30); // Más fluido
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
