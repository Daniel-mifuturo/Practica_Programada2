/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso1;

/**
 *
 * @author daniel
 */
public class Estudiante {
    
    private String codigo;
    private String nombre;
    private PilaActividad pilaActividades;

    public Estudiante(String codigo, String nombre) {

        this.codigo = codigo;
        this.nombre = nombre;

        this.pilaActividades = new PilaActividad();
    }

    public PilaActividad getPilaActividades() {
        return pilaActividades;
    }
}
