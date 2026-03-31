package Tarea4.vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Tarea4.logica.UsuarioDAO;
import Tarea4.modelo.Usuario;

public class VentanaRegistro extends JFrame {
	
	private JLabel lblTitulo;
    private JLabel lblNombreUsuario;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JLabel lblContrasena;
    private JLabel lblConfirmarContrasena;

    private JTextField txtNombreUsuario;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    private JPasswordField txtConfirmarContrasena;

    private JButton btnRegistrar;
    private JButton btnVolver;

    private UsuarioDAO usuarioDAO;
    
    private final Color COLOR_FONDO = new Color(250, 251, 240);         // #fafbf0
    private final Color COLOR_TITULO = new Color(29, 31, 38);           // #1d1f26
    private final Color COLOR_LABEL = new Color(53, 63, 67);            // #353f43
    private final Color COLOR_BOTON_PRINCIPAL = new Color(65, 93, 109); // #415d6d
    private final Color COLOR_BOTON_SECUNDARIO = new Color(125, 108, 81); // #7d6c51
    private final Color COLOR_BORDE = new Color(125, 108, 81);          // #7d6c51
    private final Color COLOR_CAMPO_TEXTO = Color.WHITE;
    private final Color COLOR_TEXTO = new Color(29, 31, 38);            // #1d1f26
    
    public VentanaRegistro() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Registro de Usuario");
        setSize(520, 470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);

        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
    	lblTitulo = new JLabel("REGISTRO");
    	lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
    	lblTitulo.setForeground(COLOR_TITULO);
    	lblTitulo.setBounds(185, 20, 160, 30);
    	add(lblTitulo);

        lblNombreUsuario = new JLabel("Nombre de Usuario:");
        lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNombreUsuario.setForeground(COLOR_LABEL);
        lblNombreUsuario.setBounds(40, 70, 150, 25);
        add(lblNombreUsuario);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        txtNombreUsuario.setBackground(COLOR_CAMPO_TEXTO);
        txtNombreUsuario.setForeground(COLOR_TEXTO);
        txtNombreUsuario.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtNombreUsuario.setBounds(220, 70, 190, 28);
        add(txtNombreUsuario);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNombre.setForeground(COLOR_LABEL);
        lblNombre.setBounds(40, 110, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        txtNombre.setBackground(COLOR_CAMPO_TEXTO);
        txtNombre.setForeground(COLOR_TEXTO);
        txtNombre.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtNombre.setBounds(220, 110, 190, 28);
        add(txtNombre);

        lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Arial", Font.PLAIN, 13));
        lblApellido.setForeground(COLOR_LABEL);
        lblApellido.setBounds(40, 150, 150, 25);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setFont(new Font("Arial", Font.PLAIN, 13));
        txtApellido.setBackground(COLOR_CAMPO_TEXTO);
        txtApellido.setForeground(COLOR_TEXTO);
        txtApellido.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtApellido.setBounds(220, 150, 190, 28);
        add(txtApellido);

        lblTelefono = new JLabel("Telefono:");
        lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
        lblTelefono.setForeground(COLOR_LABEL);
        lblTelefono.setBounds(40, 190, 150, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTelefono.setBackground(COLOR_CAMPO_TEXTO);
        txtTelefono.setForeground(COLOR_TEXTO);
        txtTelefono.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtTelefono.setBounds(220, 190, 190, 28);
        add(txtTelefono);

        lblCorreo = new JLabel("Correo Electronico:");
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 13));
        lblCorreo.setForeground(COLOR_LABEL);
        lblCorreo.setBounds(40, 230, 150, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Arial", Font.PLAIN, 13));
        txtCorreo.setBackground(COLOR_CAMPO_TEXTO);
        txtCorreo.setForeground(COLOR_TEXTO);
        txtCorreo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtCorreo.setBounds(220, 230, 190, 28);
        add(txtCorreo);

        lblContrasena = new JLabel("Contrasena:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblContrasena.setForeground(COLOR_LABEL);
        lblContrasena.setBounds(40, 270, 150, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(220, 270, 190, 28);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtContrasena.setBackground(COLOR_CAMPO_TEXTO);
        txtContrasena.setForeground(COLOR_TEXTO);
        txtContrasena.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        add(txtContrasena);

        lblConfirmarContrasena = new JLabel("Confirmar Contrasena:");
        lblConfirmarContrasena.setBounds(40, 310, 150, 25);
        lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblConfirmarContrasena.setForeground(COLOR_LABEL);
        add(lblConfirmarContrasena);

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtConfirmarContrasena.setBackground(COLOR_CAMPO_TEXTO);
        txtConfirmarContrasena.setForeground(COLOR_TEXTO);
        txtConfirmarContrasena.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtConfirmarContrasena.setBounds(220, 310, 190, 28);
        add(txtConfirmarContrasena);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 385, 130, 35);
        estilizarBotonPrincipal(btnRegistrar);
        add(btnRegistrar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(270, 385, 130, 35);
        estilizarBotonSecundario(btnVolver);
        add(btnVolver);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VentanaLogin();
            }
        });
    }
    
    //Metodo de estilo para los botones
    
    private void estilizarBotonPrincipal(JButton boton) {
        boton.setBackground(COLOR_BOTON_PRINCIPAL);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setBorderPainted(false);
    }
    
    private void estilizarBotonSecundario(JButton boton) {
        boton.setBackground(COLOR_BOTON_SECUNDARIO);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setBorderPainted(false);
    }

    private void registrarUsuario() {
        String nombreUsuario = txtNombreUsuario.getText().trim();
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();
        String confirmarContrasena = new String(txtConfirmarContrasena.getPassword()).trim();

        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el nombre de usuario.");
            return;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el nombre.");
            return;
        }

        if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el apellido.");
            return;
        }

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el telefono.");
            return;
        }

        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta el correo electronico.");
            return;
        }

        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta la contrasena.");
            return;
        }

        if (confirmarContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Falta confirmar la contrasena.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            JOptionPane.showMessageDialog(this, "La contrasena y su confirmacion no coinciden.");
            return;
        }

        if (usuarioDAO.existeNombreUsuario(nombreUsuario)) {
            JOptionPane.showMessageDialog(this, "Ese nombre de usuario ya esta registrado.");
            return;
        }

        Usuario usuario = new Usuario(nombreUsuario, contrasena, nombre, apellido, telefono, correo);

        boolean registrado = usuarioDAO.registrarUsuario(usuario);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            dispose();
            new VentanaLogin();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el usuario.");
        }
    }

}