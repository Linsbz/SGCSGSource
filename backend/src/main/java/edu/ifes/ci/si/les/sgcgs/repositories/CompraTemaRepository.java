package edu.ifes.ci.si.les.sgcgs.repositories;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
import edu.ifes.ci.si.les.sgcgs.model.Tema;


@Repository
public interface CompraTemaRepository extends JpaRepository<CompraTema, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "select * from COMPRA_TEMA where TEMA_ID  = ?1", nativeQuery = true)
    public Collection<CompraTema> findBytemaID(Integer idTema);

    @Transactional(readOnly = true)
    @Query(value = "select * from COMPRA_TEMA where tempo = ?1", nativeQuery = true)
    public Collection<CompraTema> findByData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.util.@NotNull(message="Data da compra deve ser preenchida") Date date);

    @Transactional(readOnly = true)
    @Query(value = "SELECT SUM(T.valor) FROM COMPRA_TEMA CT INNER JOIN TEMA T WHERE CT.tempo >= ?1 AND CT.TEMA_ID=T.id", nativeQuery = true)
    public Float findTotal(String inicio);

}