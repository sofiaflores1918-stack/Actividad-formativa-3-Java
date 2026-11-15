// Clase base: contiene los datos que comparten los estudiantes.
public class Estudiante {
    protected String nombre, matricula, carrera;
    protected double promedio;

    // Constructor que guarda los datos generales.
    public Estudiante(String nombre, String matricula, String carrera, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    // Regresa la matrícula para realizar búsquedas.
    public String getMatricula() {
        return matricula;
    }

    // Muestra la información general del estudiante.
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
    }
}
