package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemAnuncioRepository;

@Service
public class PostagemAnuncioService {
    @Autowired
    private PostagemAnuncioRepository repository;

    public PostagemAnuncio findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<PostagemAnuncio> findAll() {
        return repository.findAll();
    }

    public PostagemAnuncio insert(PostagemAnuncio obj) {
        return repository.save(obj);
    }

    public PostagemAnuncio update(PostagemAnuncio obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}