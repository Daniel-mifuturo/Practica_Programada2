/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso2;

/**
 *
 * @author daniel
 */
public class Modificacion {
    
    private String codigo;
    private String descripcion;
    private String responsable;
    private String fecha;

    public Modificacion(String codigo, String descripcion, String responsable, String fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Código de la modificación: "+codigo+"\nDescripción de la modificación:"
                +descripcion+"\nResponsable de la modificación: "+responsable+
                "\nFecha de la modificación: "+fecha;
    }
    
    
    
}
