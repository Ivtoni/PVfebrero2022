package ar.edu.unju.edm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name="PELICULAS")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int codPeli;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private float duracion;
	@Column
	private byte[] fotografia;
	@Column
	private String director;
	@Column
	private String actor;
	
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	
	public Pelicula(int codPeli, String nombre, String descripcion, float duracion, byte[] fotografia, String director,
			String actor) {
		super();
		this.codPeli = codPeli;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.fotografia = fotografia;
		this.director = director;
		this.actor = actor; 
	}


	public int getCodPeli() {
		return codPeli;
	}

	public void setCodPeli(int codPeli) {
		this.codPeli = codPeli;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
	
}
