package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;

/** @author Júlia de Souza Borges */

@Repository
public interface PostagemNoticiaRepository extends JpaRepository<PostagemNoticia, Integer> {
}