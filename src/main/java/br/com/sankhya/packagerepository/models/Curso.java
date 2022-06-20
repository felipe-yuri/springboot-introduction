package br.com.sankhya.packagerepository.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Curso {

	private Long id;
	
	@NonNull
	private String nome;
	@NonNull
	private String categoria;

}
