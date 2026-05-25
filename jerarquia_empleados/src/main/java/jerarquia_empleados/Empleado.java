/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquia_empleados;

import java.time.LocalDate;// importación para el ingreso valido de fechas de nacimiento.

/**
 *
 * @author ferna
 */
public class Empleado {
    // Definición de propiedades generales de la clase empleado
    private String nombre;
    private String direccion;
    private LocalDate fecha_nacimiento;
    private String sexo;
    private Double salario;
    
    public Empleado (String nombre, String direccion, LocalDate fecha_nacimiento, String sexo, Double salario){
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.salario = salario;
    }
    
    
    
    
    
}
