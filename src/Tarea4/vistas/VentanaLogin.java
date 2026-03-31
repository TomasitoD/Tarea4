package Tarea4.vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Tarea4.logica.UsuarioDAO;
import Tarea4.modelo.Usuario;


public class VentanaLogin extends JFrame {

	private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblContrasena;

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    private JButton btnEntrar;
    private JButton btnRegistrarse;

    private UsuarioDAO usuarioDAO;
    
    public VentanaLogin() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
        lblTitulo = new JLabel("LOGIN");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(150, 20, 100, 30);
        add(lblTitulo);

        lblUsuario = new JLabel("Nombre de Usuario:");
        lblUsuario.setBounds(40, 80, 140, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(180, 80, 150, 25);
        add(txtUsuario);

        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(40, 120, 140, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(180, 120, 150, 25);
        add(txtContrasena);

        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(70, 190, 100, 30);
        add(btnEntrar);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(200, 190, 120, 30);
        add(btnRegistrarse);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VentanaRegistro();
            }
        });
    }

    private void iniciarSesion() {
        String nombreUsuario = txtUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();

        if (nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar su usuario y contraseña, si no está registrado debe registrarse.");
            return;
        }

        Usuario usuario = usuarioDAO.iniciarSesion(nombreUsuario, contrasena);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
            dispose();
            new VentanaPrincipal();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        }
    }
}
