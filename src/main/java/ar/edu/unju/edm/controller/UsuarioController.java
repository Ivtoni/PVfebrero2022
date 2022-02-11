package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.services.IUsuarioService;

@Controller
public class UsuarioController {
	@Autowired 
	IUsuarioService unUsuario;
	
	@GetMapping ("/registro")
	public String registrarUsuario(Model model) {
		model.addAttribute("unUser", unUsuario.crearUsuario());
		return "registro";
	}
	@PostMapping ("/registro/guardar")
	public String guardarUsuario(@ModelAttribute ("unUser") Usuario unUsrio, Model model) {
		unUsuario.guardarUsuario(unUsrio);
		return "redirect:/login";
}
	@GetMapping ("/usuario")
	public String registrarUsuarioAdmin(Model model) {
		model.addAttribute("unUser", unUsuario.crearUsuario());
		return "principal";
	}
	@PostMapping ("/usuario/guardar")
	public String guardarUsuarioAdmin(@ModelAttribute ("unUser") Usuario unUsrio, Model model) {
		unUsuario.guardarUsuario(unUsrio);
		return "redirect:/login";
}
	@GetMapping ("usuario/editar/{dni}")
	public String editarUsuario(Model model, @PathVariable(name="dni") String dni) throws Exception {
		try {
			Usuario usuarioEncontrado = unUsuario.encontrarUsuario(null);
			model.addAttribute("unUser", usuarioEncontrado);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unUser", unUsuario.crearUsuario());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("lista", unUsuario.obtenerTodosUsuarios());
		return("usuario");
	}
	@PostMapping ("/usuario/modificar")
	public String modificarUsuario(@ModelAttribute ("unUser") Usuario unUsrio, Model model) {
		
		try {
			unUsuario.modificarUsuario(unUsrio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/usuario";
	}
	@GetMapping ("/usuario/eliminar/{dni}")
	public String eliminarUsuario(Model model, @PathVariable (name="dni") String dni) {
		
		try {
			unUsuario.eliminarUsuario(dni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/usuario";
	}
}