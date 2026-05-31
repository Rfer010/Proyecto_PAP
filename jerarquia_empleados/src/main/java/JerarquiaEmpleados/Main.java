/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package JerarquiaEmpleados;

import java.util.Scanner;
import ClasesUtilitarias.ImportarDatos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ferna
 */
public class Main {

    public static void main(String[] args) {
        //autoreferencia para usar metodos de la misma clase
        Main inicio = new Main();
        // definicion de clase de entrada de datos por consola
        Scanner teclado = new Scanner(System.in);
        // definicion de variables para controlar el flujo de las estructuras repetitivas
        boolean continuar = false;
        boolean entrada_valida = true;
        
        // crear nuevo objeto para llenar la lista de empleados segun rol
        //ruta de archivo ../DatosEmpleados/DatosEmpleados.csv
        ImportarDatos importacion = new ImportarDatos();
        List<Empleado> empleados = new ArrayList<>();
        
        empleados = importacion.ImportarEmpleados("..//DatosEmpleados//DatosEmpleados.csv");
        //funcion para mostrar los empleados
        inicio.MostrarEmpleados(empleados);
        
        // flujo principal
        /*
        do {
            inicio.Mostrar_menu();
            int opcion = teclado.nextInt();

            while (entrada_valida == true) {
                entrada_valida = inicio.Validar_opcion(opcion);
            }

            inicio.Realizar_opcion(opcion);
            
            System.out.println();
            System.out.println("¿Desea Realizar otra operación? (y/n)");
            teclado.nextLine();
            String eleccion = teclado.nextLine();
            continuar = inicio.Continuar_programa(eleccion);//hacer un ciclo repetitivo.

        } while (continuar == true);
        */
    }

    // mostrar el menu de opciones
    private void Mostrar_menu() {
        System.out.println("-------------Empresa Automotriz [PERFECT CAR]-------------");
        System.out.println("MENÚ OPCIONES:");
        System.out.println("1 - Ordenar y mostrar empleados alfabeticamente segun primer apellido.");
        System.out.println("2 - Ordenar y mostrar empleados  por sueldo.");
        System.out.println("3 - Mostrar cantidad de empleados según sus roles.");
        System.out.println("4 - salir.");
    }

    //realizar las opcciones segun menu de opciones
    private void Realizar_opcion(int opcion) {

        switch (opcion) {
            case 1:
                System.out.println("Eleccion 1");
                break;
            case 2:
                System.out.println("Eleccion 2");
                break;
            case 3:
                System.out.println("Eleccion 3");
                break;
            default:
                System.out.println("Fallo");
                break;
        }
    }

    //funcion para validar que la opcion este dentro del rango
    private boolean Validar_opcion(int opcion) {
        if (opcion > 3 || opcion < 1) {
            return true;
        }
        return false;
    }

    //funcion para verificar la continuidad de la app y limpiar pantalla
    private boolean Continuar_programa(String eleccion) {
        String eleccion_lowercase = eleccion.toLowerCase();
        if (eleccion_lowercase.equals("y")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                
            }
            return true;
        }
        return false;
    }
    
    //funcion para mostrar la lista de empleados
    private void MostrarEmpleados(List<Empleado> empleados){
        int contador=0;
        System.out.println("Nombres |Apellido |Direccion |Fecha de Nacimiento |Sexo |Rol");
        for(Empleado cadaEmpleado : empleados){
            System.out.print(cadaEmpleado.GetNombre() + " - ");
            System.out.print(cadaEmpleado.GetApellido() + " - ");
            //System.out.print(cadaEmpleado.GetDireccion() + " - ");
            //System.out.print(cadaEmpleado.GetFechaNacimiento() + " - ");
            //System.out.print(cadaEmpleado.GetSexo() + " - ");
            System.out.print(cadaEmpleado.GetRolEmpleado() + " - ");
            System.out.print("$" + cadaEmpleado.GetSalarioNeto()+ " - ");
            System.out.print("$" + cadaEmpleado.salarioBase + " - ");
            System.out.println("AFP %" + cadaEmpleado.DescuentoAFP()+ " ");
            
        }
    }
}
