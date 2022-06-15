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
public class CompraTema implements Serializable{

	private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private CompraTemaPK id = new CompraTemaPK();

    @NotNull(message = "Data da Compra do Tema deve ser preenchida")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @Builder
    public CompraTema(Tema tema, Usuario usuario, Date data) {
        this.id.setCompra(emprestimo);
        this.id.setTema(tema);
        this.valor.setTemaV(tema);
    }

    @JsonIgnore
    public Tema getTema() {
        return id.getTema();
    }

    public void setTema(Tema tema) {
        id.setTema(tema);
    }

    public Tema setTemaV(Tema tema) {
        valor.setTemaV(tema);
    }

    public Tema getTemaV() {
        return id.getTemaV();
    }

    public Usuario getUsuario() {
        return id.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        id.setUsuario(usuario);
    }

}
