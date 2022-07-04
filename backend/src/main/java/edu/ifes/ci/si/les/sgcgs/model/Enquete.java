package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
// import javax.validation.Valid;
// import org.springframework.validation.BindingResult;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

// Hilda
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

	@Column(length = 30)
	@NotBlank(message = "Nome da enquete deve ser preenchido")
	private String nome;

	@NotBlank(message = "Estado da enquete deve ser preenchido")
	private Boolean estado;

	@NotBlank(message = "Resposta única deve ser preenchido")
	private Boolean respostaUnica;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
