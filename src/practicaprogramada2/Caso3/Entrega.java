/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaprogramada2.Caso3;

/**
 *
 * @author daniel
 */
public class Entrega {
    
    private String codigo;
    private String material;
    private double cantidad;
    private String unidadMedida;
    private String fecha;

    public Entrega(String codigo, String material, double cantidad, String unidadMedida, String fecha) {
        this.codigo = codigo;
        this.material = material;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Código de la entrega: "+codigo+"\nMaterial Entregado: "+material+
                "\nCantidad: "+cantidad+"\nUnidad de Medida: "+unidadMedida+
                "\nFecha de la Entrega: "+fecha;
    }
    
    
    
}
