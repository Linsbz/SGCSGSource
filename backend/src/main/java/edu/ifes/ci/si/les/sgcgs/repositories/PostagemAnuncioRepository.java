// package edu.ifes.ci.si.les.sgcgs.repositories;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;

// @Repository
// public interface PostagemAnuncioRepository extends JpaRepository<PostagemAnuncio, Integer> {
//     @Transactional(readOnly = true)
//     public Collection<PostagemAnuncio> findByCliente(Usuario usuario);

//     @Transactional(readOnly = true)
//     @Query(value = "select * from POSTAGEMANUNCIO where POSTAGEMANUNCIO.ESTADO = TRUE AND POSTAGEMANUNCIO.AREA = ?1", nativeQuery = true)
//     public Collection<PostagemAnuncio> findByAreaEstado(Integer idAnuncioA);

//     @Transactional(readOnly = true)
//     @Query(value = "select * from POSTAGEMANUNCIO where POSTAGEMANUNCIO.ANUNCIO = ?1", nativeQuery = true)
//     public Collection<PostagemAnuncio> findByAnuncio(Integer idAnuncioA);
// }