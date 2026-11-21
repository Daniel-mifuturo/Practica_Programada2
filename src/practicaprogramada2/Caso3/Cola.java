/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

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
        String solicitud = JOptionPane.showInputDialog(
                null, "Ingrese solicitud de recoleccion:");

        if (solicitud == null || solicitud.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Ingrese una solicitud válida.");
            return;
        }

        NodoCola nuevo = new NodoCola();
        nuevo.setElemento(solicitud.trim());

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        JOptionPane.showMessageDialog(null,
                "Solicitud agregada.");
    }

    public void desencolar() {
        if (!vacia()) {
            String solicitud = inicio.getElemento();
            inicio = inicio.getSiguiente();

            if (inicio == null) {
                fin = null;
            }

            JOptionPane.showMessageDialog(null,
                    "Solicitud atendida:\n\n"
                    + solicitud,
                    "Desencolar",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "No hay solicitudes pendientes.",
                    "Cola Vacia",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


public void consultarFrente() {
    if (!vacia()) {
        JOptionPane.showMessageDialog(null,
                "Primera solicitud pendiente:\n\n"
                + inicio.getElemento(),
                "Frente de la cola",
                JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null,
                "No hay solicitudes pendientes.",
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
                "Solicitudes pendientes:\n\n" + s,
                "Mostrar solicitudes de recolección",
                JOptionPane.PLAIN_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null,
                "No hay solicitudes pendientes.",
                "Cola Vacia",
                JOptionPane.ERROR_MESSAGE);
    }
}


}
