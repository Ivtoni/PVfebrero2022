package ar.edu.unju.edm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.model.Pelicula;

public interface IPeliculaDAO extends CrudRepository <Pelicula, Integer>{
	@Query("from Pelicula c order by c.codPeli")
	public List<Pelicula> obtenerPelis();
}
