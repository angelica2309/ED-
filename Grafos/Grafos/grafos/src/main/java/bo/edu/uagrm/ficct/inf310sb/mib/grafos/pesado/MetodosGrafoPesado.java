/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.pesado;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author HP 240 G5
 */
public class MetodosGrafoPesado extends GrafoPesado{
    
      public double pesoArista(int origen, int destino, GrafoPesado grafoP){
     List<AdyacenteConPeso> adyacencias= grafoP.listaDeAdyacencias.get(origen); 
     for(int i=0; i< adyacencias.size();i++){
       AdyacenteConPeso adyacenciasDestino= adyacencias.get(i);  
       if(adyacenciasDestino.getIndiceVertice()==destino){
       return adyacenciasDestino.getPeso();
       }
     }
     return -1;
     }
      
    public GrafoPesado  ordenarArista(GrafoPesado grafoP){
     GrafoPesado auxOrdenado= grafoP;
     
    return auxOrdenado;
    }
    
}
