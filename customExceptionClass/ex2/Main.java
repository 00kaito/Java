package zad2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InsufficientFoundsException {
        BankAccount myAccount = new BankAccount(0);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile ma na koncie?");

         myAccount.deposit(scanner.nextDouble());
        System.out.println("Ile chcesz wybrac z konta?");
        myAccount.withdraw(scanner.nextDouble());
        System.out.println("Na koncie pozostlao"+ myAccount.getBilling());
    }
}
