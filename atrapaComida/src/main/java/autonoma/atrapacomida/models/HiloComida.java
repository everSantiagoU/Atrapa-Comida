/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import java.util.Iterator;
import java.util.Random;

/**
 * Hilo encargado de generar y mover las comidas que caen en el juego.
 *
 * @author Santiago
 * @since 21-05-2025
 * @version 1.0
 */
public class HiloComida extends Thread {
    private Juego juego;
    private boolean activo = true;
    private Random rand = new Random();

    /**
     * Constructor del hilo de comida.
     * @param juego referencia al juego principal
     */
    public HiloComida(Juego juego) {
        this.juego = juego;
    }

    /**
     * Detiene la ejecución del hilo.
     */
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
                    c.moverAbajo(2);
                    if (c.getY() > 500) {
                        it.remove();
                    }
                }
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
