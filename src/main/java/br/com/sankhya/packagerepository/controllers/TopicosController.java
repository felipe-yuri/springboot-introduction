package br.com.sankhya.packagerepository.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sankhya.packagerepository.models.Curso;
import br.com.sankhya.packagerepository.models.Topico;

@Controller
public class TopicosController {

	@RequestMapping("/topics")
	@ResponseBody
	public List<Topico> list() {
		Topico topico = new Topico("Duvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		return Arrays.asList(topico, topico, topico);
	}
}
