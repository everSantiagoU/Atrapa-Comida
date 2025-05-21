/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.views;

/**
 *
 * @author ACER
 */
import autonoma.atrapacomida.models.Comida;
import autonoma.atrapacomida.models.Elemento;
import autonoma.atrapacomida.models.Juego;
import autonoma.atrapacomida.models.Veneno;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PanelJuego extends JPanel {

    private Juego juego;

    public PanelJuego(Juego juego) {
        this.juego = juego;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);

        // Detectar clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                juego.procesarClic(e.getX(), e.getY());
                repaint(); // Actualizar pantalla tras clic
            }
        });

        // Temporizador para refrescar pantalla cada 0.5 seg
        Timer timer = new Timer(500, e -> repaint());
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        List<Elemento> elementos = juego.getTodosLosElementos();

        for (Elemento elem : elementos) {
            if (elem instanceof Comida) {
                g.setColor(Color.GREEN);
            } else if (elem instanceof Veneno) {
                g.setColor(Color.RED);
            }
            g.fillOval(elem.getX(), elem.getY(), 30, 30); // círculo
        }

        // Mostrar puntaje
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Puntaje: " + juego.getPuntaje(), 10, 20);
    }
}