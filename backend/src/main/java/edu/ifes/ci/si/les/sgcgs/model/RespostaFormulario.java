package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;

/** @author Felipe Gaspar */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class RespostaFormulario implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Data da resposta deve ser preenchida")
	@Column(length = 8)
    @Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	private Date dataResposta;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;

	
	@NotNull(message = "A Resposta de Formulário deve possuir respostas em campos")
    @OneToMany(mappedBy = "respostaFormulario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<RespostaCampo> respostaCampos = new ArrayList<>();

    @Builder
    public RespostaFormulario(Integer id, Date data, Usuario usuario, Formulario formulario) {
        this.id = id;
        this.dataResposta = data;
		this.usuario = usuario;
		this.formulario = formulario;
    }

}
