package bo.edu.uagrm.ficct.inf310sb.ui;

import bo.edu.uagrm.ficct.inf310sb.arboles.*;
import bo.edu.uagrm.ficct.inf310sb.arboles.excepciones.ExcepcionOrdenInvalido;

import java.util.Scanner;

public class TestArbol {

    public static void pruebaMVias() throws ExcepcionOrdenInvalido {
        ArbolMViasBusqueda<Integer, String> mvias = new ArbolMViasBusqueda<>(5);
        mvias.insertar(10, "Pepa");
        mvias.insertar(20, "Pepe");
        mvias.insertar(30, "Pepi");
        mvias.insertar(40, "Pepo");
        mvias.insertar(11, "Qepa");
        mvias.insertar(13, "Qepe");
        mvias.insertar(16, "Qepi");
        mvias.insertar(12, "Qepo");
        mvias.insertar(1, "Qepe");
        mvias.insertar(5, "Qepi");
        mvias.insertar(7, "Qepo");
        mvias.mostrar();
        mvias.eliminar(13);
        mvias.eliminar(16);
        mvias.eliminar(12);
        mvias.eliminar(11);
        mvias.eliminar(10);
        mvias.mostrar();
    }

    public static void main(String[] argumentos) throws ExcepcionOrdenInvalido {
        pruebaMVias();
        /*IArbolBusqueda<Integer, String> arbolprueba = new ArbolBinarioBusqueda<>();
        IArbolBusqueda<Integer, String> arbolprueba2 = new ArbolBinarioBusqueda<>();
        Scanner entrada = new Scanner(System.in);*/

       /* System.out.println("Elija un tipo de árbol (ABB, AVL, AMVias, AB)");
        String tipoArbol = entrada.next();
        switch (tipoArbol){
            case "ABB":
                arbolprueba = new ArbolBinarioBusqueda<>();
                break;
            case "AVL":
                arbolprueba = new AVL<>();
                break;
            case "AMVias":
                arbolprueba = new ArbolMViasBusqueda<>(4);
                break;
            case "AB":
                arbolprueba = new ArbolB<>(4);
                break;
            default:
                System.out.println("Tipo de árbol invalido. Usando AVL");
                arbolprueba = new AVL<>();
                break;
        }*/

        /*arbolprueba.insertar(50,"Azul");
        arbolprueba.insertar(78,"Naranja");
        arbolprueba.insertar(74,"Zapato");
        arbolprueba.insertar(30,"Jeans");
        arbolprueba.insertar(44,"Amarillo");
        arbolprueba.insertar(20,"Negro");
        arbolprueba.insertar(25,"Café");
        arbolprueba.insertar(24,"Camisa");
        arbolprueba.insertar(23, "Mesa");
        arbolprueba.insertar(28,"TV");
        arbolprueba.insertar(74,"Banana");
        arbolprueba.insertar(120,"Arroz");
        arbolprueba.insertar(35,"Blusa");
        arbolprueba.insertar(111,"Zapato");
        arbolprueba.insertar(90,"Portatil");
        arbolprueba.insertar(81,"Llaves");
        arbolprueba.insertar(71,"Mouse");
        arbolprueba.insertar(100,"Cables");
        arbolprueba.insertar(89,"Térmico");
        arbolprueba.insertar(51,"Gato");

        System.out.println(arbolprueba);

        arbolprueba2.insertar(50,"Azul");
        arbolprueba2.insertar(78,"Naranja");
        arbolprueba2.insertar(74,"Zapato");
        arbolprueba2.insertar(30,"Jeans");
        arbolprueba2.insertar(44,"Amarillo");
        arbolprueba2.insertar(20,"Negro");
        arbolprueba2.insertar(89,"Térmico");
        arbolprueba2.insertar(120,"Arroz");


        System.out.println(arbolprueba);


        System.out.println(((ArbolBinarioBusqueda<Integer, String>) arbolprueba).árbolesSimilares((ArbolBinarioBusqueda<Integer, String>) arbolprueba2));

        System.out.println("ambos hijos: " + ((ArbolBinarioBusqueda<Integer, String>) arbolprueba).cantidadNodosQueTienenAmbosHijos(1));

        System.out.println("arbol lleno:" + ((ArbolBinarioBusqueda<Integer, String>) arbolprueba2).arbolBinarioLlenoRec());*/
    }

}
