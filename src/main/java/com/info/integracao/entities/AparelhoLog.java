package com.info.integracao.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "aparelholog" )
@EqualsAndHashCode
@ToString
public class AparelhoLog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Getter
    @Setter
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "aparelholog_id" )
	@SequenceGenerator( name = "aparelholog_id", sequenceName = "aparelholog_id", allocationSize = 1 )
	private int id;
	
    @Getter
    @Setter
	@OneToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "aparelhoid", nullable = false )
	@JsonIgnore
	private Aparelho aparelho;
	
    @Getter
    @Setter
	@Column( name = "datahora", nullable = false )
	@Temporal( TemporalType.TIMESTAMP )
	private GregorianCalendar dataHora;
	
    @Getter
    @Setter
	@Column( name = "usuid", nullable = false )
	private String usuId;
	
    @Getter
    @Setter
	@Column( name = "observacao", columnDefinition = "TEXT", nullable = false )
	private String observacao;
	
	public AparelhoLog() {
        this.aparelho = null;
		this.dataHora = null;
		this.usuId = null;
		this.observacao = null;
	}

	public AparelhoLog(Aparelho aparelho, GregorianCalendar dataHora, String usuId, String observacao) {
		this.aparelho = aparelho;
		this.dataHora = dataHora;
		this.usuId = usuId;
		this.observacao = observacao;
	}
}
