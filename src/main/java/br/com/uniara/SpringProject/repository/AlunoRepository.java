package br.com.uniara.SpringProject.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.uniara.SpringProject.entity.AlunoEntity;

public interface AlunoRepository extends CrudRepository<AlunoEntity, Integer> {

	
}
