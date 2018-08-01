package extra;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class NumberOne {
public static void main(String[] args) {
	try {
		FileWriter fw = new FileWriter("src/extra/numberOne.txt");
		JOptionPane pane = new JOptionPane();
		fw.write(pane.showInputDialog("Write here!"));
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}


//Copyright © 2018 by Evan Coats
//Copyright © 2018 by Evan Coats