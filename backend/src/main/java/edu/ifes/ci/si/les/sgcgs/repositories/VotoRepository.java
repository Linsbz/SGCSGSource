<<<<<<< HEAD
package edu.ifes.ci.si.les.sgcgs.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.Voto;


/** @author Hilda Biazatti */

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
    @Transactional(readOnly = true)
    public Collection<Voto> findByCliente(Usuario usuario);

    //RN 1: Usuário não pode votar em enquetes que já votou
    @Transactional(readOnly = true)
    // SELECT COUNT(*) < 1
    // FROM voto AS v INNER JOIN enquete AS e
    // WHERE v.enquete_id = e.id AND v.usuario_id = usuario
    // GROUP BY v.enquete_id
    @Query(value = "SELECT * FROM voto AS voto WHERE voto.enquete_id = ?1 AND voto.usuario_v = ?2", nativeQuery = true)
    public Collection<Voto> findByEnqueteId(Integer idEnquete, Integer idUsuario);

    //RN 2: Usuário só pode votar em enquetes abertas
    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM voto AS voto INNER JOIN enquete AS enquete WHERE voto.enquete_id = ?1 AND enquete.estado = FALSE", nativeQuery = true)
    public boolean findByEnqueteAberta(Integer idEnquete);
=======
package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Integer> {
>>>>>>> refs/remotes/origin/main
}