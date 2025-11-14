public class Elemento {
    private int id;
    private String nombre;
    private String descripcion;

    // Constructor vacío
    public Elemento() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
    }

    // Constructor con parámetros
    public Elemento(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Descripción: " + descripcion;
    }
}
