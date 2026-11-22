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

        ListaDobleCircular participantes =
                new ListaDobleCircular();

        Cola cola = new Cola();

        GestorRutas gestorRutas = new GestorRutas();

        GestorMateriales gestorMateriales =
                new GestorMateriales();

        Participante p;

        int opcion = 0;

        do {

            String menu = JOptionPane.showInputDialog(
                "===== MENU PRINCIPAL - PROGRAMA DE RECICLAJE =====\n\n"

                + "--- PARTICIPANTES ---\n"
                + "1. Agregar participante al inicio\n"
                + "2. Agregar participante al final\n"
                + "3. Eliminar participante\n"
                + "4. Buscar participante\n"
                + "5. Mostrar participantes (hacia adelante)\n"
                + "6. Mostrar participantes (hacia atrás)\n\n"

                + "--- HISTORIAL DE ENTREGAS ---\n"
                + "7. Agregar entrega\n"
                + "8. Eliminar entrega\n"
                + "9. Mostrar historial de entregas\n"
                + "10. Verificar si la pila está vacía\n\n"

                + "--- SOLICITUDES DE RECOLECCION ---\n"
                + "11. Agregar solicitud de recolección\n"
                + "12. Atender solicitud de recolección\n"
                + "13. Consultar primera solicitud\n"
                + "14. Mostrar solicitudes pendientes\n"
                + "15. Verificar si la cola está vacía\n\n"

                + "--- RUTAS Y PARADAS DE CAMIONES ---\n"
                + "16. Agregar ruta\n"
                + "17. Mostrar rutas\n"
                + "18. Eliminar ruta\n"
                + "19. Agregar parada a una ruta\n"
                + "20. Mostrar paradas de una ruta\n"
                + "21. Buscar parada\n"
                + "22. Eliminar parada\n"
                + "23. Simular recorrido\n\n"

                + "--- CATALOGO DE MATERIALES ---\n"
                + "24. Agregar material\n"
                + "25. Mostrar catálogo\n"
                + "26. Buscar material\n"
                + "27. Eliminar material\n\n"

                + "28. Salir\n\n"

                + "Seleccione una opción numérica (1-28):"
            );

            if (menu == null) {

                opcion = 28;

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

                // =====================================
                // PARTICIPANTES - LISTA DOBLE CIRCULAR
                // =====================================

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

                        JOptionPane.showMessageDialog(
                            null,
                            p.toString(),
                            "Participante encontrado",
                            JOptionPane.PLAIN_MESSAGE
                        );
                    }

                    break;

                case 5:

                    JOptionPane.showMessageDialog(
                        null,
                        participantes.recorrerAdelante(),
                        "Participantes hacia adelante",
                        JOptionPane.PLAIN_MESSAGE
                    );

                    break;

                case 6:

                    JOptionPane.showMessageDialog(
                        null,
                        participantes.recorrerAtras(),
                        "Participantes hacia atrás",
                        JOptionPane.PLAIN_MESSAGE
                    );

                    break;

                // =====================================
                // ENTREGAS - PILA
                // =====================================

                case 7:

                    p = pedirParticipante(participantes);

                    if (p == null) {
                        break;
                    }

                    String codigo = leerTexto(
                        "Ingrese el código de la entrega:");

                    if (codigo == null) {
                        break;
                    }

                    String material = leerTexto(
                        "Ingrese el material de la entrega:");

                    if (material == null) {
                        break;
                    }

                    String dato = leerTexto(
                        "Ingrese la cantidad de material:");

                    if (dato == null) {
                        break;
                    }

                    double cantidad;

                    try {

                        cantidad = Double.parseDouble(dato);

                        if (cantidad <= 0) {

                            JOptionPane.showMessageDialog(
                                null,
                                "La cantidad debe ser mayor que cero."
                            );

                            break;
                        }

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(
                            null,
                            "Ingrese una cantidad numérica válida.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                        );

                        break;
                    }

                    String unidadMedida = leerTexto(
                        "Ingrese la unidad de medida de la entrega:");

                    if (unidadMedida == null) {
                        break;
                    }

                    String fecha = leerTexto(
                        "Ingrese la fecha de la entrega (DD/MM/YYYY):");

                    if (fecha == null) {
                        break;
                    }

                    Entrega entrega = new Entrega(
                        codigo,
                        material,
                        cantidad,
                        unidadMedida,
                        fecha
                    );

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
                                null,
                                "La pila está vacía."
                            );

                        } else {

                            JOptionPane.showMessageDialog(
                                null,
                                "Existen entregas en la pila."
                            );
                        }
                    }

                    break;

                // =====================================
                // SOLICITUDES - COLA
                // =====================================

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
                            "Existen solicitudes pendientes."
                        );
                    }

                    break;

                // =====================================
                // RUTAS Y PARADAS - LISTA SIMPLE
                // =====================================

                case 16:

                    gestorRutas.agregarRuta();

                    break;

                case 17:

                    gestorRutas.mostrarRutas();

                    break;

                case 18:

                    gestorRutas.eliminarRuta();

                    break;

                case 19:

                    gestorRutas.agregarParada();

                    break;

                case 20:

                    gestorRutas.mostrarParadas();

                    break;

                case 21:

                    gestorRutas.buscarParada();

                    break;

                case 22:

                    gestorRutas.eliminarParada();

                    break;

                case 23:

                    gestorRutas.simularRecorrido();

                    break;

                // =====================================
                // MATERIALES - LISTA SIMPLE
                // =====================================

                case 24:

                    gestorMateriales.agregarMaterial();

                    break;

                case 25:

                    gestorMateriales.mostrarCatalogo();

                    break;

                case 26:

                    gestorMateriales.buscarMaterial();

                    break;

                case 27:

                    gestorMateriales.eliminarMaterial();

                    break;

                // =====================================
                // SALIR
                // =====================================

                case 28:

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

        } while (opcion != 28);
    }

    // =====================================
    // METODO PARA LEER TEXTO
    // =====================================

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

    // =====================================
    // BUSCAR PARTICIPANTE
    // =====================================

    public static Participante pedirParticipante(
            ListaDobleCircular participantes) {

        if (participantes.vacia()) {

            JOptionPane.showMessageDialog(
                null,
                "No hay participantes registrados."
            );

            return null;
        }

        String codigo = leerTexto(
            "Ingrese el código del participante:");

        if (codigo == null) {
            return null;
        }

        Participante p = participantes.buscar(codigo);

        if (p == null) {

            JOptionPane.showMessageDialog(
                null,
                "No existe un participante con el código " + codigo,
                "Participante",
                JOptionPane.WARNING_MESSAGE
            );
        }

        return p;
    }

    // =====================================
    // AGREGAR PARTICIPANTE
    // =====================================

    public static void agregarParticipante(
            ListaDobleCircular participantes,
            boolean alInicio) {

        String codigo = leerTexto(
            "Ingrese el código del participante:");

        if (codigo == null) {
            return;
        }

        if (participantes.buscar(codigo) != null) {

            JOptionPane.showMessageDialog(
                null,
                "Ya existe un participante con el código " + codigo,
                "Código repetido",
                JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        String nombre = leerTexto(
            "Ingrese el nombre del participante:");

        if (nombre == null) {
            return;
        }

        Participante p = new Participante(codigo, nombre);

        if (alInicio) {

            participantes.insertarInicio(p);

        } else {

            participantes.insertarFinal(p);
        }

        JOptionPane.showMessageDialog(
            null,
            "Participante agregado correctamente."
        );
    }

    // =====================================
    // ELIMINAR PARTICIPANTE
    // =====================================

    public static void eliminarParticipante(
            ListaDobleCircular participantes) {

        if (participantes.vacia()) {

            JOptionPane.showMessageDialog(
                null,
                "No hay participantes registrados."
            );

            return;
        }

        String codigo = leerTexto(
            "Ingrese el código del participante a eliminar:");

        if (codigo == null) {
            return;
        }

        if (participantes.eliminar(codigo)) {

            JOptionPane.showMessageDialog(
                null,
                "Participante eliminado correctamente."
            );

        } else {

            JOptionPane.showMessageDialog(
                null,
                "No existe un participante con el código " + codigo,
                "Eliminar participante",
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
}