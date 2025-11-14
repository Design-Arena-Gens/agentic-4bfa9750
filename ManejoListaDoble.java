import javax.swing.JOptionPane;

public class ManejoListaDoble {
    private ListaDoble lista;

    // Constructor
    public ManejoListaDoble() {
        this.lista = new ListaDoble();
    }

    // Agrega un elemento al inicio
    public void agregarAlInicio() {
        try {
            Elemento elemento = capturarElemento();
            if (elemento != null) {
                // Validar que el ID no exista
                if (lista.buscarPorId(elemento.getId()) != null) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe un elemento con el ID " + elemento.getId(),
                        "ID Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                lista.insertarAlInicio(elemento);
                JOptionPane.showMessageDialog(null,
                    "Elemento agregado al inicio correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al agregar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Agrega un elemento al final
    public void agregarAlFinal() {
        try {
            Elemento elemento = capturarElemento();
            if (elemento != null) {
                // Validar que el ID no exista
                if (lista.buscarPorId(elemento.getId()) != null) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe un elemento con el ID " + elemento.getId(),
                        "ID Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                lista.insertarAlFinal(elemento);
                JOptionPane.showMessageDialog(null,
                    "Elemento agregado al final correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al agregar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Inserta antes de un elemento específico
    public void insertarAntes() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos de referencia.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String idRefStr = JOptionPane.showInputDialog(null,
                "Ingrese el ID del elemento de referencia:",
                "Insertar Antes",
                JOptionPane.QUESTION_MESSAGE);

            if (idRefStr == null || idRefStr.trim().isEmpty()) {
                return;
            }

            int idReferencia = Integer.parseInt(idRefStr.trim());

            // Verificar que existe el elemento de referencia
            if (lista.buscarPorId(idReferencia) == null) {
                JOptionPane.showMessageDialog(null,
                    "No se encontró un elemento con ID " + idReferencia,
                    "Elemento No Encontrado",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            Elemento elemento = capturarElemento();
            if (elemento != null) {
                // Validar que el ID no exista
                if (lista.buscarPorId(elemento.getId()) != null) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe un elemento con el ID " + elemento.getId(),
                        "ID Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (lista.insertarAntesDe(idReferencia, elemento)) {
                    JOptionPane.showMessageDialog(null,
                        "Elemento insertado correctamente antes del ID " + idReferencia,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                        "No se pudo insertar el elemento",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Error: Debe ingresar un ID válido (número entero)",
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al insertar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Inserta después de un elemento específico
    public void insertarDespues() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos de referencia.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String idRefStr = JOptionPane.showInputDialog(null,
                "Ingrese el ID del elemento de referencia:",
                "Insertar Después",
                JOptionPane.QUESTION_MESSAGE);

            if (idRefStr == null || idRefStr.trim().isEmpty()) {
                return;
            }

            int idReferencia = Integer.parseInt(idRefStr.trim());

            // Verificar que existe el elemento de referencia
            if (lista.buscarPorId(idReferencia) == null) {
                JOptionPane.showMessageDialog(null,
                    "No se encontró un elemento con ID " + idReferencia,
                    "Elemento No Encontrado",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            Elemento elemento = capturarElemento();
            if (elemento != null) {
                // Validar que el ID no exista
                if (lista.buscarPorId(elemento.getId()) != null) {
                    JOptionPane.showMessageDialog(null,
                        "Error: Ya existe un elemento con el ID " + elemento.getId(),
                        "ID Duplicado",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (lista.insertarDespuesDe(idReferencia, elemento)) {
                    JOptionPane.showMessageDialog(null,
                        "Elemento insertado correctamente después del ID " + idReferencia,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                        "No se pudo insertar el elemento",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Error: Debe ingresar un ID válido (número entero)",
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al insertar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Busca un elemento por ID
    public void buscarElemento() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para buscar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String idStr = JOptionPane.showInputDialog(null,
                "Ingrese el ID del elemento a buscar:",
                "Buscar Elemento",
                JOptionPane.QUESTION_MESSAGE);

            if (idStr == null || idStr.trim().isEmpty()) {
                return;
            }

            int id = Integer.parseInt(idStr.trim());
            Nodo nodo = lista.buscarPorId(id);

            if (nodo != null) {
                Elemento elemento = (Elemento) nodo.getDato();
                JOptionPane.showMessageDialog(null,
                    "Elemento encontrado:\n\n" + elemento.toString(),
                    "Búsqueda Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "No se encontró un elemento con ID " + id,
                    "Elemento No Encontrado",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Error: Debe ingresar un ID válido (número entero)",
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al buscar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Elimina el primer elemento
    public void eliminarPrimero() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para eliminar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Object dato = lista.eliminarPrimero();
            if (dato != null) {
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado:\n\n" + dato.toString(),
                    "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al eliminar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Elimina el último elemento
    public void eliminarUltimo() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para eliminar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Object dato = lista.eliminarUltimo();
            if (dato != null) {
                JOptionPane.showMessageDialog(null,
                    "Elemento eliminado:\n\n" + dato.toString(),
                    "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al eliminar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Elimina un elemento por ID
    public void eliminarPorId() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para eliminar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String idStr = JOptionPane.showInputDialog(null,
                "Ingrese el ID del elemento a eliminar:",
                "Eliminar Elemento",
                JOptionPane.QUESTION_MESSAGE);

            if (idStr == null || idStr.trim().isEmpty()) {
                return;
            }

            int id = Integer.parseInt(idStr.trim());

            // Buscar el elemento antes de eliminarlo para mostrar información
            Nodo nodo = lista.buscarPorId(id);
            if (nodo == null) {
                JOptionPane.showMessageDialog(null,
                    "No se encontró un elemento con ID " + id,
                    "Elemento No Encontrado",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (lista.eliminarPorId(id)) {
                JOptionPane.showMessageDialog(null,
                    "Elemento con ID " + id + " eliminado correctamente",
                    "Eliminación Exitosa",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "No se pudo eliminar el elemento",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Error: Debe ingresar un ID válido (número entero)",
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al eliminar elemento: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Muestra la lista desde el inicio
    public void mostrarDesdeCabeza() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para mostrar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String contenido = lista.imprimirDesdeCabeza();
            JOptionPane.showMessageDialog(null,
                contenido,
                "Contenido de la Lista (Desde Inicio)",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al mostrar la lista: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Muestra la lista desde el final
    public void mostrarDesdeCola() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista está vacía. No hay elementos para mostrar.",
                "Lista Vacía",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String contenido = lista.imprimirDesdeCola();
            JOptionPane.showMessageDialog(null,
                contenido,
                "Contenido de la Lista (Desde Final)",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al mostrar la lista: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Vacía la lista completa
    public void vaciarLista() {
        if (lista.estaVacia()) {
            JOptionPane.showMessageDialog(null,
                "La lista ya está vacía.",
                "Lista Vacía",
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro que desea vaciar toda la lista?\n" +
                "Esta acción no se puede deshacer.",
                "Confirmar Vaciado",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

            if (confirmacion == JOptionPane.YES_OPTION) {
                lista.liberar();
                JOptionPane.showMessageDialog(null,
                    "La lista ha sido vaciada correctamente",
                    "Lista Vaciada",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al vaciar la lista: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Muestra información de la lista
    public void mostrarInformacion() {
        try {
            String info = "Información de la Lista Doble\n";
            info += "==============================\n\n";
            info += "Tamaño: " + lista.getTamanio() + " elementos\n";
            info += "Estado: " + (lista.estaVacia() ? "Vacía" : "Con elementos") + "\n";

            if (!lista.estaVacia()) {
                Nodo cabeza = lista.getCabeza();
                Nodo cola = lista.getCola();

                if (cabeza != null && cabeza.getDato() instanceof Elemento) {
                    Elemento primero = (Elemento) cabeza.getDato();
                    info += "\nPrimer elemento:\n" + primero.toString() + "\n";
                }

                if (cola != null && cola.getDato() instanceof Elemento) {
                    Elemento ultimo = (Elemento) cola.getDato();
                    info += "\nÚltimo elemento:\n" + ultimo.toString() + "\n";
                }
            }

            JOptionPane.showMessageDialog(null,
                info,
                "Información de la Lista",
                JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al mostrar información: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método auxiliar para capturar un elemento desde el usuario
    private Elemento capturarElemento() {
        try {
            // Capturar ID
            String idStr = JOptionPane.showInputDialog(null,
                "Ingrese el ID del elemento:",
                "Captura de Datos",
                JOptionPane.QUESTION_MESSAGE);

            if (idStr == null || idStr.trim().isEmpty()) {
                return null;
            }

            int id = Integer.parseInt(idStr.trim());

            // Capturar Nombre
            String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre del elemento:",
                "Captura de Datos",
                JOptionPane.QUESTION_MESSAGE);

            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                    "El nombre no puede estar vacío",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Capturar Descripción
            String descripcion = JOptionPane.showInputDialog(null,
                "Ingrese la descripción del elemento:",
                "Captura de Datos",
                JOptionPane.QUESTION_MESSAGE);

            if (descripcion == null || descripcion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                    "La descripción no puede estar vacía",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
                return null;
            }

            return new Elemento(id, nombre.trim(), descripcion.trim());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                "Error: El ID debe ser un número entero válido",
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
