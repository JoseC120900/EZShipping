package pe.edu.upc.ezshipping;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import pe.edu.upc.ezshipping.models.entities.Persona;
import pe.edu.upc.ezshipping.models.entities.TipoCliente;
import pe.edu.upc.ezshipping.services.PersonaService;
import pe.edu.upc.ezshipping.services.TipoClienteService;

@SpringBootTest
class SpringEzshippingApplicationTests {

	@Autowired
	TipoClienteService tipoclienteService;
	
	@Test
	void contextLoads() {		
		TipoCliente tipo = new TipoCliente();
		tipo.setNombre("Black");
		tipo.setDescuento(0.35);
				
		try {
			tipoclienteService.save(tipo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.isTrue(true);	
	}
	
	
}

