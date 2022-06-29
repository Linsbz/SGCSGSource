package edu.ifes.ci.si.les.sgcgs.repositories;

// import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
 

/** @author Júlia de Souza Borges */

@Repository
public interface PostagemNoticiaRepository extends JpaRepository<PostagemNoticia, Integer> {
    // REGRA 1:
        // SELECT USUARIO_ID = 5 FROM NOTICIA WHERE ID = 2 
        @Transactional(readOnly = true)
        @Query(value = "SELECT USUARIO_ID = ?1 FROM NOTICIA WHERE ID = ?2 LIMIT 1")
        public boolean findUsuario(Integer usuarioTentandoAlterar, Integer noticiaID);

        // REGRA 2:
        // SELECT COUNT(*) < 3 AS VALIDADESTAQUE
        // FROM POSTAGEM_NOTICIA
        // WHERE DESTAQUE = TRUE 
        @Transactional(readOnly = true)
        @Query(value = "SELECT COUNT(*) < 3 AS VALIDADESTAQUE FROM POSTAGEM_NOTICIA WHERE DESTAQUE = TRUE LIMIT 1")
        public boolean findNoticiaDestaque();
}