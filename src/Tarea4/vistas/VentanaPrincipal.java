package Tarea4.vistas;

import java.awt.Color;
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
    
    private final Color COLOR_FONDO = new Color(250, 251, 240);         // #fafbf0
    private final Color COLOR_TITULO = new Color(29, 31, 38);           // #1d1f26
    private final Color COLOR_LABEL = new Color(53, 63, 67);            // #353f43
    private final Color COLOR_BOTON_PRINCIPAL = new Color(65, 93, 109); // #415d6d
    private final Color COLOR_BOTON_SECUNDARIO = new Color(125, 108, 81); // #7d6c51
    private final Color COLOR_BOTON_PELIGRO = new Color(255, 20, 20);    // #3c5f5c
    private final Color COLOR_TABLA_HEADER = new Color(65, 93, 109);    // #415d6d
    private final Color COLOR_TABLA_TEXTO = new Color(29, 31, 38);      // #1d1f26
    
    public VentanaPrincipal() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Usuarios Registrados");
        setSize(860, 540);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);

        iniciarComponentes();
        cargarUsuariosEnTabla();

        setVisible(true);
    }

    private void iniciarComponentes() {
        lblTitulo = new JLabel("CLIENTES REGISTRADOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(COLOR_TITULO);
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
        tablaUsuarios.setRowHeight(28);
        tablaUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
        tablaUsuarios.setForeground(COLOR_TABLA_TEXTO);
        tablaUsuarios.setSelectionBackground(new Color(224, 195, 111)); // #e0c36f
        tablaUsuarios.setSelectionForeground(COLOR_TITULO);
        tablaUsuarios.setGridColor(new Color(220, 220, 220));
        tablaUsuarios.setShowVerticalLines(true);
        tablaUsuarios.setShowHorizontalLines(true);

        tablaUsuarios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        tablaUsuarios.getTableHeader().setBackground(COLOR_TABLA_HEADER);
        tablaUsuarios.getTableHeader().setForeground(Color.WHITE);

        tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);

        scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(40, 75, 770, 290);
        add(scrollPane);

        btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(40, 360, 120, 35);
        estilizarBotonPrincipal(btnNuevo);
        add(btnNuevo);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(210, 360, 120, 35);
        estilizarBotonSecundario(btnActualizar);
        add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(380, 360, 120, 35);
        estilizarBotonPeligro(btnEliminar);
        add(btnEliminar);

        btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.setBounds(550, 360, 150, 35);
        estilizarBotonSecundario(btnCerrarSesion);
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

    private void estilizarBotonPeligro(JButton boton) {
        boton.setBackground(COLOR_BOTON_PELIGRO);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setBorderPainted(false);
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