package Generador_Clases;

import java.util.ArrayList;

public class Generadores {

// ********************************* METODOS ************************************* //

// ******** GENERADOR DEL CONSTRUCTOR VACIO ********** //
	public String generarConstructorVacio(ArrayList<variable> lista, String nombre) {

		String cadena = "public " + nombre + " () {\n"; // SENTENCIA NORMAL //

		for (variable temp : lista) { // EL FOR RECORRE TODOS LAS VARIABLES Y COMPRUEBA SUS TERMINACIONES 
									  // EJEMPLO SI ES STRING TE DEVUELVE "" O INT 0 CON LOS CASE
			String tipo_vacio = ""; 
			
			switch (temp.getTipo()) {
			
				case "String":
						tipo_vacio = " \"\" "; 
					break;
					
				case "int":
					tipo_vacio = " 0 ";
					break;
					
				case "double":
					tipo_vacio = " 0.0 ";
					break;

				case "boolean":
					tipo_vacio = "false";
					break;
					
				default:
					tipo_vacio = " null ";
					break;
			}
			cadena += "this." + temp.getNombre() + " = " + tipo_vacio + ";\n"; // CADENA //
		}

		cadena += "\n}\n"; // FINAL //

		return cadena;
	}

// ******** GENERADOR DEL CONSTRUCTOR COPIA ********** //
	public String generarConstructorCopia(ArrayList<variable> lista, String nombre) {

		String cadena = "public " + nombre + " (" + nombre + " c ) {\n"; // HEADER //

		for (variable temp : lista) { // RECORRE TODO EL ARRAYLIST DE VARIABLES Y LE VA ASIGNANDO SU CONSTRUCTOR

			cadena += "this." + temp.getNombre() + " = c." + temp.getNombre() + ";\n"; // CADENA QUE ASIGNA //
		}

		cadena += "\n}\n"; // FINAL //

		return cadena;
	}

// ******** GENERADOR DEL CONSTRUCTOR COPIA ********** //
	public String generarConstructorCompleto(ArrayList<variable> lista, String nombre) {

		String cadena = "public " + nombre + " ( "; // HEADER //

		for (int i = 0; i < lista.size(); i++) { // FOR PARA RECORRER TODAS LAS VARIABLES //

			cadena += lista.get(i).getTipo() + " " + lista.get(i).getNombre(); // HEADER DEL CONSTRUCTOR //

			if (i < lista.size() - 1) { 
				cadena += ", "; 
			}

		}

		cadena += " ) {\n"; // FIN DEL HEADER //

		for (variable temp : lista) {

			cadena += "this." + temp.getNombre() + " = " + temp.getNombre() + ";\n"; // SENTENCIA DEL CONSTRUCTOR //

		}

		cadena += "\n}\n"; // FIN DE LA SENTENCIA //

		return cadena;
	}
	
// ******** GENERADOR DEL TO STRING ********** //
	public String generarToString(ArrayList<variable> lista) {

		String cadena = "@Override \n" + "public String toString () { \n" + // HEADER //
		 " return \"[\"+"; // SENTENCIA //

		for (variable temp : lista) {

			cadena += " \" + " + temp.getNombre() + " :\" + " + temp.getNombre() + "+"; // SETENCIA DEL TO STRING //

		}

		cadena += " \"]\"; \n}"; // FIN //

		return cadena;
	}

}
