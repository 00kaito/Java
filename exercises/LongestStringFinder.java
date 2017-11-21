import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Random;

public class LongestStringFinder {
    public static void main(String[] args) throws FileNotFoundException {
        //nadjluzszy ciag znakow taki, ze kolejny jest wiekszy/mniejszy od poprzedniego
        int[] ciagLosowy = tworzeniTablicy(25, 20);
        najdluzszyCiag(ciagLosowy);
    }

    static void najdluzszyCiag(int[] tab) {
        String nastSzukany;
        int counter = 1;
        int max = 0;
        int[] szukanyCiagTmp = new int[tab.length];
        int[] szukanyCiagKoncowy = new int[tab.length];
        int a=0;

        while (tab[a]==tab[a+1]){
            a++;
        }
        if (tab[a] < tab[a+1]) {
            nastSzukany = "W";
        } else {
            nastSzukany = "M";
        }
//Gdy liczby obok siebie maja te same wartosci
        for (int i = 1; i < tab.length; i++) {
            if(tab[i-1]==tab[i]){
                counter = 1;
                zerowanie(szukanyCiagTmp);
                continue;
            }
            // W - wiekszy
            // M - mniejszy
            if (tab[i-1] < tab[i] && nastSzukany.equals("W")) {
                counter++;
                nastSzukany = "M";
                szukanyCiagTmp[i-1]=tab[i-1];
                szukanyCiagTmp[i]=tab[i];
            }
            else if (tab[i-1] > tab[i] && nastSzukany.equals("M")) {
                counter++;
                nastSzukany = "W";
                szukanyCiagTmp[i-1]=tab[i-1];
                szukanyCiagTmp[i]=tab[i];
            }
            else {
                counter = 1;
                if (tab[i-1] < tab[i]) {
                    nastSzukany = "W";
                } else {
                    nastSzukany = "M";
                }
                i--;
                //zerowanie szukanegoCiagu
                zerowanie(szukanyCiagTmp);
            }
            if (counter > max) {
                max = counter;
                szukanyCiagKoncowy = przepiszTab(szukanyCiagTmp);
            }
        }
        System.out.println("\nNajdluzszy ciag: " + max);
        wypiszTab(szukanyCiagKoncowy);
    }

    //#################################
    static int[] tworzeniTablicy(int wielkoscTablicy, int przedzialLosowanychLiczb){

        int[] ciag = new int[wielkoscTablicy];
        Random r = new Random();
        System.out.print("LOSOWA TABLICA: ");

        for(int i=0; i<wielkoscTablicy; i++){
            ciag[i]=r.nextInt(przedzialLosowanychLiczb);
            System.out.print(ciag[i]+",");
        }
        return ciag;
    }

    //#################################
    static int[] zerowanie(int[] szukanyCiag){
        for(int j=0; j<szukanyCiag.length; j++){
            szukanyCiag[j]=0;
        }
        return szukanyCiag;
    }

    //#################################
    static void wypiszTab(int[] szukanyCiag){
        System.out.print("Szukany ciąg: ");
        for(int i=0; i<szukanyCiag.length; i++){
            System.out.print(szukanyCiag[i]+"|");
        }
    }

    //#################################
    static int[] przepiszTab(int[] tab){
        int[] newTab = new int[tab.length];

        for(int i=0; i<tab.length; i++){
            newTab[i]=tab[i];
        }
        return newTab;
    }
}
