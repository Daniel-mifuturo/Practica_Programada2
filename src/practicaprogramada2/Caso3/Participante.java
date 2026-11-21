/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author santiago
 */

public class Participante {

    private String codigo;
    private String nombre;
    private PilaEntrega pilaEntregas;//cada participante tiene su propio historial de entregas

    public Participante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pilaEntregas = new PilaEntrega();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PilaEntrega getPilaEntregas() {
        return pilaEntregas;
    }

    @Override
    public String toString() {
        return "Código del participante: " + codigo + "\nNombre del participante: " + nombre;
    }
}
