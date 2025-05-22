/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import javax.swing.ImageIcon;
/**
 * Representa un elemento de tipo veneno que cae en el juego.
 *
 * @author Santiago
 * @since 21-05-2025
 * @version 1.0
 */
public class Veneno extends Elemento {

    private ImageIcon imagen;

    /**
     * Constructor de Veneno.
     * @param x posición horizontal inicial
     * @param y posición vertical inicial
     */
    public Veneno(int x, int y) {
        super(x, y);
        this.imagen = new ImageIcon(getClass().getResource("/autonoma/atrapacomida/images/cigarette.png"));
    }

    /**
     * Obtiene la imagen asociada al veneno.
     * @return ImageIcon del veneno
     */
    public ImageIcon getImagen() {
        return imagen;
    }
}

