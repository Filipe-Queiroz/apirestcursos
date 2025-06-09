package br.com.apirest.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apirest.produtos.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
