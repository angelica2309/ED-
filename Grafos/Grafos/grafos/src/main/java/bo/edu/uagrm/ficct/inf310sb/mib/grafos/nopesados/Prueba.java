/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados;
 

import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.ExcepcionNroVerticesInvalido_1;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.excepciones.*;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.nopesados.*;
import bo.edu.uagrm.ficct.inf310sb.mib.grafos.pesado.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author HP 240 G5
 */
public class Prueba {
    public static void main(String[] argumentos) 
            throws ExcepcionNroVerticesInvalido_1, ExcepcionNroVerticesInvalido,ExcepcionAristaYaExiste
        {
        MetodosPracticoGrafo metodoGrafo= new MetodosPracticoGrafo();
        Grafo  grafo1= new Grafo(6);
       Grafo  grafo2= new Grafo(6);
       grafo1.insertarArista(0,1);
        grafo1.insertarArista(0,2);
        grafo1.insertarArista(1,3);
        grafo1.insertarArista(3,4);
        grafo1.insertarArista(2,5);
        
        grafo1.insertarArista(5,5);
        grafo1.insertarArista(1,1);
        grafo1.eliminarArista(2, 5);
      //  grafo1.eliminarArista(1, 3);
     
      
      Digrafo digrafo1= new Digrafo(7);   
     
      digrafo1.insertarArista(0, 2);
      digrafo1.insertarArista(0,3 );
      digrafo1.insertarArista(1,6 );
      digrafo1.insertarArista(5,1);
     // digrafo1.insertarArista(2,5);
      digrafo1.insertarArista(4,3 );
       digrafo1.eliminarArista(1,6);
      digrafo1.insertarArista(1,1 );
      
        Digrafo digrafo2= new Digrafo(4);
       digrafo2.insertarArista(0, 1);
       digrafo2.insertarArista(0, 2);
       digrafo2.insertarArista(2, 3);
       digrafo2.insertarArista(3, 1);
       
       
       
       MetodosPracticoDigrafo digrafo= new MetodosPracticoDigrafo(); 
      //Practico Grafos
      System.out.println("Practico Grafos");
    //Estudiante: Maria Ines Barrios Barrientos         Registro: 218006403
    /*1. Para un grafo dirigido implementar un método o clase que sea capas de retornar los 
    componentes de las islas que existen en dicho digrafo */
    System.out.println("1. Componentes de las islas: " + digrafo.componentesDeIslasDigrafo(digrafo1));
    /*. 2.Para un grafo dirigido implementar un algoritmo para encontrar si el grafo dirigido tiene 
        ciclos*/
    System.out.println("2. Tiene ciclo: "+ digrafo.hayCiclo(digrafo1) );
    /*3. Para un grafo dirigido implementar un algoritmo para encontrar si es débilmente conexo
    */
   
     System.out.println("3. Es debilmente conexo: "+ digrafo.esDebilmenteConexo(digrafo2) );
     
    /*4.. Para un grafo no dirigido implementar un algoritmo para encontrar que en que vértices del 
    grafo hay ciclos*/
    System.out.println("4. Vertices que tienen ciclo: "+ metodoGrafo.verticesConCiclo(grafo1) );
     
     /*5. Para un grafo no dirigido implementar un algoritmo para encontrar el número de islas que 
            hay en el grafo
     */
       System.out.println("5. CantDeIslas grafo:" + metodoGrafo.cantDeIslas(grafo1));
     /*6. Para un grafo dirigido implementar un algoritmo para encontrar el número de islas que hay 
        en el grafo*/ 
       System.out.println("6.CantDeIslas digrafo: "+ digrafo.cantIslasDi(digrafo1));
      /* 7. Para un grafo dirigido implementar el algoritmo de Wharshall, que luego muestre entre que 
        vértices hay camino */
       
       System.out.println("7. Warshall"); 
       digrafo.algoritmoWarshall(digrafo2);
      /*8. Para un grafo dirigido usando la implementación del algoritmo de Floyd-Wharsall encontrar 
        los caminos de costo mínimo entre un vértice a y el resto. Mostrar los costos y cuáles son 
        los caminos*/
      System.out.println("8.Floyd Warshall"); 
      digrafo.algoritmoFloydWarshall(digrafo2);
      
      /*9. Para un grafo dirigido implementar un algoritmo que retorne cuántas componentes 
    fuertemente conexas hay en dicho grafo. Definimos formalmente un componente 
    fuertemente conectado, C, de un grafo G, como el mayor subconjunto de vértices C (que es 
    un subconjunto de los vértices del grafo G) tal que para cada pareja de vértices v,w
    pertenecen a C tenemos una ruta desde v hasta w y una ruta desde w hasta v.
    */ 
      digrafo2.insertarVertice();
      digrafo2.insertarArista(1, 3);
      digrafo2.insertarArista(3, 4);
      digrafo2.insertarArista(4, 3);
      digrafo2.insertarArista(1, 4);
      digrafo2.insertarArista(4, 1);
      //System.out.println("9. Componentes conexos: "+digrafo.componentesConexos(digrafo2));
      
      /*16. Para un grafo dirigido solo usando como base la lógica de un recorrido (dfs o bfs) encuentre 
        desde que vértices se puede llegar a un vértice a
      */
      Digrafo digrafo3= new Digrafo(5);
       digrafo3.insertarArista(0, 1);
       digrafo3.insertarArista(0, 3);
       digrafo3.insertarArista(1, 4);
       digrafo3.insertarArista(2, 1);
       digrafo3.insertarArista(2, 4);
      digrafo3.insertarArista(3, 1);
      System.out.println("16.Caminos:"+ digrafo.caminosAVertice(digrafo3, 1));
      
      
      
      DigrafoPesado grafoP1=new DigrafoPesado(5);
    
        grafoP1.insertarArista(0,1,10);
        grafoP1.insertarArista(0,4,4);
        grafoP1.insertarArista(1,3,2);
        grafoP1.insertarArista(2,3,1);
        grafoP1.insertarArista(4,1,5);
        grafoP1.insertarArista(3,4,7);
        grafoP1.insertarArista(2,1,3);
        
        MetodosDigrafoPesado digrafoPesado = new MetodosDigrafoPesado();
        int n=grafoP1.cantidadDeVertices();
        double matriz[][];
             matriz=   digrafoPesado.matrizDeAdyacencia(grafoP1);
              System.out.println("Matriz Grafo Pesado: ");
             digrafoPesado.imprimirMatriz(matriz, n);
      
        
      
     /*  10. Para un grafo dirigido pesado implementar el algoritmo de Dijkstra que muestre cual es el 
    camino de costo mínimo entre un vértice a y b y cual el costo */
    //System.out.println("peso " + digrafoPesado.pesoArista(0,3 , grafoP1));
     System.out.println("Recorrido= "+ digrafoPesado.algoritmoDijkstra(0, 1, grafoP1));
     
     /*11. Para un grafo dirigido pesado implementar el algoritmo de Dijkstra que muestre con que 
        vértices hay caminos de costo mínimo partiendo desde un vértice v, con qué costo y cuáles 
        son los caminos.
        */
      digrafoPesado.calc(n, 0, grafoP1);
     
      
     /* 12. Para un grafo no dirigido pesado implementar el algoritmo de Kruskal que muestre cual es 
        el grafo encontrado por el algoritmo*/
     
     
     /*  13. Para un grafo no dirigido pesado implementar el algoritmo de Prim que muestre cual es el 
        grafo encontrado por el algoritmo*/
     
    /*    14. Para un grafo dirigido implementar al algoritmo de ordenamiento topológico. Debe mostrar 
        cual es el orden de los vértices según este algoritmo. */ 
     
    }
  
}
