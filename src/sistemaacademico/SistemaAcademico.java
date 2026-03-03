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
    static ArrayList<Nota> notas = new ArrayList<>();
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
            System.out.println("2. listar asignatura");
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
                case 2 ->
                    listarAsignaturas();
                case 3 ->
                    buscarAsignatura();
                case 4 ->
                    actualizarAsignatura();
                case 5 ->
                    eliminarAsignatura();
                case 0 ->
                    System.out.println("Saliendo");
                default ->
                    System.out.println("opcion invalida");
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
        System.out.println("asignatura registrada");
    }


    public static void listarAsignaturas() {
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas");
        } else {
            asignaturas.forEach(System.out::println);
        }
    }

    
    private static Asignatura buscarAsignatura(String codigo) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }
        return null;
    }

    public static void buscarAsignatura() {
        System.out.print("Ingrese codigo: ");
        String codigo = sc.nextLine();
        Asignatura a = buscarAsignatura(codigo);
        System.out.println(a != null ? a : "asignatura no encontrada");
    }
    
    public static void actualizarAsignatura() { 
        System.out.print("Codigo: "); 
        String codigo = sc.nextLine();
        Asignatura a = buscarAsignatura(codigo);
        if (a != null) { 
        System.out.print("nuevo nombre: ");
        a.setNombre(sc.nextLine());
        System.out.print("nuevos creditos: ");
        a.setCreditos(sc.nextInt());
        sc.nextLine();
        System.out.print("nuevo docente: ");

        a.setDocente(sc.nextLine());
        System.out.println("Asignatura actualizada.");
        } else { System.out.println("Asignatura no encontrada");
        } 
    }
   
    public static void eliminarAsignatura() {
        System.out.print("codigo: ");
        String codigo = sc.nextLine();
        boolean removed = asignaturas.removeIf(a -> a.getCodigo().equals(codigo));
        if (removed) {
            System.out.println("asignatura eliminada.");
        } else {
            System.out.println("asignatura no encontrada");
        }
    }

    //Metodos Nota
    public static void registrarNota() {
        System.out.print("Codigo estudiante: ");
        String codEst = sc.nextLine();

        System.out.print("Codigo asignatura: ");
        String codAsig = sc.nextLine();

        System.out.print("Valor nota: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Nota nueva = new Nota(codEst, codAsig, valor);
        notas.add(nueva);

        System.out.println("Nota registrada correctamente.");
    }
    
    public static void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            for (Nota n : notas) {
                System.out.println(n);
            }
        }
    }
    
    public static void buscarNota() {
        System.out.print("Codigo estudiante: ");
        String codigo = sc.nextLine();

        for (Nota n : notas) {
            if (n.getCodigoEstudiante().equals(codigo)) {
                System.out.println("Nota encontrada:");
                System.out.println(n);
                return;
            }
        }

        System.out.println("Nota no encontrada.");
    }
    
    public static void actualizarNota() {
        System.out.print("Codigo estudiante: ");
        String codigo = sc.nextLine();

        for (Nota n : notas) {
            if (n.getCodigoEstudiante().equals(codigo)) {

                System.out.print("Nuevo valor: ");
                double nuevoValor = sc.nextDouble();
                sc.nextLine();

                n.setValor(nuevoValor);

                System.out.println("Nota actualizada.");
                return;
            }
        }

        System.out.println("Nota no encontrada.");
    }
    
    public static void eliminarNota() {
        System.out.print("Codigo estudiante: ");
        String codigo = sc.nextLine();

        for (Nota n : notas) {
            if (n.getCodigoEstudiante().equals(codigo)) {
                notas.remove(n);
                System.out.println("Nota eliminada.");
                return;
            }
        }

        System.out.println("Nota no encontrada.");
    }
}
