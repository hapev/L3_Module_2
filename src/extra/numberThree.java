package extra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class numberThree {
public static void main(String[] args) {
	

}

public void printFileName(File f) {
	
	if (f.isDirectory()) {
		for (File f2 : f.listFiles()) {
			printFileName(f2);
		}
		
	}
	else {
		try {
			BufferedWriter bw = new BufferedWriter("src/extra/Files.txt");
			bw.append(c)
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
}
}
