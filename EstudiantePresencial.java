// Clase derivada: hereda de la clase Estudiante.
public class EstudiantePresencial extends Estudiante {
    private String salon;

    // super(...) envía los datos generales al constructor base.
    public EstudiantePresencial(String nombre, String matricula, String carrera,
                                double promedio, String salon) {
        super(nombre, matricula, carrera, promedio);
        this.salon = salon; // Guarda el salón.
    }

    // Sobrescribe el método para incluir el salón.
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Llama al método de la clase base.
        System.out.println("Salón: " + salon);
    }
}
