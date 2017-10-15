import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class espressioneTest extends espressione {

	public static void main(String[] args) throws IOException {
	//	FileReader lettura= new FileReader("Espressione.txt");
		BufferedReader reader=new BufferedReader(new FileReader("Espressione.txt"));
			   String line=reader.readLine();
			  
		
		espressione es1=new espressione();
		es1.aggiungi(new BufferedReader(reader));
		
		
		/*es1.aggiungi(new String("*"));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new Double(1.0));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(4.0));
		es1.aggiungi(new Double(1.0));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new Double(3.0));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new Double(9.0));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("*"));

		es1.aggiungi(new Double(14.0));
		es1.aggiungi(new Double(0.3));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(1.0));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new Double(6.0));
		es1.aggiungi(new Double(5.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new Double(1.0));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new Double(8.0));
		es1.aggiungi(new Double(8.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new Double(6.0));
		es1.aggiungi(new Double(6.0));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new Double(8.0));
		es1.aggiungi(new Double(4.0));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("+"));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(5.0));
		es1.aggiungi(new Double(1.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(4.0));
		es1.aggiungi(new Double(2.0));
		es1.aggiungi(new String("-"));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(4.0));
		es1.aggiungi(new Double(7.0));
		es1.aggiungi(new String("*"));
		es1.aggiungi(new Double(7.0));
		es1.aggiungi(new Double(9.0));*/
		
		 
		es1.operazione();
		es1.stampa();

	}

}
