package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.repository.IPeliculaDAO;
import ar.edu.unju.edm.services.IPeliculaService;

@Service
public class PeliculaServiceMySQL implements IPeliculaService{
	@Autowired
	Pelicula unaPeli;
	@Autowired
	IPeliculaDAO peliDAO;
	
	@Override
	public void guardarPeli(Pelicula unaPeli) {
		// TODO Auto-generated method stub
		
		peliDAO.save(unaPeli);

	}

	@Override
	public void eliminarPeli(int codPeli) throws Exception {
		// TODO Auto-generated method stub
		Pelicula peliAEliminar = peliDAO.findById(codPeli).orElseThrow(()->new Exception("La Pelicula solicitada no fue encontrado"));
		peliDAO.delete(peliAEliminar);
		
	}

	@Override
	public void modificarPeli(Pelicula unaPeli) throws Exception {
		// TODO Auto-generated method stub
		Pelicula peliAModificar= peliDAO.findById(unaPeli.getCodPeli()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		cambiarPeli(unaPeli, peliAModificar);
		peliDAO.save(peliAModificar);
	}
	private void cambiarPeli(Pelicula desde, Pelicula hacia) {
		hacia.setNombre(desde.getNombre());
		hacia.setDescripcion(desde.getDescripcion());
		hacia.setFotografia(desde.getFotografia());
		hacia.setDirector(desde.getDirector());
		hacia.setActor(desde.getActor());
	}
	

	@Override
	public Pelicula crearPeli() {
		// TODO Auto-generated method stub
		return unaPeli;
	}

	@Override
	public Pelicula encontrarPeli(int codPeli) throws Exception {
		// TODO Auto-generated method stub
		return peliDAO.findById(codPeli).orElseThrow(()->new Exception("el cliente no fue encontrado"));
	}

	@Override
	public List<Pelicula> obtenerTodasPelis() {
		// TODO Auto-generated method stub
		return  (List<Pelicula>) peliDAO.findAll();
	}

	
	
}
