package clase;

// Variables que se utilizaran para la informacion de la agenda
public class contacto {
    int id;
    String nombres, apellidos, correo, numero;
    
    public contacto(int id, String nombres, String apellidos, String correo, String numero) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.numero = numero;
    }

    // Métodos de lectura (Getters)
    public int getid() {
        return id;
    }

    public String getnombres() {
        return nombres;
    }

    public String getapellidos() {
        return apellidos;
    }

    
    public String getcorreo() {
        return correo;
    }

    public String getnumero() {
        return numero;
    }

    // Métodos de asignación (Setters)
    public void setid(int id) {
        this.id = id; 
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

   
    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public void setnumero(String numero) {
        this.numero = numero;
    }
}