package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;
import java.util.ArrayList;
import java.util.List;

import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido_1;
//import java.util.Collections;

public class Grafo {
	//protected int cantAristas; // si se quiere calcular quitar la variable y calcular cada vez
	protected List<List<Integer>> listasDeAdyacencias;
	//private UtilsRecorridos utilsRecorridos;
	public Grafo() {
		this.listasDeAdyacencias= new ArrayList<>();
            
		//this.cantAristas=0;
	}
	public Grafo(int nroDeVerticesInicial) throws ExcepcionNroVerticesInvalido   {
		if (nroDeVerticesInicial<0) {
			throw new ExcepcionNroVerticesInvalido ();
		}
		this.listasDeAdyacencias= new ArrayList<>();
		//this.cantAristas=0;
		for (int i=0; i<nroDeVerticesInicial;i++) {
			this.listasDeAdyacencias.add(new ArrayList<>());
		}
	}
	public void insertarVertice() {
	this.listasDeAdyacencias.add(new ArrayList<>());	
	}
	public int cantidadDeAristas() {
                int cantAristas=0;
                int cantLazos=0;
                for(int i=0;i<this.listasDeAdyacencias.size(); i++){
                    List<Integer>adyacentesDeUnVertice= this.listasDeAdyacencias.get(i);
                for (Integer posAdyacente: adyacentesDeUnVertice){
                   if(i==posAdyacente){ 
                cantAristas++;
                   }
                }
                }
                cantAristas= (cantAristas/2)+ cantLazos;
		return cantAristas;
	}
	public int cantidadDeVertices() {
		return listasDeAdyacencias.size();
	}
	protected void validarVertice(int posicionDeVertice) {
		if (posicionDeVertice<0||
			posicionDeVertice>= cantidadDeVertices()) {
			throw new IllegalArgumentException ("El vertice" + posicionDeVertice+
					"no pertenece al grafo");
		}
	}
	public void insertarArista(int posVerticeOrigen, int posVerticeDestino)throws ExcepcionNroVerticesInvalido_1 {
		validarVertice(posVerticeOrigen);
		validarVertice(posVerticeDestino);
                if (this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)){
                  throw new ExcepcionNroVerticesInvalido_1();  //arista ya existe
                  }

		//this.cantAristas++;
		List<Integer>adyacenciasDelOrigen= this.listasDeAdyacencias.get(posVerticeOrigen);
		adyacenciasDelOrigen.add(posVerticeDestino);
                //Collections.sort(adyacenciasDelOrigen); para ordenar
		if (posVerticeOrigen!=posVerticeDestino) {
			List<Integer>adyacenciasDelDestino= this.listasDeAdyacencias.get(posVerticeDestino);
			adyacenciasDelDestino.add(posVerticeOrigen);
		}
	}
	
	public boolean existeAdyacencia(int posVerticeOrigen, int posVerticeDestino) {
		validarVertice(posVerticeOrigen);
		validarVertice(posVerticeDestino);
		List<Integer> adyacenciasDelOrigen= this.listasDeAdyacencias.get(posVerticeOrigen);
                 
               return adyacenciasDelOrigen.contains(posVerticeDestino);
                
	}
        
        public void eliminarVertice(int posVerticeAEliminar){
        validarVertice(posVerticeAEliminar);
        this.listasDeAdyacencias.remove(posVerticeAEliminar);
        for(List<Integer> adyacentesDeVertice : this.listasDeAdyacencias){
        int posicionDeVerticeEnAdy= adyacentesDeVertice.indexOf(posVerticeAEliminar);
        if(posicionDeVerticeEnAdy>=0){
        adyacentesDeVertice.remove(posicionDeVerticeEnAdy);      
        }
        for (int i=0 ; i<adyacentesDeVertice.size(); i++){
            int posicionAdyacente= adyacentesDeVertice.get(i);
            if(posicionAdyacente>posVerticeAEliminar){
            adyacentesDeVertice.set(i, posicionAdyacente -1);
                    }
                }
            }
        //recalcular la cantidad de aristas que quedan al eliminar el vertice y arista
        }
        //hacer eliminar arista
        public void eliminarArista(int posVerticeOrigen, int posVerticeDestino){
        //hacer
        if (existeAdyacencia(posVerticeOrigen,  posVerticeDestino)){
         List<Integer> adyacenciasDelOrigen= this.listasDeAdyacencias.get(posVerticeOrigen);
         List<Integer> adyacenciasDelDestino= this.listasDeAdyacencias.get(posVerticeDestino);
        
         adyacenciasDelOrigen.remove(adyacenciasDelOrigen.lastIndexOf(posVerticeDestino));
         adyacenciasDelDestino.remove(adyacenciasDelDestino.lastIndexOf(posVerticeOrigen));
        }
      
        }
        
        public int gradoDeVertice(int posDeVertice){
        validarVertice(posDeVertice);
        List<Integer> adyacenciasDelVertice= this.listasDeAdyacencias.get(posDeVertice);
        return adyacenciasDelVertice.size();
        }
        public Iterable<Integer> adyacentesDeVertice(int posDeVertice){
        validarVertice(posDeVertice);
        List<Integer> adyacenciasDelVertice = this.listasDeAdyacencias.get(posDeVertice);
        Iterable<Integer> it = adyacenciasDelVertice;
        return it;
        }
        public Iterable recorridoBFS(Grafo unGrafo, int posVertice){
            BFS recorrido= new BFS(unGrafo, posVertice);   
        Iterable<Integer> recorridoBFS= recorrido.elRecorrido();
        return recorridoBFS;
        }
        public Iterable recorridoDFS(Grafo unGrafo, int posVertice){
            DFS recorrido= new DFS(unGrafo, posVertice);
            
        Iterable<Integer> recorridoDFS= recorrido.elRecorrido();
        return recorridoDFS;
        }
        
	}
