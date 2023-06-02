package com.info.integracao.dto;

import com.info.integracao.entities.Aparelho;

public class AparelhoMinDTO {

	private int id;
	private String nomeAparelho;
	private String modelo;
	private String fabricante;
	private int protocolo;
	private int comunicacao;
	
	
	public AparelhoMinDTO(Aparelho aparelho) {
		this.id = aparelho.getId();
		this.nomeAparelho = aparelho.getNomeAparelho();
		this.modelo = aparelho.getModelo();
		this.fabricante = aparelho.getFabricante();
		this.protocolo = aparelho.getProtocolo();
		this.comunicacao = aparelho.getComunicacao();
	}

	public int getId() {
		return id;
	}

	public String getNomeAparelho() {
		return nomeAparelho;
	}

	public String getModelo() {
		return modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public int getComunicacao() {
		return comunicacao;
	}
	
}
