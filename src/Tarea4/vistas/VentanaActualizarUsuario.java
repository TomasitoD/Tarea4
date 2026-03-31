package Tarea4.vistas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Tarea4.logica.UsuarioDAO;
import Tarea4.modelo.Usuario;

public class VentanaActualizarUsuario extends JFrame{
	
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
	    
	    public VentanaActualizarUsuario(Usuario usuario) {
	        this.usuario = usuario;
	        this.usuarioDAO = new UsuarioDAO();

	        setTitle("Actualizar Usuario");
	        setSize(500, 450);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);

	        iniciarComponentes();
	        cargarDatosUsuario();

	        setVisible(true);
	    }

	    private void iniciarComponentes() {
	        lblTitulo = new JLabel("ACTUALIZAR USUARIO");
	        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
	        lblTitulo.setBounds(130, 20, 250, 30);
	        add(lblTitulo);

	        lblNombreUsuario = new JLabel("Nombre de Usuario:");
	        lblNombreUsuario.setBounds(40, 70, 150, 25);
	        add(lblNombreUsuario);

	        txtNombreUsuario = new JTextField();
	        txtNombreUsuario.setBounds(220, 70, 180, 25);
	        add(txtNombreUsuario);

	        lblNombre = new JLabel("Nombre:");
	        lblNombre.setBounds(40, 110, 150, 25);
	        add(lblNombre);

	        txtNombre = new JTextField();
	        txtNombre.setBounds(220, 110, 180, 25);
	        add(txtNombre);

	        lblApellido = new JLabel("Apellido:");
	        lblApellido.setBounds(40, 150, 150, 25);
	        add(lblApellido);

	        txtApellido = new JTextField();
	        txtApellido.setBounds(220, 150, 180, 25);
	        add(txtApellido);

	        lblTelefono = new JLabel("Telefono:");
	        lblTelefono.setBounds(40, 190, 150, 25);
	        add(lblTelefono);

	        txtTelefono = new JTextField();
	        txtTelefono.setBounds(220, 190, 180, 25);
	        add(txtTelefono);

	        lblCorreo = new JLabel("Correo Electronico:");
	        lblCorreo.setBounds(40, 230, 150, 25);
	        add(lblCorreo);

	        txtCorreo = new JTextField();
	        txtCorreo.setBounds(220, 230, 180, 25);
	        add(txtCorreo);

	        lblContrasena = new JLabel("Nueva Contrasena:");
	        lblContrasena.setBounds(40, 270, 150, 25);
	        add(lblContrasena);

	        txtContrasena = new JPasswordField();
	        txtContrasena.setBounds(220, 270, 180, 25);
	        add(txtContrasena);

	        lblConfirmarContrasena = new JLabel("Confirmar Contrasena:");
	        lblConfirmarContrasena.setBounds(40, 310, 150, 25);
	        add(lblConfirmarContrasena);

	        txtConfirmarContrasena = new JPasswordField();
	        txtConfirmarContrasena.setBounds(220, 310, 180, 25);
	        add(txtConfirmarContrasena);

	        btnActualizar = new JButton("Actualizar");
	        btnActualizar.setBounds(100, 360, 120, 30);
	        add(btnActualizar);

	        btnCancelar = new JButton("Cancelar");
	        btnCancelar.setBounds(260, 360, 120, 30);
	        add(btnCancelar);

	        btnActualizar.addActionListener(e -> actualizarUsuario());

	        btnCancelar.addActionListener(e -> {
	            dispose();
	            new VentanaPrincipal();
	        });
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
