package edu.ifes.ci.si.les.sgcgs.model;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

//By Gabriel

public class CompraTema implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Data da compra deve ser preenchida")
	@Column(length = 8)
    @Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
	private Date tempo;

    @NotNull(message = "O Usuario do Compra Tema deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "compraTema_id")
    private Usuario usuario;

    @NotNull(message = "O Tema do Compra Tema deve ser preenchido")
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

}