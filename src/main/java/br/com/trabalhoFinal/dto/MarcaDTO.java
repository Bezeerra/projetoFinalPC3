package br.com.trabalhoFinal.dto;

import br.com.trabalhoFinal.domain.*;


public class MarcaDTO {
	private Long id;
	private String sigla;
	private String descricao;

	
	public MarcaDTO(Marca marca) {
		this.id = marca.getId();
		this.sigla = marca.getSigla();
		this.descricao = marca.getDescricao();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
