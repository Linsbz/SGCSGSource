package edu.ifes.ci.si.les.sgcgs.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
import edu.ifes.ci.si.les.sgcgs.model.Tema;


@Repository
public interface CompraTemaRepository extends JpaRepository<CompraTema, Integer> {

    @Transactional(readOnly = true)
    @Query(value = "select * from COMPRA_TEMA where TEMA_ID  = ?1", nativeQuery = true)
    public Collection<CompraTema> findBytemaID(Integer idTema);

    @Transactional(readOnly = true)
    @Query(value = "select * from COMPRA_TEMA where data_compra = ?1", nativeQuery = true)
    public Collection<CompraTema> findByData(Date data);


}