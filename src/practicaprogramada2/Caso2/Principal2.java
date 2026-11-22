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

    public static void main(String[] args) {

        PilaModificacion pila = new PilaModificacion();

        ListaDobleCircular integrantes =
                new ListaDobleCircular();

        Cola cola = new Cola();

        GestorHitos gestorHitos = new GestorHitos();

        int opcion = 0;

        do {

            String menu = JOptionPane.showInputDialog(
                "===== MENU PRINCIPAL DEL PROYECTO =====\n\n"

                + "--- HISTORIAL DE MODIFICACIONES ---\n"
                + "1. Agregar modificación\n"
                + "2. Eliminar modificación\n"
                + "3. Mostrar modificaciones\n"
                + "4. Verificar si la pila está vacía\n\n"

                + "--- INTEGRANTES DEL EQUIPO ---\n"
                + "5. Agregar integrante al inicio\n"
                + "6. Agregar integrante al final\n"
                + "7. Eliminar integrante\n"
                + "8. Buscar integrante\n"
                + "9. Mostrar integrantes (hacia adelante)\n"
                + "10. Mostrar integrantes (hacia atrás)\n\n"

                + "--- ASIGNACION DE NUEVAS TAREAS ---\n"
                + "11. Agregar tarea pendiente\n"
                + "12. Retirar tarea de asignación\n"
                + "13. Consultar primera tarea\n"
                + "14. Mostrar tareas pendientes\n"
                + "15. Verificar cola\n\n"

                + "--- HITOS Y ENTREGABLES ---\n"
                + "16. Agregar hito\n"
                + "17. Mostrar hitos\n"
                + "18. Buscar hito\n"
                + "19. Eliminar hito\n\n"

                + "20. Salir\n\n"

                + "Seleccione una opción numérica (1-20):"
            );

            if (menu == null) {

                opcion = 20;

            } else {

                try {

                    opcion = Integer.parseInt(menu.trim());

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Ingrese una opción numérica válida.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );

                    opcion = 0;
                }
            }

            switch (opcion) {

                // =================================
                // PILA: HISTORIAL DE MODIFICACIONES
                // =================================

                case 1:

                    String codigo = leerTexto(
                        "Ingrese el código de la modificación:");

                    if (codigo == null) {
                        break;
                    }

                    String descripcion = leerTexto(
                        "Ingrese la descripción de la modificación:");

                    if (descripcion == null) {
                        break;
                    }

                    String responsable = leerTexto(
                        "Ingrese el nombre de la persona responsable:");

                    if (responsable == null) {
                        break;
                    }

                    String fecha = leerTexto(
                        "Ingrese la fecha de la modificación (DD/MM/YYYY):");

                    if (fecha == null) {
                        break;
                    }

                    Modificacion modificacion = new Modificacion(
                        codigo,
                        descripcion,
                        responsable,
                        fecha
                    );

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
                            null,
                            "La pila está vacía."
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                            null,
                            "Existen modificaciones en la pila."
                        );
                    }

                    break;

                // =================================
                // LISTA DOBLE CIRCULAR: INTEGRANTES
                // =================================

                case 5:

                    agregarIntegrante(integrantes, true);

                    break;

                case 6:

                    agregarIntegrante(integrantes, false);

                    break;

                case 7:

                    eliminarIntegrante(integrantes);

                    break;

                case 8:

                    buscarIntegrante(integrantes);

                    break;

                case 9:

                    JOptionPane.showMessageDialog(
                        null,
                        integrantes.recorrerAdelante(),
                        "Integrantes (hacia adelante)",
                        JOptionPane.PLAIN_MESSAGE
                    );

                    break;

                case 10:

                    JOptionPane.showMessageDialog(
                        null,
                        integrantes.recorrerAtras(),
                        "Integrantes (hacia atrás)",
                        JOptionPane.PLAIN_MESSAGE
                    );

                    break;

                // =================================
                // COLA: ASIGNACION DE TAREAS
                // =================================

                case 11:

                    cola.encolar();

                    break;

                case 12:

                    cola.desencolar();

                    break;

                case 13:

                    cola.consultarFrente();

                    break;

                case 14:

                    cola.mostrar();

                    break;

                case 15:

                    if (cola.vacia()) {

                        JOptionPane.showMessageDialog(
                            null,
                            "La cola está vacía."
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                            null,
                            "Existen tareas pendientes."
                        );
                    }

                    break;

                // =================================
                // LISTA SIMPLE: HITOS Y ENTREGABLES
                // =================================

                case 16:

                    gestorHitos.agregarHito();

                    break;

                case 17:

                    gestorHitos.mostrarHitos();

                    break;

                case 18:

                    gestorHitos.buscarHito();

                    break;

                case 19:

                    gestorHitos.eliminarHito();

                    break;

                // =================================
                // SALIR
                // =================================

                case 20:

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

        } while (opcion != 20);
    }

    // =================================
    // METODOS PARA INTEGRANTES
    // =================================

    public static String leerTexto(String mensaje) {

        String texto = JOptionPane.showInputDialog(mensaje);

        if (texto == null || texto.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                null,
                "El campo no puede estar vacío.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );

            return null;
        }

        return texto.trim();
    }

    public static void agregarIntegrante(
            ListaDobleCircular integrantes,
            boolean alInicio) {

        String codigo = leerTexto(
            "Ingrese el código del integrante:");

        if (codigo == null) {
            return;
        }

        if (integrantes.buscar(codigo) != null) {

            JOptionPane.showMessageDialog(
                null,
                "Ya existe un integrante con el código " + codigo,
                "Código repetido",
                JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String nombre = leerTexto(
            "Ingrese el nombre del integrante:");

        if (nombre == null) {
            return;
        }

        Integrante i = new Integrante(codigo, nombre);

        if (alInicio) {

            integrantes.insertarInicio(i);

        } else {

            integrantes.insertarFinal(i);
        }

        JOptionPane.showMessageDialog(
            null,
            "Integrante agregado correctamente."
        );
    }

    public static void eliminarIntegrante(
            ListaDobleCircular integrantes) {

        if (integrantes.vacia()) {

            JOptionPane.showMessageDialog(
                null,
                "No hay integrantes registrados."
            );

            return;
        }

        String codigo = leerTexto(
            "Ingrese el código del integrante a eliminar:");

        if (codigo == null) {
            return;
        }

        if (integrantes.eliminar(codigo)) {

            JOptionPane.showMessageDialog(
                null,
                "Integrante eliminado correctamente."
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "No existe un integrante con el código " + codigo,
                "Eliminar integrante",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static void buscarIntegrante(
            ListaDobleCircular integrantes) {

        if (integrantes.vacia()) {

            JOptionPane.showMessageDialog(
                null,
                "No hay integrantes registrados."
            );

            return;
        }

        String codigo = leerTexto(
            "Ingrese el código del integrante a buscar:");

        if (codigo == null) {
            return;
        }

        Integrante i = integrantes.buscar(codigo);

        if (i != null) {

            JOptionPane.showMessageDialog(
                null,
                i.toString(),
                "Integrante encontrado",
                JOptionPane.PLAIN_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "No existe un integrante con el código " + codigo,
                "Buscar integrante",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
