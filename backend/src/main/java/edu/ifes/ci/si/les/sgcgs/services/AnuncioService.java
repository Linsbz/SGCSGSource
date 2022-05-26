package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Anuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.AnuncioRepository;

@Service
public class AnuncioService {
    @Autowired
    private AnuncioRepository repository;

    public Anuncio findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Anuncio> findAll() {
        return repository.findAll();
    }

    public Anuncio insert(Anuncio obj) {
        return repository.save(obj);
    }

    public Anuncio update(Anuncio obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}