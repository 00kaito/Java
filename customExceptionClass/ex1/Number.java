package zad1;


public class Number {

    private Number(){
        //utility - tworzac konstruktora private zabezpieczam sie by nie torzyc instancji tej klasy
    }

    public static double divide(double a, double b) throws  DivideZeroException {
        if (b == 0)
            throw new DivideZeroException();
        else
            return (double)a/b;

    }
}
