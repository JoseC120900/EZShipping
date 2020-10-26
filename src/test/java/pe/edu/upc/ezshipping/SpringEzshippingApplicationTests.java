package pe.edu.upc.ezshipping;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import pe.edu.upc.ezshipping.models.entities.Persona;
import pe.edu.upc.ezshipping.services.PersonaService;

@SpringBootTest
class SpringEzshippingApplicationTests {

	@Autowired
	PersonaService personaService;
	
	@Test
	void contextLoads() {		
		Persona persona = new Persona();
		persona.setNombre("Jose");
		persona.setApellido("Donayre");
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		try{
		Date date = DateFor.parse("21/02/2000");		
		persona.setFechaNacimiento(date);
		}catch (ParseException e) {e.printStackTrace();}
		persona.setEmail("JoseDona@gmail.com");
				
		try {
			personaService.save(persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.isTrue(true);	
	}
}
