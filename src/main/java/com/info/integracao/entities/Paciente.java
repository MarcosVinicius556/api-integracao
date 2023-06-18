package com.info.integracao.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "paciente",
		indexes = {
			@Index( name = "idx_paciente_pacnome", columnList = "pacnome" )
		}
		)
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@Column( name = "paccod", nullable = false )
	private int pacCod;

	@Getter
	@Setter
	@Column( name = "pacnome", length = 50 )
	private String pacNome;
	
	@Getter
	@Setter
	@Column( name = "endereco", length = 40 )
	private String endereco;

	@Getter
	@Setter
	@Column( name = "numero" )
	private int numero;

	@Getter
	@Setter
	@Column( name = "complemento", length = 14 )
	private String complemento;

	@Getter
	@Setter
	@Column( name = "bairro", length = 20 )
	private String bairro;

	@Getter
	@Setter
	@Column( name = "cep", length = 8 )
	private String cep;

	@Getter
	@Setter
	@Column( name = "muncod" )
	private int munCod;

	@Getter
	@Setter
	@Column( name = "proximidade", length = 30 )
	private String proximidades;

	@Getter
	@Setter
	@Column( name = "sexo" )
	private int sexo;

	@Getter
	@Setter
	@Column( name = "datanasc", columnDefinition = "DATE" )
	private GregorianCalendar dataNasc;
	
	@Getter
	@Setter
	@Column( name = "raca" )
	private int raca;
	
	@Getter
	@Setter
	@Column( name = "cpf", length = 11 )
	private String cpf;

	@Getter
	@Setter
	@Column( name = "cartidentidade", length = 15 )
	private String cartIdentidade;
	
	@Getter
	@Setter
	@Column( name = "nomemae", length = 40 )
	private String nomeMae;
	
	@Getter
	@Setter
	@Column( name = "nomepai", length = 40 )
	private String nomePai;
	
	@Getter
	@Setter
	@Column( name = "telefone", length = 14 )
	private String telefone;
	
	@Getter
	@Setter
	@Column( name = "telefonerecado", length = 14 )
	private String telefoneRecado;
	
	@Getter
	@Setter
	@Column( name = "celular", length = 14 )
	private String celular;
	
	@Getter
	@Setter
	@Column( name = "email", length = 55 )
	private String email;
	
	@Getter
	@Setter
	@Column( name = "cns", length = 20 )
	private String cns;
	
	@Getter
	@Setter
	@Column( name = "emailresult", length = 55 )
	private String emailResult;
	
	@Getter
	@Setter
	@Column( name = "datacadastro", columnDefinition = "DATE" )
	private GregorianCalendar dataCadastro;
	
	@Getter
	@Setter
	@Column( name = "situacao" )
	private int situacao;
	
	@Getter
	@Setter
	@Column( name = "senhaacessoresult", length = 15 )
	private String senhaAcessoResult;
	
	@Getter
	@Setter
	@Column( name = "obs", length = 350 )
	private String obs;
	
	@Getter
	@Setter
	@Column( name = "etnia" )
	private int etnia;

	@Getter
	@Setter
	@Column( name = "obsimportante" )
	private boolean obsImportante;
	
	
	@Getter
	@Setter
	@Column( name = "restricao", length = 100 )
	private String restricao;

	@Getter
	@Setter
	@Column( name = "enviasms" )
	private boolean enviaSms;

	@Getter
	@Setter
	@Column( name = "dataultimaalteracao", columnDefinition = "DATE" )
	private GregorianCalendar dataUltimaAlteracao;
	
	@Getter
	@Setter
	@Column( name = "nomeresponsavel", length = 50 )
	private String nomeResponsavel;

	@Getter
	@Setter
	@Column( name = "cpfresponsavel", length = 11 )
	private String cpfResponsavel;

	@Getter
	@Setter
	@Column( name = "telefoneresponsavel", length = 14 )
	private String telefoneResponsavel;
	
	@Getter
	@Setter
	@Column( name = "cnpj", length = 14 )
	private String cnpj;

	@Getter
	@Setter
	@Column( name = "nacionalidade" )
	private int nacionalidade;

	@Getter
	@Setter
	@Column( name = "naturalidade" )
	private int naturalidade;
	
	@Getter
	@Setter
	@Column( name = "mostraresultadoanterior" )
	private boolean mostraResultadoAnterior;
	
	@Getter
	@Setter
	@Column( name = "pacnomesocial", length = 50 )
	private String pacNomeSocial;
	
	@Getter
	@Setter
	@OneToMany( mappedBy = "paciente",  fetch = FetchType.EAGER )
	private List<PacienteAtend> pacienteAtend = new ArrayList<>();

	public Paciente() {
		pacCod = 0;
		pacNome = "";
		pacNomeSocial = "";
		endereco = "";
		numero = 0;
		complemento = "";
		bairro = "";
		cep = "";
		munCod = 0;
		proximidades = "";
		sexo = 0;
		dataNasc = null;
		raca = 0;
		etnia = 0;
		cpf = "";
		cartIdentidade = "";
		nomeMae = "";
		nomePai = "";
		telefone = "";
		telefoneRecado = "";
		celular = "";
		email = "";
		emailResult = "";
		cns = "";
		dataCadastro = null;
		situacao = 0;
		senhaAcessoResult = "";
		obs = "";
		obsImportante = false;
		restricao = "";
		enviaSms = true;
		dataUltimaAlteracao = null;
		nomeResponsavel = "";
		cpfResponsavel = "";
		telefoneResponsavel = "";
		cnpj = "";
		nacionalidade = 0;
		naturalidade = 0;
		mostraResultadoAnterior = true;
	}
}
