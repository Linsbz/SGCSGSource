package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.OpcaoVoto;

@Repository
public interface OpcaoVotoRepository extends JpaRepository<OpcaoVoto, Integer> {
}