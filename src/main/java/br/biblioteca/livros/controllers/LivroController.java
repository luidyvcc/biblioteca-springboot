package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Livro;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	private String template;
	
	public LivroController() {
		this.template = "/livros";
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
	public ModelAndView storage(Livro livro) {
		System.out.println("A: "+livro.hashCode());
		System.out.println("Livro gravado: "+livro.getNome()+" qtde: "+livro.getQuantidadePaginas());
		return new ModelAndView("redirect:/"+this.template+"/list");
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {	
		System.out.println("Editar livro: "+id);
		return new ModelAndView(this.template+"/edit");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView destroy(@PathVariable("id") Long id) {
		System.out.println("Excluir livro: "+id);
		return new ModelAndView("redirect:/"+this.template+"/list");
	}
	
}
