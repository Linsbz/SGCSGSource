package edu.ifes.ci.si.les.sgcgs.model;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class AreaAnuncio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome da área de anúncio deve ser preenchido")
	@Size(min = 3, max = 50, message = "Nome da área de anúncio deve ter entre 3 e 50 letras")
	private String nome;

}
