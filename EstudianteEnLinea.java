// Clase derivada: también hereda de Estudiante.
public class EstudianteEnLinea extends Estudiante {
    private String plataforma;

    // super(...) reutiliza el constructor de la clase base.
    public EstudianteEnLinea(String nombre, String matricula, String carrera,
                             double promedio, String plataforma) {
        super(nombre, matricula, carrera, promedio);
        this.plataforma = plataforma; // Guarda la plataforma.
    }

    // Sobrescribe el método para incluir la plataforma.
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base.
        System.out.println("Plataforma: " + plataforma);
    }
}
