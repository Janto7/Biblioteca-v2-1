package org.iesalandalus.programacion.biblioteca.mvc.modelo.dominio;
import java.util.Objects;
import javax.naming.OperationNotSupportedException;

public class LibroEscrito extends Libro {

	private static final int PAGINAS_PARA_RECOMPENSA = 25;
	private static final float PUNTOS_PREMIO = 0.5f;

	private int numPaginas;

	public LibroEscrito(String titulo, String autor, int numPaginas) {

		super(titulo, autor);
		setNumPaginas(numPaginas);
	}

	public LibroEscrito(LibroEscrito libro) {
		super(libro);
		numPaginas = libro.getNumPaginas();
	}

	public static LibroEscrito getLibroFicticio(String titulo, String autor) {

		return new LibroEscrito(titulo, autor, 560);
	}

	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		if (titulo == null) {
			throw new NullPointerException("ERROR: El título no puede ser nulo.");
		}
		if (titulo.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El título no puede estar vacío.");
		}
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	private void setAutor(String autor) {
		if (autor == null) {
			throw new NullPointerException("ERROR: El autor no puede ser nulo.");
		}
		if (autor.trim().equals("")) {
			throw new IllegalArgumentException("ERROR: El autor no puede estar vacío.");
		}
		this.autor = autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	private void setNumPaginas(int numPaginas) {
		if (numPaginas <= 0) {
			throw new IllegalArgumentException("ERROR: El número de páginas debe ser mayor que cero.");
		}
		this.numPaginas = numPaginas;
	}

	public float getPuntos() {

		return 0.5f + (getNumPaginas()/ PAGINAS_PARA_RECOMPENSA) * PUNTOS_PREMIO ;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return String.format("%s, número de páginas=%d]", super.toString(), numPaginas);
	}

}