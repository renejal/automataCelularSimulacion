
package modelo;

import java.util.ArrayList;

public class clsCelula {
    private ArrayList atrColCelulas = new ArrayList();
    private int atrNumCelulas=0; 
    public clsCelula(int parNumCelulas,ArrayList parEstadosIniciales){
        this.setNumCelulas(parNumCelulas);
        this.inicializar();
        this.posicionesIniciales(parEstadosIniciales);
       
    }
    public ArrayList getColCelulas(){
        return atrColCelulas;
    }
    public void setNumCelulas(int parNumCelulas){
        atrNumCelulas = parNumCelulas;
    }
    public void posicionesIniciales(ArrayList<Integer> parColposiciones){
        for (int i = 0; i < parColposiciones.size(); i++) {
            int item=parColposiciones.get(i);
           atrColCelulas.set(item,1);
        }
    }
    private void inicializar(){
        for (int i = 0; i < atrNumCelulas; i++) {
            atrColCelulas.add(0);
        }
    }
    
}
