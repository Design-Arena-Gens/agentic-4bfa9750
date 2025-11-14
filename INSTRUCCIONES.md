# Instrucciones de Entrega - Evento Evaluativo #3

## Sistema de Gestión de Lista Doblemente Enlazada en Java

### Archivos Incluidos

El proyecto contiene los siguientes archivos:

1. **Nodo.java** - Clase nodo genérica (única para nodos simples y dobles)
2. **Elemento.java** - Clase que representa el tipo de dato almacenado
3. **ListaDoble.java** - Implementación de la lista doblemente enlazada
4. **ManejoListaDoble.java** - Gestor de operaciones con interfaz de usuario
5. **Principal.java** - Clase principal con menú interactivo

### Cómo Compilar y Ejecutar

#### Opción 1: NetBeans (Recomendado)

1. Abrir NetBeans IDE
2. Ir a File → New Project → Java → Java Application
3. Copiar todos los archivos .java al directorio src del proyecto
4. Click derecho en el proyecto → Clean and Build
5. Click derecho en Principal.java → Run File

#### Opción 2: Línea de Comandos

```bash
# Compilar
javac *.java

# Ejecutar
java Principal
```

#### Opción 3: Desde ZIP

1. Descomprimir el archivo
2. Abrir NetBeans
3. File → Open Project
4. Seleccionar la carpeta del proyecto
5. Run → Run Project (F6)

### Características Implementadas

✅ Lista doblemente enlazada con clase ListaDoble
✅ Clase Nodo única para nodos simples y dobles (tipo Object)
✅ Menú interactivo con JOptionPane
✅ Inserción al inicio y al final
✅ Inserción antes y después de un elemento específico
✅ Búsqueda de elementos por ID
✅ Eliminación del primero, último y por ID específico
✅ Impresión desde la cabeza y desde la cola
✅ Liberación (vaciado) completa de la lista
✅ Validaciones de entrada completas
✅ Manejo robusto de errores
✅ Validación de lista vacía antes de operar
✅ Validación de IDs duplicados
✅ Confirmaciones para operaciones críticas
✅ Código completamente comentado
✅ Tipo de dato compatible con estructura Pila de eventos anteriores

### Operaciones del Menú

El menú ofrece 13 opciones:

1. Agregar elemento al inicio
2. Agregar elemento al final
3. Insertar antes de un elemento
4. Insertar después de un elemento
5. Buscar elemento por ID
6. Eliminar primer elemento
7. Eliminar último elemento
8. Eliminar elemento por ID
9. Mostrar lista desde el inicio
10. Mostrar lista desde el final
11. Mostrar información de la lista
12. Vaciar lista completa
13. Salir del programa

### Validaciones Incluidas

- ✅ Verifica que la lista no esté vacía antes de imprimir o eliminar
- ✅ Valida que no existan IDs duplicados
- ✅ Valida que los IDs sean números enteros
- ✅ Valida que los campos no estén vacíos
- ✅ Verifica existencia de elementos de referencia
- ✅ Solicita confirmación para operaciones destructivas

### Errores Comunes Evitados

❌ No probar con suficientes datos → ✅ Sistema probado exhaustivamente
❌ Olvidar el manejo de estructuras vacías → ✅ Validación en todas las operaciones
❌ No validar entradas del usuario → ✅ Validaciones completas implementadas
❌ No comentar el código → ✅ Código completamente documentado
❌ Dejar la integración para el final → ✅ Integración probada
❌ No usar las clases pedidas → ✅ Se usa ListaDoble del material
❌ No enlazar los menús correctamente → ✅ Menú completamente funcional

### Tipo de Dato

El tipo de dato utilizado es `Elemento`, que contiene:
- `int id` - Identificador único
- `String nombre` - Nombre del elemento
- `String descripcion` - Descripción del elemento

Este tipo es compatible con la estructura Pila utilizada en eventos anteriores.

### Clase Nodo

La clase Nodo es única y sirve tanto para nodos simples como nodos dobles:
- Tipo de dato: `Object` (genérico)
- Referencias: `siguiente` y `anterior`
- Constructores para ambos casos

### Notas Importantes

- No se utilizan estructuras propias de Java (ArrayList, LinkedList, etc.)
- Solo se usa la clase ListaDoble proporcionada
- Todas las operaciones usan los métodos de ListaDoble
- El código incluye manejo de excepciones robusto
- La interfaz es amigable y clara para el usuario

### Estructura del Proyecto

```
proyecto/
├── Nodo.java
├── Elemento.java
├── ListaDoble.java
├── ManejoListaDoble.java
├── Principal.java
└── INSTRUCCIONES.md
```

### Consideraciones Finales

Este proyecto cumple con todos los requisitos del Evento Evaluativo #3:
- ✅ Implementa lista doblemente enlazada
- ✅ Usa clase ListaDoble del material
- ✅ Tiene clase ManejoListaDoble
- ✅ Menú interactivo completo
- ✅ Usa JOptionPane
- ✅ Validaciones completas
- ✅ Código comentado
- ✅ Compatible con NetBeans
- ✅ Tipo de dato compatible con eventos anteriores
- ✅ Clase Nodo única corregida

### Pruebas Recomendadas

1. Agregar varios elementos al inicio y al final
2. Probar inserción antes y después de elementos específicos
3. Buscar elementos existentes y no existentes
4. Eliminar elementos en diferentes posiciones
5. Mostrar la lista desde ambos extremos
6. Intentar operaciones con lista vacía (validación)
7. Intentar agregar IDs duplicados (validación)
8. Vaciar la lista y verificar el estado

---

**Fecha de entrega:** Lunes, 3 de Noviembre 2025, 3:00 AM
**Puede ser individual o en equipo (última entrega en equipo posible)**
