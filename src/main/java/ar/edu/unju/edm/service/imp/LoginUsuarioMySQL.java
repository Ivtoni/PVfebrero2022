package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.IUsuarioDAO;
@Service
public class LoginUsuarioMySQL implements UserDetailsService{ 
	@Autowired
	IUsuarioDAO unUsuarioDAO;
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = unUsuarioDAO.findById(dni).orElseThrow(()-> new UsernameNotFoundException("Usuario inválido"));
		
		List<GrantedAuthority> tipos = new ArrayList<>(); 
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipoUsuario());
		tipos.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(dni, usuarioEncontrado.getPassword(), tipos);
		
		return user;
	}
	
}
