package br.com.apirest.produtos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.produtos.entity.Curso;
import br.com.apirest.produtos.services.CursoService;

@RestController
@RequestMapping(value="/api/cursos")
public class CursoController {
	
	private final CursoService cursoService;
	
	@Autowired
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Curso>> listarTodosCursos() {
		List<Curso> cursos = cursoService.listarTodosCurso();
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id) {
		Optional<Curso> curso = cursoService.buscarCursoPorId(id);
		return curso.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
		
		
		Curso novoCurso = cursoService.salvarCurso(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso cursoAtualizado) {
		Optional<Curso> curso = cursoService.buscarCursoPorId(id);
		
		if (curso.isPresent()) {
			cursoAtualizado.setId(id);
			Curso cursoAtualizadoSalvo = cursoService.salvarCurso(cursoAtualizado);
			return ResponseEntity.ok(cursoAtualizado);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> excluirCurso(@PathVariable Long id) {
		Optional<Curso> curso = cursoService.buscarCursoPorId(id);
		
		if (curso.isPresent()) {
			cursoService.excluirCurso(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}

















