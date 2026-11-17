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
                    "Ingrese el código de la actividad:");
                if (codigo == null || codigo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un código válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                codigo = codigo.trim();

                String nombre = JOptionPane.showInputDialog(
                    "Ingrese el nombre del Estudiante:");
                if (nombre == null || nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un nombre válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                nombre = nombre.trim();

                String descripcion = JOptionPane.showInputDialog(
                    "Ingrese la descripción de la actividad:");
                if (descripcion == null || descripcion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe una descripción válida",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                descripcion = descripcion.trim();                

                String curso = JOptionPane.showInputDialog(
                    "Ingrese el nombre del curso:");
                if (curso == null || curso.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un curso válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                curso = curso.trim();

                String estado = JOptionPane.showInputDialog(
                    "Ingrese el estado de la actividad:");
                
                if (estado == null || estado.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un estado válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                estado = estado.trim();
                
                String fecha = JOptionPane.showInputDialog(
                    "Ingrese la fecha de la actividad:");

                if (fecha == null || fecha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe una fecha válida. Formato DD/MM/YYYY",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                fecha = fecha.trim();

                Actividad actividad = new Actividad(
                    codigo, nombre, descripcion, curso,
                    fecha, estado);

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
    
    

