/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;

import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido_1;
import java.util.List;

/**
 *
 * @author HP 240 G5
 */
public class Digrafo extends Grafo {
    public Digrafo(){
    }
    
    public Digrafo(int nroDeVerticesInicial) throws ExcepcionNroVerticesInvalido{
        super(nroDeVerticesInicial);
        
    }

    @Override
    public void insertarArista(int posVerticeOrigen, int posVerticeDestino) throws ExcepcionNroVerticesInvalido_1 {
       
        super.validarVertice(posVerticeOrigen);
		super.validarVertice(posVerticeDestino);
                if (super.existeAdyacencia(posVerticeOrigen, posVerticeDestino)){
                  throw new ExcepcionNroVerticesInvalido_1();  //arista ya existe
                  }

		//super.cantAristas++;
		List<Integer>adyacenciasDelOrigen= super.listasDeAdyacencias.get(posVerticeOrigen);
		adyacenciasDelOrigen.add(posVerticeDestino);
    }

    @Override
    public int gradoDeVertice(int posDeVertice) {
      //  return super.gradoDeVertice(posDeVertice); //To change body of generated methods, choose Tools | Templates.
      throw new UnsupportedOperationException("No soportado en grado dirigido");
    }
    public int gradoDeSalida(int posDeVertice){
    return super.gradoDeVertice(posDeVertice);
    }
    public int gradoDeEntrada(int posDeVertice){
        super.validarVertice(posDeVertice);
        int entradasDeVertice=0;
    for(List<Integer> adyacentesDeUnVertice: super.listasDeAdyacencias){
        for (Integer posAdyacente: adyacentesDeUnVertice){
            if (posAdyacente== posDeVertice ){
                entradasDeVertice++;
            }
    }
    }
            return entradasDeVertice;
    }

    @Override
    public int cantidadDeAristas() {
        return super.cantidadDeAristas(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarArista(int posVerticeOrigen, int posVerticeDestino) {
     if (existeAdyacencia(posVerticeOrigen,  posVerticeDestino)){
         List<Integer> adyacenciasDelOrigen= this.listasDeAdyacencias.get(posVerticeOrigen);
         
        
         adyacenciasDelOrigen.remove(adyacenciasDelOrigen.lastIndexOf(posVerticeDestino));
        
        }
    }
    
    public Iterable recorridoBFS(Digrafo unGrafo, int posVertice){
            BFS recorrido= new BFS(unGrafo, posVertice);   
        Iterable<Integer> recorridoBFS= recorrido.elRecorrido();
        return recorridoBFS;
        }
        public Iterable recorridoDFS(Digrafo unGrafo, int posVertice){
            DFS recorrido= new DFS(unGrafo, posVertice);
            
        Iterable<Integer> recorridoDFS= recorrido.elRecorrido();
        return recorridoDFS;
        }
    
    
}
