// package edu.ifes.ci.si.les.sgcgs.model;

// import java.util.Date;
// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.Collection;
// import javax.persistence.*;
// import javax.validation.constraints.*;
// import lombok.*;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @EqualsAndHashCode(of = {"id"})

// public class PostagemAnuncio {

// 	@Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Integer id;

// 	@NotNull(message = "Data do início do anúncio deve ser preenchida")
// 	@Column(length = 8)
//     @Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
// 	private Date dataInicio;

// 	@NotNull(message = "Data do fim do anúncio deve ser preenchida")
// 	@Column(length = 8)
//     @Size(min = 8, max = 8, message = "Data no formato dd/mm/aaaa")
// 	private Date dataFim;

// 	@NotNull(message = "O Anúncio deve ser preenchido")
//     @ManyToOne
// 	@JoinColumn(name = "anuncio_id")
// 	private Anuncio anuncio;

// 	@NotNull(message = "Área de anúncio deve ser preenchida")
//     @ManyToOne
//     @JoinColumn(name = "areaAnuncio_id")
// 	private AreaAnuncio areaAnuncio;

// //     @Builder
// //     public PostagemAnuncio(Integer id, Date dataI, Date dataF, Anuncio anuncio, AreaAnuncio areaAnuncio) {
// //         this.id = id;
// //         this.dataI = data;
// //         this.dataF = data;
// //         this.Anuncio = anuncio;
// //         this.AreaAnuncio = areaAnuncio;
// //     }

// }
