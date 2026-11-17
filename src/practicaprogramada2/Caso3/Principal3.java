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
        
        PilaEntrega pila = new PilaEntrega();

        int opcion = 0;

        do {

        String menu = JOptionPane.showInputDialog(
            "===== MENU DE ENTREGAS =====\n\n"
            + "1. Agregar entrega\n"
            + "2. Eliminar entrega\n"
            + "3. Historial de entregas\n"
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
                    "Ingrese el código de la entrega:");
                if (codigo == null || codigo.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un código válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                codigo = codigo.trim();

                String material = JOptionPane.showInputDialog(
                    "Ingrese el material de la entrega:");
                if (material == null || material.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe un material válido",
                    "Error",JOptionPane.ERROR_MESSAGE);
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
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                unidadMedida = unidadMedida.trim();
              
                String fecha = JOptionPane.showInputDialog(
                    "Ingrese la fecha de la actividad:");

                if (fecha == null || fecha.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                    "Error! Escribe una fecha válida. Formato DD/MM/YYYY",
                    "Error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                fecha = fecha.trim();

                Entrega entrega = new Entrega(
                    codigo, material, cantidad, unidadMedida,
                    fecha);

                pila.agregarPila(entrega);
                break;

                case 2:
                    pila.Eliminar();
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
