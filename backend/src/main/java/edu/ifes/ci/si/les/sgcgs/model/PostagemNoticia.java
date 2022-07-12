package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/** @author Júlia de Souza Borges */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class PostagemNoticia implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 8)
	@NotBlank(message = "Data de início deve ser preenchida!")
	@Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	@JsonFormat(pattern = "yyyy-MM-dd")
	// private Date dataInicio;
	private String dataInicio;

	@Column(length = 8)
	@NotBlank(message = "Data de fim deve ser preenchida!")
	@Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	@JsonFormat(pattern = "yyyy-MM-dd")
	// private Date dataFim;
	private String dataFim;

	private Boolean destaque;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "noticia_id")
    public Noticia noticia;

}
