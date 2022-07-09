package edu.ifes.ci.si.les.sgcgs.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// import edu.ifes.ci.si.les.sgcgs.model.Noticia;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
// import edu.ifes.ci.si.les.sgcgs.model.Noticia;
  

/** @author Júlia de Souza Borges */
    
@Repository
public interface PostagemNoticiaRepository extends JpaRepository<PostagemNoticia, Integer> {
        // REGRA 1:
        // SELECT USUARIO_ID = 5 FROM NOTICIA WHERE ID = 2 LIMIT 1
        @Transactional(readOnly = true)
        @Query(value = "SELECT USUARIO_ID = ?1 FROM NOTICIA WHERE ID = ?2", nativeQuery = true)
        public boolean findUsuario(Integer usuarioTentandoAlterar, Integer noticiaID);

        // REGRA 2:
        // SELECT COUNT(*) < 3 AS VALIDADESTAQUE FROM POSTAGEM_NOTICIA  WHERE DESTAQUE = TRUE LIMIT 1
        @Transactional(readOnly = true)
        @Query(value = "SELECT COUNT(*) < 3 AS VALIDADESTAQUE FROM POSTAGEM_NOTICIA WHERE DESTAQUE = TRUE", nativeQuery = true)
        public boolean findNoticiaDestaque();

        //RELATÓRIO:
        //SELECT data_fim, data_inicio FROM POSTAGEM_NOTICIA 
        //Tempo em destaque
        @Transactional(readOnly = true)
        @Query(value = "SELECT ?1, ?2 FROM POSTAGEM_NOTICIA", nativeQuery = true)
        public Collection<?> findTempoDestaque(String data_fim, String data_inicio);
}