package edu.ifes.ci.si.les.sgcgs.model;

// import java.util.Date;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class OpcaoVoto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 30)
	@NotBlank(message = "Valor do campo (OpcaoVoto) deve ser preenchido")
	private String valor;

	// implementar fks

	@ManyToOne
	@JoinColumn(name = "enquete_id")
	private Enquete enquete;
}