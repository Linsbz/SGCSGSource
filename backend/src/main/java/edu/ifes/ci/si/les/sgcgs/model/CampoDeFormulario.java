package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** @author Felipe Gaspar */

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

	@Column(length = 100)
	@NotBlank(message = "Nome do campo formulário deve ser preenchido")
	@Size(min = 2, max = 100, message = "Nome do campo de formulário deve ter entre 2 e 100 letras")
	private String nome;

	@Column(length = 10)
	@NotBlank(message = "Nome do campo formulário deve ser preenchido")
	@Size(min = 2, max = 10, message = "Tipo do campo de formulário deve ter entre 2 e 10 letras")
	private String tipo;
	
	@Column(length = 100)
	@NotBlank(message = "Valores do campo formulário devem ser preenchidos")
	@Size(min = 2, max = 100, message = "Valores do campo de formulário devem ter entre 2 e 100 letras")
	private String valores;

	@NotNull(message = "O atributo 'campo obrigatório' do campo de formulário deve ser preenchido")	
	private Boolean campoObrigatorio;

	@ManyToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;

    @JsonIgnore
    public Formulario getFormulario() {
        return this.formulario;
    }
}