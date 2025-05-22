/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.atrapacomida.models;
import javax.swing.ImageIcon;
/**
 *
 * @author ACER
 */
public class Veneno extends Elemento {

    private ImageIcon imagen;
    public Veneno(int x, int y) {
        super(x, y);
        this.imagen = new ImageIcon(getClass().getResource("/autonoma/atrapacomida/images/cigarette.png"));
    }

    public ImageIcon getImagen() {
        return imagen;
    }
}

