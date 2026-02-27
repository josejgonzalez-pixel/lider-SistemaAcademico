
package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {
    //Listas globales en memoria
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static ArrayList<Nota> notas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        mostrarMenu();
    }
    //Menu principal
    public static void mostrarMenu(){
        int opcion;
        do{
            System.out.println("\n--- SISTEMA ACADÉMICO UPC ---");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Actualizar Estudiante");
            System.out.println("5. Eliminar Estudiante");
            //opciones sugeridas en el taller
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();//Limpiar buffer de memoria
            
            switch(opcion) {
                case 1: registrarEstudiante(); break;
                case 2: listarEstudiantes(); break;
                // ... resto de casos
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida");
            }
        }while(opcion != 0)
            // Aquí irás implementando los métodos de tu responsabilidad
    }
    public static void registrarEstudiante() {
     System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
     System.out.print("Código: "); String codigo = sc.nextLine();
     System.out.print("Nombre: "); String nombre = sc.nextLine();
     System.out.print("Apellido: "); String apellido = sc.nextLine();
     System.out.print("Edad: "); int edad = sc.nextInt();
     System.out.print("Semestre: "); int semestre = sc.nextInt();
     sc.nextLine(); // Limpiar buffer

     // Esta línea funcionará cuando el Desarrollador 1 entregue su parte
     estudiantes.add(new Estudiante(codigo, nombre, apellido, edad, semestre));
     System.out.println("Estudiante registrado con éxito.");
    }
    // Implementar listarEstudiantes() y buscarEstudiante() 
    public static void listarEstudiantes() {
     System.out.println("\n--- LISTA DE ESTUDIANTES ---");
     if (estudiantes.isEmpty()) {
        System.out.println("No hay estudiantes registrados.");
     } else {
        for (Estudiante e : estudiantes) {
            System.out.println(e.toString());
        }
     }
    }

    //Metodo buscar estudiante
    public static Estudiante buscarEstudiante(String codigo) {
     for (Estudiante e : estudiantes) {
        if (e.getCodigo().equals(codigo)) {
            return e;
        }
     }
     return null;
    }
    
    //actualizar estudiante
    public static void actualizarEstudiante(){
        System.out.print("Ingrese el código del estudiante a editar");
        String cod = sc.nextLine();
        
        for (estudiante e : estudiantes){
            if (e.getCodigo().equals(cod)){
                System.out.print("Nuevo Nombre (actual: " + e.getNombre() + "): ");
                e.setNombre(sc.nextLine());
                System.out.print("Nuevo Apellido: ");
                e.setApellido(sc.nextLine());
                System.out.print("Nuevo Semestre: ");
                e.setSemestre(sc.nextInt());
                sc.nextLine(); // Limpiar buffer
                System.out.println("Datos actualizados correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un estudiante con ese código.");
    }
}
