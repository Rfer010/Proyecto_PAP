/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
// importaciones de las clases para dividirlas en base a su tipo de rol

import JerarquiaEmpleados.Empleado;
import JerarquiaEmpleados.Gerente;
import JerarquiaEmpleados.JefeArea;
import JerarquiaEmpleados.Supervisor;
import JerarquiaEmpleados.Tecnico;

// importaciones para guardar fechas
import java.time.LocalDate;

//importaciones necesarias para extraer , leer y almacenar datos .
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//importar clases para ordernar los objetos
public class ImportarDatos {

    // metodo para realizar importacion de los datos desde un archivo externo
    public List<Empleado> ImportarEmpleados(String direccionArchivo) {
        // lista para guardar todos los objetos
        List<Empleado> empleados = new ArrayList<>();
        //usamos try-buffer-resources para abrir y cerrar automaticamente el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))) {

            String texto;

            while ((texto = br.readLine()) != null) {

                String[] textoDividido = texto.split(",");
                /* 
            nota : Estructura del CSV con los datos
            nombre[0],apellido[1],direccion[2],fechaNacimiento[3],sexo[4],rol[5]
                 */

                //division de la cadena String
                String nombre = textoDividido[0];
                String apellido = textoDividido[1];
                String direccion = textoDividido[2];
                LocalDate fechaNacimiento = LocalDate.parse(textoDividido[3]);
                String sexo = textoDividido[4];
                String rolEmpleado = textoDividido[5];

                // Segun el tipo de rol crear nuevos objetos y almacenarlos en una lista
                switch (rolEmpleado) {
                    case "Gerente":
                        Gerente gerente = new Gerente(nombre, apellido, direccion, fechaNacimiento, sexo);
                        empleados.add(gerente);
                        break;
                    case "Tecnico":
                        Tecnico tecnico = new Tecnico(nombre, apellido, direccion, fechaNacimiento, sexo);
                        empleados.add(tecnico);
                        break;
                    case "Jefe de Area":
                        JefeArea jefeArea = new JefeArea(nombre, apellido, direccion, fechaNacimiento, sexo);
                        empleados.add(jefeArea);
                        break;
                    case "Supervisor":
                        Supervisor supervisor = new Supervisor(nombre, apellido, direccion, fechaNacimiento, sexo);
                        empleados.add(supervisor);
                        break;
                    default:
                        System.out.print("No se ha encontrado el rol");
                        break;

                }
            }

        } catch (IOException e) {
            System.out.println("Fallo la lectura del archivo" + e.getMessage());
        }
        // el metodo devuelve la clase de empleados
        return empleados;
    }
}
