import java.util.ArrayList;

import javax.swing.JFrame;

import conexion.ComunaDao;
import conexion.Conexion;
import estructuraTpVista.MenuComuna;
import estructuraTpVista.MenuPrincipal;
import tpfinal.Comuna;

public class App {
	
	public static void main(String[] args) {
		JFrame marco = new JFrame();
	
		
		marco.setVisible(true);	
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setBounds(0,0,750,500);
		
		MenuPrincipal panel = new MenuPrincipal(marco);
		
		marco.setContentPane(panel);
		marco.validate();

		
		
	}
}
