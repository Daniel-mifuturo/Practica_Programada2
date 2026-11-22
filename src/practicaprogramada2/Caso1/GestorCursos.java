/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso1;

/**
 *
 * @author Administrator
 */
import javax.swing.JOptionPane;

public class GestorCursos {

    private ListaSimple cursos;

    public GestorCursos() {
        this.cursos = new ListaSimple();
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

    private Elemento pedirCurso() {
        int codigo = pedirCodigo("Ingrese el código del curso:");
        if (codigo == -1) {
            return null;
        }
        Elemento curso = cursos.buscar(codigo);
        if (curso == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el curso.");
        }
        return curso;
    }

    public void agregarCurso() {
        int codigo = pedirCodigo("Ingrese el código numérico del curso\n"
        + "Ejemplo: 101"
        );
        if (codigo == -1) {
            return;
        }
        String nombre = pedirTexto("Ingrese el nombre del curso:");
        if (nombre == null) {
            return;
        }
        String descripcion = pedirTexto("Ingrese la descripción del curso:");
        if (descripcion == null) {
            return;
        }
        if (cursos.insertar(new Elemento(codigo, nombre, descripcion))) {
            JOptionPane.showMessageDialog(null, "Curso agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un curso con ese código.");
        }
    }

    public void mostrarCursos() {
        JOptionPane.showMessageDialog(null, cursos.toString(),
                "Cursos disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarCurso() {
        Elemento curso = pedirCurso();
        if (curso != null) {
            JOptionPane.showMessageDialog(null,
                    "Código: " + curso.getId() + "\nNombre: " + curso.getNombre()
                    + "\nDescripción: " + curso.getDetalle(),
                    "Curso encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarCurso() {
        int codigo = pedirCodigo("Ingrese el código numérico del curso a eliminar\n"
        + "Ejemplo: 101"
        );
        if (codigo == -1) {
            return;
        }
        if (cursos.eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Curso eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el curso.");
        }
    }

    public void agregarModulo() {
        Elemento curso = pedirCurso();
        if (curso == null) {
            return;
        }
        int codigo = pedirCodigo("Ingrese el número del módulo:");
        if (codigo == -1) {
            return;
        }
        String nombre = pedirTexto("Ingrese el nombre del módulo:");
        if (nombre == null) {
            return;
        }
        String descripcion = pedirTexto("Ingrese la descripción del módulo:");
        if (descripcion == null) {
            return;
        }
        if (curso.getSublista().insertar(new Elemento(codigo, nombre, descripcion))) {
            JOptionPane.showMessageDialog(null, "Módulo agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un módulo con ese número.");
        }
    }

    public void mostrarModulos() {
        Elemento curso = pedirCurso();
        if (curso != null) {
            JOptionPane.showMessageDialog(null, curso.getSublista().toString(),
                    "Módulos de " + curso.getNombre(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void buscarModulo() {
        Elemento curso = pedirCurso();
        if (curso == null) {
            return;
        }
        int codigo = pedirCodigo("Ingrese el número del módulo a buscar:");
        if (codigo == -1) {
            return;
        }
        Elemento modulo = curso.getSublista().buscar(codigo);
        if (modulo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el módulo.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Número: " + modulo.getId() + "\nNombre: " + modulo.getNombre()
                    + "\nDescripción: " + modulo.getDetalle(),
                    "Módulo encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void eliminarModulo() {
        Elemento curso = pedirCurso();
        if (curso == null) {
            return;
        }
        int codigo = pedirCodigo("Ingrese el número del módulo a eliminar:");
        if (codigo == -1) {
            return;
        }
        if (curso.getSublista().eliminar(codigo)) {
            JOptionPane.showMessageDialog(null, "Módulo eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el módulo.");
        }
    }
}

