/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;

import javax.swing.ImageIcon;

/**
 * Representa un elemento de tipo comida que cae en el juego.
 *
 * @author Santiago
 * @since 21-05-2025
 * @version 1.0
 */
public class Comida extends Elemento {
    private ImageIcon imagen;

    /**
     * Constructor de Comida.
     * @param x posición horizontal inicial
     * @param y posición vertical inicial
     */
    public Comida(int x, int y) {
        super(x, y);
        this.imagen = new ImageIcon(getClass().getResource("/autonoma/atrapacomida/images/Gerald-G-Fast-Food-Lunch-Dinner-.png"));
    }

    /**
     * Obtiene la imagen asociada a la comida.
     * @return ImageIcon de la comida
     */
    public ImageIcon getImagen() {
        return imagen;
    }

   
}
