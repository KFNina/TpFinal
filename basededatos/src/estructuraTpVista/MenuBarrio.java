package estructuraTpVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBarrio extends JPanel {

private static final long serialVersionUID = 1L;
	
	private JLabel labelTitulo;
	
	private JButton botonAgregar;
	private JButton botonConsultar;
	private JButton botonVolver;
	
	private JFrame marco;
	
	private AgregarBarrio agregar;
	private BarrioConsulta consultar;
	private MenuPrincipal menuPrincipal;
	private MenuBarrio panelActual = this; 
	
	public MenuBarrio(JFrame marco,MenuPrincipal menuPrincipal) {
		this.marco = marco;
		this.menuPrincipal = menuPrincipal;
		setBounds(0,0,750,500);
		
		crearLabels();
		crearBotones();
		accionBotones();
	}

	public void crearLabels() {
		setLayout(null);
		labelTitulo = new JLabel("Barrio");
		labelTitulo.setBounds(325, 11, 102, 56);
		add(labelTitulo);
		
		
	}
	
	public void crearBotones() {

		botonAgregar = new JButton("Agregar");
		botonAgregar.setBounds(289, 162, 89, 23);
		add(botonAgregar);
		
		botonConsultar = new JButton("Consultar");
		botonConsultar.setBounds(289, 311, 89, 23);
		add(botonConsultar);
		
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(24,422,89,23);
		add(botonVolver);
		
	}
	
	public void accionBotones() {
		botonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregar = new AgregarBarrio(marco, panelActual);
				marco.setContentPane(agregar);
			}
		});
		
		botonConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				consultar = new BarrioConsulta(marco,panelActual);
				consultar.actualizarTabla();
				marco.setContentPane(consultar);
			}
		});
		
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marco.setContentPane(menuPrincipal);
				
			}
		});
	}

}
