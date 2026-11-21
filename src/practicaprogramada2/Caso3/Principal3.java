/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaprogramada2.Caso3;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Principal3 {

    public static void main(String[] args) {

        ListaDobleCircular participantes = new ListaDobleCircular();//participantes del programa
        Participante p;//participante elegido para trabajar con su historial de entregas
        Cola cola = new Cola();

        int opcion = 0;

        do {

            String menu = JOptionPane.showInputDialog(
                    "===== MENU DEL PROGRAMA DE RECICLAJE =====\n\n"
                    + "--- Participantes ---\n"
                    + "1. Agregar participante al inicio\n"
                    + "2. Agregar participante al final\n"
                    + "3. Eliminar participante\n"
                    + "4. Buscar participante\n"
                    + "5. Mostrar participantes (hacia adelante)\n"
                    + "6. Mostrar participantes (hacia atrás)\n"
                    + "--- Historial de entregas de un participante ---\n"
                    + "7. Agregar entrega\n"
                    + "8. Eliminar entrega\n"
                    + "9. Historial de entregas\n"
                    + "10. Verificar si la pila está vacía\n"
                    + "--- Solicitudes de recolección ---\n"
                    + "11. Agregar solicitud de recolección\n"
                    + "12. Atender solicitud de recolección\n"
                    + "13. Consultar primera solicitud\n"
                    + "14. Mostrar solicitudes pendientes\n"
                    + "15. Verificar si la cola está vacía\n"
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
                    agregarParticipante(participantes, true);
                    break;

                case 2:
                    agregarParticipante(participantes, false);
                    break;

                case 3:
                    eliminarParticipante(participantes);
                    break;

                case 4:
                    p = pedirParticipante(participantes);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString(), "Participante encontrado", JOptionPane.PLAIN_MESSAGE);
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, participantes.recorrerAdelante(),
                            "Participantes (hacia adelante)", JOptionPane.PLAIN_MESSAGE);
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, participantes.recorrerAtras(),
                            "Participantes (hacia atrás)", JOptionPane.PLAIN_MESSAGE);
                    break;

                case 7:
                    p = pedirParticipante(participantes);//la entrega se guarda en la pila de ese participante
                    if (p == null) {
                        break;
                    }
                    String codigo = JOptionPane.showInputDialog(
                            "Ingrese el código de la entrega:");
                    if (codigo == null || codigo.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe un código válido",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    codigo = codigo.trim();

                    String material = JOptionPane.showInputDialog(
                            "Ingrese el material de la entrega:");
                    if (material == null || material.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe un material válido",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    material = material.trim();

                    String dato = JOptionPane.showInputDialog(
                            "Ingrese la cantidad de material:");

                    if (dato == null || dato.trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null,
                                "Error: Ingrese una cantidad válida.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);

                        break;
                    }

                    double cantidad = Double.parseDouble(dato.trim());

                    String unidadMedida = JOptionPane.showInputDialog(
                            "Ingrese la unidad de medida de la entrega:");
                    if (unidadMedida == null || unidadMedida.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe una unidad de medida válida",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    unidadMedida = unidadMedida.trim();

                    String fecha = JOptionPane.showInputDialog(
                            "Ingrese la fecha de la actividad:");

                    if (fecha == null || fecha.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Error! Escribe una fecha válida. Formato DD/MM/YYYY",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    fecha = fecha.trim();

                    Entrega entrega = new Entrega(
                            codigo, material, cantidad, unidadMedida,
                            fecha);

                    p.getPilaEntregas().agregarPila(entrega);
                    break;

                case 8:
                    p = pedirParticipante(participantes);
                    if (p != null) {
                        p.getPilaEntregas().Eliminar();
                    }
                    break;

                case 9:
                    p = pedirParticipante(participantes);
                    if (p != null) {
                        p.getPilaEntregas().mostrar();
                    }
                    break;

                case 10:
                    p = pedirParticipante(participantes);
                    if (p != null) {
                        if (p.getPilaEntregas().vacio()) {
                            JOptionPane.showMessageDialog(
                                    null, "La pila está vacía.");
                        } else {
                            JOptionPane.showMessageDialog(
                                    null, "Existen entregas en la pila.");
                        }
                    }
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
                                "La cola está vacía.");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Existen solicitudes pendientes.");
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

    //pide el codigo de un participante y lo busca en la lista; devuelve null si no existe
    public static Participante pedirParticipante(ListaDobleCircular participantes) {
        if (participantes.vacia()) {
            JOptionPane.showMessageDialog(null, "No hay participantes registrados");
            return null;
        }
        String codigo = leerTexto("Ingrese el código del participante:");
        if (codigo == null) {
            return null;
        }
        Participante p = participantes.buscar(codigo);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "No existe un participante con el código " + codigo,
                    "Participante", JOptionPane.WARNING_MESSAGE);
        }
        return p;
    }

    //registra un participante al inicio o al final, sin permitir codigos repetidos
    public static void agregarParticipante(ListaDobleCircular participantes, boolean alInicio) {
        String codigo = leerTexto("Ingrese el código del participante:");
        if (codigo == null) {
            return;
        }
        if (participantes.buscar(codigo) != null) {
            JOptionPane.showMessageDialog(null, "Ya existe un participante con el código " + codigo,
                    "Código repetido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = leerTexto("Ingrese el nombre del participante:");
        if (nombre == null) {
            return;
        }
        Participante p = new Participante(codigo, nombre);
        if (alInicio) {
            participantes.insertarInicio(p);
        } else {
            participantes.insertarFinal(p);
        }
        JOptionPane.showMessageDialog(null, "Participante agregado correctamente");
    }

    //elimina un participante por codigo (junto con su historial de entregas)
    public static void eliminarParticipante(ListaDobleCircular participantes) {
        if (participantes.vacia()) {
            JOptionPane.showMessageDialog(null, "No hay participantes registrados");
            return;
        }
        String codigo = leerTexto("Ingrese el código del participante a eliminar:");
        if (codigo == null) {
            return;
        }
        if (participantes.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Participante eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un participante con el código " + codigo,
                    "Eliminar participante", JOptionPane.WARNING_MESSAGE);
        }
    }
}
