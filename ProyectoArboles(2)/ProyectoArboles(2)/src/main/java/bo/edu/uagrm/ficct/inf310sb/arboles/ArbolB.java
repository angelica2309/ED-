package bo.edu.uagrm.ficct.inf310sb.arboles;

import bo.edu.uagrm.ficct.inf310sb.arboles.excepciones.ExcepcioClaveNoExiste;
import bo.edu.uagrm.ficct.inf310sb.arboles.excepciones.ExcepcionOrdenInvalido;

import java.util.Stack;

public class ArbolB <K extends Comparable<K>, V> extends ArbolMViasBusqueda<K,V>{
    private  int nroMaximoDeDatos;
    private  int nroMinimoDeDatos;
    private  int nroMinimoDeHijos;

    public ArbolB(){
        super();
        this.nroMaximoDeDatos = 2;
        this.nroMinimoDeDatos = 1;
        this.nroMinimoDeHijos = 2;

    }

    public ArbolB(int orden)  throws
            ExcepcionOrdenInvalido {
        super(orden);
        this.nroMaximoDeDatos = super.orden - 1;
        this.nroMinimoDeDatos = this.nroMaximoDeDatos / 2;
        this.nroMinimoDeHijos = this.nroMinimoDeDatos + 1;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if (claveAInsertar == null) {
            throw new IllegalArgumentException("Clave  a eliminar no puede ser nula");
        }

        V valorARetornar = this.buscar(claveAInsertar);
        if(valorARetornar == null){
            throw new ExcepcioClaveNoExiste("La clave a eliminar no existe en el árbol");
        }
        if(super.esArbolVacio()){
            super.raiz = new NodoMVias<>(super.orden + 1, claveAInsertar, valorAInsertar);
            return;
        }

        Stack<NodoMVias <K,V>> pilaDeAncestros = new Stack<>();
        NodoMVias<K,V> nodoActual = super.raiz;
        while(!NodoMVias.esNodoVacio(nodoActual)){
            int posicionClaveExiste = super.existeClaveEnNodo(nodoActual, claveAInsertar);
            if(posicionClaveExiste != POSICION_INVALIDA){
                nodoActual.setValor(posicionClaveExiste, valorAInsertar);
                nodoActual = NodoMVias.nodoVacio();
            }else {
                // que sea hoja
                if (nodoActual.esHoja()){
                    super.insertarDatosOrdenadosEnNodo(nodoActual, claveAInsertar, valorAInsertar);
                    if (nodoActual.cantidadDeClavesNoVacias() > this.nroMinimoDeDatos){
                        this.dividir(nodoActual, pilaDeAncestros);
                    }
                    nodoActual = NodoMVias.nodoVacio();
                }else{
                    // cuando no es hoja
                    int posicionPorDondeBajar = super.porDondeBajar(nodoActual, claveAInsertar);
                    pilaDeAncestros.push(nodoActual);
                    nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                }
            }
        }

    }
// lo mas importante es el método dividir
    private void dividir(NodoMVias<K,V> nodoActual, Stack<NodoMVias<K,V>> pilaDeAncestros) {
        while (true) {
            int posicionQSube = this.nroMaximoDeDatos / 2;
            // guardamos la clave y el valor
            K claveQSube = nodoActual.getClave(posicionQSube);
            V valorQSube = nodoActual.getValor(posicionQSube);
            // os creamos 2 nuevos nodos
            NodoMVias<K,V> nodoIzq = new NodoMVias<>(orden + 1);
            NodoMVias<K,V> nodoDer = new NodoMVias<>(orden + 1);
            // si la posicion donde estamos no es == a posicion que sube
            for (int i = 0; i < posicionQSube; i++) {
                // insertamos en el nodoIzq que nos creamos
                insertarOrdenB(nodoIzq, nodoActual.getClave(i), nodoActual.getValor(i));
                nodoIzq.setHijo(i, nodoActual.getHijo(i));
                if (i == posicionQSube - 1) {
                    nodoIzq.setHijo(i + 1, nodoActual.getHijo(i + 1));
                }
            }

            // si la posicion donde estamos es >a posicion que sube

            for (int i = posicionQSube + 1; i < this.orden; i++) {
                // insertamos en el nodoDer que nos creamos co los hijos del nodo ACTUAL

                insertarOrdenB(nodoDer, nodoActual.getClave(i), nodoActual.getValor(i));
                nodoDer.setHijo(i - (posicionQSube + 1), nodoActual.getHijo(i));
                if (i == this.orden - 1) {
                    nodoDer.setHijo(i - posicionQSube, nodoActual.getHijo(i + 1));
                }
            }

            //verificamos si el nodo en el que estamos es el raiz
            if (pilaDeAncestros.isEmpty()) {//es la raiz por que ya no hay nada que sacar
                //vaciamos el nodo Actual para que el sea la nueva raiz y ponemos su clave y valor que ya divimos
                vaciarNodo1(nodoActual);
                insertarOrdenB(nodoActual, claveQSube,valorQSube);
                // insertanos sus hijos
                nodoActual.setHijo(0, nodoIzq);
                nodoActual.setHijo(1, nodoDer);
                break;
            } else {//el nodo no es la raiz
                //sacamos el nodo padre del nodo Actual
                NodoMVias<K,V> nodoPadre = pilaDeAncestros.pop();
                //buscamos la posicion por la que colgaba el nodoActual
                insertarOrdenB(nodoPadre, claveQSube,valorQSube);
                //insertamos como su hijo
                nodoPadre.setHijo(porDondeBajar(nodoPadre, claveQSube), nodoIzq);
                nodoPadre.setHijo(porDondeBajar(nodoPadre, claveQSube) + 1, nodoDer);
                if (!nodoPadre.estanClavesLlenas()) {
                    break;
                } else {
                    nodoActual = nodoPadre;
                }
            }
        }
    }

