package controlador;
import file.filetxt;
import java.util.ArrayList;
import modelo.clsAutomataCelular;
import modelo.clsCelula;
import modelo.clsEstado;
import modelo.clsReglas;
import vista.index;

public class clsControlador {
    filetxt file = new filetxt();
    public int[][] iniciarAtomataCelular(int parCelulas,int parRegla,int parEvoluciones,ArrayList parValoresIniciales){
    
    //40:celulas
    //30:regla
    //16:evoluciones
    //temp: valores iniciales
    clsAutomataCelular objAutomataCelular = new clsAutomataCelular(parCelulas,parRegla,parEvoluciones,parValoresIniciales); 
    return objAutomataCelular.ObtenerMatriz();
    }
    public int[][] RealizarSimulacion(int[][] parMatriz){
        clsAutomataCelular obj = new clsAutomataCelular(parMatriz);
        return obj.Simular();
    }
    public int[][] RealizarSimulacionJuegoVida(int[][] parMatriz){
        clsAutomataCelular obj = new clsAutomataCelular(parMatriz);
        return obj.SimularJuegoDelaVida();
    }
    public void guardarAutomata(int[][] parMatriz,String parNombre){
        file.deleteFile(parNombre);
        
        for (int i = 0; i < parMatriz.length; i++) {
            String varlinea = "";
            for (int j = 0; j < parMatriz[0].length; j++) {
              
               varlinea = varlinea +" "+Integer.toString (parMatriz[i][j]);
            }
              file.writeFile(parNombre,varlinea,true);
        }
    }
}
