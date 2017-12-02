package zad2;

public class BankAccount {
    double billing;

    public double getBilling() {
        return billing;
    }

    public void setBilling(double billing) {
        this.billing = billing;
    }

    BankAccount(double accountAmount) {
        this.billing = accountAmount;
    }

    public void deposit(double ammount) {
        this.billing += ammount;
    }

    public void withdraw(double ammount) throws InsufficientFoundsException {
        try {
            if (this.billing < ammount) {
                throw new InsufficientFoundsException("Ex: probouje wybrac z konta wiece niz masz");
            } else
                this.billing -= ammount;
        } catch (InsufficientFoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