    private void vaciarNodo1(NodoMVias<K,V> nodo) {
        for (int i = 0; i < orden; i++) {
            nodo.setClave(i, null);
            nodo.setValor(i, null);
            nodo.setHijo(i, null);
        }
        nodo.setHijo(orden, null);

    }

    private void insertarOrdenB(NodoMVias<K,V> nodoActual,K clave,V valor){
        int  posicionAPoner=porDondeBajar(nodoActual, clave);
        for (int i = nodoActual.cantidadDeClavesNoVacias()-1; i >= posicionAPoner ; i--) {
            K claveEnTurno=nodoActual.getClave(i);
            if(claveEnTurno.compareTo(clave)>0){
                if(hayHijosMasAdelante(nodoActual, i) && nodoActual.esClaveVacia(i+1)){
                    nodoActual.setClave(i+1, nodoActual.getClave(i));
                    nodoActual.setValor(i+1, nodoActual.getValor(i));
                    nodoActual.setHijo(i+2, nodoActual.getHijo(i+1));
                    nodoActual.setHijo(i+1, nodoActual.getHijo(i));

                }else{
                    nodoActual.setClave(i+1, nodoActual.getClave(i));
                    nodoActual.setValor(i+1, nodoActual.getValor(i));
                    nodoActual.setHijo(i+1, nodoActual.getHijo(i));
                }
            }
        }
        nodoActual.setClave(posicionAPoner,clave);
        nodoActual.setValor(posicionAPoner,valor);
        nodoActual.setHijo(posicionAPoner,NodoMVias.nodoVacio());

    }

    @Override
    public V eliminar(K claveAEliminar) {
        if (claveAEliminar == null) {
            throw new IllegalArgumentException("Clave  a eliminar no puede ser nula");
        }

        Stack<NodoMVias <K,V>> pilaDeAncestros = new Stack<>();
        NodoMVias<K, V> nodoActual = this.buscarNodoDeLaClave(claveAEliminar, pilaDeAncestros);

        if(NodoMVias.esNodoVacio(nodoActual)){
            throw new ExcepcioClaveNoExiste("La Clave no existe en el árbol");
        }
        int posicionDeLaCLaveEnElNodo = super.porDondeBajar(nodoActual, claveAEliminar) - 1;
        V valorARetornar = nodoActual.getValor(posicionDeLaCLaveEnElNodo);

        if(nodoActual.esHoja()) {
            super.eliminarDatosDeNodo(nodoActual, posicionDeLaCLaveEnElNodo);
            if (nodoActual.cantidadDeClavesNoVacias() < this.nroMinimoDeDatos) {
                if (pilaDeAncestros.isEmpty()) {
                    if (nodoActual.cantidadDeClavesNoVacias() == 0) {
                        super.vaciar();
                    }
                } else {
                    this.prestarseOFusionarse(nodoActual, pilaDeAncestros);
                }
            }
        }else {
                // no es hoja
                pilaDeAncestros.push(nodoActual);
                NodoMVias<K,V> nodoDelPredecesor = this.buscarNodoPredecesor(pilaDeAncestros,
                        nodoActual.getHijo(posicionDeLaCLaveEnElNodo));
                int posicionDelPredecesor = nodoDelPredecesor.cantidadDeClavesNoVacias() - 1;
                K clavePredecesora = nodoDelPredecesor.getClave(posicionDelPredecesor);
                V valorPredecesora = nodoDelPredecesor.getValor(posicionDelPredecesor);
                super.eliminarDatosDeNodo(nodoDelPredecesor, posicionDelPredecesor);
                nodoActual.setClave(posicionDeLaCLaveEnElNodo, clavePredecesora);
                nodoActual.setValor(posicionDeLaCLaveEnElNodo, valorPredecesora);
                if(nodoDelPredecesor.cantidadDeClavesNoVacias() < this.nroMinimoDeDatos){
                    this.prestarseOFusionarse(nodoDelPredecesor, pilaDeAncestros);
                }
        }

        return valorARetornar;

    }

    private NodoMVias<K,V> buscarNodoPredecesor(Stack<NodoMVias<K,V>> pilaDeAncestros, NodoMVias<K,V> hijo) {
       return null;
    }

    private void prestarseOFusionarse(NodoMVias<K,V> nodoActual, Stack<NodoMVias<K,V>> pilaDeAncestros) {
    }

    private NodoMVias<K,V> buscarNodoDeLaClave(K claveAEliminar, Stack<NodoMVias<K,V>> pilaDeAncestros) {
        return null;
    }
}
