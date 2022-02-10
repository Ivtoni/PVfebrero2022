package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="USUARIOS")
public class Usuario {
	@Id
	@Column
	private String dni;
	@Column
	private String apellido;
	@Column
	private String nombre;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	@Column
	private String password;
	@Column
	private String tipoUsuario="Cliente";
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	public Usuario(String dni, String apellido, String nombre, LocalDate fechaNac, String password,
			String tipoUsuario) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
