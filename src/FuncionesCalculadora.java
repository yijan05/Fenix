import javax.swing.*;

public class FuncionesCalculadora {
    public static void main(String[] args) {
        menuCalculadora();
    }

    public static void menuCalculadora() {
        while (true) {
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
                    + "10. SEN\n"
                    + "11. COS\n"
                    + "12. TAN\n"
                    + "13. PORCENTAJE\n"
                    + "13. SALIR\n\n"
                    + "Por favor, ingrese el número de la función que desea ejecutar:";

            String opcion = JOptionPane.showInputDialog(menu);

            if (opcion == null || opcion.equals("10")) {
                JOptionPane.showMessageDialog(null, "Saliendo de la calculadora...");
                System.exit(0);
            }

            desicion(opcion);

            int continuar = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra operación?", "Calculadora",
                    JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Saliendo de la calculadora...");
                System.exit(0);
            }
        }
    }

    public static void desicion(String opcion) {
        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, "Seleccionaste Sumar");
                operacion("suma");
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "Seleccionaste Restar");
                operacion("resta");
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "Seleccionaste Multiplicar");
                operacion("multiplicacion");
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Seleccionaste Dividir");
                operacion("division");
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "Seleccionaste Fórmula del Estudiante");
                FE();
                break;
            case "6":
                JOptionPane.showMessageDialog(null, "Seleccionaste Raíz Cuadrada");
                RaizCuadrada();
                break;
            case "7":
                JOptionPane.showMessageDialog(null, "Seleccionaste Potencia");
                Potencia();
                break;
            case "8":
                JOptionPane.showMessageDialog(null, "Seleccionaste Módulo");
                Modulo();
                break;
            case "9":
                JOptionPane.showMessageDialog(null, "Seleccionaste Convertir Celsius a Fahrenheit");
                CelsiusAFahrenheit();
                break;
            case "10":
                JOptionPane.showMessageDialog(null, "Seleccionaste Seno");
                Sen();
                break;
            case "11":
                JOptionPane.showMessageDialog(null, "Seleccionaste Coseno");
                Cos();
                break;
            case "12":
                JOptionPane.showMessageDialog(null, "Seleccionaste Tangente");
                Tan();
                break;
            case "13":
                JOptionPane.showMessageDialog(null, "Seleccionaste Porcentaje");
                Porcentaje();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
        }
    }

    public static void operacion(String tipo) {
        String num1 = JOptionPane.showInputDialog(null, "Ingrese el primer número");
        String num2 = JOptionPane.showInputDialog(null, "Ingrese el segundo número");

        if (noValido(num1) || noValido(num2)) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
            return;
        }

        float nume1 = Float.parseFloat(num1);
        float nume2 = Float.parseFloat(num2);
        float resultado = 0;

        switch (tipo) {
            case "suma":
                resultado = nume1 + nume2;
                JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
                break;
            case "resta":
                resultado = nume1 - nume2;
                JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + resultado);
                break;
            case "multiplicacion":
                resultado = nume1 * nume2;
                JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: " + resultado);
                break;
            case "division":
                if (nume2 == 0) {
                    JOptionPane.showMessageDialog(null, "No se puede dividir por cero");
                } else {
                    resultado = nume1 / nume2;
                    JOptionPane.showMessageDialog(null, "El resultado de la división es: " + resultado);
                }
                break;
        }
    }

    public static void FE() {
        String num1 = JOptionPane.showInputDialog(null, "Ingrese a");
        String num2 = JOptionPane.showInputDialog(null, "Ingrese b");
        String num3 = JOptionPane.showInputDialog(null, "Ingrese c");

        if (noValido(num1) || noValido(num2) || noValido(num3)) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos.");
            return;
        }

        float a = Float.parseFloat(num1);
        float b = Float.parseFloat(num2);
        float c = Float.parseFloat(num3);

        if (a == 0) {
            JOptionPane.showMessageDialog(null, "El valor de 'a' no puede ser 0. La ecuación no seria cuadratica.");
            return;
        }

        float discriminante = b * b - 4 * a * c;

        if (discriminante < 0) {
            JOptionPane.showMessageDialog(null, "No hay solucion Real");
        } else {
            double raiz = Math.sqrt(discriminante);
            double x1 = (-b + raiz) / (2 * a);
            double x2 = (-b - raiz) / (2 * a);
            JOptionPane.showMessageDialog(null, "El resultado en x1: " + x1 + "\nEl resultado en x2: " + x2);
        }
    }

    public static void RaizCuadrada() {
        String num = JOptionPane.showInputDialog(null, "Ingrese el número para calcular su raíz cuadrada");

        if (noValido(num)) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido.");
            return;
        }

        float numero = Float.parseFloat(num);

        if (numero < 0) {
            JOptionPane.showMessageDialog(null, "No se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            double raiz = Math.sqrt(numero);
            JOptionPane.showMessageDialog(null, "La raíz cuadrada de " + numero + " es: " + raiz);
        }
    }

    public static void Potencia() {
        String base = JOptionPane.showInputDialog(null, "Ingrese la base");
        String exponente = JOptionPane.showInputDialog(null, "Ingrese el exponente");

        if (noValido(base) || noValido(exponente)) {
            JOptionPane.showMessageDialog(null, "ingrese valores numéricos validos.");
            return;
        }

        float baseNum = Float.parseFloat(base);
        float exponenteNum = Float.parseFloat(exponente);

        double potencia = Math.pow(baseNum, exponenteNum);
        JOptionPane.showMessageDialog(null,
                "El resultado de " + baseNum + " elevado a " + exponenteNum + " es: " + potencia);
    }

    public static void Modulo() {
        String num1 = JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 = JOptionPane.showInputDialog(null, "Ingrese el segundo numero");

        if (noValido(num1) || noValido(num2)) {
            JOptionPane.showMessageDialog(null, "ingrese valores numéricos válidos.");
            return;
        }

        float nume1 = Float.parseFloat(num1);
        float nume2 = Float.parseFloat(num2);

        if (nume2 == 0) {
            JOptionPane.showMessageDialog(null, "No se puede calcular el modulo con divisor cero.");
        } else {
            float modulo = nume1 % nume2;
            JOptionPane.showMessageDialog(null, "El resultado del modulo es: " + modulo);
        }
    }

    public static void CelsiusAFahrenheit() {
        String celsius = JOptionPane.showInputDialog(null, "Ingrese la temperatura en grados Celsius:");

        if (noValido(celsius)) {
            JOptionPane.showMessageDialog(null, "ingrese un valor numerico valido.");
            return;
        }

        float celsiusNum = Float.parseFloat(celsius);
        float fahrenheit = (celsiusNum * 9 / 5) + 32;

        JOptionPane.showMessageDialog(null, celsiusNum + " °C equivale a " + fahrenheit + " °F");
    }

    public static void Sen() {
        String angulo = JOptionPane.showInputDialog(null, "Ingrese el ángulo en grados:");

        if (noValido(angulo)) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numérico valido.");
            return;
        }

        double anguloGrados = Double.parseDouble(angulo);
        double anguloRadianes = Math.toRadians(anguloGrados);
        double seno = Math.sin(anguloRadianes);

        JOptionPane.showMessageDialog(null, "El seno de " + anguloGrados + "es " + seno);

    }

    public static void Cos() {
        String angulo = JOptionPane.showInputDialog(null, "Ingrese el ángulo en grados:");

        if (noValido(angulo)) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor numerico valido.");
            return;
        }

        double anguloGrados = Double.parseDouble(angulo);
        double anguloRadianes = Math.toRadians(anguloGrados);
        double coseno = Math.cos(anguloRadianes);

        JOptionPane.showMessageDialog(null, "El coseno de " + anguloGrados + "° es: " + coseno);

    }

    public static void Tan() {
        String angulo = JOptionPane.showInputDialog(null, "Ingrese el ángulo en grados:");

        if (noValido(angulo)) {
            JOptionPane.showMessageDialog(null, "Ingrese valores numericos validos unicamendte");
            return;
        }
        
        double anguloGrados = Double.parseDouble(angulo);
        double anguloRadianes = Math.toRadians(anguloGrados);
        double tangente = Math.tan(anguloRadianes);

        if (anguloGrados % 90 == 0 && anguloGrados % 100 != 0) {
            JOptionPane.showMessageDialog(null, "La tangente de" + anguloGrados + " es indefinida");
        } else {
            JOptionPane.showMessageDialog(null, "la tangente de+ " + anguloGrados + " es: " + tangente);  
            }
        }

        public static void Porcentaje() {
            String numero = JOptionPane.showInputDialog(null, "Ingrese el numero:");
            String porcentaje = JOptionPane.showInputDialog(null, "Ingrese el porcentaje:");

            if (noValido(numero) || noValido(porcentaje)) {
                JOptionPane.showMessageDialog(null,"Ingrese solo valores numericos validos");
                return;
            }

            float num = Float.parseDouble(numero);
            float porc = Float.parseDouble(porcentaje);

            float resultado = (num * porc) / 100;
            JOptionPane.showMessageDialog(null, "El"+ "% de" + num+ "es: "+ resultado);
        }

    public static boolean noValido(String datos) {
        if (!datos.matches("-?[0-9]+(\\.[0-9]+)?")) {
            JOptionPane.showMessageDialog(null, "Caracter invalido, solo ingrese valores numéricos.");
            return true;
        }
        return false;
    }
} 