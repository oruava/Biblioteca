package org.example.Gui;
import org.example.Datos.Datos;
import org.example.Modelo.Biblioteca;
import org.example.Modelo.Libro;
import org.example.Modelo.Revista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormularioDatos extends JFrame {

    private JTextField idTextField, prestadoTextField, tituloTextField, autorTextField, isbnTextField, issnTextField, edicionTextField, buscarIDTextField;

    public FormularioDatos() {
        // Configuración del JFrame
        setTitle("Formulario Datos");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));


        JLabel idLabel = new JLabel("  ID:");
        idTextField = new JTextField();

        JLabel prestadoLabel = new JLabel("  PRESTADO:");
        prestadoTextField = new JTextField();

        JLabel tituloLabel = new JLabel("  TITULO:");
        tituloTextField = new JTextField();

        JLabel autorLabel = new JLabel("  AUTOR:");
        autorTextField = new JTextField();

        JLabel isbnLabel = new JLabel("  ISBN:");
        isbnTextField = new JTextField();

        JLabel isnnLabel = new JLabel("  ISNN:");
        issnTextField = new JTextField();

        JLabel edicionLabel = new JLabel("  EDICION:");
        edicionTextField = new JTextField();

        JButton buscarButton = new JButton("Buscar");

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos.buscarLibroPorID(idTextField.getText());

            }
        });

        JButton guardarButton = new JButton("Guardar Datos");

        JButton cambiarPrestadoButton = new JButton("Cambiar Prestado");

        cambiarPrestadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos.cambiarEstadoPrestadoPorID(idTextField.getText(), prestadoTextField.getText());
                idTextField.setText("");
                prestadoTextField.setText("");

            }
        });


        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(prestadoLabel);
        panel.add(prestadoTextField);
        panel.add(tituloLabel);
        panel.add(tituloTextField);
        panel.add(autorLabel);
        panel.add(autorTextField);
        panel.add(isbnLabel);
        panel.add(isbnTextField);
        panel.add(isnnLabel);
        panel.add(issnTextField);
        panel.add(edicionLabel);
        panel.add(edicionTextField);
        panel.add(buscarButton);
        panel.add(guardarButton);
        panel.add(cambiarPrestadoButton);


        add(panel);

        setVisible(true);


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteca biblioteca = new Biblioteca();
                Libro libro = new Libro();
                Revista revista = new Revista();


                String nombre = idTextField.getText();
                biblioteca.setId(nombre);

                String apellido = prestadoTextField.getText();
                biblioteca.setPrestado(apellido);

                String rut = tituloTextField.getText();
                biblioteca.setTitulo(rut);

                String isapre = autorTextField.getText();
                biblioteca.setAutor(isapre);

                String isbn = isbnTextField.getText();
                libro.setIsbn(isbn);

                String issn = issnTextField.getText();
                revista.setIssn(issn);

                String edicion = edicionTextField.getText();
                biblioteca.setEdicion(edicion);

                Datos.guardarDatosEnCSV(biblioteca,libro,revista);


                idTextField.setText("");
                prestadoTextField.setText("");
                tituloTextField.setText("");
                autorTextField.setText("");
                isbnTextField.setText("");
                issnTextField.setText("");
                edicionTextField.setText("");
            }
        });
    }
}




