package Tarea4.modelo;

public class Usuario extends Persona {

    private int id;
    private String nombreUsuario;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String contrasena, String nombre, String apellido, String telefono, String correo) {
        super(nombre, apellido, telefono, correo);
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono, String correo) {
        super(nombre, apellido, telefono, correo);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String mostrarInformacion() {
        return "Usuario: " + nombreUsuario +
               ", Nombre: " + getNombre() +
               ", Apellido: " + getApellido() +
               ", Telefono: " + getTelefono() +
               ", Correo: " + getCorreo();
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido();
    }
}
