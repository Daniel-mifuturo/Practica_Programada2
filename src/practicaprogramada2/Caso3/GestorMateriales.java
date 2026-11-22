/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author Administrator
 */
import javax.swing.JOptionPane;

public class GestorMateriales {

    private ListaSimple catalogo;

    public GestorMateriales() {
        this.catalogo = new ListaSimple();
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

    public void agregarMaterial() {
        int codigo = pedirCodigo("Ingrese el código del material:");
        if (codigo == -1) {
            return;
        }
        String nombre = pedirTexto("Ingrese el nombre del material:");
        if (nombre == null) {
            return;
        }
        String unidad = pedirTexto("Ingrese la unidad de medida (kg, litros, unidades):");
        if (unidad == null) {
            return;
        }
        if (catalogo.insertar(new Elemento(codigo, nombre, unidad))) {
            JOptionPane.showMessageDialog(null, "Material agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un material con ese código.");
        }
    }

    public void mostrarCatalogo() {
        JOptionPane.showMessageDialog(null, catalogo.toString(),
                "Catálogo de materiales", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarMaterial() {
        int codigo = pedirCodigo("Ingrese el código del material a buscar:");
        if (codigo == -1) {
            return;
        }
        Elemento material = catalogo.buscar(codigo);
        if (material == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el material.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Código: " + material.getId() + "\nNombre: " + material.getNombre()
                    + "\nUnidad de medida: " + material.getDetalle(),
                    "Material encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarMaterial() {
        int codigo = pedirCodigo("Ingrese el código del material a eliminar:");
        if (codigo == -1) {
            return;
        }
        if (catalogo.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Material eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el material.");
        }
    }

    public void menu() {
        int opcion = 0;

        do {

            String entrada = JOptionPane.showInputDialog(
                "===== CATÁLOGO DE MATERIALES =====\n\n"
                + "1. Agregar material\n"
                + "2. Mostrar catálogo\n"
                + "3. Buscar material\n"
                + "4. Eliminar material\n"
                + "5. Volver al menú principal\n\n"
                + "Seleccione una opción:"
            );

            if (entrada == null) {
                opcion = 5;
            } else {
                opcion = Integer.parseInt(entrada);
            }

            switch (opcion) {

                case 1:
                    agregarMaterial();
                    break;

                case 2:
                    mostrarCatalogo();
                    break;

                case 3:
                    buscarMaterial();
                    break;

                case 4:
                    eliminarMaterial();
                    break;

                case 5:
                    break;

                default:
                    JOptionPane.showMessageDialog(
                        null, "Opción incorrecta.");
            }

        } while (opcion != 5);
    }
}
