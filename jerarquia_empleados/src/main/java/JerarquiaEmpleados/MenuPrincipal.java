/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JerarquiaEmpleados;

import Utilidades.ImportarDatos;
import Utilidades.OrdenarClases;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ferna
 */
public class MenuPrincipal {

     private boolean continuar = true; // controla el flujo del menu
    
    public void IniciarEjecucion() {
        // definicion de clase de entrada de datos por consola
        Scanner teclado = new Scanner(System.in);
        
        // crear nuevo objeto para llenar la lista de empleados segun rol
        List<Empleado> empleados = new ArrayList<>();

        ImportarDatos importacion = new ImportarDatos();
        //ruta de archivo ../DatosEmpleados/DatosEmpleados.csv
        String direccionDocumentoEmpleados = "..//DatosEmpleados//DatosEmpleados.csv";

        //iniciar importacion de los empleados y guardarlos en una lista
        empleados = importacion.ImportarEmpleados(direccionDocumentoEmpleados);

        // flujo principal de ejecucion
        while (continuar == true) {
            int opcion = 0;
            boolean entrada_valida = true;

            Mostrar_menu();
            while (entrada_valida == true) {
                try {
                    opcion = teclado.nextInt();
                    entrada_valida = Validar_opcion(opcion);
                } catch (InputMismatchException e) {
                    entrada_valida = false;
                    opcion = 0;
                    System.out.println("Solo se permiten longitudes numericas entre 1 y 5");
                    System.out.println("Error detectado: " + e.getMessage());
                }
            }
            Realizar_opcion(opcion, empleados, importacion);
            LimpiarPantalla(teclado);
        }
    }

    // mostrar el menu de opciones
    private void Mostrar_menu() {
        System.out.println("-------------Empresa Automotriz [PERFECT CAR]-------------");
        System.out.println("MENÚ OPCIONES:");
        System.out.println("1 - Mostrar Empleados.");
        System.out.println("2 - Ordenar y mostrar empleados alfabeticamente segun primer apellido.");
        System.out.println("3 - Ordenar y mostrar empleados  por sueldo.");
        System.out.println("4 - Mostrar cantidad de empleados según sus roles.");
        System.out.println("5 - Mas Opciones.");
        System.out.println("6 - salir.");
    }

    //realizar las opcciones segun menu de opciones
    private void Realizar_opcion(int opcion, List<Empleado> empleados, ImportarDatos importacion) {
        OrdenarClases ordenar = new OrdenarClases();

        switch (opcion) {
            case 1:
                System.out.println("Mostrando Empleados");
                ordenar.MostrarEmpleados(empleados);
                break;
            case 2:
                // intentar hacer generico
                System.out.println("Eleccion 2");
                List<Empleado> empleadosOrdenados = new ArrayList<>();
                empleadosOrdenados = ordenar.OrdenarEmpleados(empleados);
                ordenar.MostrarEmpleados(empleadosOrdenados);
                break;
            case 3:
                System.out.println("Eleccion 3");
                List<Empleado> empleadoOrdenadoSalario = new ArrayList<>();
                empleadoOrdenadoSalario = ordenar.OrdernarEmpleadosSalario(empleados);
                ordenar.MostrarEmpleados(empleadoOrdenadoSalario);
                break;
            case 4:
                System.out.println("Eleccion 4");
                ordenar.MostrarCantidadCategorias(empleados);
                break;
            case 5:
                System.out.println("Eleccion 5.\nIniciando SubMenu");
                
                break;
            case 6:
                continuar = false;
                break;
            default:
                System.out.println("Fallo");
                break;
        }
    }

    //funcion para validar que la opcion este dentro del rango
    private boolean Validar_opcion(int opcion) {
        if (opcion > 6 || opcion < 1) {
            System.out.println("No se reconoce la opción seleccionada");
            return true;
        }
        return false;
    }

    //funcion para limpiar la pantalla en consola 
    private void LimpiarPantalla(Scanner detener){
        System.out.println("Precione Enter para continuar");
        detener.nextLine();
          try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Fallo la acción de limpiar pantalla");
            }
    }
}
