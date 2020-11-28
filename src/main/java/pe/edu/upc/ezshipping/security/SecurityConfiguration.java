package pe.edu.upc.ezshipping.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
		
				// ---------------------------------------------
				// authenticated: para ir a una pagina, primero necesita autenticarse
				// permitAll: todos pueden acceder a esa pagina
				// ---------------------------------------------
		
				.antMatchers("/").permitAll()
				 .antMatchers("/contactanos").authenticated()
//				--------jason--------
				 .antMatchers("/lista_envios").hasRole("CUSTOMER")
//				--------keiji--------
				 .antMatchers("/terminos").permitAll()
				 .antMatchers("/terminosblack").permitAll()
				 .antMatchers("/terminossilver").permitAll()
				 .antMatchers("/terminosgold").permitAll()
				 .antMatchers("/terminossin").permitAll()
				 .antMatchers("/clientesmembresia").hasRole("ADMIN")
				 .antMatchers("/clientesmembresiasilver").hasRole("ADMIN")
				 .antMatchers("/clientesmembresiagold").hasRole("ADMIN")
				 .antMatchers("/clientesmembresiablack").hasRole("ADMIN")
				 .antMatchers("/clientesenvios").hasRole("ADMIN")
				 .antMatchers("/administrar").hasRole("ADMIN")
				 .antMatchers("/administrar").hasRole("ADMIN")
				 .antMatchers("/listaclientes").hasRole("ADMIN")
//				--------dylan--------
				.antMatchers("/rastrear").hasRole("CUSTOMER")
				.antMatchers("/rastrear/search").hasRole("CUSTOMER")
				.antMatchers("/precios").hasRole("CUSTOMER")
				.antMatchers("/preciossearch-2").hasRole("CUSTOMER")
				.antMatchers("/preciossearch-3").hasRole("CUSTOMER")
				.antMatchers("/preciossearch-4").hasRole("CUSTOMER")
				.antMatchers("/envio/new").hasRole("CUSTOMER")
				.antMatchers("/envio/new/detail").hasRole("CUSTOMER")
				.antMatchers("/envio/new/detail/confirm").hasRole("CUSTOMER")
//				--------jose--------
				 .antMatchers("/reclamos").authenticated()
				 .antMatchers("/membresias").hasRole("CUSTOMER")
				 .antMatchers("/membresias/view-Gold").hasRole("CUSTOMER")
				 .antMatchers("/membresias/view-Black").hasRole("CUSTOMER")
				 .antMatchers("/membresias/view-Silver").hasRole("CUSTOMER")
//				--------jacobo--------
				 .antMatchers("/tarjetas").hasRole("CUSTOMER")
				 .antMatchers("/filtrarFechasClientes").hasRole("ADMIN")
				 .antMatchers("/sobreNosotros").permitAll()
				 .antMatchers("/contacto").hasRole("CUSTOMER")
				.and()
					.formLogin()
						.loginProcessingUrl("/signin") //iniciar sesion
						.loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
				.and()
						.logout() //cerrar sesion
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Aqui se crea el vinculo entre el Spring security y: el PasswordEncoder y
	// UsuarioDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		return daoAuthenticationProvider;
	}

}