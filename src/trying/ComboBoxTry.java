package trying;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxTry extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo;

	public ComboBoxTry() {
		super();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		combo = new JComboBox<String>(new String[] { "yosi", "moshe" });
		combo.setBounds(0, 0, 200, 200);
		combo.setVisible(true);
		this.add(combo);
		this.add(new JLabel("fdailhsgnk"));
	}

	public static void main(String[] args) {
		new ComboBoxTry();
	}

}
