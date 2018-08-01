package extra;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NumberFour implements ActionListener {
	JPanel panel1;
	JPanel panel2;
	JFrame frame;
	JButton add;
	JButton remove;
	JButton save;
	JButton load;
	JButton selectedTask;
	int height = 200;
	int width = 720;
	int whichTask = 0;

	public ArrayList<JButton> list;

	public NumberFour() {
		panel1 = new JPanel();
		panel2 = new JPanel();
		frame = new JFrame();
		add = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		list = new ArrayList<JButton>();
		BorderLayout manager = new BorderLayout();
		frame.setLayout(manager);
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}

	public void add() {
		JButton J = new JButton(JOptionPane.showInputDialog("Type Your Task Here"));

		frame.setVisible(false);
		list.add(J);
		J.addActionListener(this);
		J.setText(J.getText());

		panel2.add(J, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

	}

	public void run() {
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.SOUTH);
		panel1.add(add);
		panel1.add(remove);
		panel1.add(load);
		panel1.add(save);
		load.setText("load");
		save.setText("save");
		remove.setText("remove");
		add.setText("add");
		load();
		frame.pack();

		frame.setVisible(true);
		


	}

	public static void main(String[] args) {
		NumberFour nf = new NumberFour();
		nf.run();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			add();
		}
		if (e.getSource() == remove) {
			remove();
		}
		if (e.getSource() == save) {
			write();
		}
		if (e.getSource() == load) {
			load();
		}
		
		
		if (e.getSource() != add && e.getSource() != remove && e.getSource() != load && e.getSource() != save) {
			selectedTask = (JButton) e.getSource();
		}

	}

	public void remove() {
		if (selectedTask != null) {
			JButton j = selectedTask;
			frame.setVisible(false);
			panel2.remove(j);
			list.remove(j);
			frame.pack();
			frame.setVisible(true);

		}
	}

	public void write() {
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			FileWriter fWriter = new FileWriter(chooser.getSelectedFile());
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for (JButton J:list) {
				bWriter.write(J.getText()+"\n");
				
				
			}
			bWriter.flush();
			
			bWriter.close();
			fWriter.close();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		}
		public void load() {
			
			for (JButton J:list) {
				
				panel2.remove(J);
			
			}
			
			list.clear();
				
				
				try {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				FileReader fReader = new FileReader(chooser.getSelectedFile());
				BufferedReader bReader = new BufferedReader(fReader);
		
				
				String read = bReader.readLine();
				while (read != null) {
					JButton J = new JButton(read);
					frame.setVisible(false);
					list.add(J);
					J.addActionListener(this);
					J.setText(J.getText());
					panel2.add(J, BorderLayout.CENTER);
					frame.pack();
					frame.setVisible(true);
					read = bReader.readLine();

				}
				fReader.close();
				bReader.close();

				

				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
//Copyright © 2018 by Evan Coats