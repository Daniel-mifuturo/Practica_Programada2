/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaprogramada2.Caso2;

import javax.swing.JOptionPane;


/**
 *
 * @author daniel
 */
public class Principal2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PilaModificacion pila = new PilaModificacion();
        
                int opcion = 0;

        do {

        String menu = JOptionPane.showInputDialog(
            "===== MENU DE MODIFICACIONES =====\n\n"
            + "1. Agregar modificación\n"
            + "2. Eliminar modificación\n"
            + "3. Mostrar Modificaciones\n"
            + "4. Verificar si la pila está vacía\n"
            + "5. Salir\n\n"
            + "Seleccione una opción:"
        );

        if (menu == null) {
            opcion = 5;
        } else {
            opcion = Integer.parseInt(menu);
        }

        switch (opcion) {

            case 1:
                String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la modificación:");

                if (codigo == null || codigo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un código válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                codigo = codigo.trim();

                String descripcion = JOptionPane.showInputDialog(
                    "Ingrese la descripción de la modificación:");
                
                if (descripcion == null || descripcion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe una descripción válida",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                descripcion = descripcion.trim();

                String responsable = JOptionPane.showInputDialog(
                    "Ingrese el nombre de la persona responsable:");
                
                if (responsable == null || responsable.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un nombre válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                responsable = responsable.trim();

                String fecha = JOptionPane.showInputDialog(
                    "Ingrese la fecha de la modificación:");
                
                if (fecha == null || fecha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe una fecha válida. Formato DD/MM/YYYY",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                fecha = fecha.trim();

                Modificacion modificacion = new Modificacion (codigo, descripcion, responsable, 
                        fecha);

                pila.agregarPila(modificacion);
                break;

                case 2:
                    pila.eliminar();
                    break;

                case 3:
                    pila.mostrar();
                    break;

                case 4:
                    if (pila.vacio()) {
                    JOptionPane.showMessageDialog(
                        null, "La pila está vacía.");
                    } else {
                        JOptionPane.showMessageDialog(
                            null, "Existen modificaciones en la pila.");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(
                        null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(
                        null, "Opción incorrecta.");
            }

        } while (opcion != 5);
    }
}
