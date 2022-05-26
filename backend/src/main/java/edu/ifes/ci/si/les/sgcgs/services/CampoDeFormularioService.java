package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.CampoDeFormulario;
import edu.ifes.ci.si.les.sgcgs.repositories.CampoDeFormularioRepository;

@Service
public class CampoDeFormularioService {
    @Autowired
    private CampoDeFormularioRepository repository;

    public CampoDeFormulario findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<CampoDeFormulario> findAll() {
        return repository.findAll();
    }

    public CampoDeFormulario insert(CampoDeFormulario obj) {
        return repository.save(obj);
    }

    public CampoDeFormulario update(CampoDeFormulario obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
