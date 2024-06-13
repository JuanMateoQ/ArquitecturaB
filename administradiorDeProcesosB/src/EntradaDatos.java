import java.util.Scanner;

public class EntradaDatos {
    private Scanner scanner = new Scanner(System.in);

    public int leerEntero() {
        System.out.print("Ingrese un numero entero: ");
        return scanner.nextInt();
    }

    public void cerrarScanner() {
        scanner.close();
    }
}