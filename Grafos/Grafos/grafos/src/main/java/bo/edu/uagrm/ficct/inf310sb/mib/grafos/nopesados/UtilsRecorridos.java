/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP 240 G5
 */
public class UtilsRecorridos {
    private List<Boolean> marcados;
    private int nroVertices;
    
    public UtilsRecorridos(int nroVertices){
     this.nroVertices= nroVertices;
    }
    
      public void desmarcarTodos(){
        marcados= new ArrayList<>();
        for(int i=0; i<this.nroVertices;i++ ){
            marcados.add(Boolean.FALSE);
            
        }
    }
      public void marcarVertice(int posVertice){
        marcados.set(posVertice, Boolean.TRUE);
    }  
      public boolean estaMarcado(int posVertice){
        return marcados.get(posVertice);
    }
     public boolean estanTodosMarcados(){
        for (Boolean marcado: this.marcados){
        if(!marcado){
            return false;
        }
        }
        return true;
      /* int a= this.nroVertices;
         for (int i=0; i<this.nroVertices-1;i++ ){
             boolean b= marcados.get(i);
        if(!marcados.get(i)){
            return false;
        }
        }
        return true;*/
    }  
    public Iterable <Boolean> marcados(){
    return marcados;
    }
    
    
}
