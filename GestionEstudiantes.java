import java.util.ArrayList;
import java.util.Scanner;

// Clase principal: contiene el menú del programa.
public class GestionEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Lee los datos del usuario.
        ArrayList<Estudiante> estudiantes = new ArrayList<>(); // Guarda estudiantes.
        int opcion;

        // El menú se repite hasta elegir la opción 5.
        do {
            System.out.println("\n1. Registrar presencial");
            System.out.println("2. Registrar en línea");
            System.out.println("3. Mostrar estudiantes");
            System.out.println("4. Buscar por matrícula");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el salto de línea.

            // Registra un estudiante según el tipo seleccionado.
            if (opcion == 1 || opcion == 2) {
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Matrícula: ");
                String matricula = sc.nextLine();
                System.out.print("Carrera: ");
                String carrera = sc.nextLine();
                System.out.print("Promedio: ");
                double promedio = sc.nextDouble();
                sc.nextLine();

                if (opcion == 1) {
                    // Crea y guarda un estudiante presencial.
                    System.out.print("Salón: ");
                    String salon = sc.nextLine();
                    estudiantes.add(new EstudiantePresencial(
                            nombre, matricula, carrera, promedio, salon));
                } else {
                    // Crea y guarda un estudiante en línea.
                    System.out.print("Plataforma: ");
                    String plataforma = sc.nextLine();
                    estudiantes.add(new EstudianteEnLinea(
                            nombre, matricula, carrera, promedio, plataforma));
                }
                System.out.println("Estudiante registrado.");

            } else if (opcion == 3) {
                // Recorre la lista y muestra cada estudiante.
                for (Estudiante e : estudiantes) {
                    e.mostrarInformacion(); // Llama al método correspondiente.
                    System.out.println("----------------");
                }

            } else if (opcion == 4) {
                // Busca un registro usando su matrícula.
                System.out.print("Matrícula a buscar: ");
                String buscar = sc.nextLine();

                for (Estudiante e : estudiantes) {
                    if (e.getMatricula().equals(buscar)) {
                        e.mostrarInformacion(); // Muestra el resultado encontrado.
                    }
                }
            }
        } while (opcion != 5);

        sc.close(); // Cierra el Scanner.
    }
}
