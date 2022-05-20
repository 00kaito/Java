import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileReadingAndOperating {
	
	public String wyszukajLiczby(BufferedReader in) throws IOException{
		String str;
		String komunikat="sorry, no historical data results, try again";
		int[] tabl= sprawdzListeLiczb();
		while((str = in.readLine())!=null){
			int[]numbers = zamianaStrNaInt(str);
			Arrays.sort(tabl);
			boolean rowne = Arrays.equals(tabl, numbers);
			if (rowne){
				komunikat = "We find it! The lucky lottery was:" + wyswietlDate(str);
			}
		}
		return komunikat;
		
	}
	
	public int[] sprawdzListeLiczb() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wyswietlKomunikat("Enter numbers in the range 1-49");
		int[] tabl = new int[6];
		for (int i=0; i<tabl.length; i++){
			tabl[i]=sprawdzLiczbe(br);
		}
		return tabl;
	}
	
	//sprawdzanie liczby wprowadzonej przez uzytkownika
	public int sprawdzLiczbe(BufferedReader br) throws IOException{
		boolean poprawnie = false;
		int j = 0;
		// vsc test
		do{
			try{
				j = Integer.parseInt(br.readLine());
				if ((j<1) || (j>49)){
					throw new InvalidNumber();
				} else{
					poprawnie = true;
				}
			}
			catch (NumberFormatException nfe){
				wyswietlBlad("wrong number");
			}
			catch (InvalidNumber e){
				wyswietlBlad("Number out of range");
			}
		}
		while (!poprawnie);
		return j;
	}
	
	public int[] zamianaStrNaInt(String str){
		String[] tab = str.substring(str.lastIndexOf(" ")+1).split(",");
		int[] numbers = new int[6];
		for (int i = 0; i < tab.length; i++) {
			numbers[i] = Integer.parseInt(tab[i]);
		}
		Arrays.sort(numbers);
		return numbers;
	}

	public String wyswietlDate(String str){
		return str.substring(str.indexOf(" ")+1, str.lastIndexOf(" ")+1);
	}
	
	public void wyswietlBlad(String str){
		System.err.println(str);
	}
	
	public void wyswietlKomunikat(String str){
		System.out.println(str);
	}
	
}