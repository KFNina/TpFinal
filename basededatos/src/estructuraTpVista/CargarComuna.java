package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class CargarComuna extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JSpinner spinner;
	

	/**
	 * Create the panel.
	 */
	public CargarComuna() {
		setBounds(100, 100, 600, 450);
		setLayout(null);
		crearLabels();
		crearTextField();
		crearButton();
		crearSpinners();
		
	}
	
	public void crearLabels() {
		lblNewLabel = new JLabel("Cargar Comuna");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(203, 39, 170, 58);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(127, 152, 84, 31);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero Comuna:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(87, 279, 123, 31);
		add(lblNewLabel_2);
		
		
	}
	
	public void crearTextField() {
		textField = new JTextField();
		textField.setBounds(252, 159, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
	public void crearButton() {
		btnNewButton = new JButton("Crear");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(411, 201, 123, 58);
		add(btnNewButton);
	}
	
	public void crearSpinners() {
		spinner = new JSpinner();
		spinner.setBounds(265, 277, 76, 38);
		add(spinner);
	}
}
