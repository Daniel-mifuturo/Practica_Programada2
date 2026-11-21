/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

/**
 *
 * @author santiago
 */

public class NodoDoble {

    private Integrante dato;//integrante del equipo guardado en el nodo
    private NodoDoble siguiente;//enlace al nodo de la derecha
    private NodoDoble anterior;//enlace al nodo de la izquierda

    public NodoDoble(Integrante dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Integrante getDato() {
        return dato;
    }

    public void setDato(Integrante dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
