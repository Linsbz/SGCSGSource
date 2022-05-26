package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Formulario;
import edu.ifes.ci.si.les.sgcgs.repositories.FormularioRepository;

@Service
public class FormularioService {
    @Autowired
    private FormularioRepository repository;

    public Formulario findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Formulario> findAll() {
        return repository.findAll();
    }

    public Formulario insert(Formulario obj) {
        return repository.save(obj);
    }

    public Formulario update(Formulario obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
