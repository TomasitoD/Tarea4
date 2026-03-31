package Tarea4.vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Tarea4.logica.UsuarioDAO;
import Tarea4.modelo.Usuario;

public class VentanaActualizarUsuario extends JFrame {

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

    private JButton btnActualizar;
    private JButton btnCancelar;

    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    private final Color COLOR_FONDO = new Color(250, 251, 240);
    private final Color COLOR_TITULO = new Color(29, 31, 38);
    private final Color COLOR_LABEL = new Color(53, 63, 67);
    private final Color COLOR_BOTON_PRINCIPAL = new Color(65, 93, 109);
    private final Color COLOR_BOTON_SECUNDARIO = new Color(125, 108, 81);
    private final Color COLOR_BORDE = new Color(125, 108, 81);
    private final Color COLOR_CAMPO_TEXTO = Color.WHITE;
    private final Color COLOR_TEXTO = new Color(29, 31, 38);

    public VentanaActualizarUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.usuarioDAO = new UsuarioDAO();

        setTitle("Actualizar Usuario");
        setSize(520, 485);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);

        iniciarComponentes();
        cargarDatosUsuario();

        setVisible(true);
    }

    private void iniciarComponentes() {
        lblTitulo = new JLabel("ACTUALIZAR USUARIO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(COLOR_TITULO);
        lblTitulo.setBounds(105, 18, 300, 32);
        add(lblTitulo);

        lblNombreUsuario = new JLabel("Nombre de Usuario:");
        lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNombreUsuario.setForeground(COLOR_LABEL);
        lblNombreUsuario.setBounds(40, 75, 150, 25);
        add(lblNombreUsuario);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        txtNombreUsuario.setBackground(COLOR_CAMPO_TEXTO);
        txtNombreUsuario.setForeground(COLOR_TEXTO);
        txtNombreUsuario.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtNombreUsuario.setBounds(220, 75, 190, 28);
        add(txtNombreUsuario);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        lblNombre.setForeground(COLOR_LABEL);
        lblNombre.setBounds(40, 115, 150, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 13));
        txtNombre.setBackground(COLOR_CAMPO_TEXTO);
        txtNombre.setForeground(COLOR_TEXTO);
        txtNombre.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtNombre.setBounds(220, 115, 190, 28);
        add(txtNombre);

        lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Arial", Font.PLAIN, 13));
        lblApellido.setForeground(COLOR_LABEL);
        lblApellido.setBounds(40, 155, 150, 25);
        add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setFont(new Font("Arial", Font.PLAIN, 13));
        txtApellido.setBackground(COLOR_CAMPO_TEXTO);
        txtApellido.setForeground(COLOR_TEXTO);
        txtApellido.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtApellido.setBounds(220, 155, 190, 28);
        add(txtApellido);

        lblTelefono = new JLabel("Telefono:");
        lblTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
        lblTelefono.setForeground(COLOR_LABEL);
        lblTelefono.setBounds(40, 195, 150, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 13));
        txtTelefono.setBackground(COLOR_CAMPO_TEXTO);
        txtTelefono.setForeground(COLOR_TEXTO);
        txtTelefono.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtTelefono.setBounds(220, 195, 190, 28);
        add(txtTelefono);

        lblCorreo = new JLabel("Correo Electronico:");
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 13));
        lblCorreo.setForeground(COLOR_LABEL);
        lblCorreo.setBounds(40, 235, 150, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Arial", Font.PLAIN, 13));
        txtCorreo.setBackground(COLOR_CAMPO_TEXTO);
        txtCorreo.setForeground(COLOR_TEXTO);
        txtCorreo.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtCorreo.setBounds(220, 235, 190, 28);
        add(txtCorreo);

        lblContrasena = new JLabel("Nueva Contrasena:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblContrasena.setForeground(COLOR_LABEL);
        lblContrasena.setBounds(40, 275, 150, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtContrasena.setBackground(COLOR_CAMPO_TEXTO);
        txtContrasena.setForeground(COLOR_TEXTO);
        txtContrasena.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtContrasena.setBounds(220, 275, 190, 28);
        add(txtContrasena);

        lblConfirmarContrasena = new JLabel("Confirmar Contrasena:");
        lblConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblConfirmarContrasena.setForeground(COLOR_LABEL);
        lblConfirmarContrasena.setBounds(40, 315, 150, 25);
        add(lblConfirmarContrasena);

        txtConfirmarContrasena = new JPasswordField();
        txtConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtConfirmarContrasena.setBackground(COLOR_CAMPO_TEXTO);
        txtConfirmarContrasena.setForeground(COLOR_TEXTO);
        txtConfirmarContrasena.setBorder(BorderFactory.createLineBorder(COLOR_BORDE, 1));
        txtConfirmarContrasena.setBounds(220, 315, 190, 28);
        add(txtConfirmarContrasena);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(95, 390, 135, 36);
        estilizarBotonPrincipal(btnActualizar);
        add(btnActualizar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(275, 390, 135, 36);
        estilizarBotonSecundario(btnCancelar);
        add(btnCancelar);

        btnActualizar.addActionListener(e -> actualizarUsuario());

        btnCancelar.addActionListener(e -> {
            dispose();
            new VentanaPrincipal();
        });
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

    private void cargarDatosUsuario() {
        txtNombreUsuario.setText(usuario.getNombreUsuario());
        txtNombre.setText(usuario.getNombre());
        txtApellido.setText(usuario.getApellido());
        txtTelefono.setText(usuario.getTelefono());
        txtCorreo.setText(usuario.getCorreo());
    }

    private void actualizarUsuario() {
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
            JOptionPane.showMessageDialog(this, "Falta la nueva contrasena.");
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

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setCorreo(correo);
        usuario.setContrasena(contrasena);

        boolean actualizado = usuarioDAO.actualizarUsuario(usuario);

        if (actualizado) {
            JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
            dispose();
            new VentanaPrincipal();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario.");
        }
    }
}