package br.com.uniara.SpringProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uniara.SpringProject.entity.AlunoEntity;
import br.com.uniara.SpringProject.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	List<AlunoEntity> listaAlunos = new ArrayList<>();

	@Autowired
	AlunoService alunoService;
	
	@PostMapping("/")
	public ResponseEntity<String> salvar(@RequestBody AlunoEntity aluno) {
		alunoService.salvar(aluno);
		return ResponseEntity.ok("top");
	}
	
	@GetMapping("/{ra}")
	public ResponseEntity<?> buscarRa(@PathVariable int ra) {
		AlunoEntity alunoEntity = alunoService.buscarRa(ra);
		return ResponseEntity.ok(alunoEntity);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AlunoEntity>> buscar() {
		return ResponseEntity.ok(alunoService.buscar());
	}
	
	@DeleteMapping("/{ra}")
	public ResponseEntity<?> deletar(@PathVariable int ra) {
		alunoService.deletar(ra);
		return ResponseEntity.ok("Deletou");
	}
	
	@PatchMapping("/")
	public ResponseEntity<String> alterar(
			@RequestBody AlunoEntity aluno) {
		alunoService.alterar(aluno);
		return ResponseEntity.ok("alterou");
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> exception(Exception e){
		Map<String, String> mapException = new HashMap<>();
		mapException.put("message", e.getMessage());
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(mapException);
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> exceptionRuntime(RuntimeException e){
		Map<String, String> mapException = new HashMap<>();
		mapException.put("message", e.getMessage());
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(mapException);
	}
}








