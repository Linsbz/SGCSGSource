// package edu.ifes.ci.si.les.scv.repositories;

// import java.util.Collection;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

// import edu.ifes.ci.si.les.scv.model.Usuario;
// import edu.ifes.ci.si.les.scv.model.CompraTema;
// import edu.ifes.ci.si.les.scv.model.Tema;


// @Repository
// public interface CompraTemaRepository extends JpaRepository<CompraTema, Integer> {
	
//     @Transactional(readOnly = true)
//     public Collection<CompraTema> findByCliente(Usuario usuario);

//     @Transactional(readOnly = true)
//     @Query(value = "select * from COMPRATEMA where COMPRATEMA.TEMA_ID = ?1")
//     public Collection<CompraTema> findBytemaID(Integer idTema);

//     @Transactional(readOnly = true)
//     @Query(value = "select * from COMPRATEMA where Extract('Month' From data) = ?1")
//     public Collection<CompraTema> findByData(Date dataM);


// }
