/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;

/**
 *
 * @author HP 240 G5
 */
public class Conexo {
    private DFS dfsGrafo;
    public Conexo (Grafo unGrafo){
    dfsGrafo= new DFS(unGrafo,0);
    }
    
    public boolean esConexo(){
        return dfsGrafo.hayCaminoATodos();
    }
}
