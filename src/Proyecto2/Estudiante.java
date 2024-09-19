
//Clase Estudiante.

package Proyecto2;

public class Estudiante extends Persona {
    
    //Variables.
    private float proyecto1;
    private float proyecto2;
    private float foroAcademico;
    private float encuesta;
    private float juego;
    private float promedio;

    //Constructor.
    public Estudiante(float proyecto1, float proyecto2, float foroAcademico, float encuesta, float juego, float promedio, String cedula, String nombre, String apellido1, String apellido2, String carrera) {
        super(cedula, nombre, apellido1, apellido2, carrera);
        this.proyecto1 = proyecto1;
        this.proyecto2 = proyecto2;
        this.foroAcademico = foroAcademico;
        this.encuesta = encuesta;
        this.juego = juego;
        this.promedio = promedio;
    }

    //Getters and Setters.
    public float getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(float proyecto1) {
        this.proyecto1 = proyecto1;
    }

    public float getProyecto2() {
        return proyecto2;
    }

    public void setProyecto2(float proyecto2) {
        this.proyecto2 = proyecto2;
    }

    public float getForoAcademico() {
        return foroAcademico;
    }

    public void setForoAcademico(float foroAcademico) {
        this.foroAcademico = foroAcademico;
    }

    public float getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(float encuesta) {
        this.encuesta = encuesta;
    }

    public float getJuego() {
        return juego;
    }

    public void setJuego(float juego) {
        this.juego = juego;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
}