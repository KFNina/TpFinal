package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearComplejos extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNewLabel;
	private JLabel labelMonoblock;
	private JSpinner spinnerMonoblocks;
	private JCheckBox checkBoxConsorcio;
	private JButton buttonCrear;
	
	/**
	 * Create the panel.
	 */
	public CrearComplejos() {
		setBounds(100, 100, 600, 450);
		setLayout(null);
		
		crearButton();
		crearSpinners();
		crearLabels();
		crearCheckBox();
	
	}
	
	public void crearLabels() {
		lblNewLabel = new JLabel("Crear Complejos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(210, 63, 179, 69);
		add(lblNewLabel);
		 
		labelMonoblock = new JLabel("Cantidad Monoblocks:");
		labelMonoblock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelMonoblock.setBounds(72, 159, 163, 32);
		add(labelMonoblock);
	}
	
	public void crearSpinners() {
		spinnerMonoblocks = new JSpinner();
		spinnerMonoblocks.setBounds(274, 159, 63, 37);
		add(spinnerMonoblocks);
	}

	public void crearButton() {
		buttonCrear = new JButton("Crear Barrio");
		buttonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonCrear.setBounds(421, 204, 109, 62);
		add(buttonCrear);
	}
	
	public void crearCheckBox() {
		checkBoxConsorcio = new JCheckBox("Tiene consorcio?");
		checkBoxConsorcio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBoxConsorcio.setBounds(151, 249, 172, 42);
		add(checkBoxConsorcio);
	}
	
	
	
}
