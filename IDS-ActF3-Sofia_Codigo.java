import java.util.ArrayList;
import java.util.Scanner;

// Clase base con los datos generales de cualquier estudiante.
class Estudiante {
    String nombre, matricula, carrera;
    double promedio;

    Estudiante(String n, String m, String c, double p) {
        nombre = n;
        matricula = m;
        carrera = c;
        promedio = p;
    }

    // Método general que reutilizan las clases derivadas.
    void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + "\nMatrícula: " + matricula
                + "\nCarrera: " + carrera + "\nPromedio: " + promedio);
    }
}

// Clase derivada: agrega el salón y hereda los datos de Estudiante.
class EstudiantePresencial extends Estudiante {
    String salon;

    EstudiantePresencial(String n, String m, String c, double p, String s) {
        super(n, m, c, p); // Llama al constructor de la clase base.
        salon = s;
    }

    @Override
    void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base.
        System.out.println("Salón: " + salon);
    }
}

// Otra clase derivada: agrega la plataforma de estudio.
class EstudianteEnLinea extends Estudiante {
    String plataforma;

    EstudianteEnLinea(String n, String m, String c, double p, String pl) {
        super(n, m, c, p); // Reutiliza el constructor de Estudiante.
        plataforma = pl;
    }

    @Override
    void mostrarInformacion() {
        super.mostrarInformacion(); // Reutiliza el método de la clase base.
        System.out.println("Plataforma: " + plataforma);
    }
}

// Clase principal que conserva el registro, consulta y búsqueda de la Unidad 2.
public class GestionEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> lista = new ArrayList<>();
        int op;

        do {
            System.out.println("\\n1. Registrar presencial  2. Registrar en línea"
                    + "\\n3. Mostrar estudiantes  4. Buscar matrícula  5. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1 || op == 2) {
                System.out.print("Nombre: ");
                String n = sc.nextLine();
                System.out.print("Matrícula: ");
                String m = sc.nextLine();
                System.out.print("Carrera: ");
                String c = sc.nextLine();
                System.out.print("Promedio: ");
                double p = sc.nextDouble();
                sc.nextLine();

                if (op == 1) {
                    System.out.print("Salón: ");
                    lista.add(new EstudiantePresencial(n, m, c, p, sc.nextLine()));
                } else {
                    System.out.print("Plataforma: ");
                    lista.add(new EstudianteEnLinea(n, m, c, p, sc.nextLine()));
                }
                System.out.println("Registro guardado.");

            } else if (op == 3) {
                for (Estudiante e : lista) {
                    e.mostrarInformacion(); // Se ejecuta la versión de cada subclase.
                    System.out.println("----------------");
                }

            } else if (op == 4) {
                System.out.print("Matrícula: ");
                String buscar = sc.nextLine();
                boolean encontrado = false;

                for (Estudiante e : lista) {
                    if (e.matricula.equalsIgnoreCase(buscar)) {
                        e.mostrarInformacion();
                        encontrado = true;
                    }
                }
                if (!encontrado) System.out.println("No se encontró el estudiante.");
            }
        } while (op != 5);

        sc.close();
    }
}
