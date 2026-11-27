package estructuraTpVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import conexion.Sentencia;

public class MenuComuna extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame marco;
	
	private JLabel titulo;
	
	private JButton botonCargar;
	private JButton botonConsultar;
	private JButton botonVolver;
	
	private Sentencia sentencia;
	
	private CargarComuna PanelAgregar;
	private PanelComunaConsulta PanelConsultar;
	private MenuPrincipal PanelMenuPrincipal;
	private MenuComuna panelActual = this;
	
	
	public MenuComuna(JFrame marco, MenuPrincipal menuPrincipal) {
	    this.marco = marco;
	    this.PanelMenuPrincipal = menuPrincipal;
	    setLayout(null);
	    setBounds(0,0,750,500);

	    crearLabels();
	    crearBotones();
	    eventoBotones();
	}
	
	public void crearLabels() {
		titulo = new JLabel("Comuna");
		titulo.setBounds(318, 28, 100, 14);
		add(titulo);
	}
	
	public void crearBotones() {
		botonConsultar = new JButton("Consultar");
		botonConsultar.setBounds(297, 264, 89, 23);
		add(botonConsultar);
		
		
		botonCargar = new JButton("Cargar");
		botonCargar.setBounds(297, 140, 89, 23);
		add(botonCargar);
		
		botonVolver = new JButton("VOLVER");
		botonVolver.setBounds(60, 401, 133, 23);
		add(botonVolver);
	}
	
	public void eventoBotones() {
		botonCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelAgregar = new CargarComuna(marco, panelActual);
				marco.setContentPane(PanelAgregar);
			}
		});
		
		botonConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanelConsultar = new PanelComunaConsulta(marco,panelActual);
				PanelConsultar.actualizarTabla();
				marco.setContentPane(PanelConsultar);
			}
		});
	
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marco.setContentPane(PanelMenuPrincipal);
			}
		});
		
	}


}
