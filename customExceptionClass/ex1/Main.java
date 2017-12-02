package zad1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        try {
            double result = Number.divide(a, b);
            System.out.println("Wynik dzielenia to: "+result);
        } catch (DivideZeroException e) {
            System.out.println("nie mozna dizelic przez 0");
        }
    }
}
