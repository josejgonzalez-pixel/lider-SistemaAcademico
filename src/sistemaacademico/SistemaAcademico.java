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
   
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA ACADEMICO =====");
            System.out.println("1. Registrar asignatura");
            System.out.println("2. Listar asignatura");
            System.out.println("3. Buscar asignatura ");
            System.out.println("4. Actualizar asignatura");
            System.out.println("5. Eliminar asignatura");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 ->
                    registrarAsignatura();
                /*case 2 ->
                   listarAsignaturas();
                case 3 ->
                    buscarAsignatura();
                case 4 ->
                    actualizarAsignatura();
                case 5 ->
                    eliminarAsignatura();*/
                case 0 ->
                    System.out.println("Saliendo");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
  
    }
    public static void registrarAsignatura() { 
        System.out.print("codigo: ");
        String codigo = sc.nextLine();
        System.out.print("nombre: ");
        String nombre = sc.nextLine();
        System.out.print("creditos: ");
        int creditos = sc.nextInt();
        sc.nextLine();
        System.out.print("docente: ");
        String docente = sc.nextLine();
        asignaturas.add(new Asignatura(codigo, nombre, creditos, docente));
        System.out.println("asignatura registrada."); }

    private static class Asignatura {

        public Asignatura(String codigo, String nombre, int creditos, String docente) {
        }
    }
    
    
    
    
    
   
 
}

        
    
    

