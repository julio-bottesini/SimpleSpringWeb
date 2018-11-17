package br.com.uniara.SpringProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uniara.SpringProject.entity.AlunoEntity;
import br.com.uniara.SpringProject.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public void salvar(AlunoEntity aluno) {
		if(validarNome(aluno.getNome())) {
			alunoRepository.save(aluno);
		}else {
			throw new RuntimeException("nome invalido!");
		}
	}
	
	public AlunoEntity buscarRa(int ra) {
		return alunoRepository.findById(ra).orElse(null);
	}
	
	public List<AlunoEntity> buscar() {
		return (List<AlunoEntity>) alunoRepository.findAll();
	}
	
	public void deletar(int ra) {
		alunoRepository.deleteById(ra);
	}
	
	public void alterar(AlunoEntity alunoEntity) {
		alunoRepository.save(alunoEntity);
	}
	
	public boolean validarNome(String nome) {
		return !nome.contains("_");
	}
}






