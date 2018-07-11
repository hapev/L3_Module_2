package extra;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class NumberTwo {
	public static void main(String[] args) {

		try {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);

			FileReader fr = new FileReader(chooser.getSelectedFile());

			FileWriter fw = new FileWriter("src/extra/encrypted.txt");
			int read = fr.read();
			while (read != -1) {
				fw.write((char) read + 1);
				read = fr.read();
			}
			fw.flush();
			fw.close();
			fr.close();
			FileWriter fw2 = new FileWriter("src/extra/decrypted.txt");
			FileReader fr2 = new FileReader("src/extra/encrypted.txt");

			int read2 = fr2.read();
			System.out.println(read2);
			while (read2 != -1) {
				fw2.write((char) read2 - 1);
				read2 = fr2.read();
			}



			fr2.close();
			fw2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}


//Copyright © 2018 by Evan Coats