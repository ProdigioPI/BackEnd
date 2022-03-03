package com.generation.prodigio.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nomeMateria;
	
	@NotBlank
	@Size(max=255)
	private String descricao;
	
	@NotBlank
	private String agenda;// 03/03 ate 09/03 ->> Anexar(Vincular) o Link da agenda do GOOGLE no FRONTEND
	
	@NotNull
	@Positive(message="O valor tem que ser maior que R$ 00.00")
	private BigDecimal valor;

	@ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;
    
    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Usuario usuario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

		
	public String getNomeMateria() {
		return nomeMateria;
	}

	public void setNomeMateria(String nomeMateria) {
		this.nomeMateria = nomeMateria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
