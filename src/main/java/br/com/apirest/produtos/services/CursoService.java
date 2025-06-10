package br.com.apirest.produtos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apirest.produtos.entity.Curso;
import br.com.apirest.produtos.repository.CursoRepository;

@Service
public class CursoService {
	
	private final CursoRepository cursoRepository;
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Optional<Curso> buscarCursoPorId(Long id) {
		return cursoRepository.findById(id);
	}
	
	public List<Curso> listarTodosCurso() {
		return cursoRepository.findAll();
	}
	
	public void excluirCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}
