package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.RespostaFormulario;
//import edu.ifes.ci.si.les.sgcgs.model.RespostaCampo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RespostaFormularioRepository extends JpaRepository<RespostaFormulario, Integer> {
    // REGRA 1:
    //Resposta única por usuário em formulários que aceitem somente uma resposta
    // SELECT ESTADO AND( RESPOSTA_UNICA = FALSE OR (SELECT COUNT(*) > 0 AS RESPONDEU FROM RESPOSTA_FORMULARIO WHERE USUARIO_ID = 2 AND FORMULARIO_ID = 2) = FALSE ) AS PODE_RESPONDER FROM FORMULARIO WHERE ID = 2
    @Transactional(readOnly = true)
    @Query(value = "SELECT ESTADO AND( RESPOSTA_UNICA = FALSE OR (SELECT COUNT(*) > 0 AS RESPONDEU FROM RESPOSTA_FORMULARIO WHERE USUARIO_ID = ?1 AND FORMULARIO_ID = ?2) = FALSE ) AS PODE_RESPONDER FROM FORMULARIO WHERE ID = ?2;", nativeQuery = true)
    public boolean usuarioPodeResponder(Integer usuarioId, Integer formularioId);

    // REGRA 2:
    //Resposta apenas para formulários abertos
    // SELECT ESTADO FROM FORMULARIO WHERE ID = 1 LIMIT 1;
    @Transactional(readOnly = true)
    @Query(value = "SELECT ESTADO FROM FORMULARIO WHERE ID = ?1 LIMIT 1;", nativeQuery = true)
    public boolean formularioEstaAberto(Integer formularioId);

    //@Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM resposta_campo WHERE respostaformulario_id = ?1", nativeQuery = true)
    //public Collection<RespostaCampo> findRespostas(Integer id);
}