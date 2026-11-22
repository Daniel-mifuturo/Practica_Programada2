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

    public static void main(String[] args) {

        PilaActividad pila = new PilaActividad();
        Cola cola = new Cola();
        GestorCursos gestorCursos = new GestorCursos();

        int opcion = 0;

        do {

            String entrada = JOptionPane.showInputDialog(
                "===== MENU PRINCIPAL =====\n\n"

                + "--- ACTIVIDADES ---\n"
                + "1. Agregar actividad\n"
                + "2. Eliminar actividad\n"
                + "3. Mostrar actividades por estudiante\n"
                + "4. Verificar si la pila está vacía\n\n"

                + "--- SOLICITUDES DE AYUDA TECNICA ---\n"
                + "5. Agregar solicitud de ayuda técnica\n"
                + "6. Atender solicitud de ayuda técnica\n"
                + "7. Consultar primera solicitud\n"
                + "8. Mostrar solicitudes pendientes\n"
                + "9. Verificar cola\n\n"

                + "--- CURSOS Y MODULOS ---\n"
                + "10. Agregar curso\n"
                + "11. Mostrar cursos disponibles\n"
                + "12. Buscar curso\n"
                + "13. Eliminar curso\n"
                + "14. Agregar módulo a un curso\n"
                + "15. Mostrar módulos de un curso\n"
                + "16. Buscar módulo\n"
                + "17. Eliminar módulo\n\n"

                + "18. Salir\n\n"

                + "Seleccione una opción:"
            );

            if (entrada == null) {
                opcion = 18;
            } else {

                try {
                    opcion = Integer.parseInt(entrada.trim());

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar una opción numérica.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );

                    opcion = 0;
                }
            }

            switch (opcion) {

                // ACTIVIDADES - PILA

                case 1:

                    String codigo = JOptionPane.showInputDialog(
                        "Ingrese el código de la actividad:");

                    if (codigo == null || codigo.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese un código válido.");
                        break;
                    }

                    String nombre = JOptionPane.showInputDialog(
                        "Ingrese el nombre del estudiante:");

                    if (nombre == null || nombre.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese un nombre válido.");
                        break;
                    }

                    String descripcion = JOptionPane.showInputDialog(
                        "Ingrese la descripción de la actividad:");

                    if (descripcion == null || descripcion.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese una descripción válida.");
                        break;
                    }

                    String curso = JOptionPane.showInputDialog(
                        "Ingrese el nombre del curso:");

                    if (curso == null || curso.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese un curso válido.");
                        break;
                    }

                    String estado = JOptionPane.showInputDialog(
                        "Ingrese el estado de la actividad:");

                    if (estado == null || estado.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese un estado válido.");
                        break;
                    }

                    String fecha = JOptionPane.showInputDialog(
                        "Ingrese la fecha de la actividad:");

                    if (fecha == null || fecha.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(
                            null, "Ingrese una fecha válida.");
                        break;
                    }

                    Actividad actividad = new Actividad(
                        codigo.trim(),
                        nombre.trim(),
                        descripcion.trim(),
                        curso.trim(),
                        fecha.trim(),
                        estado.trim()
                    );

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

                // SOLICITUDES - COLA

                case 5:
                    cola.encolar();
                    break;

                case 6:
                    cola.desencolar();
                    break;

                case 7:
                    cola.consultarFrente();
                    break;

                case 8:
                    cola.mostrar();
                    break;

                case 9:

                    if (cola.vacia()) {

                        JOptionPane.showMessageDialog(
                            null, "Cola vacía.");

                    } else {

                        JOptionPane.showMessageDialog(
                            null, "Hay solicitudes pendientes.");
                    }

                    break;

                // CURSOS Y MODULOS - LISTAS

                case 10:
                    gestorCursos.agregarCurso();
                    break;

                case 11:
                    gestorCursos.mostrarCursos();
                    break;

                case 12:
                    gestorCursos.buscarCurso();
                    break;

                case 13:
                    gestorCursos.eliminarCurso();
                    break;

                case 14:
                    gestorCursos.agregarModulo();
                    break;

                case 15:
                    gestorCursos.mostrarModulos();
                    break;

                case 16:
                    gestorCursos.buscarModulo();
                    break;

                case 17:
                    gestorCursos.eliminarModulo();
                    break;

                // SALIR

                case 18:

                    JOptionPane.showMessageDialog(
                        null,
                        "Programa finalizado."
                    );

                    break;

                default:

                    JOptionPane.showMessageDialog(
                        null,
                        "Opción incorrecta.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );

                    break;
            }

        } while (opcion != 18);
    }
}
    
    

