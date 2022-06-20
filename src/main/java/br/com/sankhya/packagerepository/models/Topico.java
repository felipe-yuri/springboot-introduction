package br.com.sankhya.packagerepository.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Topico {

	
	private Long id;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;
	private Usuario autor;
	private List<Resposta> respostas = new ArrayList<>();
	
	@NonNull
	private String titulo;
	@NonNull
	private String mensagem;
	@NonNull
	private Curso curso;
	

}
