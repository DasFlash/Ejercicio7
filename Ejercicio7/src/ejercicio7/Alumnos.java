package ejercicio7;

public class Alumnos {
	private int nia;
    private String nombre;
    private String apellidos;
    private char genero;
    private String fechaNacimiento;
    private String ciclo;
    private String curso;
    private String grupo;

    public Alumnos(int nia, String nombre, String apellidos, char genero, String fechaNacimiento, String ciclo, String curso, String grupo) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.ciclo = ciclo;
        this.curso = curso;
        this.grupo = grupo;
    }

    // Getters
    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public char getGenero() {
        return genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCiclo() {
        return ciclo;
    }

    public String getCurso() {
        return curso;
    }

    public String getGrupo() {
        return grupo;
    }
}
