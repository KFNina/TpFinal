package estructuraTpVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
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

public class PanelDetalleComuna extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JFrame marco;
	
	private JScrollPane scrollPane;
	
	private JTable tabla;
	
	private DefaultTableModel modelo;
	
	private Object[] columnas;
	
	private String numeroSedeSeleccionada;
	
	private JButton botonVolver;
	private PanelComunaConsulta consulta;
	
	//private PanelComunaConsulta consulta;
	/**
	 * Create the panel.
	 */
	public PanelDetalleComuna(JFrame marco, String numeroSedeSeleccionada, PanelComunaConsulta consulta) {
		this.marco = marco;
		this.numeroSedeSeleccionada = numeroSedeSeleccionada;
		this.consulta = consulta;
		setBounds(0,0,750,500);
		
		crearTablaCompleta();
		crearBoton();
		accionBoton();
		actualizarTabla();
	}

	public void crearTablaCompleta() {
		setLayout(null);
		tabla =  new JTable();
		tabla.setBounds(57, 122, 300, 112);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 338, 123);
		add(scrollPane);
		
		columnas = new Object[] {"Nombre" , "Tipo "};
		
		modelo = new DefaultTableModel(columnas, 0);

		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);
		
		actualizarTabla();	
	}
	public void crearBoton() {
		botonVolver = new JButton("VOLVER");
		botonVolver.setBounds(10, 409, 89, 23);
		add(botonVolver);
	}
	
	public void accionBoton() {
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				marco.setContentPane(consulta);
			}
		});
	}
	
	
	public void actualizarTabla() {
		modelo.setRowCount(0); 
		String nombre;
		for(Comuna com: Sentencia.conexionComuna.asociarComunasConBarrios()) {
			
			if(com.getNumerocomuna().equals(numeroSedeSeleccionada)) {
				
				for(Barrio b : com.getBarrios()) {
					
					nombre = b.getNombre();
					
					if(b instanceof TrazadoFormal) {
						modelo.addRow(new Object[] {nombre, "Trazado Formal"});
					}
					if(b instanceof UrbanizacionPlanificada) {
						modelo.addRow(new Object[] {nombre, "Urbanizacion Planificada"});
					}
					if(b instanceof ComplejosHabitacionales){
						modelo.addRow(new Object[] {nombre, "Complejos Habitacionales"});
					}
					
				}
				break;
			}
			
		}
		
	}

}
