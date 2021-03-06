package tienda.daniel.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	private int id_rol;

	@Email(message = "Formato no valido")
	@NotBlank(message = "campo obligatorio")
	private String email;

	@NotBlank(message = "campo obligatorio")
	private String clave;

	@NotBlank(message = "campo obligatorio")
	private String nombre;

	@NotBlank(message = "campo obligatorio")
	private String apellido1;

	private String apellido2;

	private String direccion;

	private String localidad;

	private String provincia;

	private String telefono;

	private String dni;

	// private String imagen;

	/*
	 * public String getImagen() { return imagen; }
	 * 
	 * 
	 * 
	 * public void setImagen(String imagen) { this.imagen = imagen; }
	 */

	public Usuarios(String email, String clave) {
		this.clave = clave;
		this.email = email;
	}

	public Usuarios(int id_rol, String email, String clave, String nombre, String apellido1, String apellido2,
			String direccion, String localidad, String provincia, String telefono, String dni) {
		super();
		this.id_rol = id_rol;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.dni = dni;
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", id_rol=" + id_rol + ", email=" + email + ", clave=" + clave + ", nombre="
				+ nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", telefono=" + telefono + ", dni=" + dni
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
