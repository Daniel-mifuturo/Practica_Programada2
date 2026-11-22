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

public class GestorRutas {

    private ListaSimple rutas;

    public GestorRutas() {
        this.rutas = new ListaSimple();
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


    private Elemento pedirRuta() {
        int codigo = pedirCodigo("Ingrese el código de la ruta:");
        if (codigo == -1) {
            return null;
        }
        Elemento ruta = rutas.buscar(codigo);
        if (ruta == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la ruta.");
        }
        return ruta;
    }

    public void agregarRuta() {
        int codigo = pedirCodigo("Ingrese el código de la ruta:");
        if (codigo == -1) {
            return;
        }
        String camion = pedirTexto("Ingrese la placa o nombre del camión:");
        if (camion == null) {
            return;
        }
        String descripcion = pedirTexto("Ingrese la descripción de la ruta:");
        if (descripcion == null) {
            return;
        }
        if (rutas.insertar(new Elemento(codigo, camion, descripcion))) {
            JOptionPane.showMessageDialog(null, "Ruta agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una ruta con ese código.");
        }
    }

    public void mostrarRutas() {
        JOptionPane.showMessageDialog(null, rutas.toString(),
                "Rutas de camiones", JOptionPane.INFORMATION_MESSAGE);
    }

    public void eliminarRuta() {
        int codigo = pedirCodigo("Ingrese el código de la ruta a eliminar:");
        if (codigo == -1) {
            return;
        }
        if (rutas.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Ruta eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la ruta.");
        }
    }

    public void agregarParada() {
        Elemento ruta = pedirRuta();
        if (ruta == null) {
            return;
        }
        int orden = pedirCodigo("Ingrese el número de orden de la parada:");
        if (orden == -1) {
            return;
        }
        String zona = pedirTexto("Ingrese la zona o dirección de la parada:");
        if (zona == null) {
            return;
        }
        String horario = pedirTexto("Ingrese el horario aproximado (ej. 08:30):");
        if (horario == null) {
            return;
        }
        if (ruta.getParadas().insertar(new Elemento(orden, zona, horario))) {
            JOptionPane.showMessageDialog(null, "Parada agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe una parada con ese número.");
        }
    }

    public void mostrarParadas() {
        Elemento ruta = pedirRuta();
        if (ruta != null) {
            JOptionPane.showMessageDialog(null, ruta.getParadas().toString(),
                    "Paradas de la ruta " + ruta.getId(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void buscarParada() {
        Elemento ruta = pedirRuta();
        if (ruta == null) {
            return;
        }
        int orden = pedirCodigo("Ingrese el número de orden de la parada a buscar:");
        if (orden == -1) {
            return;
        }
        Elemento parada = ruta.getParadas().buscar(orden);
        if (parada == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la parada.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Orden: " + parada.getId() + "\nZona: " + parada.getNombre()
                    + "\nHorario: " + parada.getDetalle(),
                    "Parada encontrada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarParada() {
        Elemento ruta = pedirRuta();
        if (ruta == null) {
            return;
        }
        int orden = pedirCodigo("Ingrese el número de orden de la parada a eliminar:");
        if (orden == -1) {
            return;
        }
        if (ruta.getParadas().eliminar(orden)) {
            JOptionPane.showMessageDialog(null, "Parada eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la parada.");
        }
    }

    public void simularRecorrido() {
        Elemento ruta = pedirRuta();
        if (ruta == null) {
            return;
        }
        if (ruta.getParadas().vacia()) {
            JOptionPane.showMessageDialog(null, "La ruta no tiene paradas.");
            return;
        }
        int cantidad = pedirCodigo("¿Cuántas paradas desea recorrer?");
        if (cantidad <= 0) {
            return;
        }
        JOptionPane.showMessageDialog(null, ruta.getParadas().recorrer(cantidad),
                "Recorrido del camión " + ruta.getNombre(), JOptionPane.INFORMATION_MESSAGE);
    }
}