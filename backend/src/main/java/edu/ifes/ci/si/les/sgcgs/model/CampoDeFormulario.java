package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CampoDeFormulario {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String tipo;

	private String valores;

	private Boolean campoObrigatorio;

	@ManyToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;
}
