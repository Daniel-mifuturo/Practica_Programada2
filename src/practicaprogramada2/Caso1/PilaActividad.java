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
public class PilaActividad {
    
    private NodoActividad cima;
    
    public PilaActividad (){
        cima = null;
    }
    
    public void agregarPila(Actividad actividad){
        NodoActividad nuevo = new NodoActividad(actividad);
        nuevo.siguiente=cima;
        cima=nuevo;
        JOptionPane.showMessageDialog(null, "Agregado correctamente en la pila de actividades");
    }
    
    public boolean vacio(){
        return cima == null;
    }
    
    public Actividad desapilar(){
        if (cima == null){
            return null;
        }
        Actividad actividad = cima.getActividad();
        cima = cima.getSiguiente();
        return actividad;        
    }
    
    public void mostrar() {

        if (vacio()) {
            JOptionPane.showMessageDialog(null,
                    "La pila de actividades está vacía.");
            return;
        }

        NodoActividad actual = cima;
        String informacion = "";

        while (actual != null) {
            informacion += actual.getActividad().toString() + "\n\n";
            actual = actual.getSiguiente();
        }

        JOptionPane.showMessageDialog(null,
                informacion,
                "Historial de actividades pendientes",
                JOptionPane.INFORMATION_MESSAGE);
    }
        
    public void eliminarActividad() {

        if (vacio()) {
            JOptionPane.showMessageDialog(null,"No existen actividades pendientes en la pila.");
        return;
        }

        Actividad actividad = cima.getActividad();

        cima = cima.getSiguiente();

        JOptionPane.showMessageDialog(null,"Actividad eliminada correctamente:\n\n" 
                + actividad,"Eliminar actividad",JOptionPane.INFORMATION_MESSAGE);
    }
}
