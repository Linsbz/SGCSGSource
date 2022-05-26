package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.AreaAnuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.AreaAnuncioRepository;

@Service
public class AreaAnuncioService {
    @Autowired
    private AreaAnuncioRepository repository;

    public AreaAnuncio findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<AreaAnuncio> findAll() {
        return repository.findAll();
    }

    public AreaAnuncio insert(AreaAnuncio obj) {
        return repository.save(obj);
    }

    public AreaAnuncio update(AreaAnuncio obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}