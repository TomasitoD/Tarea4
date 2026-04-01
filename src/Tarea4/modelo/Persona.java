package Tarea4.modelo;

// Clase abstracta que guarda los datos comunes de una persona.
// Se usa como base para que la clase Usuario herede estos atributos.
public abstract class Persona {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Devuelve el nombre y apellido juntos en un solo texto.
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    // Este metodo sera implementado por las clases hijas
    // para mostrar la informacion de la forma que necesiten.
    public abstract String mostrarInformacion();
}