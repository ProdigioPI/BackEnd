package com.generation.prodigio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_categoria")
public class Categoria {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotBlank(message="Este campo é obrigatório.")
	@Size(min=5, max=255, message="Este campo deverá ter o máximo de 20 caracteres.")
	private String materia; /*Puxa o assunto que quer estudar.*/
	
	@NotBlank(message="Este campo é obrigatório.")
	@Size(min=5, max=255, message="Este campo deverá ter o máximo de 20 caracteres.")
	private String areaDeEstudo; /*Puxa o conteudo a ser estudado*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getAreaDeEstudo() {
		return areaDeEstudo;
	}

	public void setAreaDeEstudo(String areaDeEstudo) {
		this.areaDeEstudo = areaDeEstudo;
	}
}