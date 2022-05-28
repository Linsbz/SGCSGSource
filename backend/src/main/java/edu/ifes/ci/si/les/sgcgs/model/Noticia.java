package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/** @author Júlia de Souza Borges */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Noticia implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50)
	@NotBlank(message = "Título da notíca deve ser preenchida")
	@Size(min = 2, max = 50, message = "Título da notíca deve ter entre 2 e 50 letras")
	private String titulo;

	@Column(length = 50)
	@NotBlank(message = "Subtítulo da notíca deve ser preenchida")
	@Size(min = 2, max = 50, message = "Subtítulo da notíca deve ter entre 2 e 50 letras")
	private String subTitulo;

	@Column(length = 400)
	@NotBlank(message = "Conteúdo da notíca deve ser preenchida")
	@Size(min = 2, max = 400, message = "Conteúdo da notíca deve ter entre 2 e 400 letras")
	private String conteudo;

	@Column(length = 50)
	@NotBlank(message = "Path da imagem da notíca deve ser preenchida")
	@Size(min = 2, max = 50, message = "Path da imagem da notíca deve ter entre 2 e 50 letras")
	private String imagem;

	@Column(length = 50)
	@NotBlank(message = "URL da notíca deve ser preenchida")
	@Size(min = 2, max = 50, message = "URL da notíca deve ter entre 2 e 50 letras")
	private String url;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

}
