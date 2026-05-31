/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JerarquiaEmpleados;

import java.time.LocalDate;// importación para el ingreso valido de fechas de nacimiento.

/**
 *
 * @author ferna
 */
public abstract class Empleado {

    // Definición de propiedades generales de la clase empleado
    private String nombre;
    private String apellido;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String sexo;
    protected Double salarioBase;

    public Empleado(String nombre, String apellido, String direccion, LocalDate fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    // definicion de metodos setter
    public String SetNombre(String nombre) {
        return this.nombre = nombre;
    }

    public String SetApellido(String apelido) {
        return this.apellido = apellido;
    }

    public String SetDireccion(String direccion) {
        return this.direccion = direccion;
    }

    public LocalDate SetFechaNacimiento(LocalDate fechaNacimiento) {
        return this.fechaNacimiento = fechaNacimiento;
    }

    public String SetSexo(String sexo) {
        return this.sexo = sexo;
    }

    // definicion de metodos getter
    public String GetNombre() {
        return nombre;
    }

    public String GetApellido() {
        return apellido;
    }

    public String GetDireccion() {
        return direccion;
    }

    public LocalDate GetFechaNacimiento() {
        return fechaNacimiento;
    }

    public String GetSexo() {
        return sexo;
    }

    public abstract String GetRolEmpleado();

    //definicion de metodos para calcular salarios con descuentos
    protected Double DescuentoISSS() {
        return salarioBase * 0.075; // ISSS 7.5%
    }

    protected Double DescuentoAFP() {
        return salarioBase * 0.0775; // AFP 7.75%
    }

    // definicion de metodo para calcular salarios en base a renta
    protected Double DescuentoRenta() {
        Double salarioConDescuento = salarioBase - DescuentoISSS() - DescuentoAFP();

        if (salarioConDescuento >= 0.01 && salarioConDescuento <= 472.00) {
            // No se aplica retencion de renta
            return 0.0;
        } else if (salarioConDescuento > 472.00 && salarioConDescuento <= 895.24) {

            return ((salarioConDescuento - 472.00) * 0.1) + 17.67;

        } else if (salarioConDescuento > 895.24 && salarioConDescuento <= 2038.11) {

            return ((salarioConDescuento - 895.24) * 0.2) + 60.00;

        } else {

            return ((salarioConDescuento - 2038.11) * 0.3) + 288.57;
        }
    }

    public Double GetSalarioNeto() {
        return (salarioBase - DescuentoISSS() - DescuentoAFP() - DescuentoRenta());
    }

}
