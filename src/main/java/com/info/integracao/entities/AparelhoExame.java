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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name = "aparelhoexame", uniqueConstraints = @UniqueConstraint(columnNames = {"aparelhoid", "examecod"}) )
@EqualsAndHashCode
@ToString
public class AparelhoExame implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Getter
    @Setter
	@Column( name = "id", nullable = false )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "aparelhoexame_id" )
	@SequenceGenerator( name = "aparelhoexame_id", sequenceName = "aparelhoexame_id", allocationSize = 1 )
	private int id;
	
    @Getter
    @Setter
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "aparelhoid", nullable = false )
	private Aparelho aparelho;
	
    @Getter
    @Setter
	@OneToMany( mappedBy = "aparelhoExame", fetch = FetchType.EAGER )
	private Set<AparelhoCampos> aparelhoCampos = new HashSet<>();
	
    @Getter
    @Setter
	@Column( name = "examecod", length = 10, nullable = false ) //Não da para fazer ORM aqui pois o exame não é annotation
	private String exameCod;
	
    @Getter
    @Setter
	@Column( name = "macros", columnDefinition = "TEXT", nullable = false)
	private String macros;
	
	public AparelhoExame() {
		this.aparelho = null;
		this.exameCod = null;
		this.macros = null;
	}

	public AparelhoExame(Aparelho aparelho, String exameCod, String macros) {
		this.aparelho = aparelho;
		this.exameCod = exameCod;
		this.macros = macros;
	}
}