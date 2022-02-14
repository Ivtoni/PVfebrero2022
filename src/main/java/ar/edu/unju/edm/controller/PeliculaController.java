package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.services.IPeliculaService;

@Controller
public class PeliculaController {
	@Autowired
	IPeliculaService unaPeli;
	@GetMapping ("/pelicula") 
	public String cargarPelicula(Model model) {
		model.addAttribute("lista", unaPeli.obtenerTodasPelis());	
		model.addAttribute("unaPeli", unaPeli.crearPeli() );
			return ("pelicula");
}
	@PostMapping("/pelicula/guardar")
	public String guardarPelicula(@ModelAttribute ("unaPeli") Pelicula unaPelicula, Model model) {
		unaPeli.guardarPeli(unaPelicula);
		return "redirect:/lista";
}
	@GetMapping("/pelicula/editar/{codPeli}")
	public String editarPelicula(Model model, @PathVariable(name="codPeli") int cod) throws Exception {
		try {
			Pelicula peliculaEncontrada = unaPeli.encontrarPeli(cod);
			model.addAttribute("unaPeli", peliculaEncontrada);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unaPeli", unaPeli.crearPeli());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("lista", unaPeli.obtenerTodasPelis());
		return ("pelicula");
	}
	@PostMapping ("/pelicula/modificar")
	public String modificarPelicula(@ModelAttribute ("unaPeli") Pelicula unaPelicula, Model model) {
		try {
			unaPeli.modificarPeli(unaPelicula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/listaPeliAdmin";
	}
	@GetMapping("/pelicula/eliminar/{codPeli}")
	public String eliminarPelicula(Model model, @PathVariable(name="codPeli") int codPeli) {
		try {			unaPeli.eliminarPeli(codPeli);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/listaPeliAdmin";
	}
	@GetMapping ("/listaPelis")
	public String mostrarLista(Model model) {
		model.addAttribute("listapeli", unaPeli.obtenerTodasPelis());
		return ("pelisUsuario");
}
	@GetMapping ("/listaPeliAdmin")
	public String mostrarListaAdmin(Model model) {
		model.addAttribute("listapeli", unaPeli.obtenerTodasPelis());
		return ("tablapeli");
}
}