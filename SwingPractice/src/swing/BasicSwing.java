package swing;

import javax.swing.*;

public class BasicSwing extends JFrame{
	
	JPanel panel = new JPanel();
	JButton button = new JButton("Hello");
	JTextField text = new JTextField("Hi" , 20); //cant go over multiple lines (string, columns)
	JTextArea textarea = new JTextArea("How \n are \n you", 5 , 20); //Can go over multiple lines (string, rows, columns)
	JLabel label = new JLabel("What's up"); //Cannot Edit Text
	String[] choices = {"Hallo" , "Bonjour" , "Konichiwa" };
	JComboBox combobox = new JComboBox(choices);

	public static void main(String[] args) {
		new BasicSwing();
	}

	public BasicSwing() { //3 things you need to set up for every swing
		super("Basic Swing App"); //name? must be first
		setSize(400, 300); //size (in pixels?
		setResizable(true); //can change size?
		setDefaultCloseOperation(EXIT_ON_CLOSE); //closes window?
		panel.add(button);
		panel.add(text);
		panel.add(textarea);
		panel.add(label);
		panel.add(combobox);
		add(panel);
		
		setVisible(true); //very last thing to do
	}
}
