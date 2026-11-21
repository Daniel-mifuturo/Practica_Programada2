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
        ListaDobleCircular integrantes = new ListaDobleCircular();//lista de integrantes del equipo
        Cola cola = new Cola();
        int opcion = 0;

        do {

            String menu = JOptionPane.showInputDialog(
                    "===== MENU DEL PROYECTO =====\n\n"
                    + "--- Historial de modificaciones ---\n"
                    + "1. Agregar modificación\n"
                    + "2. Eliminar modificación\n"
                    + "3. Mostrar Modificaciones\n"
                    + "4. Verificar si la pila está vacía\n"
                    + "--- Integrantes del equipo ---\n"
                    + "5. Agregar integrante al inicio\n"
                    + "6. Agregar integrante al final\n"
                    + "7. Eliminar integrante\n"
                    + "8. Buscar integrante\n"
                    + "9. Mostrar integrantes (hacia adelante)\n"
                    + "10. Mostrar integrantes (hacia atrás)\n"
                    + "--- Asignacion de nuevas tareas ---\n"
                    + "11. Agregar tarea pendiente\n"
                    + "12. Retirar tarea de asignacion\n"
                    + "13. Consultar primera tarea\n"
                    + "14. Mostrar tareas pendientes\n"
                    + "15. Verificar cola\n"
                    + "16. Salir\n\n"
                    + "Seleccione una opción:"
            );

            if (menu == null) {
                opcion = 16;
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
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    codigo = codigo.trim();

                    String descripcion = JOptionPane.showInputDialog(
                            "Ingrese la descripción de la modificación:");

                    if (descripcion == null || descripcion.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe una descripción válida",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    descripcion = descripcion.trim();

                    String responsable = JOptionPane.showInputDialog(
                            "Ingrese el nombre de la persona responsable:");

                    if (responsable == null || responsable.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe un nombre válido",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    responsable = responsable.trim();

                    String fecha = JOptionPane.showInputDialog(
                            "Ingrese la fecha de la modificación:");

                    if (fecha == null || fecha.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe una fecha válida. Formato DD/MM/YYYY",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    fecha = fecha.trim();

                    Modificacion modificacion = new Modificacion(codigo, descripcion, responsable,
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
                    JOptionPane.showMessageDialog(null, integrantes.recorrerAdelante(),
                            "Integrantes (hacia adelante)", JOptionPane.PLAIN_MESSAGE);
                    break;

                case 10:
                    JOptionPane.showMessageDialog(null, integrantes.recorrerAtras(),
                            "Integrantes (hacia atrás)", JOptionPane.PLAIN_MESSAGE);
                    break;

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
                        JOptionPane.showMessageDialog(null,
                                "La cola está vacia.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Existen tareas pendientes.");
                    }
                    break;

                case 16:
                    JOptionPane.showMessageDialog(
                            null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null, "Opción incorrecta.");
            }

        } while (opcion != 16);
    }

    //solicita un texto; devuelve null si cancela o lo deja vacio
    public static String leerTexto(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        if (texto == null) {
            JOptionPane.showMessageDialog(null, "Operación cancelada", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } else if (texto.length() == 0) {
            JOptionPane.showMessageDialog(null, "Error! El valor no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            return texto;
        }
    }

    //registra un integrante al inicio o al final, sin permitir codigos repetidos
    public static void agregarIntegrante(ListaDobleCircular integrantes, boolean alInicio) {
        String codigo = leerTexto("Ingrese el código del integrante:");
        if (codigo == null) {
            return;
        }
        if (integrantes.buscar(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un integrante con el código " + codigo,
                    "Código repetido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = leerTexto("Ingrese el nombre del integrante:");
        if (nombre == null) {
            return;
        }
        Integrante i = new Integrante(codigo, nombre);
        if (alInicio) {
            integrantes.insertarInicio(i);
        } else {
            integrantes.insertarFinal(i);
        }
        JOptionPane.showMessageDialog(null, "Integrante agregado correctamente");
    }

    //elimina un integrante por codigo
    public static void eliminarIntegrante(ListaDobleCircular integrantes) {
        if (integrantes.vacia()) {
            JOptionPane.showMessageDialog(null, "No hay integrantes registrados");
            return;
        }
        String codigo = leerTexto("Ingrese el código del integrante a eliminar:");
        if (codigo == null) {
            return;
        }
        if (integrantes.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Integrante eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un integrante con el código " + codigo,
                    "Eliminar integrante", JOptionPane.WARNING_MESSAGE);
        }
    }

    //busca un integrante por codigo y muestra sus datos
    public static void buscarIntegrante(ListaDobleCircular integrantes) {
        if (integrantes.vacia()) {
            JOptionPane.showMessageDialog(null, "No hay integrantes registrados");
            return;
        }
        String codigo = leerTexto("Ingrese el código del integrante a buscar:");
        if (codigo == null) {
            return;
        }
        Integrante i = integrantes.buscar(codigo);
        if (i != null) {
            JOptionPane.showMessageDialog(null, i.toString(), "Integrante encontrado", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No existe un integrante con el código " + codigo,
                    "Buscar integrante", JOptionPane.WARNING_MESSAGE);
        }
    }
}
