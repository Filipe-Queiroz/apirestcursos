package br.com.apirest.produtos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
@RequestMapping(value="/cursos")
public class CursoController {

	@GetMapping
	public ModelAndView cursoJava() {
		ModelAndView template = new ModelAndView("index");
		
		return template;
	}
}
