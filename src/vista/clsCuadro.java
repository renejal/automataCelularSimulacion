
package vista;

import java.awt.Color;
import javax.swing.JButton;

public class clsCuadro extends JButton {
    private int atrEstado = 0;
    public clsCuadro(){
        super();
    }
    public void cambiarEstado(int parEstado){
        atrEstado = parEstado;
        this.setBackground(Color.black);
    }
}
