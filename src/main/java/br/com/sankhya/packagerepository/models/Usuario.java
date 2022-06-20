package br.com.sankhya.packagerepository.models;

import lombok.Data;

@Data
public class Usuario {

	private Long id;
	private String nome;
	private String email;
	private String senha;

}
