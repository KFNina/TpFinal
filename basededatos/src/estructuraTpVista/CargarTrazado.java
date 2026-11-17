package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class CargarTrazado extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNewLabel;
	private JLabel labelEdificios;
	private JLabel labelAsfalto;
	private JSpinner spinnerEdificios;
	private JSpinner spinner_Asfalto;
	private JButton bottumCrear;
	
	/**
	 * Create the panel.
	 */
	public CargarTrazado() {
		setLayout(null);
		setBounds(100, 100, 600, 450);
		
		crearSpinners();
		crearLabels();
		crearButton();
		
	}
	
	public void crearLabels() {
		lblNewLabel = new JLabel("Trazado Formal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(213, 52, 159, 48);
		add(lblNewLabel);
		
		labelEdificios = new JLabel("Cantidad Edificios:");
		labelEdificios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelEdificios.setBounds(75, 146, 123, 48);
		add(labelEdificios);
		
		labelAsfalto = new JLabel("Porcentaje Asfalto:");
		labelAsfalto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelAsfalto.setBounds(75, 269, 130, 39);
		add(labelAsfalto);
	}
	
	public void crearSpinners() {
		spinnerEdificios = new JSpinner();
		spinnerEdificios.setBounds(255, 145, 63, 54);
		add(spinnerEdificios);
		
		spinner_Asfalto = new JSpinner();
		spinner_Asfalto.setBounds(255, 266, 63, 48);
		add(spinner_Asfalto);
	}
	
	public void crearButton() {
		bottumCrear = new JButton("Crear Barrio");
		bottumCrear.setBounds(404, 210, 117, 54);
		add(bottumCrear);
	}

}
