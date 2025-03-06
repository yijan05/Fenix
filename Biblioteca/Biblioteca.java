package com.mycompany.biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Biblioteca extends JFrame implements ActionListener {
    private JTextField txtBusqueda; // campo de texto para buscar
    private JTextArea txtAreaResultado; // para resultados
    private ArrayList<Libro> libros; // lista de libros

    public Biblioteca() {
        super("Gestión de Biblioteca");
        libros = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Panel, formulario
        JPanel panelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));

        // campo para buscar
        JLabel lblBusqueda = new JLabel("Buscar (Título, Autor o ISBN):");
        txtBusqueda = new JTextField();
        panelFormulario.add(lblBusqueda);
        panelFormulario.add(txtBusqueda);

        JButton btnAgregar = new JButton("Agregar Libro");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnListar = new JButton("Listar Libros");

        btnAgregar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnListar.addActionListener(this);

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnBuscar);
        panelFormulario.add(btnListar);

        // Área de texto para resultados
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setPreferredSize(new Dimension(560, 200));

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panelPrincipal);
        setVisible(true);
    }

    // Método para manejar eventos de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Agregar Libro")) {
            agregarLibro();
        } else if (comando.equals("Buscar")) {
            buscarLibro();
        } else if (comando.equals("Listar Libros")) {
            listarLibros();
        }
    }

    // Método para agregar un libro
    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog(this, "Ingrese el título del libro:");
        String autor = JOptionPane.showInputDialog(this, "Ingrese el autor del libro:");
        String ISBN = JOptionPane.showInputDialog(this, "Ingrese el ISBN del libro:");

        if (titulo != null && !titulo.isEmpty() && autor != null && !autor.isEmpty() && ISBN != null
                && !ISBN.isEmpty()) {
            libros.add(new Libro(titulo, autor, ISBN, true));
            txtAreaResultado.setText("Libro agregado con éxito.");
        } else {
            txtAreaResultado.setText("Error: Complete todos los campos.");
        }
    }

    // metoodo para buscar un libro
    private void buscarLibro() {
        String busqueda = txtBusqueda.getText().trim();

        if (!busqueda.isEmpty()) {
            StringBuilder resultado = new StringBuilder();
            for (Libro libro : libros) {
                if (libro.getTitulo().equalsIgnoreCase(busqueda) ||
                        libro.getAutor().equalsIgnoreCase(busqueda) ||
                        libro.getISBN().equalsIgnoreCase(busqueda)) {
                    resultado.append(libro.toString()).append("\n");
                }
            }
            if (resultado.length() > 0) {
                txtAreaResultado.setText(resultado.toString());
            } else {
                txtAreaResultado.setText("No se encontraron libros con ese criterio.");
            }
        } else {
            txtAreaResultado.setText("Error: Ingrese un criterio de búsqueda.");
        }
    }

    // metodo para listar todos los libros que se pongan
    private void listarLibros() {
        if (libros.isEmpty()) {
            txtAreaResultado.setText("No hay libros registrados.");
        } else {
            StringBuilder inventario = new StringBuilder();
            for (Libro libro : libros) {
                inventario.append(libro.toString()).append("\n");
            }
            txtAreaResultado.setText(inventario.toString());
        }
    }

    // metodo principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Biblioteca());
    }

    // clase libro, la bendita clase libro que tanto dolor de cabeza nos dio :)
   class Libro {
       private String titulo;
       private String autor;
       private String ISBN;
       private boolean disponible;
       // constructor
       public Libro(String titulo, String autor, String ISBN, boolean disponible) {
           this.titulo = titulo;
           this.autor = autor;
           this.ISBN = ISBN;
           this.disponible = disponible;
       }
       // Getters y Setters
       public String getTitulo() {
           return titulo;
       }
       public void setTitulo(String titulo) {
           this.titulo = titulo;
       }
       public String getAutor() {
           return autor;
       }
       public void setAutor(String autor) {
           this.autor = autor;
       }
       public String getISBN() {
           return ISBN;
       }
       public void setISBN(String ISBN) {
           this.ISBN = ISBN;
       }
       public boolean isDisponible() {
           return disponible;
       }
       public void setDisponible(boolean disponible) {
           this.disponible = disponible;
       }
       // metodo toString para mostrar la información del libro
       @Override
       public String toString() {
           return "Libro{titulo='" + titulo + "', autor='" + autor + "', ISBN='" + 
                   + "}";
       }
   }
}
 
 
 
 
 

 
 
 
 
 
 
 

 
 
 
 

 
 
 

 
 
 

 
 
 

 
 
 

 
 
 

 
 
 

 
 
 

 
 
 
 ISBN + "', disponible=" + disponible
 
 
 