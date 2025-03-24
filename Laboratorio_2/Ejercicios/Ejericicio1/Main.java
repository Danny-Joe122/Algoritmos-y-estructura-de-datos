package Operaciones;

import java.util.Scanner;

public class MenuOperaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú de Operaciones:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.print("¿Tipo de dato? (1: Integer, 2: Double): ");
                int tipo = sc.nextInt();

                if (tipo == 1) {
                    System.out.print("Valor A (int): ");
                    int a = sc.nextInt();
                    System.out.print("Valor B (int): ");
                    int b = sc.nextInt();

                    OperacionesMatBInteger op1 = new OperacionesMatBInteger(a);
                    OperacionesMatBInteger op2 = new OperacionesMatBInteger(b);

                    switch (opcion) {
                        case 1 -> System.out.println("Resultado: " + op1.sumar(op2).getValor());
                        case 2 -> System.out.println("Resultado: " + op1.restar(op2).getValor());
                        case 3 -> System.out.println("Resultado: " + op1.multiplicar(op2).getValor());
                        case 4 -> System.out.println("Resultado: " + op1.dividir(op2).getValor());
                        case 5 -> System.out.println("Resultado: " + Math.pow(a, b));
                        case 6 -> System.out.println("Resultado: " + Math.sqrt(a));
                        case 7 -> System.out.println("Resultado: " + Math.cbrt(a));
                    }

                } else if (tipo == 2) {
                    System.out.print("Valor A (double): ");
                    double a = sc.nextDouble();
                    System.out.print("Valor B (double): ");
                    double b = sc.nextDouble();

                    OperacionesMatDouble op1 = new OperacionesMatDouble(a);
                    OperacionesMatDouble op2 = new OperacionesMatDouble(b);

                    switch (opcion) {
                        case 1 -> System.out.println("Resultado: " + op1.sumar(op2).getValor());
                        case 2 -> System.out.println("Resultado: " + op1.restar(op2).getValor());
                        case 3 -> System.out.println("Resultado: " + op1.multiplicar(op2).getValor());
                        case 4 -> System.out.println("Resultado: " + op1.dividir(op2).getValor());
                        case 5 -> System.out.println("Resultado: " + Math.pow(a, b));
                        case 6 -> System.out.println("Resultado: " + Math.sqrt(a));
                        case 7 -> System.out.println("Resultado: " + Math.cbrt(a));
                    }
                } else {
                    System.out.println("Tipo inválido.");
                }
            }

        } while (opcion != 8);
        System.out.println("Programa terminado.");
    }
}
