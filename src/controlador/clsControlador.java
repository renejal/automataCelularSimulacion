package controlador;
import java.util.ArrayList;
import modelo.clsAutomataCelular;
import modelo.clsCelula;
import modelo.clsEstado;
import modelo.clsReglas;
import vista.index;

public class clsControlador {
    
    public int[][] iniciar(int parCelulas,int parRegla,int parEvoluciones,ArrayList parValoresIniciales){
    
    //40:celulas
    //30:regla
    //16:evoluciones
    //temp: valores iniciales
    clsAutomataCelular objAutomataCelular = new clsAutomataCelular(parCelulas,parRegla,parEvoluciones,parValoresIniciales); 
    return objAutomataCelular.ObtenerMatriz();
    }
    
}
