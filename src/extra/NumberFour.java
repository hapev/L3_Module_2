package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NumberFour implements ActionListener {
	JPanel panel;
	JFrame frame;
	JButton add;
	JButton remove;
	JButton save;
	JButton load;
	JButton selectedTask;

	ArrayList<JButton> list;

	public NumberFour() {
		panel = new JPanel();
		frame = new JFrame();
		add = new JButton();
		remove = new JButton();
		save = new JButton();
		load = new JButton();
		list = new ArrayList<JButton>();

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
		panel.add(J);
		frame.pack();
		frame.setVisible(true);

		
	}

	public void run() {
		frame.add(panel);
		
		panel.add(add);
		panel.add(remove);
		panel.add(load);
		panel.add(save);
		load.setText("load");
		save.setText("save");
		remove.setText("remove");
		add.setText("add");
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
		if (e.getSource()!=add||e.getSource()!=remove||e.getSource()!=load||e.getSource()!=save) {
			selectedTask = (JButton)e.getSource();
		}

	}

	public void remove() {
		if (selectedTask !=null) {
		JButton j = selectedTask;
		frame.setVisible(false);
		panel.remove(j);
		list.remove(j);
		frame.pack();
		frame.setVisible(true);
		
		}
	}

}
