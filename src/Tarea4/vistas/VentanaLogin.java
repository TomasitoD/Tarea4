package Tarea4.vistas;

import java.awt.Color;
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
    
    //Creacion de colores
    
    private final Color COLOR_FONDO = new Color(248, 248, 242);      // #fafbf0
    private final Color COLOR_TITULO = new Color(29, 31, 38);        // #1d1f26
    private final Color COLOR_LABEL = new Color(53, 63, 67);         // #353f43
    private final Color COLOR_BOTON_PRINCIPAL = new Color(65, 93, 109); // #415d6d
    private final Color COLOR_BOTON_SECUNDARIO = new Color(125, 108, 81); // #7d6c51
    private final Color COLOR_BORDE = new Color(125, 108, 81);       // #7d6c51
    private final Color COLOR_CAMPO_TEXTO = Color.WHITE;
    private final Color COLOR_TEXTO = new Color(29, 31, 38);         // #1d1f26
    
    public VentanaLogin() {
        usuarioDAO = new UsuarioDAO();
        
        setTitle("Login");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);

        iniciarComponentes();
        setVisible(true);
    }

    private void iniciarComponentes() {
    	
    	lblTitulo = new JLabel("LOGIN");
    	lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
    	lblTitulo.setForeground(COLOR_TITULO);
    	lblTitulo.setBounds(145, 20, 140, 35);
    	add(lblTitulo);

    	lblUsuario = new JLabel("Nombre de Usuario:");
    	lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
    	lblUsuario.setForeground(COLOR_LABEL);
    	lblUsuario.setBounds(40, 85, 140, 25);
    	add(lblUsuario);

    	txtUsuario = new JTextField();
    	txtUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
    	txtUsuario.setBounds(180, 85, 170, 30);
    	
    	txtUsuario.setBackground(COLOR_CAMPO_TEXTO);
    	txtUsuario.setForeground(COLOR_TEXTO);
    	txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(COLOR_BORDE, 1));
    	add(txtUsuario);

        lblContrasena = new JLabel("Contrasena:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblUsuario.setForeground(COLOR_LABEL);
        lblContrasena.setBounds(40, 130, 140, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtContrasena.setBounds(180, 130, 170, 30);
        
        txtContrasena.setBackground(COLOR_CAMPO_TEXTO);
        txtContrasena.setForeground(COLOR_TEXTO);
        txtContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(COLOR_BORDE, 1));
        add(txtContrasena);

        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(55, 210, 125, 38);
        add(btnEntrar);
        estilizarBotonPrincipal(btnEntrar);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(215, 210, 135, 38);
        add(btnRegistrarse);
        estilizarBotonSecundario(btnRegistrarse);
        

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
}
