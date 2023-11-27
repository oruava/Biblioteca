package org.example.Datos;

import org.example.Gui.FormularioDatos;
import org.example.Modelo.Biblioteca;
import org.example.Modelo.Libro;
import org.example.Modelo.Revista;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface Datos {

	static void guardarDatosEnCSV(Biblioteca biblioteca, Libro libro, Revista revista) {

		String[] datos = {biblioteca.getId(), biblioteca.getPrestado(), biblioteca.getTitulo(), biblioteca.getAutor(), libro.getIsbn(), revista.getIssn(), biblioteca.getEdicion()};
		escribirCSV("datos.csv", datos);



		System.out.println("Datos guardados en datos.csv");
	}

	static void escribirCSV(String nombreArchivo, String[] datos) {
		try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
			for (String dato : datos) {
				writer.append(dato).append(",");
			}
			writer.append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void buscarLibroPorID(String idBuscado) {
		try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length > 0 && datos[0].equals(idBuscado)) {

					System.out.println("Libro encontrado:");
					System.out.println("ID: " + datos[0]);
					System.out.println("Prestado: " + datos[1]);
					System.out.println("Titulo: " + datos[2]);
					System.out.println("Autor: " + datos[3]);
					System.out.println("ISBN: " + datos[4]);
					System.out.println("ISSN: " + datos[5]);
					System.out.println("Edicion: " + datos[6]);



					return;
				}
			}

			System.out.println("Libro no encontrado con ID: " + idBuscado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void cambiarEstadoPrestadoPorID(String idBuscado, String nuevoEstado) {
		try (BufferedReader br = new BufferedReader(new FileReader("datos.csv"))) {
			String linea;
			StringBuilder nuevoContenido = new StringBuilder();
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length > 0 && datos[0].equals(idBuscado)) {
					datos[1] = nuevoEstado;
					System.out.println("El estado prestado de la ID ingresada ha sido cambiado");
				}
				nuevoContenido.append(String.join(",", datos)).append("\n");
			}
			try (FileWriter writer = new FileWriter("datos.csv")) {
				writer.write(nuevoContenido.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		}