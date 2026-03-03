package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {

    // Listas globales en memoria
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static ArrayList<Nota> notas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- SISTEMA ACADÉMICO UPC ---");
            System.out.println("1. Gestión de Estudiantes");
            System.out.println("2. Gestión de Asignaturas");
            System.out.println("3. Gestión de Notas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> menuEstudiantes();
                case 2 -> menuAsignaturas();
                case 3 -> menuNotas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    // --- MÉTODOS GESTIÓN ESTUDIANTES (Responsabilidad D1) ---
    public static void menuEstudiantes() {
        System.out.println("\n1. Registrar 2. Listar 3. Buscar 4. Actualizar 5. Eliminar");
        int op = sc.nextInt(); sc.nextLine();
        switch(op) {
            case 1 -> registrarEstudiante();
            case 2 -> listarEstudiantes();
            case 3 -> {
                System.out.print("Código: ");
                Estudiante e = buscarEstudiante(sc.nextLine());
                System.out.println(e != null ? e : "No encontrado");
            }
            case 4 -> actualizarEstudiante();
            case 5 -> eliminarEstudiante();
        }
    }

    public static void registrarEstudiante() {
        System.out.print("Código: "); String cod = sc.nextLine();
        System.out.print("Nombre: "); String nom = sc.nextLine();
        System.out.print("Apellido: "); String ape = sc.nextLine();
        System.out.print("Edad: "); int ed = sc.nextInt();
        System.out.print("Semestre: "); int sem = sc.nextInt();
        sc.nextLine();
        estudiantes.add(new Estudiante(cod, nom, ape, ed, sem));
        System.out.println("Estudiante registrado.");
    }

    public static void listarEstudiantes() {
        if (estudiantes.isEmpty()) System.out.println("Lista vacía.");
        else estudiantes.forEach(System.out::println);
    }

    public static Estudiante buscarEstudiante(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) return e;
        }
        return null;
    }

    public static void actualizarEstudiante() {
        System.out.print("Código a editar: ");
        String cod = sc.nextLine();
        Estudiante e = buscarEstudiante(cod);
        if (e != null) {
            System.out.print("Nuevo Nombre: "); e.setNombre(sc.nextLine());
            System.out.print("Nuevo Apellido: "); e.setApellido(sc.nextLine());
            System.out.print("Nuevo Semestre: "); e.setSemestre(sc.nextInt());
            sc.nextLine();
            System.out.println("Actualizado.");
        } else System.out.println("No encontrado.");
    }

    public static void eliminarEstudiante() {
        System.out.print("Código a eliminar: ");
        String cod = sc.nextLine();
        boolean removed = estudiantes.removeIf(e -> e.getCodigo().equals(cod));
        System.out.println(removed ? "Eliminado." : "No encontrado.");
    }

    // --- MÉTODOS GESTIÓN ASIGNATURAS (Responsabilidad D1) ---
    public static void menuAsignaturas() {
        System.out.println("\n1. Registrar 2. Listar 3. Eliminar");
        int op = sc.nextInt(); sc.nextLine();
        if(op == 1) registrarAsignatura();
        else if(op == 2) listarAsignaturas();
        else if(op == 5) eliminarAsignatura();
    }

    public static void registrarAsignatura() {
        System.out.print("Código: "); String cod = sc.nextLine();
        System.out.print("Nombre: "); String nom = sc.nextLine();
        System.out.print("Créditos: "); int cre = sc.nextInt(); sc.nextLine();
        System.out.print("Docente: "); String doc = sc.nextLine();
        asignaturas.add(new Asignatura(cod, nom, cre, doc));
        System.out.println("Asignatura registrada.");
    }

    public static void listarAsignaturas() {
        if (asignaturas.isEmpty()) System.out.println("No hay asignaturas.");
        else asignaturas.forEach(System.out::println);
    }

    public static void eliminarAsignatura() {
        System.out.print("Código: ");
        String cod = sc.nextLine();
        asignaturas.removeIf(a -> a.getCodigo().equals(cod));
        System.out.println("Operación realizada.");
    }

    // --- MÉTODOS GESTIÓN NOTAS (Responsabilidad D2) ---
    public static void menuNotas() {
        System.out.println("\n1. Registrar Nota 2. Listar Notas");
        int op = sc.nextInt(); sc.nextLine();
        if(op == 1) registrarNota();
        else if(op == 2) listarNotas();
    }

    public static void registrarNota() {
        System.out.print("Cod Estudiante: "); String ce = sc.nextLine();
        System.out.print("Cod Asignatura: "); String ca = sc.nextLine();
        System.out.print("Valor: "); double v = sc.nextDouble(); sc.nextLine();
        notas.add(new Nota(ce, ca, v));
        System.out.println("Nota guardada.");
    }

    public static void listarNotas() {
        if (notas.isEmpty()) System.out.println("No hay notas.");
        else notas.forEach(System.out::println);
    }
}