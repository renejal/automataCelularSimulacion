package modelo;
import java.util.ArrayList;
public class clsEstado {
     private ArrayList atrListaAuxiliar = new ArrayList();
     private ArrayList atrColEstados = new ArrayList();
    public clsEstado(){
        this.AgregarEstados();
    }
    private void AgregarEstados(){
    atrListaAuxiliar.add(1); atrListaAuxiliar.add(1); atrListaAuxiliar.add(1);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(1); atrListaAuxiliar.add(1); atrListaAuxiliar.add(0);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(1); atrListaAuxiliar.add(0); atrListaAuxiliar.add(1);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(1); atrListaAuxiliar.add(0); atrListaAuxiliar.add(0);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(0); atrListaAuxiliar.add(1); atrListaAuxiliar.add(1);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(0); atrListaAuxiliar.add(1); atrListaAuxiliar.add(0);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(0); atrListaAuxiliar.add(0); atrListaAuxiliar.add(1);
        atrColEstados.add(atrListaAuxiliar);
            atrListaAuxiliar = new ArrayList();
            atrListaAuxiliar.add(0); atrListaAuxiliar.add(0); atrListaAuxiliar.add(0);
        atrColEstados.add(atrListaAuxiliar);
    }
    public ArrayList getAtrColEstado(){
        return atrColEstados;
    }
}
