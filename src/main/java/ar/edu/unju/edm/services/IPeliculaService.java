package ar.edu.unju.edm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;

@Service
public interface IPeliculaService {
	public void guardarPeli(Pelicula unaPeli);
	public void modificarPeli(Pelicula unaPeli) throws Exception;
	public Pelicula crearPeli();
	public Pelicula encontrarPeli(int codPeli) throws Exception;
	public List<Pelicula> obtenerTodasPelis();
	public void eliminarPeli(int codPeli) throws Exception;
}
