/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

/**
 *
 * @author Administrator
 */
public class ListaSimple {

    private NodoLista inicio;

    public ListaSimple() {
        this.inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public boolean insertar(Elemento e) {
        if (buscar(e.getId()) != null) {
            return false;
        }
        if (vacia()) {
            inicio = new NodoLista(e);
        } else if (e.getId() < inicio.getDato().getId()) {
            NodoLista aux = new NodoLista(e);
            aux.setSiguiente(inicio);
            inicio = aux;
        } else {
            NodoLista aux = inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getId() < e.getId()) {
                aux = aux.getSiguiente();
            }
            NodoLista temp = new NodoLista(e);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
        return true;
    }

    public boolean eliminar(int id) {
        if (vacia()) {
            return false;
        }
        if (inicio.getDato().getId() == id) {
            inicio = inicio.getSiguiente();
            return true;
        }
        NodoLista aux = inicio;
        while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getId() != id) {
            aux = aux.getSiguiente();
        }
        if (aux.getSiguiente() == null) {
            return false;
        }
        aux.setSiguiente(aux.getSiguiente().getSiguiente());
        return true;
    }

    public Elemento buscar(int id) {
        NodoLista aux = inicio;
        while (aux != null) {
            if (aux.getDato().getId() == id) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    @Override
    public String toString() {
        if (vacia()) {
            return "Lista vacía";
        }
        NodoLista aux = inicio;
        String s = "";
        while (aux != null) {
            s += aux.getDato().getId() + " / " + aux.getDato().getNombre()
                    + " / " + aux.getDato().getDetalle() + "\n";
            aux = aux.getSiguiente();
        }
        return s;
    }
}
