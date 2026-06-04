/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JerarquiaEmpleados;

import Utilidades.ImportarDatos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ferna
 */
public class MenuPrincipal {
    
    
    public void IniciarEjecucion(){
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
        String direccionDocumentoEmpleados = "..//DatosEmpleados//DatosEmpleados.csv";
        
        //iniciar importacion de los empleados y guardarlos en una lista
        empleados = importacion.ImportarEmpleados(direccionDocumentoEmpleados);
        

        // flujo principal de ejecucion
        do {
            Mostrar_menu();
            int opcion = teclado.nextInt();

            while (entrada_valida == true) {
                entrada_valida = Validar_opcion(opcion);
            }

            Realizar_opcion(opcion, empleados, importacion);

            System.out.println();
            System.out.println("¿Desea Realizar otra operación? (y/n)");
            teclado.nextLine();
            String eleccion = teclado.nextLine();
            continuar = Continuar_programa(eleccion);//hacer un ciclo repetitivo.

        } while (continuar == true);
    }
    
     // mostrar el menu de opciones
    private void Mostrar_menu() {
        System.out.println("-------------Empresa Automotriz [PERFECT CAR]-------------");
        System.out.println("MENÚ OPCIONES:");
        System.out.println("1 - Mostrar Empleados.");
        System.out.println("2 - Ordenar y mostrar empleados alfabeticamente segun primer apellido.");
        System.out.println("3 - Ordenar y mostrar empleados  por sueldo.");
        System.out.println("4 - Mostrar cantidad de empleados según sus roles.");
        System.out.println("5 - salir.");
    }

    //realizar las opcciones segun menu de opciones
    private void Realizar_opcion(int opcion, List<Empleado> empleados, ImportarDatos importacion) {

        switch (opcion) {
            case 1:
                System.out.println("Mostrando Empleados");
                importacion.MostrarEmpleados(empleados);
                break;
            case 2:
                System.out.println("Eleccion 2");
                List<Empleado> empleadosOrdenados = new ArrayList<>();
                empleadosOrdenados = importacion.OrdenarEmpleados(empleados);
                importacion.MostrarEmpleados(empleadosOrdenados);
                break;
            case 3:
                System.out.println("Eleccion 3");
                List<Empleado> empleadoOrdenadoSalario = new ArrayList<>();
                empleadoOrdenadoSalario = importacion.OrdernarEmpleadosSalario(empleados);
                importacion.MostrarEmpleados(empleadoOrdenadoSalario);
                break;
            case 4:
                System.out.println("Eleccion 4");
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

    
    
}
