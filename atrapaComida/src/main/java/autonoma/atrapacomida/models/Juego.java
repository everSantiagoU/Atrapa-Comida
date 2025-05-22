/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Clase principal que gestiona la lógica del juego Atrapa Comida.
 * Controla las listas de comidas y venenos, el puntaje y los hilos de movimiento.
 *
 * @author Juan Diego
 * @since 21-05-2025
 * @version 1.0
 */
public class Juego {
    private List<Comida> comidas = new ArrayList<>();
    private List<Veneno> venenos = new ArrayList<>();
    private ControladorPuntaje controlador = new ControladorPuntaje();
    private HiloComida hiloComida;
    private HiloVeneno hiloVeneno;

    /**
     * Constructor de Juego. Inicializa los hilos de comida y veneno.
     */
    public Juego() {
        hiloComida = new HiloComida(this);
        hiloVeneno = new HiloVeneno(this);
    }

    /**
     * Inicia los hilos para que los elementos comiencen a caer.
     */
    public void iniciarJuego() {
        hiloComida.start();
        hiloVeneno.start();
    }

    /**
     * Detiene los hilos del juego.
     */
    public void detenerJuego() {
        hiloComida.detener();
        hiloVeneno.detener();
    }

    /**
     * Agrega una comida a la lista si hay menos de 4 en pantalla.
     * @param c la comida a agregar
     */
    public synchronized void agregarComida(Comida c) {
        if (comidas.size() < 4) {
            comidas.add(c);
        }
    }

    /**
     * Agrega un veneno a la lista si hay menos de 4 en pantalla.
     * @param v el veneno a agregar
     */
    public synchronized void agregarVeneno(Veneno v) {
        if (venenos.size() < 4) {
            venenos.add(v);
        }
    }

    /**
     * Procesa un clic del usuario, sumando o restando puntos según el elemento.
     * @param x coordenada X del clic
     * @param y coordenada Y del clic
     */
    public synchronized void procesarClic(int x, int y) {
        Iterator<Comida> itC = comidas.iterator();
        while (itC.hasNext()) {
            Comida c = itC.next();
            if (c.esClicDentro(x, y)) {
                controlador.sumarPunto();
                itC.remove();
                return;
            }
        }

        Iterator<Veneno> itV = venenos.iterator();
        while (itV.hasNext()) {
            Veneno v = itV.next();
            if (v.esClicDentro(x, y)) {
                controlador.restarDosPuntos();
                itV.remove();
                return;
            }
        }
    }

    /**
     * Obtiene una lista con todos los elementos (comidas y venenos).
     * @return lista de elementos en pantalla
     */
    public synchronized List<Elemento> getTodosLosElementos() {
        List<Elemento> todos = new ArrayList<>();
        todos.addAll(comidas);
        todos.addAll(venenos);
        return todos;
    }

    /**
     * Obtiene el puntaje actual del juego.
     * @return puntaje
     */
    public int getPuntaje() {
        return controlador.getPuntaje();
    }

    /**
     * Obtiene la lista de venenos.
     * @return lista de venenos
     */
    public synchronized List<Veneno> getVenenos() {
        return venenos;
    }

    /**
     * Obtiene la lista de comidas.
     * @return lista de comidas
     */
    public synchronized List<Comida> getComidas() {
        return comidas;
    }
}
