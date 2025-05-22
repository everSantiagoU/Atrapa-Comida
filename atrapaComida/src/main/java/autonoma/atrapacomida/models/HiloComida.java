/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import java.util.Iterator;
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
            int x = rand.nextInt(400);
            juego.agregarComida(new Comida(x, 0));

            synchronized (juego) {
                Iterator<Comida> it = juego.getComidas().iterator();
                while (it.hasNext()) {
                    Comida c = it.next();
                    c.moverAbajo(2); // Ahora baja de a 2 píxeles
                    if (c.getY() > 500) {
                        it.remove();
                    }
                }
            }

            try {
                Thread.sleep(30); // Más fluido (más pasos por segundo)
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
