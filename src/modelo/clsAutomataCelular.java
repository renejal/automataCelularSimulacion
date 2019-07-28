package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import file.filetxt;

public class clsAutomataCelular {
    private int atrCantidadEvoluciones = 0;
    private clsCelula atrObjCelula = null;
    private clsReglas atrObjRegla= null;
    private clsEstado atrObjEstado = null;
    private int atrMatriz[][] = null;
    private int atrFilas = 0;
    private int atrColumnas = 0;
    
    private filetxt archivo = new filetxt(); 
    
   public clsAutomataCelular(int parNumCelula,int parRegla,int parCantidadEvoluciones, ArrayList parValoresIniciales){
       atrObjCelula = new clsCelula(parNumCelula,parValoresIniciales);
       atrObjRegla = new clsReglas(parRegla);
       atrObjEstado = new clsEstado();
       atrCantidadEvoluciones = parCantidadEvoluciones;
       this.CrearAutomataCelular(atrObjRegla.getColReglas(),atrObjEstado.getAtrColEstado(),atrObjCelula.getColCelulas());
   }
   public clsAutomataCelular(int [][] parMatriz){
        this.atrMatriz = parMatriz;
        this.atrFilas = atrMatriz.length;
        this.atrColumnas = atrMatriz[0].length;
   }
   public int[][] Simular(){
       int[][] matrizAux = new int[atrFilas][atrColumnas];
       //logica de juego de la vida
       for (int i = 0; i < atrMatriz.length; i++) {
           for (int j = 0; j < atrMatriz[0].length; j++) {
               //regla 1 si una celula esta viva entonces y continue viva debe tener dos o tres vecinas vivas
               int numVivas = cantidadVecinasVivas(i, j);
               
                    if(numVivas == 2 || numVivas==3){
                    System.out.println("vive"+"["+i+"]"+"["+j+"]");
                    //queda viva 
                    matrizAux[i][j]=1;
                    }
                    else{
                       System.out.println("muere"+"["+i+"]"+"["+j+"]");
                        matrizAux[i][j]=0;
                   }
               
               //else{
                 //  if (numVivas == 3){
                   //    System.out.println("renace"+"["+i+"]"+"["+j+"]");
                     //  matrizAux[i][j]=1;
                  // }
              // }
               
           }
       }
       
       return matrizAux;
   }
   public int[][] SimularJuegoDelaVida(){
       
       int[][] matrizAux = new int[atrFilas][atrColumnas];
       //logica de juego de la vida
       for (int i = 0; i < atrMatriz.length; i++) {
           for (int j = 0; j < atrMatriz[0].length; j++) {
               //regla 1 si una celula esta viva entonces y continue viva debe tener dos o tres vecinas vivas
               int numVivas = cantidadVecinasVivasjuegoVida(i,j);
               if(atrMatriz[i][j]==1){                   
                    if(numVivas == 2 || numVivas==3){
                    System.out.println("vive"+"["+i+"]"+"["+j+"]");
                    //queda viva 
                    matrizAux[i][j]=1;
                    }
                    else{
                       System.out.println("muere"+"["+i+"]"+"["+j+"]");
                        matrizAux[i][j]=0;
                   }
               }
               else{
                   if (numVivas == 3){
                       System.out.println("renace"+"["+i+"]"+"["+j+"]");
                       matrizAux[i][j]=1;
                   }
               }
               
           }
       }
       return matrizAux;
   }
  private int cantidadVecinasVivas(int posX,int posY){
         int numVivas = 0;
        int filas = atrMatriz.length;
        int columnas = atrMatriz[0].length;
        if(posX-1 > 0 && posY-1 > 0)
        {
            if(atrMatriz[posX-1][posY-1]==1){
                numVivas++;
            }
        }
        if (posX+1 < columnas && posY-1 > 0)
        {
           if(atrMatriz[posX+1][posY-1]==1){
                numVivas++;
            }
        }
        if (posX-1 > 0 && posY+1 < filas)
        {
           if(atrMatriz[posX-1][posY+1]==1){
                numVivas++;
            }
        }
         if (posX+1 < columnas && posY+1 < filas)
        {
           if(atrMatriz[posX+1][posY+1]==1){
                numVivas++;
            }
        }
         return numVivas;
    } 
  private int cantidadVecinasVivasjuegoVida(int posX,int posY){
         int numVivas = 0;
        int filas = atrMatriz.length;
        int columnas = atrMatriz[0].length;
        if(posX-1 > 0 && posY-1 > 0)
        {
            if(atrMatriz[posX-1][posY-1]==1){
                numVivas++;
            }
        }
        if (posX+1 < columnas && posY-1 > 0)
        {
           if(atrMatriz[posX+1][posY-1]==1){
                numVivas++;
            }
        }
        if (posX-1 > 0 && posY+1 < filas)
        {
           if(atrMatriz[posX-1][posY+1]==1){
                numVivas++;
            }
        }
         if (posX+1 < columnas && posY+1 < filas)
        {
           if(atrMatriz[posX+1][posY+1]==1){
                numVivas++;
            }
        }
         //laterales
         if (posX+1 < columnas)
        {
           if(atrMatriz[posX+1][posY]==1){
                numVivas++;
            }
        }
          if (posY+1 < filas)
        {
           if(atrMatriz[posX][posY+1]==1){
                numVivas++;
            }
        }
            if (posX-1 > 0)
        {
           if(atrMatriz[posX-1][posY]==1){
                numVivas++;
            }
        }
          if (posY-1 > 0)
        {
           if(atrMatriz[posX][posY-1]==1){
                numVivas++;
            }
        }
         return numVivas;
    } 
   public void CrearAutomataCelular(ArrayList reglas,ArrayList estados,ArrayList parColCelulas){
        archivo.deleteFile("automata.txt");
        atrMatriz = new int[atrCantidadEvoluciones][parColCelulas.size()];
        int posicion = 0, valAux = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList listaEvolucion = this.inicializar(parColCelulas.size());
        ArrayList listaAux = new ArrayList();
         String linea = "";
        
      
        for(int i = 0 ; i < parColCelulas.size(); i++) {
            listaEvolucion.add(0);
        }
        
        for(int i = 0 ; i < atrCantidadEvoluciones ; i++) {
            linea = "";
            System.out.println();
           // atrMatriz.add(parColCelulas);
            //agrega al archivo
            for(int j = 0 ; j < parColCelulas.size() ; j++) {
                valAux = (Integer)parColCelulas.get(j);
                atrMatriz[i][j]=valAux;
                linea  =linea+" "+Integer.toString(valAux);
                System.out.print(valAux);
            }
            archivo.writeFile("automata.txt",linea,true);
            ///
            for(int j = 0 ; j < parColCelulas.size() ; j++) {
                listaAux = new ArrayList();
                    
                if((j-1) < 0) { posicion = parColCelulas.size()-1; }
                else { posicion = j-1; }
                valAux = (Integer)parColCelulas.get(posicion);
                listaAux.add(valAux);
                
                valAux = (Integer)parColCelulas.get(j);
                listaAux.add(valAux);

                if((j+1) >= parColCelulas.size()) { posicion = 0; }
                else { posicion = j+1; }
                valAux = (Integer)parColCelulas.get(posicion);
                listaAux.add(valAux);
                
                for(int k = 0 ; k < estados.size() ; k++) {
                    int igual = 0;
                    ArrayList aux = (ArrayList)estados.get(k);
                    
                    for(int l = 0 ; l < aux.size() ; l++) {
                        int valListReg = (Integer)aux.get(l);
                        int valListAux = (Integer)listaAux.get(l);
                        if(valListReg == valListAux) { igual++; }
                    }
                    
                    if(igual == 3) {
                        valAux = (Integer)reglas.get(k);
                        break;
                    }
                }
                listaEvolucion.set(j, valAux);
            }
            for(int j = 0 ; j < parColCelulas.size(); j++) {
                parColCelulas.set(j, listaEvolucion.get(j));
            }
        }
        System.out.println();
        System.out.println();
    }
   private ArrayList inicializar(int parTamanio){
        ArrayList parColtemp = new ArrayList();
        for (int i = 0; i < parTamanio; i++) {
            parColtemp.add(0);
        }
        return parColtemp;
    }
   public int[][] ObtenerMatriz(){
      return atrMatriz;
   }
}
