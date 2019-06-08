package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;

@Controller
@RequestMapping("/autores")
public class AutorController {

private String template;
	
	public AutorController() {
		this.template = "/autores";
	}
	
	@GetMapping("/list")
	public ModelAndView index() {
		return new ModelAndView(this.template+"/index");
	}
	
	@GetMapping("/novo")
	public ModelAndView create() {
		return new ModelAndView(this.template+"/create");
	}
	
	@PostMapping("/gravar")
	public ModelAndView storage(Autor autor) {
		System.out.println("Autor gravado: "+autor.getNome());
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {	
		System.out.println("Editar autor: "+id);
		return new ModelAndView(this.template+"/edit");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView destroy(@PathVariable("id") Long id) {
		System.out.println("Excluir autor: "+id);
		return new ModelAndView("redirect:/autores/list");
	}
	
}
