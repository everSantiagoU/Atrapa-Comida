/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author juand
 */
public class Juego {
    private List<Comida> comidas = new ArrayList<>();
    private List<Veneno> venenos = new ArrayList<>();
    private ControladorPuntaje controlador = new ControladorPuntaje();
    private HiloComida hiloComida;
    private HiloVeneno hiloVeneno;

    public Juego() {
        hiloComida = new HiloComida(this);
        hiloVeneno = new HiloVeneno(this);
    }

    public void iniciarJuego() {
        hiloComida.start();
        hiloVeneno.start();
    }

    public void detenerJuego() {
        hiloComida.detener();
        hiloVeneno.detener();
    }

    public synchronized void agregarComida(Comida c) {
        if (comidas.size() < 4) {
            comidas.add(c);
        }
    }

    public synchronized void agregarVeneno(Veneno v) {
        if (venenos.size() < 4) {
            venenos.add(v);
        }
    }

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

    public synchronized List<Elemento> getTodosLosElementos() {
        List<Elemento> todos = new ArrayList<>();
        todos.addAll(comidas);
        todos.addAll(venenos);
        return todos;
    }

    public int getPuntaje() {
        return controlador.getPuntaje();
    }

    public synchronized List<Veneno> getVenenos() {
        return venenos;
    }

    public synchronized List<Comida> getComidas() {
        return comidas;
    }
}
