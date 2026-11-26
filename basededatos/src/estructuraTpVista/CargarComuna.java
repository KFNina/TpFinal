package estructuraTpVista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import conexion.Sentencia;
import tpfinal.Comuna;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CargarComuna extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNewLabel;
	private JTextField textFieldNombre;
	private JButton botonCrear;
	private JTextField textFieldNumero;
	private JButton botonVolver;
	
	
	private MenuComuna panelMenuComuna;
	private JPanel panelActual = this;
	private JFrame marco;
	private String numeroSedeAntiguo;
	private boolean modoModificar;

	/**
	 * Create the panel.
	 */
	public CargarComuna(JFrame marco, MenuComuna panelMenuComuna) {
		this.marco = marco;
		this.panelMenuComuna = panelMenuComuna;
		setBounds(100, 100, 600, 450);
		setLayout(null);
		crearLabels();
		crearTextField();
		crearButton();
		
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
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(252, 159, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(252, 286, 86, 20);
		add(textFieldNumero);
	}
	public void crearButton() {
		botonCrear = new JButton("Crear");
		botonCrear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonCrear.setBounds(403, 252, 123, 58);
		add(botonCrear);
		
		botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonVolver.setBounds(403, 152, 123, 58);
		add(botonVolver);
		
	}
	
	public Comuna conseguirDatos() {
		Comuna c;
		
		String nombre = textFieldNombre.getText();
		
		String numeroSede = textFieldNumero.getText();
		
		c = new Comuna(nombre, numeroSede);
		
		return c;
	}
	
	public void eventoBoton() {
		botonCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Comuna comuna = conseguirDatos();
				
				String numeroSede = comuna.getNumerocomuna();
				
				if(!Sentencia.conexionComuna.existeComunaConEsteNumero(numeroSede)) {
					if(modoModificar) {
						JOptionPane.showMessageDialog(panelActual, "Modificado con exito!!!");
						
						Sentencia.conexionComuna.modificarComuna(comuna,numeroSedeAntiguo);
						marco.setContentPane(panelMenuComuna);
					}
					else {
						JOptionPane.showMessageDialog(panelActual, "Cargado con exito!!!");
						
						Sentencia.conexionComuna.cargarComuna(comuna);
					}
				}
				else {
					JOptionPane.showMessageDialog(panelActual, "Ya existe un panel con ese número de sede, intentelo devuelta");
					textFieldNumero.setText("");
				}
			}
		});
		
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marco.setContentPane(panelMenuComuna);
			}
		});
	}
}
