package com.info.integracao.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "aparelho" )
@ToString
public class Aparelho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Getter
	@Column( name = "id", nullable = false )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "aparelho_id" )
	@SequenceGenerator( name = "aparelho_id", sequenceName = "aparelho_id", allocationSize = 1 )
	private int id;
	
    @Setter
    @Getter
	@Column( name = "nomeaparelho", length = 50, nullable = false )
	private String nomeAparelho;
	
    @Getter
    @Setter
	@Column( name = "modelo", length = 80, nullable = false )
	private String modelo;
	
    @Getter
    @Setter
	@Column( name = "fabricante", length = 80, nullable = false )
	private String fabricante;
	
    @Getter
    @Setter
	@Column( name = "protocolo", nullable = false )
	private int protocolo;
	
    @Getter
    @Setter
	@Column( name = "comunicacao", nullable = false )
	private int comunicacao;
	
    @Getter
    @Setter
	@Column( name = "iplis", length = 50 )
	private String ipLis;
	
    @Getter
    @Setter
	@Column( name = "portalis" )
	private int portaLis;
	
    @Getter
    @Setter
	@Column( name = "ipaparelho", length = 50 )
	private String ipAparelho;
	
    @Getter
    @Setter
	@Column( name = "portaaparelho" )
	private int portaAparelho;
	
    @Getter
    @Setter
	@Column( name = "portaserial", length = 20 )
	private String portaSerial;
	
    @Getter
    @Setter
	@Column( name = "taxatransmissao" )
	private int taxaTransmissao;
	
    @Getter
    @Setter
	@Column( name = "bitsdados" )
	private int bitsDados;
	
    @Getter
    @Setter
	@Column( name = "bitsparada" )
	private int bitsParada;
	
    @Getter
    @Setter
	@Column( name = "paridade" )
	private int paridade;
	
    @Getter
    @Setter
	@Column( name = "localarquivoimport", length = 100 )
	private String localArquivoImport;
	
    @Getter
    @Setter
	@Column( name = "localarquivoexport", length = 100 )
	private String localArquivoExport;
	
    @Getter
    @Setter
	@Column( name = "codigobarras", nullable = false )
	private int codigoBarras;
	
    @Getter
    @Setter
	@Column( name = "listadeamostras", nullable = false )
	private int listaDeAmostras;
	
    @Getter
    @Setter
	@Column( name = "tipointerface", nullable = false )
	private int tipoInterface;
	
    @Getter
    @Setter
	@Column( name = "status", nullable = false )
	private int status;
	
    @Getter
    @Setter
	@OneToMany( mappedBy = "aparelho", fetch = FetchType.EAGER )
	private Set<AparelhoExame> exames = new HashSet<>();
	
    @Getter
    @Setter
	@OneToOne( mappedBy = "aparelho", fetch = FetchType.EAGER )
	private AparelhoLog aparelhoLog;
	
	public Aparelho() {
		this.nomeAparelho = null;
		this.modelo = null;
		this.fabricante = null;
		this.protocolo = 0;
		this.comunicacao = 0;
		this.ipLis = null;
		this.portaLis = 0;
		this.ipAparelho = null;
		this.portaAparelho = 0;
		this.portaSerial = null;
		this.taxaTransmissao = 0;
		this.bitsDados = 0;
		this.bitsParada = 0;
		this.paridade = 0;
		this.localArquivoImport = null;
		this.localArquivoExport = null;
		this.codigoBarras = 0;
		this.listaDeAmostras = 0;
		this.tipoInterface = 0;
		this.status = 0;
	}

	public Aparelho(String nomeAparelho, String modelo, String fabricante, int protocolo, int comunicacao,
			String ipLis, int portaLis, String ipAparelho, int portaAparelho, String portaSerial, int taxaTransmissao,
			int bitsDados, int bitsParada, int paridade, String localArquivoImport, String localArquivoExport,
			int codigoBarras, int listaDeAmostrar, int tipoInterface, int status) {
		this.nomeAparelho = nomeAparelho;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.protocolo = protocolo;
		this.comunicacao = comunicacao;
		this.ipLis = ipLis;
		this.portaLis = portaLis;
		this.ipAparelho = ipAparelho;
		this.portaAparelho = portaAparelho;
		this.portaSerial = portaSerial;
		this.taxaTransmissao = taxaTransmissao;
		this.bitsDados = bitsDados;
		this.bitsParada = bitsParada;
		this.paridade = paridade;
		this.localArquivoImport = localArquivoImport;
		this.localArquivoExport = localArquivoExport;
		this.codigoBarras = codigoBarras;
		this.listaDeAmostras = listaDeAmostrar;
		this.tipoInterface = tipoInterface;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aparelho other = (Aparelho) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}
