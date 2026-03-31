package Tarea4.vistas;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Tarea4.logica.UsuarioDAO;
import Tarea4.modelo.Usuario;

public class VentanaPrincipal extends JFrame {
	
    private JLabel lblTitulo;
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private JScrollPane scrollPane;

    private JButton btnNuevo;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnCerrarSesion;

    private UsuarioDAO usuarioDAO;
    
    public VentanaPrincipal() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Usuarios Registrados");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        iniciarComponentes();
        cargarUsuariosEnTabla();

        setVisible(true);
    }

    private void iniciarComponentes() {
        lblTitulo = new JLabel("CLIENTES REGISTRADOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(250, 20, 300, 30);
        add(lblTitulo);

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo Electronico");
        modeloTabla.addColumn("Usuario");

        tablaUsuarios = new JTable(modeloTabla);

        scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(40, 70, 700, 250);
        add(scrollPane);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(40, 360, 120, 35);
        add(btnNuevo);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(210, 360, 120, 35);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(380, 360, 120, 35);
        add(btnEliminar);

        btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBounds(550, 360, 150, 35);
        add(btnCerrarSesion);

        btnNuevo.addActionListener(e -> {
            dispose();
            new VentanaRegistro();
        });

        btnCerrarSesion.addActionListener(e -> {
            dispose();
            new VentanaLogin();
        });

        btnEliminar.addActionListener(e -> eliminarUsuario());

        btnActualizar.addActionListener(e -> actualizarUsuario());
    }

    public void cargarUsuariosEnTabla() {
        modeloTabla.setRowCount(0);

        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario usuario : listaUsuarios) {
            Object[] fila = {
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getTelefono(),
                usuario.getCorreo(),
                usuario.getNombreUsuario()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro de eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);

            boolean eliminado = usuarioDAO.eliminarUsuario(id);

            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
                cargarUsuariosEnTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el usuario.");
            }
        }
    }

    private void actualizarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario para actualizar.");
            return;
        }

        int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
        String telefono = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
        String correo = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
        String nombreUsuario = (String) modeloTabla.getValueAt(filaSeleccionada, 5);

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setCorreo(correo);
        usuario.setNombreUsuario(nombreUsuario);

        dispose();
        new VentanaActualizarUsuario(usuario);
    }

}