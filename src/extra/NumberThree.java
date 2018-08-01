package extra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberThree {
	public static void main(String[] args) {

		printFileName(new File("src"));
	}

	static void printFileName(File f) {
		System.out.println(f.getAbsolutePath());
		if (f.isDirectory()) {
			for (File f2 : f.listFiles()) {
				printFileName(f2);
			}

		} else {
			if (f.getName().endsWith(".java")) {
				try {
				FileWriter fr = new FileWriter(f.getAbsolutePath(), true);
				BufferedWriter bw = new BufferedWriter(fr);
				String copyright = "//Copyright © 2018 by Evan Coats";
				bw.append("\n").append(copyright);
				bw.flush();
				bw.close();

			} catch (IOException e) {

				e.printStackTrace();
			}
			}
		
		}

	}
}

//Copyright © 2018 by Evan Coats
//Copyright © 2018 by Evan Coats