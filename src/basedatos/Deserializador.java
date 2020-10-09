package basedatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializador {
	private static File rutaTemp = new File("src\\basedatos\\temp");
	
	public static void deserializar() {
		File[] docs=rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for(File file:docs) {
			
			try {
				fis= new FileInputStream(file);
				ois= new ObjectInputStream(fis);
				ois.readObject();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
