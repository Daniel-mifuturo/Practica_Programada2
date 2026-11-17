/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class PilaModificacion {
    
    private NodoModificacion cima;
    
    public PilaModificacion (){
        this.cima = null;
    }
    
    public void agregarPila (Modificacion modificacion){
        NodoModificacion nuevo = new NodoModificacion (modificacion);
        nuevo.siguiente = cima;
        cima = nuevo;
        JOptionPane.showMessageDialog(null, "Modificación agregada exitosamente");
        
    }
    
    public boolean vacio(){
        return cima == null;
    }
    
    public Modificacion desapilar (){
        if (cima == null) {
            return null;
        }
        Modificacion modificacion = cima.getModificacion();
        cima = cima.getSiguiente() ;
        return modificacion;
    }
    
    public void mostrar (){
        if (vacio()) {
            JOptionPane.showMessageDialog(null,
                    "La pila de modificaciones está vacía.");
            return;
        }
        NodoModificacion actual = cima;
        String informacion = "";
        
        while (actual != null){
            informacion += actual.getModificacion().toString() +"\n\n";
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null,informacion,"Historial de Modificaciones",
        JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void eliminar(){
        if (vacio()){
            JOptionPane.showMessageDialog(null,"No existen modificaciones pendientes.");
        return;
        }
        Modificacion modificacion = desapilar();
        
        JOptionPane.showMessageDialog(null,"Modificación eliminada correctamente:\n\n" 
                + modificacion,"Eliminar modificación",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
