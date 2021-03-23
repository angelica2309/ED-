/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author HP 240 G5
 */
public class DFS {
     // private List<Boolean> marcados;
    private List<Integer> recorrido;
    //private List<Integer> recorrido2;
    private Grafo grafo;
    protected UtilsRecorridos controlMarcados;
    public DFS (Grafo unGrafo, int posVerticePartida){
        this.grafo= unGrafo;
        grafo.validarVertice(posVerticePartida);
        recorrido= new ArrayList<>();
        controlMarcados= new UtilsRecorridos(grafo.cantidadDeVertices()); 
        controlMarcados.desmarcarTodos();
        continuarDFS(posVerticePartida);
       
    }
    
    public  void continuarDFS(int posVertice){
        controlMarcados.marcarVertice(posVertice);
        recorrido.add(posVertice);
         Iterable<Integer> adyacentesEnTurno= grafo.adyacentesDeVertice(posVertice);
        for(Integer posVerticeAdyacente: adyacentesEnTurno){
            if(!controlMarcados.estaMarcado(posVerticeAdyacente)){
                continuarDFS(posVerticeAdyacente);
            }
        }
    }
    
    public boolean hayCaminoA(int posVertice){
        grafo.validarVertice(posVertice);
        return controlMarcados.estaMarcado(posVertice);
    }
    
    public Iterable <Integer> elRecorrido(){
    return recorrido;
    }  
    public List <Integer> elRecorrido2(){
    return recorrido;
    } 
    public boolean hayCaminoATodos(){
        return controlMarcados.estanTodosMarcados();
    }
    
   /* public int cantDeIslas(Grafo grafo){
           // boolean estaTodoMarcado= false;
          //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
         
        int cantIslas=0;
         int verticeDeProceso=0; 
       
       while(!controlMarcados.estanTodosMarcados()){
           this.continuarDFS(verticeDeProceso);
        cantIslas++;
        if(controlMarcados.estanTodosMarcados()){
        return cantIslas;
        }
        verticeDeProceso= definirVerticeNoMarcado(grafo,verticeDeProceso);
        }
        return cantIslas;
        }
       private int definirVerticeNoMarcado(Grafo unGrafo,int VerticeDeProceso){
         
         //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
       while( VerticeDeProceso<unGrafo.cantidadDeVertices()) {
        if (controlMarcados.estaMarcado(VerticeDeProceso)==true){
            VerticeDeProceso++;
        }else{
        break;
        }
        }
       return VerticeDeProceso;
       } */
       
       /*public int cantIslasDi(Grafo grafo){
       int cantIslas=0;
       int verticeDeProceso=0;
       int c= grafo.cantidadDeVertices();
     //  for(int i= verticeDeProceso; i<grafo.cantidadDeVertices();i++)
       while(verticeDeProceso<grafo.cantidadDeVertices()){
       this.continuarDFS(verticeDeProceso);
       if(controlMarcados.estanTodosMarcados()){
        cantIslas++;
        return cantIslas;
       //verticeDeProceso++;
       
       }
         verticeDeProceso=verticeNoMarcadoConAdyacenteMarcado
                                            (grafo, verticeDeProceso);
          int y=verticeDeProceso;
        if(verticeDeProceso<0){
        cantIslas++;
        verticeDeProceso= definirVerticeNoMarcado(grafo, 0);
        int z=verticeDeProceso;
        }

       }
       return cantIslas;
       }

    private int verticeNoMarcadoConAdyacenteMarcado(Grafo unGrafo,int VerticeDeProceso) {
        boolean adyacenteNoMarcado= false;
      while( VerticeDeProceso<unGrafo.cantidadDeVertices()) {
        if (!controlMarcados.estaMarcado(VerticeDeProceso)){
            Iterable<Integer> adyacentesEnTurno= unGrafo.adyacentesDeVertice(VerticeDeProceso);
            
        for(Integer posVerticeAdyacente: adyacentesEnTurno){
           if(controlMarcados.estaMarcado(posVerticeAdyacente)){
               return VerticeDeProceso;
           }
        }
        
        }
        VerticeDeProceso++;
        }
       return -1;// no econtro verticeNoMarcado
    }
       */
    
}
