public class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;
    private int tamanio;

    // Constructor
    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    // Verifica si la lista está vacía
    public boolean estaVacia() {
        return cabeza == null;
    }

    // Obtiene el tamaño de la lista
    public int getTamanio() {
        return tamanio;
    }

    // Inserta un nodo al inicio de la lista
    public void insertarAlInicio(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        tamanio++;
    }

    // Inserta un nodo al final de la lista
    public void insertarAlFinal(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        tamanio++;
    }

    // Busca un nodo por ID (asumiendo que el dato es de tipo Elemento)
    public Nodo buscarPorId(int id) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getDato() instanceof Elemento) {
                Elemento elemento = (Elemento) actual.getDato();
                if (elemento.getId() == id) {
                    return actual;
                }
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Inserta antes de un nodo específico
    public boolean insertarAntesDe(int idReferencia, Object dato) {
        if (estaVacia()) {
            return false;
        }

        Nodo nodoReferencia = buscarPorId(idReferencia);

        if (nodoReferencia == null) {
            return false;
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (nodoReferencia == cabeza) {
            insertarAlInicio(dato);
        } else {
            Nodo anterior = nodoReferencia.getAnterior();
            nuevoNodo.setSiguiente(nodoReferencia);
            nuevoNodo.setAnterior(anterior);
            anterior.setSiguiente(nuevoNodo);
            nodoReferencia.setAnterior(nuevoNodo);
            tamanio++;
        }
        return true;
    }

    // Inserta después de un nodo específico
    public boolean insertarDespuesDe(int idReferencia, Object dato) {
        if (estaVacia()) {
            return false;
        }

        Nodo nodoReferencia = buscarPorId(idReferencia);

        if (nodoReferencia == null) {
            return false;
        }

        Nodo nuevoNodo = new Nodo(dato);

        if (nodoReferencia == cola) {
            insertarAlFinal(dato);
        } else {
            Nodo siguiente = nodoReferencia.getSiguiente();
            nuevoNodo.setAnterior(nodoReferencia);
            nuevoNodo.setSiguiente(siguiente);
            nodoReferencia.setSiguiente(nuevoNodo);
            siguiente.setAnterior(nuevoNodo);
            tamanio++;
        }
        return true;
    }

    // Elimina el primer nodo
    public Object eliminarPrimero() {
        if (estaVacia()) {
            return null;
        }

        Object dato = cabeza.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    // Elimina el último nodo
    public Object eliminarUltimo() {
        if (estaVacia()) {
            return null;
        }

        Object dato = cola.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return dato;
    }

    // Elimina un nodo por ID
    public boolean eliminarPorId(int id) {
        if (estaVacia()) {
            return false;
        }

        Nodo nodoEliminar = buscarPorId(id);

        if (nodoEliminar == null) {
            return false;
        }

        if (nodoEliminar == cabeza) {
            eliminarPrimero();
        } else if (nodoEliminar == cola) {
            eliminarUltimo();
        } else {
            Nodo anterior = nodoEliminar.getAnterior();
            Nodo siguiente = nodoEliminar.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            tamanio--;
        }
        return true;
    }

    // Imprime la lista desde la cabeza
    public String imprimirDesdeCabeza() {
        if (estaVacia()) {
            return "La lista está vacía";
        }

        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        int posicion = 1;

        sb.append("Lista desde el inicio:\n");
        sb.append("=====================\n");

        while (actual != null) {
            sb.append("Posición ").append(posicion).append(": ");
            sb.append(actual.getDato()).append("\n");
            actual = actual.getSiguiente();
            posicion++;
        }

        return sb.toString();
    }

    // Imprime la lista desde la cola
    public String imprimirDesdeCola() {
        if (estaVacia()) {
            return "La lista está vacía";
        }

        StringBuilder sb = new StringBuilder();
        Nodo actual = cola;
        int posicion = tamanio;

        sb.append("Lista desde el final:\n");
        sb.append("=====================\n");

        while (actual != null) {
            sb.append("Posición ").append(posicion).append(": ");
            sb.append(actual.getDato()).append("\n");
            actual = actual.getAnterior();
            posicion--;
        }

        return sb.toString();
    }

    // Libera (vacía) toda la lista
    public void liberar() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    // Obtiene la cabeza de la lista
    public Nodo getCabeza() {
        return cabeza;
    }

    // Obtiene la cola de la lista
    public Nodo getCola() {
        return cola;
    }
}
