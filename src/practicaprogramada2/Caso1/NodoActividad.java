/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso1;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class NodoActividad {
    
    Actividad actividad;
    NodoActividad siguiente;
    
    public NodoActividad(Actividad actividad){
        this.actividad = actividad;
        this.siguiente = null;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public NodoActividad getSiguiente() {
        return siguiente;
    }
    
        
}
