import javax.swing.*;

public class FuncionesCalculadora{
public static void main(String[] args) {
        menuCalculadora();
    }

    public static void menuCalculadora() {

        String menu = "Calculadora\n"
                + "1. SUMAR\n"
                + "2. RESTAR\n"
                + "3. MULTIPLICAR\n"
                + "4. DIVIDIR\n"
                + "5. FÓRMULA DEL ESTUDIANTE\n"
                + "6. RAIZ CUADRADA\n"
                + "7. POTENCIA\n"
                + "8. MODULO\n"
                + "9. CELSIUS A FAHRENHEIT\n"
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
                JOptionPane.showConfirmDialog(null, "Seleccionaste Modulo");
                Modulo();
                break;
            case "9":
                JOptionPane.showConfirmDialog(null, "Seleccionaste Celsius a Fahrenheit");
                CelciusAFahrenheit();
                break;
            case "10":
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

        if (novalido(nume1) || novalido(nume2)) {
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

    public static void FE() {
        String nume1 = JOptionPane.showInputDialog(null, "Ingrese a");
        String nume2 = JOptionPane.showInputDialog(null, "Ingrese b");
        String nume3 = JOptionPane.showInputDialog(null, "ingrese c");

        if (novalido(nume1) || novalido(nume2) || novalido(nume3)) {
            JOptionPane.showMessageDialog(null, "Ingrese unicamente valores numericos validos");
            return;

        }

        float a = Float.parseFloat(nume1);
        float b = Float.parseFloat(nume2);
        float c = Float.parseFloat(nume3);

        float discriminante = b * b - 4 * a * c;
        if (discriminante < 0) {
            JOptionPane.showMessageDialog(null, "No tiene solucion Real");
        } else {
            double raiz = Math.sqrt(discriminante);
            double x1 = (-b + raiz) / (2 * a);
            double x2 = (-b - raiz) / (2 * a);
            JOptionPane.showMessageDialog(null, "El resultado en x1: " + x1 + "\nEl resultado en x2: " + x2);
        }

    }

    public static void RaizCuadrada() {
        String nume = JOptionPane.showInputDialog(null, "Ingrese el numero para calcular su raiz");
        if (novalido(nume)) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico valido");
            return;
        }

        float numero = Float.parseFloat(nume);
        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "no se puede calcular la raiz de un numero negativo");
        } else {
            double raiz = Math.sqrt(numero);
            JOptionPane.showMessageDialog(null, "la raiz cuadrada de " + numero + " es:" + raiz);
        }

    }

    public static void Potencia() {
        String base = JOptionPane.showInputDialog(null, "Ingrese la base");
        String exponente = JOptionPane.showInputDialog(null, "ingrese el exponente");

        if (novalido(base) || novalido(exponente)) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numericos validos");
            return;
        }

        float baseN = Float.parseFloat(base);
        float exponenteN = Float.parseFloat(exponente);

        double potencia = Math.pow(baseN, exponenteN);
        JOptionPane.showMessageDialog(null,
                "El resultado de " + baseN + " elevado a " + exponenteN + " es: " + potencia);

    }

    public static void Modulo() {
        String num1 = JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 = JOptionPane.showInputDialog(null, "Ingrese el segundo número");
        if (novalido(num1) || novalido(num2)) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numericos validos");
            return;
        }

        float nume1 = Float.parseFloat(num1);
        float nume2 = Float.parseFloat(num2);

        if (nume2 == 0) {
            JOptionPane.showMessageDialog(null,
                    "No se puede caulular el modulo de una division en cero, rey en que quedamos?");
        } else {
            float modulo = nume1 % nume2;
            JOptionPane.showMessageDialog(null, "El resultado del modulo es: " + modulo);
        }
    }

    public static boolean novalido(String datos) {
        if (!datos.matches("-?[0-9]+(\\.[0-9]+)?")) {
            JOptionPane.showMessageDialog(null, "Caracter invalido, solo valores numericos");
            return true;
        }
        return false;
    }
    
    public static void CelciusAFahrenheit() {
        String celsius = JOptionPane.showInputDialog(null, "ingrese la temperatura en grados Celsius:");

        if (novalido(celsius)) {
            JOptionPane.showMessageDialog(null, "ingrese un valor numerico valido");
            return;
        }

        float celsiusNum = Float.parseFloat(celsius);
        float fahrenheit = (celsiusNum * 9 / 5) + 32;

        JOptionPane.showMessageDialog(null, celsiusNum + " °C equivale a " + fahrenheit + " °F");

    }
    
}