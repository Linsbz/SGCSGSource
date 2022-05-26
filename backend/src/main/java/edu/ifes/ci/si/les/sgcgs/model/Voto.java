package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Voto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date data;

	@ManyToOne
	@JoinColumn(name = "opcaoVoto_id")
	private OpcaoVoto opcaoVoto;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
}
