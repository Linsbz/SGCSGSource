package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemNoticiaRepository;

@Service
public class PostagemNoticiaService {
    @Autowired
    private PostagemNoticiaRepository repository;

    public PostagemNoticia findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<PostagemNoticia> findAll() {
        return repository.findAll();
    }

    public PostagemNoticia insert(PostagemNoticia obj) {
        return repository.save(obj);
    }

    public PostagemNoticia update(PostagemNoticia obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
