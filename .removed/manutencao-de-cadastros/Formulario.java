package edu.ifes.ci.si.les.sgcgs.model;

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
public class Formulario implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100)
	@NotBlank(message = "Nome do formulário deve ser preenchido")
	@Size(min = 10, max = 100, message = "Nome do formulário deve ter entre 10 e 100 letras")
	private String nome;

	@NotNull(message = "O atributo 'estado' do formulário deve ser preenchido")
	private Boolean estado;

	@NotNull(message = "O atributo 'resposta única' do formulário deve ser preenchido")
	private Boolean respostaUnica;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@NotNull(message = "O Formulário deve possuir pelo menos dois campos de formulário")
    //orphanRemoval = true: utilizado para remover filhos (itens) sem pai (empréstimo) em caso de atualizaçao do empréstimo (para um número de itens menor que o anterior)
    @OneToMany(mappedBy = "id.formulario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CampoDeFormulario> itens = new ArrayList<>();

    @Builder
    public Formulario(Integer id, String nome, Boolean estado, Boolean respostaUnica, Usuario usuario) {
        this.id = id;
        this.nome = nome;
		this.estado = estado;
		this.respostaUnica = respostaUnica;
		this.usuario = usuario;
    }
	
}
