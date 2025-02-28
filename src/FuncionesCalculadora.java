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
                + "8. SALIR\n\n"
                + "Por favor, ingrese el número de la función que desea ejecutar:";

        String opcion = JOptionPane.showInputDialog(menu);
        desicion(opcion);
    }

    public static void desicion(String opcion) {
        switch (opcion) {
            case "1":
                JOptionPane.showMessageDialog(null, "Seleccionaste Sumar");
                Suma();
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "Seleccionaste resta");
                Resta();
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "Seleccionaste multiplicar");
                Multiplicar();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Seleccionaste dividir");
                Dividir();
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "Función de la fórmula del estudiante en construcción...");
                FE();
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

    public static String ingresoDato(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public static boolean noValido(String datos) {
        if (!datos.matches("-?[0-9]+(\\.[0-9]+)?")) {
            JOptionPane.showMessageDialog(null, "Carácter inválido, solo ingrese valores numéricos.");
            return true;
        }
        return false;
    }
    public static void Suma() {
        String num1 =JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 =JOptionPane.showInputDialog(null, "Ingrese el segundo numero");
        float nume1, nume2, sum;
        nume1= Float.parseFloat(num1);
        nume2= Float.parseFloat(num2);
        sum= nume1+nume2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es : "+sum);
    }
    public static void Resta() {
        String num1 =JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 =JOptionPane.showInputDialog(null, "Ingrese el segundo numero");
        float nume1, nume2, res;
        nume1= Float.parseFloat(num1);
        nume2= Float.parseFloat(num2);
        res= nume1-nume2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es : "+res);
    }
    public static void Multiplicar() {
        String num1 =JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 =JOptionPane.showInputDialog(null, "Ingrese el segundo numero");
        float nume1, nume2, mul;
        nume1= Float.parseFloat(num1);
        nume2= Float.parseFloat(num2);
        mul= nume1*nume2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es : "+mul);
    }
    public static void Dividir() {
        String num1 =JOptionPane.showInputDialog(null, "Ingrese el primer numero");
        String num2 =JOptionPane.showInputDialog(null, "Ingrese el segundo numero");
        float nume1, nume2, div;
        nume1= Float.parseFloat(num1);
        nume2= Float.parseFloat(num2);
        div= nume1/nume2;
        JOptionPane.showMessageDialog(null, "El resultado de la suma es : "+div);
    }
    public static void FE() {
        String num1 =JOptionPane.showInputDialog(null, "Ingrese a");
        String num2 =JOptionPane.showInputDialog(null, "Ingrese b");
        String num3 =JOptionPane.showInputDialog(null, "Ingrese c");
        float nume1, nume2,nume3, discriminante;

        nume1= Float.parseFloat(num1);
        nume2= Float.parseFloat(num2);
        nume3= Float.parseFloat(num3);
        discriminante = nume2 + (nume2 * nume2) - 4 * (nume1 * nume3);
        if (discriminante < 0) {
            JOptionPane.showMessageDialog(null, "La ecuación no tiene soluciones reales.");
        }else{
            double raiz = Math.sqrt(discriminante);
            double fe1 = (-nume2 + raiz) / (2 * nume1);
            double fe2 = (-nume2 - raiz) / (2 * nume1);
            JOptionPane.showMessageDialog(null, "El resultado en x1 : "+fe1+"El resultado en x2 : "+fe2);
        }

    }



}
