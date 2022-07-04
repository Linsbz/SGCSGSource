package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.RespostaCampo;

@Repository
public interface RespostaCampoRepository extends JpaRepository<RespostaCampo, Integer> {
}