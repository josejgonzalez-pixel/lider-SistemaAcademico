
package sistemaacademico;

import java.util.ArrayList;

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
        }while(opcion != 0)
            // Aquí irás implementando los métodos de tu responsabilidad
    }
}
