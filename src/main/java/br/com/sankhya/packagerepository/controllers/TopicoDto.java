package br.com.sankhya.packagerepository.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.sankhya.packagerepository.models.Topico;
import lombok.Getter;

@Getter
public class TopicoDto {

	private Long id;
	private String title;
	private String message;
	private LocalDateTime creationDate;

	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.title = topico.getTitulo();
		this.message = topico.getMensagem();
		this.creationDate = topico.getDataCriacao();
	}

	public static List<TopicoDto> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
	}

}
