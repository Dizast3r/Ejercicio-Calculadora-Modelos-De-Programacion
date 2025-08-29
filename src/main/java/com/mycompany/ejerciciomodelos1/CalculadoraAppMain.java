//Ladi Yolima Martinez Quiñones 20231020197
//Juan Estevan Ariza Ortiz 20241020005
//Jorge Miguel Mendez Baron 20241020030
package com.mycompany.ejerciciomodelos1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraAppMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int modo;

        System.out.println("=== CALCULADORA MULTI-BASE ===");
        System.out.println("Seleccione el modo de trabajo:");
        System.out.println("1. Binario");
        System.out.println("2. Octal");
        System.out.println("3. Decimal");
        System.out.print("Ingrese su opción (1-3): ");
        try {
            modo = scanner.nextInt();
            // cuando se habia realizado nextInt, queda el resultado volando en el escaner cuando se vuelva a llamar
            // si se le dice nextLine, "arroja" lo el int que habia quedado registrado y ahora si esta limpio pa volver a leer
            scanner.nextLine();

            switch (modo) {
                case 1:
                    manejarBinario(scanner);
                    break;
                case 2:
                    manejarOctal(scanner);
                    break;
                case 3:
                    manejarDecimal(scanner);
                    break;
                default:
                    System.out.println("Opción inválida, Cerrando programa...");
            }
        } catch (InputMismatchException e) {
            System.out.println("Operacion invalida, Cerrando programa....");
        }

        //ya se realizo la operacion, se cierra el escaner y chao programa :D
        scanner.close();
    }

    private static void manejarBinario(Scanner scanner) {
        Binario calc = new Binario();
        System.out.println("\n=== MODO BINARIO ===");

        System.out.print("Ingrese el primer número binario: ");
        //los metodos para conversiones con otras bases, parten de que el numero sea manejado como string, de ahí el nextLine() en ambos casos
        String num1 = scanner.nextLine();
        System.out.print("Ingrese el segundo número binario: ");
        String num2 = scanner.nextLine();

        //ahí con ese codigo estrambotico (obtenido de internet) estamos mirando si el numero (la cadena) cumple con la forma de un binario (solo 0 o 1)
        if ((!num1.matches("^[01]+$")) || (!num2.matches("^[01]+$"))) {
            System.out.println("Numero no en base binaria, Cerrando programa...");
            return;
        }

        //aqui se pasa a decimal momentaneamente para las operaciones
        calc.setNumerosBinarios(num1, num2);

        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.print("Ingrese su opción: ");

        String operacion = scanner.nextLine();

        if (operacion.equals("1")) {
            calc.sumar();
            System.out.println("\nResultado de la suma:");
        } else if (operacion.equals("2")) {
            calc.restar();
            System.out.println("\nResultado de la resta:");
        } else {
            System.out.println("Operación inválida, Cerrando programa....");
            return;
        }
        //el resultado estaba en decimal, lo pasamos a binario y lo mostramos
        System.out.println(calc.convertir());
    }

    private static void manejarOctal(Scanner scanner) {
        Octal calc = new Octal();
        System.out.println("\n=== MODO OCTAL ===");

        System.out.print("Ingrese el primer número octal: ");
        //los metodos para conversiones con otras bases, parten de que el numero sea manejado como string, de ahí el nextLine() en ambos casos
        String num1 = scanner.nextLine();
        System.out.print("Ingrese el segundo número octal: ");
        String num2 = scanner.nextLine();

        //ahí con ese codigo estrambotico (obtenido de internet) estamos mirando si el numero (la cadena) cumple con la forma de un octal (solo del 0 al 7)
        if ((!num1.matches("^[0-7]+$")) || (!num2.matches("^[0-7]+$"))) {
            System.out.println("Numero no en base octal, Cerrando programa...");
            return;
        }

        //aqui se colocaron como decimales pa las operaciones
        calc.setNumerosOctales(num1, num2);

        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.print("Ingrese su opción: ");

        String operacion = scanner.nextLine();

        if (operacion.equals("1")) {
            calc.sumar();
            System.out.println("\nResultado de la suma:");
        } else if (operacion.equals("2")) {
            calc.restar();
            System.out.println("\nResultado de la resta:");
        } else {
            System.out.println("Operación inválida, Cerrando programa....");
            return;
        }

        //aqui se pasa otra vez a octal para mostrar el resultado :D
        System.out.println(calc.convertir());
    }

    private static void manejarDecimal(Scanner scanner) {
        Calculadora calc = new Calculadora();
        System.out.println("\n=== MODO DECIMAL ===");

        //aqui el try catch del metodo main, tambien no es util, ya que es llamado si no se mete un double :p
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();

        //aqui ya esta en decimal, no se esta convirtiendo nada
        calc.setNumeros(num1, num2);

        System.out.println("\nSeleccione la operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.print("Ingrese su opción: ");

        String operacion = scanner.next();

        if (operacion.equals("1")) {
            calc.sumar();
            System.out.println("\nResultado de la suma:");
        } else if (operacion.equals("2")) {
            calc.restar();
            System.out.println("\nResultado de la resta:");
        } else {
            System.out.println("Operación inválida, Cerrando programa....");
            return;
        }

        System.out.println(calc.resultado);
    }
}
