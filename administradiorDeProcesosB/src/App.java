public class App {
    private int PC = 0; // Program Counter
    private int IR; // Instruction Register
    private int ACC1 = 0; // Accumulator 1
    private int ACC2 = 0; // Accumulator 2
    private int[] memoria = new int[7]; // Arreglo de instrucciones (6 instrucciones)

    public void ejecutarInstrucciones() {
        Operacion1 operacion1 = new Operacion1();
        Operacion2 operacion2 = new Operacion2();
        EntradaDatos entradaDatos = new EntradaDatos();

        // Leer los operandos desde teclado
        int a = entradaDatos.leerEntero();
        int b = entradaDatos.leerEntero();

        // Cargar las instrucciones en la memoria
        memoria[0] = a; // Invocar a
        memoria[1] = b; // Invocar b
        memoria[2] = operacion2.suma(a, b); // a + b -> ACC1
        memoria[3] = operacion1.potencia(2, b); // 2 ^ b -> ACC2
        memoria[4] = memoria[2] - memoria[3]; // ACC1 - ACC2 -> ACC1
        memoria[5] = memoria[2] + memoria[3]; // ACC1 + ACC2 -> ACC2
        memoria[6] = memoria[4]; // ACC1 -> Imprimir

        entradaDatos.cerrarScanner();

        while (PC < memoria.length) {
            IR = memoria[PC];
            ejecutarInstruccion(IR);
            PC++;
        }
    }

    private void ejecutarInstruccion(int instruccion) {
        switch (instruccion) {
            case 0:
                ACC1 = memoria[0];
                break;
            case 1:
                ACC2 = memoria[1];
                break;
            case 2:
                ACC1 = memoria[2];
                break;
            case 3:
                ACC2 = memoria[3];
                break;
            case 4:
                ACC1 = memoria[4];
                break;
            case 5:
                ACC2 = memoria[5];
                break;
            case 6:
                System.out.println("ACC1: " + memoria[6]);
                break;
            default:
                System.out.println("Instrucción inválida");
                break;
        }
        imprimirEstado();
    }

    private void imprimirEstado() {
        System.out.println("PC: " + PC + ", IR: " + IR + ", ACC1: " + ACC1 + ", ACC2: " + ACC2);
    }

    public static void main(String[] args) {
        App procesador = new App();
        procesador.ejecutarInstrucciones();
    }
}