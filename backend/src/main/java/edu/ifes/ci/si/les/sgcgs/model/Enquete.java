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
public class Enquete implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private Boolean estado;

	private Boolean respostaUnica;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
