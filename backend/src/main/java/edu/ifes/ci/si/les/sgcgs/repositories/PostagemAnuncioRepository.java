package edu.ifes.ci.si.les.sgcgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;

@Repository
public interface PostagemAnuncioRepository extends JpaRepository<PostagemAnuncio, Integer> {
}