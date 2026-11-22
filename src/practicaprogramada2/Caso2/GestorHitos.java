/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

/**
 *
 * @author Administrator
 */
import javax.swing.JOptionPane;

public class GestorHitos {

    private ListaSimple hitos;

    public GestorHitos() {
        this.hitos = new ListaSimple();
    }

    private String pedirTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        if (texto == null || texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Error! Escribe un dato válido",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return texto.trim();
    }

    
    private int pedirCodigo(String mensaje) {
        String texto = pedirTexto(mensaje);
        if (texto == null) {
            return -1;
        }
        int codigo = Integer.parseInt(texto);
        if (codigo < 0) {
            JOptionPane.showMessageDialog(null,
                    "Error! El código debe ser un número positivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return codigo;
    }


    public void agregarHito() {
        int codigo = pedirCodigo("Ingrese el número del hito:");
        if (codigo == -1) {
            return;
        }
        String nombre = pedirTexto("Ingrese el nombre del hito o entregable:");
        if (nombre == null) {
            return;
        }
        String fecha = pedirTexto("Ingrese la fecha de entrega (DD/MM/YYYY):");
        if (fecha == null) {
            return;
        }
        if (hitos.insertar(new Elemento(codigo, nombre, fecha))) {
            JOptionPane.showMessageDialog(null, "Hito agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un hito con ese número.");
        }
    }

    public void mostrarHitos() {
        JOptionPane.showMessageDialog(null, hitos.toString(),
                "Hitos del proyecto", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarHito() {
        int codigo = pedirCodigo("Ingrese el número del hito a buscar:");
        if (codigo == -1) {
            return;
        }
        Elemento hito = hitos.buscar(codigo);
        if (hito == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el hito.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Número: " + hito.getId() + "\nNombre: " + hito.getNombre()
                    + "\nFecha de entrega: " + hito.getDetalle(),
                    "Hito encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarHito() {
        int codigo = pedirCodigo("Ingrese el número del hito a eliminar:");
        if (codigo == -1) {
            return;
        }
        if (hitos.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Hito eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el hito.");
        }
    }
}
