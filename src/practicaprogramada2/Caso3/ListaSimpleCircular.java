/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author Administrator
 */
public class ListaSimpleCircular {

    private NodoLista inicio;
    private NodoLista fin;

    public ListaSimpleCircular() {
        this.inicio = null;
        this.fin = null;
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
            fin = inicio;
        } else if (e.getId() < inicio.getDato().getId()) {
            NodoLista aux = new NodoLista(e);
            aux.setSiguiente(inicio);
            inicio = aux;
        } else if (fin.getDato().getId() < e.getId()) {
            fin.setSiguiente(new NodoLista(e));
            fin = fin.getSiguiente();
        } else {//al medio
            NodoLista aux = inicio;
            while (aux.getSiguiente().getDato().getId() < e.getId()) {
                aux = aux.getSiguiente();
            }
            NodoLista temp = new NodoLista(e);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
        fin.setSiguiente(inicio);
        return true;
    }

    public boolean eliminar(int id) {
        if (vacia()) {
            return false;
        }
        if (inicio == fin) {
            if (inicio.getDato().getId() == id) {
                inicio = null;
                fin = null;
                return true;
            }
            return false;
        }
        if (inicio.getDato().getId() == id) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            return true;
        }
        NodoLista aux = inicio;
        while (aux.getSiguiente() != inicio && aux.getSiguiente().getDato().getId() != id) {
            aux = aux.getSiguiente();
        }
        if (aux.getSiguiente() == inicio) {
            return false;
        }
        if (aux.getSiguiente() == fin) {
            fin = aux;
        }
        aux.setSiguiente(aux.getSiguiente().getSiguiente());
        return true;
    }

    public Elemento buscar(int id) {
        if (vacia()) {
            return null;
        }
        NodoLista aux = inicio;
        do {
            if (aux.getDato().getId() == id) {
                return aux.getDato();
            }
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return null;
    }

    public String recorrer(int cantidad) {
        if (vacia()) {
            return "Lista vacía";
        }
        NodoLista aux = inicio;
        String s = "";
        int i = 1;
        while (i <= cantidad) {
            s += i + ". " + aux.getDato().getNombre() + " / " + aux.getDato().getDetalle() + "\n";
            aux = aux.getSiguiente();
            i++;
        }
        return s;
    }

    @Override
    public String toString() {
        if (vacia()) {
            return "Lista vacía";
        }
        NodoLista aux = inicio;
        String s = "";
        do {
            s += aux.getDato().getId() + " / " + aux.getDato().getNombre()
                    + " / " + aux.getDato().getDetalle() + "\n";
            aux = aux.getSiguiente();
        } while (aux != inicio);
        return s;
    }
}
