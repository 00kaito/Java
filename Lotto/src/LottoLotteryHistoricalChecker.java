import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class LottoLotteryHistoricalChecker {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.mbnet.com.pl/dl.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String str;
		
		FileReadingAndOperating opr = new FileReadingAndOperating();
		System.out.println(opr.wyszukajLiczby(in));
		in.close();
		
	}

}
/*
- results get from remote file
- reading files
- getting user data
- comparison with historical lotto results
- user feedback

*/