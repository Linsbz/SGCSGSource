package edu.ifes.ci.si.les.scv.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

//Classe criada para representar a chave primária composta do objeto ItemDeEmprestimo
@Embeddable
@Data
@EqualsAndHashCode(of = {"tema", "usuario"})
public class ItemDeEmprestimoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    

}
