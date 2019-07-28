
package vista;

import java.awt.Color;
import javax.swing.JButton;

public class clsCuadro extends JButton {
    private int atrEstado = 0;
    private int posX = -1;
    private int posY = -1;
    public clsCuadro(){
        super();
    }
    public void cambiarEstado(){
        if (atrEstado == 1) {
            atrEstado = 0;
            this.setBackground(Color.white);
        }
        else{
            atrEstado = 1;
            this.setBackground(Color.black);
        }

        
    }
    
   public void setPosX(int posX){
       this.posX = posX;
   }
   public void setPosY(int posY){
       this.posY = posY;
   }
   public int getPosX(){
       return this.posX;
   }
   public int getPosY(){
       return this.posY;
   }
   public int getEstado(){
       return atrEstado;
   }
   
}
