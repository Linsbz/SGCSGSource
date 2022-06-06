package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Tema implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Nome do tema deve ser preenchidp")
	private String nome;

	@Digits(integer=2, fraction=2, message = "Valor do Tema deve ser preenchido com um valor decimal")
	private Integer valor;

	private Boolean estado;

	private String imagem;

}
