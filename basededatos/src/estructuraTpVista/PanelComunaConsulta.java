package estructuraTpVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexion.Sentencia;
import tpfinal.Barrio;
import tpfinal.ComplejosHabitacionales;
import tpfinal.Comuna;
import tpfinal.TrazadoFormal;
import tpfinal.UrbanizacionPlanificada;

public class PanelComunaConsulta extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel labelTitulo;
	
	private JScrollPane scrollPane;
	
	private JTable tabla;
	
	private Sentencia sentencia;

	
	private DefaultTableModel modelo;
	
	private JButton botonVolver;
	private JButton botonVerDetalle;
	private JButton botonEliminar;
	private JButton botonActualizar;
	private JButton botonModificar;
	
	private JFrame marco;
	
	private MenuComuna menuComuna;
	private JPanel panelActual = this;
	private PanelDetalleComuna detalleComuna;
	private PanelComunaConsulta consulta;
	private CargarComuna agregar;
	
	private Comuna comuna;
	
	private Object[] columnas;
	
	
	/*
	 *CRITERIOS
	 *	
	 *Como no dice si una comuna se puede borrar con barrios asignados, y que hacer con esos barrios, decidimos que solamente se puede borrar una comuna
	 *cuando no tenga ningun barrio asignado
	*/
	public PanelComunaConsulta(JFrame marco, MenuComuna menuComuna) {
		setBounds(0, 0, 750, 500);
		setLayout(null);
		
		this.marco = marco;
		this.menuComuna = menuComuna;
		crearPaneles();
		crearLabels();
		crearTablaCompleta();
		crearBotones();
		accionBotones();
		
		actualizarTabla();
	}
	public void crearPaneles() {
		consulta = this;
	}
	
	public void crearLabels() {
		labelTitulo = new JLabel("Consultas Comuna");
		labelTitulo.setBounds(300, 25, 139, 14);
		add(labelTitulo);
		
	
	}
	
	
	public void crearBotones() {
		botonVolver = new JButton("Volver");
		botonVolver.setBounds(39, 431, 89, 23);
		add(botonVolver);
		
		botonVerDetalle = new JButton("Ver Detalle");
		botonVerDetalle.setBounds(389, 284, 139, 23);
		add(botonVerDetalle);
		
		botonEliminar = new JButton("Eliminar Seleccionado");
		botonEliminar.setBounds(557, 284, 155, 23);
		add(botonEliminar);
		
		botonActualizar = new JButton("Actualizar");
		botonActualizar.setBounds(208, 284, 112, 23);
		add(botonActualizar);
		
		botonModificar = new JButton("Modificar");
		botonModificar.setBounds(39, 284, 89, 23);
		add(botonModificar);
		
		
	}
	
	public void accionBotones() {
		botonVerDetalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = tabla.getSelectedRow();
				
				String numeroSede = (String) modelo.getValueAt(eleccion, 1);
				
				if(eleccion != -1) {
					detalleComuna = new PanelDetalleComuna(marco,numeroSede, consulta);
					
					detalleComuna.actualizarTabla();
					marco.setContentPane(detalleComuna);
				}
				else {
					JOptionPane.showMessageDialog(panelActual, "Hubo un error :( Selecciono mal en la tabla ");
				}
				
							}
		});
		
		botonActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
			}
		});
		
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = tabla.getSelectedRow();
				

				//Esto porque retorna -1 si no selecciono nada o no hay algo q nosotros carguemos como seleccionado//
				if(eleccion != -1) {
					String numeroSede = (String) modelo.getValueAt(eleccion, 1);
					//devuelve booleano si se pudo borrar
					if(!sentencia.conexionComuna.eliminarComunaSeleccionada(numeroSede)) {
						JOptionPane.showMessageDialog(panelActual, "El panel cuenta con barrios asignados, primero modifique eso");
					}
					else {
						JOptionPane.showMessageDialog(panelActual, "Personaje eliminado con exito!!!!!");
					}
				}
				
				else {
					JOptionPane.showMessageDialog(panelActual, "Hubo un error :( la comuna seleccionada no existe o no selecciono ninguna");
				}
				actualizarTabla();
			}
		});
		
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marco.setContentPane(menuComuna);
			}
		});
		
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int eleccion = tabla.getSelectedRow();
				
				if(eleccion != -1) {
					String numeroSede = (String) modelo.getValueAt(eleccion, 1);
					
					agregar = new CargarComuna(marco,menuComuna,numeroSede);
					
					marco.setContentPane(agregar);
				}
				else {
					JOptionPane.showMessageDialog(panelActual, "Hubo un error :( la comuna seleccionada no existe o no selecciono ninguna");
				}
			}
		});
	}
	
	public void crearTablaCompleta() {
		tabla =  new JTable();
		tabla.setBounds(57, 122, 300, 112);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 505, 123);
		add(scrollPane);
		
		columnas = new Object[] {"Nombre" , "Numero", "Cantidad Barrios","Barrios Criticos","Atencion Prioritaria"};
		
		modelo = new DefaultTableModel(columnas, 0);

		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);
		
	}
	public void actualizarTabla() {
		modelo.setRowCount(0); 
		String nombre;
		String numeroSede;
		int cantidadBarrio;
		int cantidadCriticos;
		boolean atencionPrioritaria;
		
		for(Comuna com: sentencia.conexionComuna.asociarComunasConBarrios()) {
			
			nombre = com.getNombreComuna();
			numeroSede = com.getNumerocomuna();
			cantidadBarrio = com.getCantidadBarrio();
			cantidadCriticos = com.getCantidadBarriosCriticos();
			if(cantidadBarrio == 0) {
				atencionPrioritaria = false;
			}
			else {
				atencionPrioritaria = (cantidadBarrio*0.5) <= cantidadCriticos;
			}
			
			modelo.addRow(new Object[] {nombre, numeroSede, cantidadBarrio, cantidadCriticos, atencionPrioritaria ? "Si":"No"});
		}
		}

}
