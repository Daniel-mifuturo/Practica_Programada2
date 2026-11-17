/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class PilaEntrega {
    
    private NodoEntrega cima;
    
    public PilaEntrega (){
        this.cima=null;
    }
    
    public void agregarPila(Entrega entrega){
        NodoEntrega nuevo = new NodoEntrega(entrega);
        nuevo.siguiente=cima;
        cima=nuevo;
         JOptionPane.showMessageDialog(null, "Entrega agregada correctamente en la pila");
    }
    
    public boolean vacio(){
        return cima == null;
    }
    
    public Entrega desapilar(){
        if (cima==null){
            return null;
        }
        Entrega entrega = cima.getEntrega();
        cima = cima.getSiguiente();
        return entrega;
    }
    
    public void mostrar() {if (vacio()) {
            JOptionPane.showMessageDialog(null,
                    "La pila de entregas está vacía.");
            return;
            }

        
        NodoEntrega actual = cima;
        String informacion = "";
        
        while (actual != null){
            informacion += actual.getEntrega().toString() + "\n\n";
            actual = actual.getSiguiente();
        }
        
        JOptionPane.showMessageDialog(null,informacion,
        "Entregas pendientes",
        JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Eliminar(){
        if (vacio()) {
            JOptionPane.showMessageDialog(null,
                    "No existen entregas en la pila.");
            return;
            }
        
        Entrega entrega = cima.getEntrega();
        cima = cima.getSiguiente();
        
        JOptionPane.showMessageDialog(null,"Entrega eliminada correctamente:\n\n" 
                + entrega,"Eliminar entrega",JOptionPane.INFORMATION_MESSAGE);
        
    }
}
