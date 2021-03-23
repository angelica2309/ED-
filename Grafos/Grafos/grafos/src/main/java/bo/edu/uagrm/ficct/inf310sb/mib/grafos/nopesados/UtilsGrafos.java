/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;

import java.util.ArrayList;

/**
 *
 * @author HP 240 G5
 */
public class UtilsGrafos {
    private DFS dfsGrafo;
    private BFS bfsGrafo;
    private UtilsRecorridos utilsRecorridos;
    private Grafo grafo;
   
    public UtilsGrafos  (Grafo unGrafo){
        this.grafo= unGrafo;
        utilsRecorridos= new UtilsRecorridos(grafo.cantidadDeVertices()); 
        dfsGrafo= new DFS(unGrafo,0);
         bfsGrafo= new BFS(unGrafo, 0);
        // grafo= new Grafo();
        utilsRecorridos.desmarcarTodos();
        
    }
    
     public Iterable recorridoBFS(int posVertice){
         //bfsGrafo= new BFS(grafo, posVertice);
            bfsGrafo.ejecutarBFS(posVertice);
        Iterable<Integer> recorridoBFS= bfsGrafo.elRecorrido();
        return recorridoBFS;
        }
        public Iterable recorridoDFS( int posVertice){
           dfsGrafo.continuarDFS(posVertice);
        Iterable<Integer> recorridoBFS= dfsGrafo.elRecorrido();
        return recorridoBFS;
        }
     public void desmarcarTodos(){
         
     utilsRecorridos.desmarcarTodos();
     }
     public void marcarVertice(int posVertice){
     utilsRecorridos.marcarVertice(posVertice);
     }
     public boolean estaMarcado(int posVertice){
      return utilsRecorridos.estaMarcado(posVertice);
     }
    public boolean  estanTodosMarcados(){
    return utilsRecorridos.estanTodosMarcados();
    }
    /*
     public int cantDeIslas(Grafo grafo){
           // boolean estaTodoMarcado= false;
          //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
        DFS dfsGrafo2= new DFS(grafo,0);
        int cantIslas=0;
         int verticeDeProceso=0; 
       
       while(!utilsRecorridos.estanTodosMarcados()){
           dfsGrafo2.continuarDFS(verticeDeProceso);
        cantIslas++;
        if(utilsRecorridos.estanTodosMarcados()){
        return cantIslas;
        }
        verticeDeProceso= definirVerticeNoMarcado(grafo,verticeDeProceso);
        }
        return cantIslas;
        }
       private int definirVerticeNoMarcado(Grafo unGrafo,int VerticeDeProceso){
         
         //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
       while( VerticeDeProceso<unGrafo.cantidadDeVertices()) {
        if (utilsRecorridos.estaMarcado(VerticeDeProceso)==true){
            VerticeDeProceso++;
        }else{
        break;
        }
        }
       return VerticeDeProceso;
       }*/
}
