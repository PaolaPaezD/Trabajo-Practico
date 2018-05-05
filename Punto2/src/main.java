import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.Random;
 
 
public class main {
 
   	public static void main(String[] args) {
         	// TODO Auto-generated method stub
         	File Ffichero=new File("C:\\Users\\Usuario\\Desktop\\archivo.txt");
         	File bkp = new File("C:\\Users\\Usuario\\Desktop\\archivo.txt.bkp");
   	Marcar(Ffichero, bkp);
   	}
 
   	public static void Marcar(File archivoA, File bkpA)   {
         	try {
                	FileReader fr = new FileReader(archivoA) ;
                	BufferedReader br = new BufferedReader(fr);
                	FileWriter fw = new FileWriter(bkpA);
                	BufferedWriter bw = new BufferedWriter(fw);
                	String cambiado ="";
                	char prev = '.';
                	
                	while(br.ready())
                	{
                       	char c = (char)br.read();
                       	bw.write(c);
                	}
                	br.reset();
                	fw.close();
                	while(br.ready())
                	{
                       	char c = (char)br.read();
                       	if(prev=='.') {
                              	c = Character.toUpperCase(c);
                       	}
                       	prev=c;
                       	cambiado+=c;
                	}
                	fr.close();
                	FileWriter sw = new FileWriter(archivoA);
                	BufferedWriter dw = new BufferedWriter(sw);
                	dw.write(cambiado);
                	sw.close();
                	
         	}
         	catch (Exception ex) {
         	   	/*Captura un posible error y le imprime en pantalla*/
         	    	System.out.println(ex.getMessage());
         	}
   	}
}
