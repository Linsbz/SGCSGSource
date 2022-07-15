package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.Formulario;
//import edu.ifes.ci.si.les.sgcgs.model.RespostaFormulario;

//import java.util.Collection;

//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Integer> {
    //@Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM resposta_formulario WHERE data_resposta BETWEEN ?2 AND ?3 AND id = ?1", nativeQuery = true)
    //public Collection<RespostaFormulario> findRespostas(Integer id, String data_fim, String data_inicio);
}