package quinto_exercicio;

import java.util.Scanner;

public class Quinto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String original = sc.nextLine();

        String invertida = inverter(original);

        System.out.println("Original: " + original);
        System.out.println("Invertida: " + invertida);
        sc.close();
    }

    public static String inverter(String str) {
        char[] caracteres = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            caracteres[i] = str.charAt(str.length() - 1 - i);
        }
        return new String(caracteres);
    }
}
