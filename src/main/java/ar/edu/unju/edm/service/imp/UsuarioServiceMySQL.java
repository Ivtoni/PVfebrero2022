package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDAO;
import ar.edu.unju.edm.services.IUsuarioService;

@Service
public class UsuarioServiceMySQL implements IUsuarioService{
	@Autowired
	Usuario unUsuario;
	@Autowired 
	IUsuarioDAO usuarioDAO;

	@Override
	public void guardarUsuario(Usuario unUsuario) {
		// TODO Auto-generated method stub
		String pw = unUsuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unUsuario.setPassword(bCryptPasswordEncoder.encode(pw));
		usuarioDAO.save(unUsuario);
	}

	@Override
	public void eliminarUsuario(String dni) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioAEliminar = usuarioDAO.findById(dni).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		usuarioDAO.delete(usuarioAEliminar);
	}
	private void cambiarUsuario(Usuario desde, Usuario hacia) {
		hacia.setApellido(desde.getApellido());
		hacia.setNombre(desde.getNombre());
		hacia.setTipoUsuario(desde.getTipoUsuario());
		hacia.setFechaNac(desde.getFechaNac());
	}

	@Override
	public void modificarUsuario(Usuario unUsuario) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioAModificar = usuarioDAO.findById(unUsuario.getDni()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		cambiarUsuario(unUsuario, usuarioAModificar);
		usuarioDAO.save(usuarioAModificar);
	}

	@Override
	public Usuario crearUsuario() {
		// TODO Auto-generated method stub
		return unUsuario;
	}

	@Override
	public Usuario encontrarUsuario(String dni) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(dni).orElseThrow(()->new Exception("el cliente no fue encontrado"));
	}

	@Override
	public List<Usuario> obtenerTodosUsuarios() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

}
