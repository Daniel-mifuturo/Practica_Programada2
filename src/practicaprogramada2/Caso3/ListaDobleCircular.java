/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author santiago
 */
public class ListaDobleCircular {

    private NodoDoble inicio;
    private NodoDoble fin;

    public ListaDobleCircular() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    //inserta al inicio de la lista
    public void insertarInicio(Participante p) {
        NodoDoble nuevo = new NodoDoble(p);
        if (vacia()) {//si esta vacia, el nuevo es inicio y fin y se apunta a si mismo
            inicio = nuevo;
            fin = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            nuevo.setSiguiente(inicio);//el nuevo apunta al antiguo inicio
            nuevo.setAnterior(fin);//y hacia atras al fin (circular)
            inicio.setAnterior(nuevo);//el antiguo inicio apunta hacia atras al nuevo
            fin.setSiguiente(nuevo);//el fin apunta al nuevo inicio
            inicio = nuevo;//el nuevo pasa a ser el inicio
        }
    }

    //inserta al final de la lista
    public void insertarFinal(Participante p) {
        NodoDoble nuevo = new NodoDoble(p);
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            nuevo.setSiguiente(inicio);//el nuevo apunta al inicio (circular)
            nuevo.setAnterior(fin);//y hacia atras al antiguo fin
            fin.setSiguiente(nuevo);//el antiguo fin apunta al nuevo
            inicio.setAnterior(nuevo);//el inicio apunta hacia atras al nuevo fin
            fin = nuevo;//el nuevo pasa a ser el fin
        }
    }

    //busca el nodo que tiene el codigo; devuelve null si no existe
    private NodoDoble buscarNodo(String codigo) {
        if (vacia()) {
            return null;
        }
        NodoDoble aux = inicio;
        do {
            if (aux.getDato().getCodigo().equals(codigo)) {
                return aux;
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);//se detiene al dar la vuelta completa
        return null;
    }

    //busca por codigo sin eliminar; devuelve null si no existe
    public Participante buscar(String codigo) {
        NodoDoble nodo = buscarNodo(codigo);
        if (nodo != null) {
            return nodo.getDato();
        } else {
            return null;
        }
    }

    //elimina por codigo; devuelve true si lo elimino
    public boolean eliminar(String codigo) {
        NodoDoble nodo = buscarNodo(codigo);
        if (nodo == null) {//lista vacia o codigo inexistente
            return false;
        }
        if (inicio == fin) {//era el unico nodo: la lista queda vacia
            inicio = null;
            fin = null;
        } else {
            //los vecinos se enlazan entre si y el nodo queda fuera
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
            if (nodo == inicio) {//si era el inicio, el siguiente pasa a ser el inicio
                inicio = nodo.getSiguiente();
            }
            if (nodo == fin) {//si era el fin, el anterior pasa a ser el fin
                fin = nodo.getAnterior();
            }
        }
        return true;
    }

    //recorre de inicio a fin usando siguiente
    public String recorrerAdelante() {
        if (vacia()) {
            return "No hay participantes registrados";
        }
        String s = "";
        NodoDoble aux = inicio;
        do {
            s += aux.getDato().getCodigo() + " - " + aux.getDato().getNombre() + "\n";
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return s;
    }

    //recorre de fin a inicio usando anterior
    public String recorrerAtras() {
        if (vacia()) {
            return "No hay participantes registrados";
        }
        String s = "";
        NodoDoble aux = fin;
        do {
            s += aux.getDato().getCodigo() + " - " + aux.getDato().getNombre() + "\n";
            aux = aux.getAnterior();
        } while (aux != fin);
        return s;
    }
}
