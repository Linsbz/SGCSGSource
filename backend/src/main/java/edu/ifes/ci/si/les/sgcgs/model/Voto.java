package edu.ifes.ci.si.les.sgcgs.model;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

//By Hilda

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Voto{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Data do voto eve ser preenchida")
	@Column(length = 8)
    @Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	private Date data;

	@NotNull(message = "A opção de voto deve ser preenchida")
    @ManyToOne
    @JoinColumn(name = "opcaovoto_id")
	private OpcaoVoto opcaoVoto;

	@NotNull(message = "A enquete deve ser preenchida")
    @ManyToOne
	@JoinColumn(name = "enquete_v")
	private Enquete enquete;

	@NotNull(message = "Usuario deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "usuario_v")
	private Usuario usuario;

	// @Builder
    // public Voto(Integer id, Date data, OpcaoVoto opcaoVoto, Enquete enquete, Usuario usuario) {
    //     this.id = id;
    //     this.data = data;
    //     this.opcaoVoto = opcaoVoto;
    //     this.enquete = enquete;
    //     this.usuario = usuario;
    // }

}
