/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jos13
 */
public class SistemaAcademico {

    /**
     * @param args the command line arguments
     */
    static ArrayList<estudiante> estudiantes = new ArrayList<>();
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA ACADEMICO =====");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Actualizar Estudiante");
            System.out.println("5. Eliminar Estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione1 una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 ->
                    registrarEstudiante();
                /*case 2 ->
                    listarEstudiantes();
                case 3 ->
                    buscarEstudiante();
                case 4 ->
                    actualizarEstudiante();
                case 5 ->
                    eliminarEstudiante();*/
                case 0 ->
                    System.out.println("Saliendo");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
        
    }
    
    public static void registrarEstudiante() {
        System.out.print("codigo: ");
        String codigo = sc.nextLine(); 
        System.out.print("nombre: ");
        String nombre = sc.nextLine();
        System.out.print("apellido: "); 
        String apellido = sc.nextLine(); 
        System.out.print("edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        estudiantes.add(new estudiante(codigo, nombre, apellido, edad));
        System.out.println("Estudiante registrado."); }
}

        
    
    

