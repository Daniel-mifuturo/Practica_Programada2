/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaprogramada2.Caso1;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Principal1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PilaActividad pila = new PilaActividad();

        int opcion = 0;

        do {

        String menu = JOptionPane.showInputDialog(
            "===== MENU DE ACTIVIDADES =====\n\n"
            + "1. Agregar actividad\n"
            + "2. Eliminar actividad\n"
            + "3. Mostrar actividades por Estudiante\n"
            + "4. Verificar si la pila está vacía\n"
            + "5. Salir\n\n"
            + "Seleccione una opción:"
        );

        if (menu == null) {
            opcion = 6;
        } else {
            opcion = Integer.parseInt(menu);
        }

        switch (opcion) {

            case 1:
                String codigo = JOptionPane.showInputDialog(
                    "Inserte el código de la actividad:");

                String nombre = JOptionPane.showInputDialog(
                    "Inserte el nombre del Estudiante:");

                String descripcion = JOptionPane.showInputDialog(
                    "Inserte la descripción de la actividad:");

                String curso = JOptionPane.showInputDialog(
                    "Inserte el nombre del curso:");

                String estado = JOptionPane.showInputDialog(
                    "Inserte el estado de la actividad:");

                int dia = Integer.parseInt(
                    JOptionPane.showInputDialog("Agregue el día:"));

                int mes = Integer.parseInt(
                    JOptionPane.showInputDialog("Agregue el mes:"));

                int year = Integer.parseInt(
                    JOptionPane.showInputDialog("Agregue el año:"));

                Actividad actividad = new Actividad(
                    codigo, nombre, descripcion, curso,
                    dia, mes, year, estado);

                pila.agregarPila(actividad);
                break;

                case 2:
                    pila.eliminarActividad();
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
                            null, "Existen actividades en la pila.");
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
    
    

