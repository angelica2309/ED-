/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.pesado;

import bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados.Digrafo;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados.UtilsRecorridos;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author HP 240 G5
 */
public class MetodosDigrafoPesado extends DigrafoPesado{
    protected UtilsRecorridos controlMarcados;
    
    
    
    public double[][] matrizDeAdyacencia(DigrafoPesado digrafoP){
         int cantVertices= digrafoP.cantidadDeVertices();
     double matriz[][]= new double[cantVertices][cantVertices];
        for(int i=0; i<cantVertices;i++){
            List<AdyacenteConPeso> adyacencias= digrafoP.listaDeAdyacencias.get(i); 
            for(int j=0; j<adyacencias.size();j++){
                AdyacenteConPeso adyacenciaPeso= adyacencias.get(j);    
                matriz[i][adyacenciaPeso.getIndiceVertice()]=adyacenciaPeso.getPeso() ;
                 
     } 
     }
        
        return matriz;
    }
    
     public void imprimirMatriz(double matriz[][], int tamaño){
        for(int i=0; i<tamaño;i++){ 
            System.out.print("|");
            for(int j=0; j<tamaño;j++){
            System.out.print("  "+matriz[i][j]);;
            }
            System.out.println(" |");
     }
     }
     public double pesoArista(int origen, int destino, DigrafoPesado digrafoP){
     List<AdyacenteConPeso> adyacencias= digrafoP.listaDeAdyacencias.get(origen); 
     for(int i=0; i< adyacencias.size();i++){
       AdyacenteConPeso adyacenciasDestino= adyacencias.get(i);  
       if(adyacenciasDestino.getIndiceVertice()==destino){
       return adyacenciasDestino.getPeso();
       }
     }
     return -1;
     }
     public double[][] matrizDeCostos(DigrafoPesado digrafoP, int vertice){
         int cantVertices= digrafoP.cantidadDeVertices();
     double matriz[][]= new double[cantVertices][cantVertices];
        for(int i=0; i<cantVertices;i++){
            List<AdyacenteConPeso> adyacencias= digrafoP.listaDeAdyacencias.get(i); 
            for(int j=0; j<adyacencias.size();j++){
                AdyacenteConPeso adyacenciaPeso= adyacencias.get(j);   
                if(i==vertice){
                 matriz[i][adyacenciaPeso.getIndiceVertice()]=0;
                }
                matriz[i][adyacenciaPeso.getIndiceVertice()]=2147483647;      
                 
     } 
     }
        
        return matriz;
    }
   
     
     
     public void calc(int n,int s, DigrafoPesado grafoP)
        {
         double matrizPesos[][];
         matrizPesos= this.matrizDeAdyacencia(grafoP);
         int[] marcado = new int[n];
         int i,minpos=1,k,c;
         double minimum;
         double distancia[]= new double[n];
         for(i=0;i<n;i++)
         {  
             marcado[i]=0; 
                distancia[i]=matrizPesos[s][i]; 
                
         }
         c=0;
         while(c<n)
         {
          minimum=122000;
          for(k=0;k<n;k++)
          {     
              double y=distancia[k];
                 if(distancia[k]<minimum && marcado[k]!=1)
              {
               minimum=distancia[i-1];
               minpos=i-1;
              }
             } 
                   marcado[minpos]=1;
             c++;
             for(k=0;k<n;k++){
              if(distancia[minpos] + matrizPesos[minpos][k] <  distancia[k] && marcado[k]!=1 )
              distancia[k]=distancia[minpos]+matrizPesos[minpos][k];
              
          }   
         } 
         
            for(int j=0; j<n;j++){
            System.out.print("  "+distancia[j]);
            }
        }
     
     
     public Stack algoritmoDijkstra(int posOrigen,int posDestino, DigrafoPesado digrafoP){
        Stack recorrido=new Stack<>();
        List<Double> costos=inicializaCosto(digrafoP.cantidadDeVertices());
        List<Integer> predecesores=inicializaPredecesores(digrafoP.cantidadDeVertices());
        int posMenorCosto=posOrigen;
         actualizarCosto(costos,posOrigen,0);
         controlMarcados= new UtilsRecorridos(digrafoP.cantidadDeVertices());
          controlMarcados.desmarcarTodos();
        while(!controlMarcados.estaMarcado(posMenorCosto)){
          List<AdyacenteConPeso> adyacencia=digrafoP.listaDeAdyacencias.get(posMenorCosto);
          controlMarcados.marcarVertice(posMenorCosto);
            for (int i = 0; i < adyacencia.size(); i++) {
                if(!controlMarcados.estaMarcado(adyacencia.get(i).getIndiceVertice())){
                    double costoA=costos.get(adyacencia.get(i).getIndiceVertice());
                    double costoV=costos.get(posMenorCosto);
                    double costoVA=adyacencia.get(i).getPeso();
                     if(costoA>costoV+costoVA){
                         actualizarCosto(costos,adyacencia.get(i).getIndiceVertice(),costoV+costoVA);
                        
                         int x=adyacencia.get(i).getIndiceVertice();
                         double y=costos.get(adyacencia.get(i).getIndiceVertice());
                         actualizarPredecesores(predecesores, adyacencia.get(i).getIndiceVertice(),
                                 posMenorCosto);
                         
                     }     
            }
        }
        posMenorCosto=posicionCostoMenor(costos);
      double c= costos.get(posMenorCosto);
     }
      int k=posDestino;
        while(k!=posOrigen){
            recorrido.add(k);
            k=predecesores.get(k);
        }
        recorrido.add(posOrigen);
        System.out.println("Costo= "+ costos.get(posMenorCosto));
        return recorrido; 
     }

    private List<Double> inicializaCosto(int cantVertices) {
        List<Double> costos= new ArrayList<>();
        for(int i=0; i<cantVertices;i++ ){
        costos.add(2147483647.0);
        }
        return costos;
    }

    private List<Integer> inicializaPredecesores(int cantVertices) {
       
     List<Integer> predecesores= new ArrayList<>();
        for(int i=0; i<cantVertices;i++ ){
        predecesores.add(-1);
        }
        return predecesores;
    }

    private void actualizarCosto(List<Double> costos, int posOrigen, double valor) {
         
        costos.set(posOrigen, valor);
        
    }

    private void actualizarPredecesores(List<Integer> predecesores, int indiceVertice, int posMenorCosto) {
      
        predecesores.set(indiceVertice,posMenorCosto);
        
        
    }

    private int posicionCostoMenor(List<Double> costos) {
        double menor=2147483647;
        for(int i=0; i<costos.size(); i++){
         if(costos.get(i)!=0){  
        if(costos.get(i)<menor){
            menor=costos.get(i);
        }
         }
        }
        return costos.indexOf(menor);
    }
     
}
