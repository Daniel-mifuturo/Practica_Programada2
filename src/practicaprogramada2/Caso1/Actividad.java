/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso1;

/**
 *
 * @author daniel
 */
public class Actividad {
    
    private String codigo;
    private String nombre;
    private String descripcion;
    private String curso;
    private int dia;
    private int mes;
    private int year;
    private String estado;

    public Actividad(String codigo, String nombre, String descripcion, String curso, int dia, int mes, int year, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.curso = curso;
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Código de la Activdad: " + codigo + "\nNombre de la Activdad: "+
                nombre + "\nDescripción de la Activdad: " + descripcion + 
                "\nNombre del Curso: " + curso + "\nEstado de la Activdad: " +
                estado + "\nFecha de la Activdad: " + dia + "/" + mes + "/" + 
                year;
    }
    
    
    
}
