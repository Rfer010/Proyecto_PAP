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
public class Tecnico extends Empleado {
    
    public Tecnico(String nombre, String apellido, String direccion, LocalDate fechaNacimiento, String sexo){
        super(nombre, apellido, direccion, fechaNacimiento, sexo);
        this.salarioBase = 350.00;
    }
    
    @Override
    public String GetRolEmpleado(){
        return "Tecnico";
    }
}
