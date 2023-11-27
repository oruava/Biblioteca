package org.example.Modelo;

public class Biblioteca {
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrestado() {
		return prestado;
	}

	public void setPrestado(String prestado) {
		this.prestado = prestado;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEdicion() {
		return edicion;
	}

	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}


	private String id;
	private String prestado;
	private String titulo;
	private String autor;
	private String edicion;

	@Override
	public String toString() {
		return super.toString();
	}
}