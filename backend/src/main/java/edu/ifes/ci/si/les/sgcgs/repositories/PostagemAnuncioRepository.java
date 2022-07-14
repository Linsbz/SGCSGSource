package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;
import edu.ifes.ci.si.les.sgcgs.model.Usuario;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostagemAnuncioRepository extends JpaRepository<PostagemAnuncio, Integer> {
    // @Transactional(readOnly = true)
    // public Collection<PostagemAnuncio> findByUsuario(Usuario usuario);

    @Transactional(readOnly = true)
    @Query(value = "select * from POSTAGEM_ANUNCIO where AREA_ANUNCIO_ID = ?1", nativeQuery = true)
    public Collection<PostagemAnuncio> findByAreaEstado(Integer idAnuncioA);

    @Transactional(readOnly = true)
    @Query(value = "select * from POSTAGEM_ANUNCIO where ANUNCIO_ID = ?1", nativeQuery = true)
    public Collection<PostagemAnuncio> findByAnuncio(Integer idAnuncioA);

    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) FROM postagem_anuncio GROUP BY AREA_ANUNCIO_ID", nativeQuery = true)
    public Integer[] findByVisual();
}