public class Nodo {
    private Object dato;
    private Nodo siguiente;
    private Nodo anterior;

    // Constructor para nodo simple
    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Constructor para nodo doble con siguiente y anterior
    public Nodo(Object dato, Nodo siguiente, Nodo anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    // Getters y Setters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return dato != null ? dato.toString() : "null";
    }
}
