import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        ManejoListaDoble manejador = new ManejoListaDoble();
        boolean continuar = true;

        // Mensaje de bienvenida
        JOptionPane.showMessageDialog(null,
            "Bienvenido al Sistema de Gestión de Lista Doble\n\n" +
            "Este programa permite gestionar una lista doblemente enlazada\n" +
            "con operaciones de inserción, eliminación y visualización.",
            "Sistema de Lista Doble",
            JOptionPane.INFORMATION_MESSAGE);

        while (continuar) {
            try {
                String menu = "╔════════════════════════════════════════════╗\n";
                menu += "║    MENÚ - GESTIÓN DE LISTA DOBLE          ║\n";
                menu += "╠════════════════════════════════════════════╣\n";
                menu += "║  1. Agregar elemento al inicio             ║\n";
                menu += "║  2. Agregar elemento al final              ║\n";
                menu += "║  3. Insertar antes de un elemento          ║\n";
                menu += "║  4. Insertar después de un elemento        ║\n";
                menu += "║  5. Buscar elemento por ID                 ║\n";
                menu += "║  6. Eliminar primer elemento               ║\n";
                menu += "║  7. Eliminar último elemento               ║\n";
                menu += "║  8. Eliminar elemento por ID               ║\n";
                menu += "║  9. Mostrar lista desde el inicio          ║\n";
                menu += "║ 10. Mostrar lista desde el final           ║\n";
                menu += "║ 11. Mostrar información de la lista        ║\n";
                menu += "║ 12. Vaciar lista completa                  ║\n";
                menu += "║ 13. Salir del programa                     ║\n";
                menu += "╚════════════════════════════════════════════╝\n";
                menu += "\nSeleccione una opción:";

                String opcionStr = JOptionPane.showInputDialog(null,
                    menu,
                    "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE);

                // Verificar si el usuario canceló
                if (opcionStr == null) {
                    int confirmarSalida = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro que desea salir del programa?",
                        "Confirmar Salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                    if (confirmarSalida == JOptionPane.YES_OPTION) {
                        continuar = false;
                    }
                    continue;
                }

                // Validar que la opción no esté vacía
                if (opcionStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                        "Debe ingresar una opción válida",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                int opcion = Integer.parseInt(opcionStr.trim());

                switch (opcion) {
                    case 1:
                        manejador.agregarAlInicio();
                        break;

                    case 2:
                        manejador.agregarAlFinal();
                        break;

                    case 3:
                        manejador.insertarAntes();
                        break;

                    case 4:
                        manejador.insertarDespues();
                        break;

                    case 5:
                        manejador.buscarElemento();
                        break;

                    case 6:
                        manejador.eliminarPrimero();
                        break;

                    case 7:
                        manejador.eliminarUltimo();
                        break;

                    case 8:
                        manejador.eliminarPorId();
                        break;

                    case 9:
                        manejador.mostrarDesdeCabeza();
                        break;

                    case 10:
                        manejador.mostrarDesdeCola();
                        break;

                    case 11:
                        manejador.mostrarInformacion();
                        break;

                    case 12:
                        manejador.vaciarLista();
                        break;

                    case 13:
                        int confirmarSalida = JOptionPane.showConfirmDialog(null,
                            "¿Está seguro que desea salir del programa?",
                            "Confirmar Salida",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if (confirmarSalida == JOptionPane.YES_OPTION) {
                            continuar = false;
                            JOptionPane.showMessageDialog(null,
                                "Gracias por usar el Sistema de Gestión de Lista Doble\n" +
                                "¡Hasta pronto!",
                                "Salir",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,
                            "Opción inválida. Por favor seleccione un número entre 1 y 13.",
                            "Opción Inválida",
                            JOptionPane.ERROR_MESSAGE);
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                    "Error: Debe ingresar un número válido",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                    "Error inesperado: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
