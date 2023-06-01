package com.info.integracao.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "aparelhocampos", 
		uniqueConstraints = { 
				@UniqueConstraint( columnNames = {"aparelhoexameid", "codigoexameaparelho", "numerocoleta"} ), 
				@UniqueConstraint( columnNames = {"aparelhoexameid", "ordem"} ) 
		})
@EqualsAndHashCode
@ToString
public class AparelhoCampos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @Getter
    @Setter
	@Column( name = "id", nullable = false )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aparelhocampos_id")
    @SequenceGenerator(name = "aparelhocampos_id", sequenceName = "aparelhocampos_id", allocationSize = 1)
	private int id;
	
    @Getter
    @Setter
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "aparelhoexameid", nullable = false )
	@JsonIgnore
	private AparelhoExame aparelhoExame;
	
    @Getter
    @Setter
	@Column( name = "ordem", nullable = false )
	private int ordem;
	
    @Getter
    @Setter
	@Column( name = "codigoexameaparelho", length = 30, nullable = false )
	private String codigoExameAparelho;
	
    @Getter
    @Setter
	@Column( name = "numerocoleta", nullable = false )
	private int numeroColeta;
	
    @Getter
    @Setter
	@Column( name = "campodeflaudo", length = 30, nullable = false )
	private String campoDefLaudo;

	public AparelhoCampos() {
		this.aparelhoExame = null;
		this.ordem = 0;
		this.codigoExameAparelho = null;
		this.numeroColeta = 0;
		this.campoDefLaudo = null;
	}

	public AparelhoCampos(AparelhoExame aparelhoExame, int ordem, String codigoExameAparelho, int numeroColeta,
			String compoDefLaudo) {
		this.aparelhoExame = aparelhoExame;
		this.ordem = ordem;
		this.codigoExameAparelho = codigoExameAparelho;
		this.numeroColeta = numeroColeta;
		this.campoDefLaudo = compoDefLaudo;
	}
	
}
