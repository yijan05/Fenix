import javax.swing.*;

public class FuncionesCalculadora {
    public static void main(String[] args) {
        menuCalculadora();
    }

    public static void menuCalculadora() {
        // Menú corregido
        String menu = "Calculadora\n"
                + "1. SUMAR\n"
                + "2. RESTAR\n"
                + "3. MULTIPLICAR\n"
                + "4. DIVIDIR\n"
                + "5. FÓRMULA DEL ESTUDIANTE\n"
                + "6. RAIZ CUADRADA\n"
                + "7. POTENCIA\n"
                + "8. SALIR\n\n"
                + "Por favor, ingrese el número de la función que desea ejecutar:";

        String opcion = JOptionPane.showInputDialog(menu);
        desicion(opcion);
    }

    public static void desicion(String opcion) {
        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, "Seleccionaste Sumar");
                operacion("suma");
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "Seleccionaste resta");
                operacion("resta");
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "Seleccionaste multiplicar");
                operacion("multiplicacion");
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Seleccionaste dividir");
                operacion("division");
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "Función de la fórmula del estudiante en construcción...");
                FE();
                break;
            case "6":
                JOptionPane.showMessageDialog(null, "Seleccionaste Raiz Cuadrada");
                break;
            case "7":
                JOptionPane.showMessageDialog(null, "Seleccionaste Potencia");
                break;
            case "8":
                JOptionPane.showMessageDialog(null, "Saliendo de la calculadora...");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
                menuCalculadora();
        }
    }

    public static void operacion(String tipo) {
        String nume1 = JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String nume2 = JOptionPane.showInputDialog(null, "Ingerese el segundo numeo");

        if (noValido(nume1) || noValido(nume2)) {
            JOptionPane.showMessageDialog(null, "Carácter inválido, solo ingrese valores numéricos.");
            return;

        }

        float n1 = Float.parseFloat(nume1);
        float n2 = Float.parseFloat(nume2);
        float resultado = 0;

        switch (tipo) {
            case "suma":
                resultado = n1 + n2;
                JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
                break;
            case "resta":
                resultado = n1 - n2;
                JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + resultado);
                break;
            case "multiplicacion":
                JOptionPane.showMessageDialog(null, "El resultado de la multiplicacion es: " + resultado);
                break;
            case " division":
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero rey, ubicate");
                } else {
                    resultado = n1 / n2;
                    JOptionPane.showMessageDialog(null, "el resultado de la division es: " + resultado);
                }
                break;

        }
    }

}
