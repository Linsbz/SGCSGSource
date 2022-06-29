package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class CompraTema implements Serializable{

	private static final long serialVersionUID = 1L;

    @NotNull(message = "Data da Compra do Tema deve ser preenchida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Builder
    public CompraTema(Tema tema, Usuario usuario, Date data) {
        this.id.setCompra(emprestimo);
        this.id.setTema(tema);
        this.valor.setTemaV(tema);
    }

    @NotNull(message = "O Usuario do Compra Tema deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "compraTema_id")
    private Usuario usuario;

    @NotNull(message = "O Tema do Compra Tema deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

}