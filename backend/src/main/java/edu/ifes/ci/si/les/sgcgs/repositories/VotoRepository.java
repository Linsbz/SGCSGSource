package edu.ifes.ci.si.les.sgcgs.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.Enquete;
// import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.Voto;


/** @author Hilda Biazatti */

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
    //RN 1: Usuário não pode votar em enquetes que já votou
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM voto WHERE enquete_v = ?1 AND usuario_v = ?2", nativeQuery = true)
    public Collection<Voto> findByEnqueteId(Integer idEnquete, Integer idUsuario);

    //RN 2: Usuário só pode votar em enquetes abertas
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM enquete WHERE id = ?1", nativeQuery = true)
    public Enquete findByEnqueteAberta(Integer idEnquete);
    
    //relatório: total de votos por enquete
    @Transactional(readOnly = true)
    @Query(value = "SELECT COUNT(*) FROM voto GROUP BY enquete_v", nativeQuery = true)
    public Integer[] findByVisual();
}