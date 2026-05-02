package clase;

//variables que se utilizaran para la informacion de la agenda
public class contacto {
	int Id;
	String Nombres;
	String Apellidos;
	String Correo;
	String Numero;
	public contacto(int Id, String Nombres, String Apellidos, String Correo, String Numero) {
		this.Id = Id;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Correo = Correo;
		this.Numero = Numero;

	}
//metodos de ecritura y lectura para la informacion que se va ingresar
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}



}
