import java.util.Scanner;

public class TorreDeHanoi {

    // Método recursivo para mover los discos
    public static void moverDiscos(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
        } else {
            moverDiscos(n - 1, origen, auxiliar, destino); // Mueve n-1 discos de origen a auxiliar
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino); // Mueve el disco n de origen a
                                                                                        // destino
            moverDiscos(n - 1, auxiliar, destino, origen); // Mueve n-1 discos de auxiliar a destino
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de discos
        System.out.print("Ingrese el número de discos: ");
        int numeroDeDiscos = scanner.nextInt();

        // Verificar que el número de discos sea válido
        if (numeroDeDiscos <= 0) {
            System.out.println("El número de discos debe ser mayor que 0.");
        } else {
            System.out.println("\nSolución para " + numeroDeDiscos + " discos:");
            moverDiscos(numeroDeDiscos, 'A', 'C', 'B'); // Llamada al método recursivo
        }

        scanner.close();
    }
}