/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class Cola {

    private NodoCola inicio;
    private NodoCola fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void encolar() {

        String tarea = JOptionPane.showInputDialog(
                null, "Ingrese nueva tarea para asignar:");

        if (tarea == null || tarea.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Ingrese tarea válida.");
            return;
        }

        NodoCola nuevo = new NodoCola();
        nuevo.setElemento(tarea.trim());

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        JOptionPane.showMessageDialog(null,
                "Tarea agregada a la cola.");

    }

    public void desencolar() {

        if (!vacia()) {
            String tarea = inicio.getElemento();
            inicio = inicio.getSiguiente();

            if (inicio == null) {
                fin = null;
            }

            JOptionPane.showMessageDialog(null,
                    "Tarea retirada:\n\n"
                    + tarea,
                    "Desencolar",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay tareas pendientes.",
                    "Cola Vacia",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void consultarFrente() {
        if (!vacia()) {
            JOptionPane.showMessageDialog(null,
                    "Primera tarea pendiente de asignar:\n\n"
                    + inicio.getElemento(),
                    "Frente de la cola",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay tareas pendientes.",
                    "Cola Vacia",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoCola aux = inicio;

            while (aux != null) {
                s += aux.getElemento() + " ← ";
                aux = aux.getSiguiente();
            }

            JOptionPane.showMessageDialog(null,
                    "Tareas pendientes de asignacion:\n\n" + s,
                    "Mostrar tareas",
                    JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay tareas pendientes.",
                    "Cola Vacia",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
