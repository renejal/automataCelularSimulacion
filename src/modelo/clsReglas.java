
package modelo;

import java.util.ArrayList;

public class clsReglas {
   private ArrayList atrColReglas = new ArrayList();
   public clsReglas(int parRegla){
       this.AsignarReglas(parRegla);
   }
   private void AsignarReglas(int parNumRegla){
        atrColReglas = convertirBinario(parNumRegla);
       
   }
   private ArrayList convertirBinario(int parNumRegla){
      ArrayList varColReglas = new ArrayList();
      int contador  = 0;
      if(parNumRegla > 0)
      {
        while(parNumRegla > 0){
            if (parNumRegla % 2 == 0){
                varColReglas.add(0);
            }
            else{
                varColReglas.add(1);
            }
            contador++;
            parNumRegla = parNumRegla /2;
        }
        
      }else if(parNumRegla == 0){ varColReglas.add(0);}
      while(contador<8){
          varColReglas = this.addInicio(contador,varColReglas);
          contador++;
      }
            return this.invertir(varColReglas);
         
   } 
   private ArrayList addInicio(int parValor, ArrayList parArreglo){
       ArrayList temp = inicializar();
       for (int i = 0; i < parArreglo.size(); i++) {
          temp.set(i,parArreglo.get(i));
       }
       return temp;
       
   }
   private ArrayList invertir(ArrayList parArray){
       ArrayList temp = new ArrayList();
       for (int i = parArray.size(); i > 0; i--) {
           temp.add(parArray.get(i-1));
       }
       return temp;
   }
   private ArrayList inicializar(){
       ArrayList parCol = new ArrayList();
       for (int i = 0; i < 8; i++) {
           parCol.add(0);
           
       }
       return parCol;
   }
   public ArrayList getColReglas(){
       return atrColReglas;
   }
   
}
