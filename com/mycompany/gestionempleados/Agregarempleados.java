import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    // Lista dinámica para almacenar empleados
    private List<Empleado> listaEmpleados;

    // Constructor
    public GestionEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    // Método para agregar un empleado
    public void agregarEmpleado(String nombre, String puesto) {
        Empleado nuevoEmpleado = new Empleado(ContadorEmpleados.getNextId(), nombre, puesto);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println("Empleado agregado: " + nuevoEmpleado);
    }

    // Método para mostrar todos los empleados
    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n=== Lista de empleados ===");
            for (Empleado emp : listaEmpleados) {
                System.out.println(emp);
            }
            System.out.println("==========================");
        }
    }

    // Método principal
    public static void main(String[] args) {
        GestionEmpleados gestion = new GestionEmpleados();

        // Agregar empleados
        gestion.agregarEmpleado("Juan Pérez", "Desarrollador");
        gestion.agregarEmpleado("Ana Gómez", "Diseñadora");
        gestion.agregarEmpleado("Carlos Ruiz", "Gerente");

        // Mostrar empleados
        gestion.mostrarEmpleados();

        // Mostrar el total de empleados registrados
        System.out.println("Total de empleados registrados: " + ContadorEmpleados.getContadorActual());
    }
}