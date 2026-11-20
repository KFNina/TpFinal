package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class CrearBarrio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	
	private JLabel lblnewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2 ;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private JSpinner spinner;
	/**
	 * Create the panel.
	 */
	public CrearBarrio() {
		setBounds(100, 100, 600, 450);
		setLayout(null);
		
		crearTextField();
		crearButton();
		crearSpinners();
		crearLabels();
		crearComboBox();
	}
	
	public void crearTextField() {
		textField = new JTextField();
		textField.setBounds(176, 179, 105, 20);
		add(textField);
		textField.setColumns(10);
	}
	
	public void crearButton() {
		btnNewButton = new JButton("Siguiente\r\n");
		btnNewButton.setBounds(361, 205, 105, 69);
		add(btnNewButton);
	}
	
	public void crearSpinners() {
		spinner = new JSpinner();
		spinner.setBounds(240, 222, 41, 34);
		add(spinner);
	}
	
	public void crearLabels() {
		lblnewLabel = new JLabel("Crear Barrio");
		lblnewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblnewLabel.setBounds(237, 73, 119, 34);
		add(lblnewLabel);
		
		lblNewLabel_1 = new JLabel("Nombrer:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(84, 175, 82, 25);
		add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Numero de Hectareas:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(79, 230, 159, 14);
		add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Tipo de Barrio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(76, 294, 119, 14);
		add(lblNewLabel_2);
	}
	
	public void crearComboBox() {
		comboBox = new JComboBox();
		comboBox.setBounds(190, 292, 41, 22);
		add(comboBox);
		
	}
	
}
