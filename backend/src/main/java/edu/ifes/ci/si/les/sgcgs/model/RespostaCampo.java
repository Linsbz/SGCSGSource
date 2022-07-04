package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
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
public class RespostaCampo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String valor;

	@ManyToOne
	@JoinColumn(name = "respostaformulario_id")
	private RespostaFormulario respostaFormulario;
	
	@JsonIgnore
    public RespostaFormulario getRespostaFormulario() {
        return this.respostaFormulario;
    }

	@ManyToOne
	@JoinColumn(name = "campodeformulario_id")
	private CampoDeFormulario campoDeFormulario;

}