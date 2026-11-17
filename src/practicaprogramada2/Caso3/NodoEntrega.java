/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author daniel
 */
public class NodoEntrega {
    
    Entrega entrega;
    NodoEntrega siguiente;
    
    public NodoEntrega(Entrega entrega){
        this.entrega=entrega;
        this.siguiente=null;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public NodoEntrega getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEntrega siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
