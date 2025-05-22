package autonoma.atrapacomida;

import autonoma.atrapacomida.views.MenuPrincipal;

/**
 *
 * @author juand
 */
public class AtrapaComida {

    public static void main(String[] args) {
        // Crear y mostrar el menú principal
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}
