package estructuraTpVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conexion.Sentencia;
import java.awt.Font;
import java.awt.Color;

public class MenuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonComuna;
	private JButton botonBarrio;
	
	private JLabel labelTitulo;
	
	private Sentencia sentencia;
	
	private JFrame marco;
	
	private JPanel MenuBarrio; 
	private JPanel MenuComuna;
	private MenuPrincipal panelActual = this;
	
	public MenuPrincipal(JFrame marco) {
		setBackground(new Color(255, 0, 0));
		this.marco = marco;
		setBounds(0, 0, 750, 500);
		setLayout(null);
		crearLabel();
		crearBotones();
		eventoBotones();
		
	}
	

	public void crearLabel() {
		labelTitulo = new JLabel("Bienvenido Al MENU \r\nDel Censo");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		labelTitulo.setBounds(207, 28, 352, 100);
		add(labelTitulo);		
	}
	
	public void crearBotones() {

		botonComuna = new JButton("Comuna");
		botonComuna.setBounds(570, 195, 111, 23);
		add(botonComuna);
		
		botonBarrio = new JButton("Barrio");
		botonBarrio.setBounds(317, 195, 127, 23);
		add(botonBarrio);
		
	}
	
	public void eventoBotones() {
		botonBarrio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuBarrio = new MenuBarrio(marco, panelActual);
				marco.setContentPane(MenuBarrio);
			}
		});
		
		botonComuna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuComuna = new MenuComuna(marco, panelActual);
				marco.setContentPane(MenuComuna);
			}
		});
	}

}
