
//Clase Persona.

package Proyecto2;

public class Persona {
    
    //Variables.
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String carrera;

    //Constructor.
    public Persona(String cedula, String nombre, String apellido1, String apellido2, String carrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.carrera = carrera;
    }
    
    //Getters and Setters.
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }  
    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }  
}
    
