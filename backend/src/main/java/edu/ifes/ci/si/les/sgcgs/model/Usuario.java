package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import edu.ifes.ci.si.les.sgcgs.model.enums.TipoUsuario;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 255)
	@NotBlank(message = "Campo nome deve ser preenchido")
	@Size(min = 3, max = 255, message = "Campo nome deve ser maior que três caracteres")
	private String nome;
	
	@Column(length = 255)
	@NotBlank(message = "Campo email deve ser preenchido")
	@Size(min = 3, max = 255, message = "Campo email deve ser maior que três caracteres")
	private String email;

	@Column(length = 255)
	@NotBlank(message = "Campo senha deve ser preenchido")
	@Size(min = 3, max = 255, message = "Campo senha deve ser maior que três caracteres")
	private String senha;

	@Digits(integer=1, fraction=0, message = "Número do tipo de usuário deve ser preenchido com um valor inteiro")
	private Integer tipo;

	@Builder
    public Usuario(Integer id, String nome, String email, String senha, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
		this.tipo = (tipo==null) ? null : tipo.getCod();
    }
    
    public TipoUsuario getTipo() {
		return TipoUsuario.toEnum(tipo);
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo.getCod();
	}
}
