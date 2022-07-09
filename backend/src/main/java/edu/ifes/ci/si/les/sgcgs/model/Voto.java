package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

/** @author Hilda Biazatti */

@Entity
@Data
// @AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Voto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 8)
	@NotNull(message = "Data do voto deve ser preenchida!")
	@Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	private Date data;

	@ManyToOne
	@JoinColumn(name = "opcao_voto")
	private OpcaoVoto opcaoVoto;

	@ManyToOne
	@JoinColumn(name = "enquete_v")
	private Enquete enquete;

	@ManyToOne
	@JoinColumn(name = "usuario_v")
	private Usuario usuario;

	@Builder
    public Voto(Integer id, Date data, OpcaoVoto opcaoVoto, Enquete enquete, Usuario usuario) {
        this.id = id;
        this.data = data;
        this.opcaoVoto = opcaoVoto;
        this.enquete = enquete;
        this.usuario = usuario;
    }

}
