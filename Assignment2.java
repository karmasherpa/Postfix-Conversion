
import java.io.*;
import java.io.IOException;

public class Assignment2 {

	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub

		try {
			FileInputStream fstream = new FileInputStream("Assignment2.txt");

			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String line = "";

			// read line by line

			while ((line = br.readLine()) != null) {

				System.out.println("Infix = " + line);
				Converter infixTOpost = new Converter();
				System.out.println("Postfix: "+infixTOpost.convertPostfix(line));

			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
