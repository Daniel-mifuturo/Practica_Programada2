/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author Administrator
 */
public class NodoLista {
    private Elemento dato;
    private NodoLista siguiente;

    public NodoLista(Elemento dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Elemento getDato() {
        return dato;
    }

    public void setDato(Elemento dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
