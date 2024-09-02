package segundo_exercicio;

import java.util.Scanner;

public class Segundo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num = sc.nextInt();

        if (fibonacci(num)) {
            System.out.print(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.print(num + " não pertence à sequência de Fibonacci.");
        }

        sc.close();
    }

    public static boolean fibonacci(int num) {
        if (num < 0) {
            return false;
        }

        int a = 0;
        int b = 1;

        while (a < num) {
            int temporaria = a;
            a = b;
            b = temporaria + b;
        }
        return a == num;
    }
}
