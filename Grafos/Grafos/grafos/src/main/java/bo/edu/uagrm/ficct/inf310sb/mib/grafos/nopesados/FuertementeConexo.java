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
public class FuertementeConexo {
    private Conexo grafoConexo;
    private boolean esFuertementeConexo;
    
    public FuertementeConexo(Digrafo unDigrafo){
        esFuertementeConexo= true;
        for(int i=0;i<unDigrafo.cantidadDeVertices()&&esFuertementeConexo;i++){
        DFS dfs= new DFS(unDigrafo,i);
        esFuertementeConexo= dfs.hayCaminoATodos();
        }
    this.grafoConexo= new Conexo(unDigrafo);
    }
    
    public boolean esFuertementeConexo(){
        return this.esFuertementeConexo;
    }
}
