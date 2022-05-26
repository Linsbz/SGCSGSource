package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class Anuncio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Nome do anúncio deve ser preenchido")
	@Size(min = 3, max = 50, message = "Nome do anúncio deve ter entre 3 e 50 letras")
	private String titulo;
	
	private String link;

	private String imagemQuadrada;

	private String imagemHorizontal;

	private String imagemVertical;

	@NotNull(message = "O Usuario deve ser preenchido")
    @ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
