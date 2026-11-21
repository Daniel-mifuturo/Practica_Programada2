/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author santiago
 */
public class NodoDoble {

    private Participante dato;//participante del programa guardado en el nodo
    private NodoDoble siguiente;//enlace al nodo de la derecha
    private NodoDoble anterior;//enlace al nodo de la izquierda

    public NodoDoble(Participante dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Participante getDato() {
        return dato;
    }

    public void setDato(Participante dato) {
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
