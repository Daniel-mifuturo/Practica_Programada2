/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

/**
 *
 * @author daniel
 */
public class NodoModificacion {
    
    Modificacion modificacion;
    NodoModificacion siguiente;
    
    public NodoModificacion (Modificacion modificacion){
        this.modificacion=modificacion;
        this.siguiente=null;
    }

    public Modificacion getModificacion() {
        return modificacion;
    }

    public void setModificacion(Modificacion modificacion) {
        this.modificacion = modificacion;
    }

    public NodoModificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoModificacion siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
