/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
import JerarquiaEmpleados.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author ferna
 */
public class OrdenarClases {
     // metodo para imprimir los objetos extraidos en consola
    public void MostrarEmpleados(List<Empleado> empleados) {
        System.out.println("Nombres       | Apellido    | Direccion     | Fecha de Nacimiento | Sexo    |   Rol    |   Salario ");
        for (Empleado cadaEmpleado : empleados) {
            System.out.print(cadaEmpleado.GetNombre() + "  -  ");
            System.out.print(cadaEmpleado.GetApellido() + "  -  ");
            System.out.print(cadaEmpleado.GetDireccion() + "  -  ");
            System.out.print(cadaEmpleado.GetFechaNacimiento() + "  -  ");
            System.out.print(cadaEmpleado.GetSexo() + "  -  ");
            System.out.print(cadaEmpleado.GetRolEmpleado()+ "  -  ");
            System.out.println(cadaEmpleado.GetSalarioNeto());
        }
    }

    // metodo para ordenar la lista de objetos(empleados) alfabaticamente segun apellido
    public List<Empleado> OrdenarEmpleados(List<Empleado> empleados) {

        char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Empleado> listaOrdenada = new ArrayList<>();

        for (int i = 0; i < alfabeto.length; i++) {
            for (Empleado cadaEmpleado : empleados) {
                char[] apellido = cadaEmpleado.GetApellido().toCharArray();
                if (apellido[0] == alfabeto[i]) {
                    listaOrdenada.add(cadaEmpleado);
                }
            }
        }
        return listaOrdenada;
    }

    // metodo para ordenar la lista de empleados por salario neto de mayor a menor
    public List<Empleado> OrdernarEmpleadosSalario(List<Empleado> empleados) {
        List<Empleado> listaOrdenadaSalario = new ArrayList<>();
        List<Empleado> salarioBajo = new ArrayList<>();
        List<Empleado> salarioMedioBajo = new ArrayList<>();
        List<Empleado> salarioMedio = new ArrayList<>();
        List<Empleado> salarioAlto = new ArrayList<>();

        for (Empleado cadaEmpleado : empleados) {
            if (cadaEmpleado.GetSalarioNeto() <= 350) {
                salarioBajo.add(cadaEmpleado);
            } else if (cadaEmpleado.GetSalarioNeto() <= 750) {
                salarioMedioBajo.add(cadaEmpleado);
            } else if (cadaEmpleado.GetSalarioNeto() <= 1500) {
                salarioMedio.add(cadaEmpleado);
            } else {
                salarioAlto.add(cadaEmpleado);
            }
        }
        //unir todas las listas

        listaOrdenadaSalario.addAll(salarioAlto);
        listaOrdenadaSalario.addAll(salarioMedio);
        listaOrdenadaSalario.addAll(salarioMedioBajo);
        listaOrdenadaSalario.addAll(salarioBajo);

        return listaOrdenadaSalario;
    }
    
    public void MostrarCantidadCategorias(List<Empleado> empleado){
        Map<String, String> empleadoCategoria = new HashMap();
        
        empleadoCategoria = ContarCategorias(empleado);
        System.out.println("MOSTRANDO CANTIDAD ROLES ");
        System.out.println("Cantidad de Tenicos : " + empleadoCategoria.get("Tecnico"));
        System.out.println("Cantidad de Jefes de Area : " + empleadoCategoria.get("Jefe de Area"));
        System.out.println("Cantidad de Gerentes : " + empleadoCategoria.get("Gerente"));
        System.out.println("Cantidad de Supervisores: " + empleadoCategoria.get("Supervisor"));
        
    }
    
    private Map<String, String> ContarCategorias(List<Empleado> empleado){
        Map<String, String> contadorEmpleadoCategoria = new HashMap();
        int contadorTecnico = 0;
        int contadorJefeArea = 0;
        int contadorGerente = 0;
        int contadorSupervisor = 0;
        
        for (Empleado cadaEmpleado : empleado){
            switch(cadaEmpleado.GetRolEmpleado()){
                case "Tecnico":
                    contadorTecnico++;
                    break;
                case "Jefe de Area":
                    contadorJefeArea++;
                    break;
                case "Gerente":
                    contadorGerente++;
                    break;
                case "Supervisor":
                    contadorSupervisor++;
                    break;
                default:
                    System.out.print("No se encontraron mas categorias");
                    break;
            }
        }  
        contadorEmpleadoCategoria.put("Tecnico", String.valueOf(contadorTecnico));
        contadorEmpleadoCategoria.put("Jefe de Area", String.valueOf(contadorJefeArea));
        contadorEmpleadoCategoria.put("Gerente", String.valueOf(contadorGerente));
        contadorEmpleadoCategoria.put("Supervisor", String.valueOf(contadorSupervisor));
        return contadorEmpleadoCategoria;
    }
}