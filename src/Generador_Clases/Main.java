package Generador_Clases;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
// ******************************************************** VARIABLES *************************************************************** //

		Scanner teclado = new Scanner(System.in); // SCANER //

		Generadores generador = new Generadores(); // CLASE DE GENERADOR //
		ArrayList<variable> lista = new ArrayList<variable>(); // ARRAY LIST //

		System.out.println("nombre de la clase");
		String nombre_archivo = teclado.next(); // NOMBRE DEL ARCHIVO //

		int opcion = 0;
		
// ******************************************************** MENU *************************************************************** //
		
		do {

			System.out.println("0- SALIR");
			System.out.println("1- String");
			System.out.println("2- Int");
			System.out.println("3- double");
			System.out.println("4- otro");
			System.out.println("5- ver variables");

			String tipo = "";

			opcion = teclado.nextInt();
			
			// ************* SWITCH CASE ************* //
			switch (opcion) {

			case 1: // **** ANADIR STRING **** //

				tipo = "String";

				break;

			case 2: // **** ANADIR INT **** //

				tipo = "int";

				break;

			case 3: // **** ANADIR DOUBLE **** //

				tipo = "double";

				break;

			case 4: // **** ANADIR VARIABLES EJEMPLO (ARRAYLIST<INTEGER>) **** //

				System.out.println("tipo");
				tipo = teclado.next();

				break;

			case 5: // **** MOSTRAR VARIABLES **** //

				mostrar(lista.toArray());

				break;

			}

			if (opcion != 0 && opcion != 5) {

				System.out.println("nombre de la variable");
				lista.add(new variable(tipo, teclado.next()));

			}

		} while (opcion != 0);

		teclado.close();
		
// ******************************************************** GENERADOR *************************************************************** //

		if (lista.size() > 0) {
			
			try {
				
				// ********** PRINTWRITER ************ //
				PrintWriter pw = new PrintWriter(nombre_archivo + ".java");
				BufferedWriter bw = new BufferedWriter(pw);
				
				// *** HEADER *** //
				bw.write("public class " + nombre_archivo + " { \n");
				bw.write("\n");
				
				// *** VARIABLES *** //
				for (variable temp : lista) {
					bw.write(temp.toString() + "\n");
				}

				// *** CONSTRUCTORES *** //
				bw.write("\n");
				bw.write(generador.generarConstructorVacio(lista, nombre_archivo));
				bw.write("\n");
				bw.write(generador.generarConstructorCopia(lista, nombre_archivo));
				bw.write("\n");
				bw.write(generador.generarConstructorCompleto(lista, nombre_archivo));
				bw.write("\n");

				// *** GETTERS AND SETTERS *** //
				for (variable temp : lista) {
					bw.write(temp.generarGetter() + "\n");
					bw.write(temp.generarSetter() + "\n");
				}

				// *** TO STRING *** //
				bw.write("\n");
				bw.write(generador.generarToString(lista));
				
				// *** FIN *** //
				bw.write("\n");
				bw.write("}");
				bw.close();
				pw.close();
				
			} catch (IOException e) {
				System.out.println("erro en la escritura del archivo " + e.getMessage());;
			}
		}
	}
	
// ******************************************************** FIN DEL GENERADOR *************************************************************** //

public static void mostrar(Object[] lista) {

	for (int i = 0; i < lista.length; i++) {
		System.out.println(lista[i]);
		System.out.println("");
	}
}

	
}
