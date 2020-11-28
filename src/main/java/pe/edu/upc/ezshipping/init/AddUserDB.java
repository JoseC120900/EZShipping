package pe.edu.upc.ezshipping.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.ezshipping.models.entities.Usuario;
import pe.edu.upc.ezshipping.models.repositories.AuthorityRepository;
import pe.edu.upc.ezshipping.models.repositories.UsuarioRepository;
import pe.edu.upc.ezshipping.utils.Segmento;

//.init-> inicializar la data, cifrar la contaseña
@Service
public class AddUserDB implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	// ejecuta de forma automatica
	@Override
	public void run(String... args) throws Exception {

		// Creando el objeto que cifra las contraseñas
		/*BCryptPasswordEncoder bcpeCliente = new BCryptPasswordEncoder();
		String passwordCliente = bcpeCliente.encode("cliente");

		Usuario cliente1 = new Usuario();
		cliente1.setUsername("josed");
		cliente1.setPassword(passwordCliente);
		cliente1.setSegmento(Segmento.CLIENTE);
		cliente1.setIdSegmento(1);
		cliente1.setEnable(true);


		Usuario cliente2 = new Usuario();
		cliente2.setUsername("dyland");
		cliente2.setPassword(passwordCliente);
		cliente2.setSegmento(Segmento.CLIENTE);
		cliente2.setIdSegmento(2);
		cliente2.setEnable(true);


		Usuario cliente3 = new Usuario();
		cliente3.setUsername("pedrom");
		cliente3.setPassword(passwordCliente);
		cliente3.setSegmento(Segmento.CLIENTE);
		cliente3.setIdSegmento(3);
		cliente3.setEnable(true);


		// Creando el objeto que cifra las contraseñas
		BCryptPasswordEncoder bcpeTrabajador = new BCryptPasswordEncoder();
		String passwordTrabajador = bcpeTrabajador.encode("trabajador");
		
		Usuario trabajador1 = new Usuario();
		trabajador1.setUsername("keijis");
		trabajador1.setPassword(passwordTrabajador);
		trabajador1.setSegmento(Segmento.TRABAJADOR);
		trabajador1.setIdSegmento(1);
		trabajador1.setEnable(true);

		
		Usuario trabajador2 = new Usuario();
		trabajador2.setUsername("marting");
		trabajador2.setPassword(passwordTrabajador);
		trabajador2.setSegmento(Segmento.TRABAJADOR);
		trabajador2.setIdSegmento(4);
		trabajador2.setEnable(true);
		
		Usuario trabajador3 = new Usuario();
		trabajador3.setUsername("miguelr");
		trabajador3.setPassword(passwordTrabajador);
		trabajador3.setSegmento(Segmento.TRABAJADOR);
		trabajador3.setIdSegmento(5);
		trabajador3.setEnable(true);
		
		// Roles de usuario: ROLE_CUSTOMER, ROLE_COURIER, ROLE_ADMIN
		cliente1.addAuthority("ROLE_CUSTOMER");
		cliente2.addAuthority("ROLE_CUSTOMER");
		cliente3.addAuthority("ROLE_CUSTOMER");
		trabajador1.addAuthority("ROLE_COURIER");
		trabajador2.addAuthority("ROLE_ADMIN");
		trabajador3.addAuthority("ROLE_COURIER");

		// Accesos a recursos
		cliente1.addAuthority("ACCESS_ALL");
		cliente2.addAuthority("ACCESS_ALL");
		cliente3.addAuthority("ACCESS_ALL");
		trabajador2.addAuthority("ACCESS_ADMIN");
		
		//Grabar
		usuarioRepository.save(cliente1);
		usuarioRepository.save(cliente2);
		usuarioRepository.save(cliente3);
		
		usuarioRepository.save(trabajador1);
		usuarioRepository.save(trabajador2);
		usuarioRepository.save(trabajador3);*/
	}

}
