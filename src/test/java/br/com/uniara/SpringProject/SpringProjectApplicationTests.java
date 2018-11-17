package br.com.uniara.SpringProject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.uniara.SpringProject.entity.AlunoEntity;
import br.com.uniara.SpringProject.service.AlunoService;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringProjectApplicationTests {
	
	@Autowired
	AlunoService alunoService;
	//MOCKITO
	
	@Test
	public void testaValidarNomeSemUnderline() {
		boolean deuCerto = 
				alunoService.validarNome("Julio");
		
		boolean deuErrado = 
				alunoService.validarNome("Ju_lio");
		
		Assert.assertEquals(true, deuCerto);
		Assert.assertEquals(false, deuErrado);
	}
	
	@Test
	public void testaTudo() {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<AlunoEntity> r = restTemplate
				.exchange("http://localhost:8080/aluno/1"
				,HttpMethod.GET,null, AlunoEntity.class);
		
		AlunoEntity alunoEntity = r.getBody();
		
		assertEquals(1, alunoEntity.getRa());
		assertEquals("nao_vou", alunoEntity.getNome());
		assertEquals(HttpStatus.OK, r.getStatusCode());
	}
	
	
	
	
	
	
	
	
	

}
