package com.mycompany.biblioteca;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Biblioteca1 extends JFrame implements ActionListener {
    private JTextField txtTitulo, txtAutor, txtISBN;
    private JTextArea txtAreaResultado;
    private List<Libro> libros;

    public Biblioteca1() {
        super("Biblioteca");
        libros = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));

        JLabel lblTitulo = new JLabel("Título:");
        txtTitulo = new JTextField();
        JLabel lblAutor = new JLabel("Autor:");
        txtAutor = new JTextField();
        JLabel lblISBN = new JLabel("ISBN:");
        txtISBN = new JTextField();

        panelFormulario.add(lblTitulo);
        panelFormulario.add(txtTitulo);
        panelFormulario.add(lblAutor);
        panelFormulario.add(txtAutor);
        panelFormulario.add(lblISBN);
        panelFormulario.add(txtISBN);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnInventario = new JButton("Inventario");

        btnAgregar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnInventario.addActionListener(this);

        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnBuscar);
        panelFormulario.add(btnInventario);

        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setPreferredSize(new Dimension(560, 200));

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(panelPrincipal);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String ISBN = txtISBN.getText().trim();

        if (comando.equals("Agregar")) {
            if (!titulo.isEmpty() && !autor.isEmpty() && !ISBN.isEmpty()) {
                libros.add(new Libro(titulo, autor, ISBN, true));
                txtAreaResultado.setText("Libro agregado con éxito.");
            } else {
                txtAreaResultado.setText("Complete todos los campos.");
            }
        } else if (comando.equals("Eliminar")) {
            libros.removeIf(libro -> libro.getISBN().equals(ISBN));
            txtAreaResultado.setText("Libro eliminado.");
        } else if (comando.equals("Buscar")) {
            for (Libro libro : libros) {
                if (libro.getISBN().equals(ISBN)) {
                    txtAreaResultado.setText(libro.toString());
                    return;
                }
            }
            txtAreaResultado.setText("Libro no encontrado.");
        } else if (comando.equals("Inventario")) {
            txtAreaResultado.setText(libros.isEmpty() ? "No hay libros registrados." : libros.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Biblioteca1::new);
    }
}

class Libro {
    private String titulo, autor, ISBN;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = disponible;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', autor='" + autor + "', ISBN='" + ISBN + "', disponible=" + disponible + "}";
    }
}
   
