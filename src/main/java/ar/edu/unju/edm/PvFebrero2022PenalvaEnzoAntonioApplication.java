package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.services.IUsuarioService;

@SpringBootApplication
public class PvFebrero2022PenalvaEnzoAntonioApplication implements CommandLineRunner{
@Autowired
Usuario unUsuario;
@Autowired
IUsuarioService unUser;

	public static void main(String[] args) {
		SpringApplication.run(PvFebrero2022PenalvaEnzoAntonioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		unUsuario.setDni("43139514");
		unUsuario.setApellido("Peñalva");
		unUsuario.setNombre("Enzo Antonio");
		unUsuario.setMail("enzo2016antonio@gmail.com");
		unUsuario.setPassword("IvanxdTesla");
		unUsuario.setTipoUsuario("Admin");
		unUser.guardarUsuario(unUsuario);
	}

}
