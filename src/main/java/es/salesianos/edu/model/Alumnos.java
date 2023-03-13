package es.salesianos.edu.model;

public class Alumnos {
    private int id;
    private String nombre;
    private String fct;

    public Alumnos(int id, String nombre, String fct) {
        this.id = id;
        this.nombre = nombre;
        this.fct = fct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }
    
}
