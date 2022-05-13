package Ficheros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ficheros {

    // GUARDA EL FICHERO QUE QUIERAS PASANDOLE POR PARAMETRO EL ARRAYLIST Y LA UBICACION DEL ARCHIVO //
	public static void GuardarFichero (Object[] lista, String url) {
			
		try {

			FileOutputStream fos=new FileOutputStream(url);
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			
			for (Object arti : lista ) {
			
				oos.writeObject(arti);

			}
			
			oos.close();
			fos.close();

		} catch ( IOException e) {
			System.out.println("No se pudo guardar el fichero " +e.getMessage());
		}
	
	}
	
	 // LEE EL FICHERO QUE QUIERAS //

     	// ejemplo de uso 

		/*ArrayList<Integer> lista = new ArrayList<>();
		Object[] array_temp = LeerFichero(url);

		for (Object arti : array_temp) {
			lista.add((Integer) arti);
		}*/
        
	public static ArrayList<Object> LeerFichero (String url) {

		ArrayList<Object> objetos = new ArrayList<>();
		
		try {
		
			FileInputStream  fis = new FileInputStream(url);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while(fis.available() > 0){
				objetos.add(ois.readObject()); 			
			}
			
			ois.close();
			fis.close();
			
			return objetos;

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("El fichero no se encuentra ," +e.getMessage());
			return null;
		}
		
	}
    
}
