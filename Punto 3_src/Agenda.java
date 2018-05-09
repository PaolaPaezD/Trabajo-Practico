/*import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

public class Agenda {
	
	
	public  void ListarContacto() {
		List <String> ListaAgenda= new ArrayList <String>();
		Contacto myClase=new Contacto();
		String hola=myClase.AgregarContacto();
		ListaAgenda.add(hola);
		for(int i=0; i< ListaAgenda.size()-1;i++) {
		System.out.println(ListaAgenda.get(i));
	}
	}
	



}*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Agenda {
    private final ArrayList<Contacto> datos;

    public Agenda() {
        datos = new ArrayList();
    }
    
    public  void AgregarContacto() {
        String name,paterno,telefono,mail;
       
        
        for (int i = 0; i < datos.size(); i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Por favor introduce un Nombre: ");
            name = input.nextLine();
            System.out.println("Introduce el apellido Paterno: ");
            paterno = input.nextLine();
            System.out.println("Introduce el telefono: ");
            telefono = input.nextLine();
            System.out.println("Introduce el mail: ");
            mail = input.nextLine();
            
            datos.add(new Contacto(name,paterno,telefono,mail));
        } 
            
        }
        public void contactoExiste() {
        	/*String a= datos;
        	while(datos.indexOf(a)>-1) {
        		//datos = datos.substring(datos.indexOf(a)+a.length(),datos.size());
        		*/
        	for(int i=0; i<datos.size(); i++){ 
                if(datos.get(i).equals(datos.get(datos.size()-1))){ 
                    System.out.println("Repetido"); 
                }  
        	}
        	
    }
    
        
    
    public   void ListarContacto() {
		
		for(int i=0; i< datos.size()-1;i++) {
		System.out.println(datos.get(i));
	}
	}
    
    public String buscarContacto(String name) {
        //Persona aux = new Persona(paterno,paterno,paterno,"","","",0);
        for(Contacto a: datos) {
            if(name.equals(a.getNombre())) return a.toString();
        }
        return "Persona no encontrada\n";
    }
    
    public String BuscarContactoporTelefono(String telefono) {
        //Persona aux = new Persona(paterno,paterno,paterno,"","","",0);
        for(Contacto a: datos) {
          
			if(telefono.equals(a.gettelefono())) return a.toString();
        }
        return "Telefono no encontrado\n";
    }
    
    
    
    
    public void allPeople() {
        for(Contacto a: datos) {
            System.out.println(a.toString());
        }
    }
public void eliminarContacto(Contacto c) {
    	
    	for(int i=0;i<datos.size();i++)
    	{
    		
    		if(c.equals(datos.get(i))) {
    			
    			datos.remove(i);
    			
    			System.out.println("Se elimino el contacto");
    		   
    			return;
    		} 
    
    		
    	} System.out.println("No se encontro el contacto");
    	
    }
    
    public void guardarContacto(){
    	try {
    		String lugar=JOptionPane.showInputDialog("\n Ingrese la direccion del archivo ");
    		BufferedWriter out=new BufferedWriter(new FileWriter(new File(lugar)));
    		for(int i=0;i<datos.size();i++) {
    			out.write(datos.get(i).getNombre()+"\n ");
    			out.write(datos.get(i).getApellidoPaterno()+"\n ");
    			out.write(datos.get(i).gettelefono()+"\n ");
    			out.write(datos.get(i).getmail()+"\n ");
    		}
    		out.close();
    		
    		}
    	catch(Exception e) {
    		e.printStackTrace();
    		return;
    		
    	}
    }
 public void CargarContacto(String lugar) {
    	
	 try {
		 BufferedReader in=new BufferedReader(new FileReader(new File(lugar)));
 		while(in.ready()) {
 			
 			Contacto c=new Contacto();
 			c.setNombre(in.readLine());
 			c.setApellidoPaterno(in.readLine());
 			c.settelefono(in.readLine());
 			c.setmail(in.readLine());
 			datos.add(c);
 		}
 		in.close();
 		}
 	catch(Exception e) {
 		e.printStackTrace();
 		return;
 		
 	}
    	
    }
    	
}

