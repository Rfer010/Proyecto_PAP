/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JerarquiaEmpleados;

import java.time.LocalDate;
/**
 *
 * @author ferna
 */
public class Gerente extends Empleado {

    public Gerente(String nombre, String apellido, String direccion, LocalDate fechaNacimiento, String sexo){
        super(nombre, apellido, direccion, fechaNacimiento, sexo);
        this.salarioBase = 5000.00;
    }
    
    @Override
    public String GetRolEmpleado(){
        return "Gerente";
    }

}
