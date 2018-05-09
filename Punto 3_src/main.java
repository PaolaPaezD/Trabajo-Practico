import java.util.Scanner;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = seleccionarOpcion();
		Agenda Agenda1=new Agenda();
		while (opcion != 0) {
			EjecutarOpcion(opcion, Agenda1);
			opcion = seleccionarOpcion();
			
		}
		
	}

	private static void EjecutarOpcion(int opcion, Agenda agenda1) {
		// TODO Auto-generated method stub
		
		if(opcion!=0) {
		
		switch (opcion) {
		case 1:
			agenda1.AgregarContacto();
			break;
		case 2:
			agenda1.ListarContacto();
			break;
		case 3:
			String contacto=JOptionPane.showInputDialog("\n Ingrese el nombre a comparar: ");
			agenda1.buscarContacto(contacto);
			break;
		case 4:
			String contactodos=JOptionPane.showInputDialog("\n Ingrese el telefono a comparar: ");
			agenda1.BuscarContactoporTelefono(contactodos);
			break;
		case 5:
			contacto c=new contacto();
			c.setNombre(JOptionPane.showInputDialog("\n Ingrese nombre: "));
			c.setApellidoPaterno(JOptionPane.showInputDialog("\n Ingrese el apellido: "));
			c.settelefono(JOptionPane.showInputDialog("\n Ingrese el telefono: "));
			c.setmail(JOptionPane.showInputDialog("\n Ingrese el mail: "));
			agenda1.eliminarContacto(c);
			
			break;
		case 6:
			agenda1.guardarContacto();
			break;
		case 7:
			String lugar=(JOptionPane.showInputDialog("\n Ingrese el lugar desde donde desea cargar el archivo"));
			agenda1.CargarContacto(lugar);
			
			break;
		default:
			break;
		}

	}
	}

	private static int seleccionarOpcion() {
		// TODO Auto-generated method stub
		int opcio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee /n"+"1-Agregar contacto"+ "2-Listar la agenda"+"3-Buscar contacto por nombre"+"4-Buscar por numero"+"5-Eliminar"+"6-Guardar en archivo"+"7-Cargar"+"0-Salir"));
		return opcio;
	}

}