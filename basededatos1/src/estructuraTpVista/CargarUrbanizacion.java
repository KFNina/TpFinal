package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CargarUrbanizacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldLey;
	private JLabel lblNewLabel;
	private JLabel labelLey;
	private JCheckBox checkBoxConexion;
	private JButton buttomCrear;
	
	/**
	 * Create the panel.
	 */
	public CargarUrbanizacion() {
		
		setBounds(100, 100, 600, 450);
		setLayout(null);
		
		crearTextField();
		crearButton();
		crearCheckBox();
		crearLabels();
	}
	
	public void crearLabels() {
		lblNewLabel = new JLabel("Crear Urbanzacion");
		lblNewLabel.setBounds(207, 61, 189, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNewLabel);
		
		labelLey = new JLabel("Num Ley:");
		labelLey.setBounds(92, 155, 80, 30);
		labelLey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelLey.setForeground(new Color(0, 0, 0));
		add(labelLey);
	}
	
	public void crearCheckBox() {
		checkBoxConexion = new JCheckBox("Conexion con Agua");
		checkBoxConexion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBoxConexion.setBounds(118, 251, 170, 64);
		add(checkBoxConexion);
	}
	
	public void crearButton() {
		buttomCrear = new JButton("Crear Barrio");
		buttomCrear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttomCrear.setBounds(410, 214, 136, 71);
		add(buttomCrear);
	}
	
	public void crearTextField() {
		textFieldLey = new JTextField();
		textFieldLey.setBounds(200, 153, 105, 38);
		add(textFieldLey);
		textFieldLey.setColumns(10);
	}
	
}
