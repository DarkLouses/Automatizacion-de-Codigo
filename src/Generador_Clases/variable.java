package Generador_Clases;

public class variable {

	private String tipo;
	private String nombre;

	public variable() {

		this.tipo = "";
		this.nombre = "";

	}

	public variable(String tipo, String nombre) {

		this.tipo = tipo;
		this.nombre = nombre;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "private " + tipo + " " + nombre + ";";
	}

	public String generarGetter() {
		return "public " + tipo + " get" + nombre + " () { \n" + "		return " + nombre + "; \n" + "}";
	}

	public String generarSetter() {
		return "public " + "void" + " set" + nombre + " (" + tipo + " " + nombre + ") { \n" + "		this." + nombre
				+ " = " + nombre + "; \n" + "}";
	}

}
