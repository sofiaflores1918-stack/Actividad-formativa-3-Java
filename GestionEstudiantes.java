import java.util.ArrayList;
import java.util.Scanner;

// Clase para guardar los datos de un estudiante.
class Estudiante {
    private String nombre;
    private String matricula;
    private String carrera;
    private double promedio;

    // El constructor permite crear un estudiante con sus datos iniciales.
    public Estudiante(String nombre, String matricula, String carrera, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    // Estos métodos permiten consultar los datos del estudiante.
    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    // Muestra toda la información del estudiante en pantalla.
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Matricula: " + matricula);
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
        System.out.println("---------------------------");
    }
}

// Esta clase contiene el menú y las opciones para administrar estudiantes.
public class GestionEstudiantes {
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        // El menú se repite hasta que la persona elija salir.
        do {
            System.out.println("\n=== SISTEMA DE GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar por matricula");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.print("Escribe un numero valido: ");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        teclado.close();
    }

    // Solicita los datos y crea un objeto de tipo Estudiante.
    private static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Matricula: ");
        String matricula = teclado.nextLine();

        System.out.print("Carrera: ");
        String carrera = teclado.nextLine();

        System.out.print("Promedio: ");
        while (!teclado.hasNextDouble()) {
            System.out.print("Escribe un promedio que sea valido: ");
            teclado.next();
        }
        double promedio = teclado.nextDouble();
        teclado.nextLine();

        Estudiante nuevo = new Estudiante(nombre, matricula, carrera, promedio);
        estudiantes.add(nuevo);
        System.out.println("Registrado correctamente.");
    }

    // Recorre la lista y muestra la información de todos los estudiantes.
    private static void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInformacion();
        }
    }

    // Busca un estudiante comparando la matrícula escrita con la guardada.
    private static void buscarEstudiante() {
        System.out.print("Escribe la matricula que buscas: ");
        String matriculaBuscada = teclado.nextLine();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getMatricula().equalsIgnoreCase(matriculaBuscada)) {
                System.out.println("Estudiante encontrado:");
                estudiante.mostrarInformacion();
                return;
            }
        }

        System.out.println("No se encontro un estudiante con esa matricula.");
    }
}
