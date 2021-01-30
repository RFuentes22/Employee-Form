package Employees.entities;

public class Empleado {

    private int idEmpleado;
    private String nombres;
    private String apellidos;
    private String cedula;
    private char estadoCivil;
    private char genero;
    private int edad;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombres, String apellidos, String cedula, char estadoCivil, char genero, int edad) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.edad = edad;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", estadoCivil=" + estadoCivil +
                ", genero=" + genero +
                ", edad=" + edad +
                '}';
    }
}
