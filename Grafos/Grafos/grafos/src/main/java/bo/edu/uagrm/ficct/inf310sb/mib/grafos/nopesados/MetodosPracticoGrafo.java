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
public class MetodosPracticoGrafo extends Grafo {
    protected DFS dfs;
    
     public int cantDeIslas(Grafo grafo){
           // boolean estaTodoMarcado= false;
          //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
        
        int cantIslas=0;
         int verticeDeProceso=0; 
        dfs= new DFS(grafo, verticeDeProceso);
       while(!dfs.controlMarcados.estanTodosMarcados()){
           dfs.continuarDFS(verticeDeProceso);
        cantIslas++;
        if(dfs.controlMarcados.estanTodosMarcados()){
        return cantIslas;
        }
        verticeDeProceso= definirVerticeNoMarcado(grafo,verticeDeProceso);
        }
        return cantIslas;
        }
       private int definirVerticeNoMarcado(Grafo unGrafo,int verticeDeProceso){
         //dfs= new DFS(unGrafo, verticeDeProceso);
         //UtilsRecorridos controlMarcados= new UtilsRecorridos(unGrafo.cantidadDeVertices());
       while( verticeDeProceso<unGrafo.cantidadDeVertices()) {
        if (dfs.controlMarcados.estaMarcado(verticeDeProceso)==true){
            verticeDeProceso++;
        }else{
        break;
        }
        }
       return verticeDeProceso;
       }
       
       public List<Integer> verticesConCiclo(Grafo grafo){
           List<Integer> listaDeVertices= new ArrayList<>();
       for (int posVertice =0; posVertice< grafo.cantidadDeVertices(); posVertice++){
        List<Integer> adyacenciasDeVertice= grafo.listasDeAdyacencias.get(posVertice);
        for (int k=0; k < adyacenciasDeVertice.size();k++){
       if(posVertice == adyacenciasDeVertice.get(k) ){
           listaDeVertices.add(posVertice);
      }
       
       }
           }
       return listaDeVertices;
       }
       
       
}
