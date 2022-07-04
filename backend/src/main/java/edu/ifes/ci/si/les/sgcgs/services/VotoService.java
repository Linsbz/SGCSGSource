<<<<<<< HEAD
package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Voto;
import edu.ifes.ci.si.les.sgcgs.repositories.VotoRepository;

import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import java.util.NoSuchElementException;

/** @author Hilda Biazatti */

@Service
public class VotoService {
    @Autowired
    private VotoRepository repository;

    public Voto findById(Integer id) {
        //return repository.findById(id).get();
        try{
            Voto obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Voto não cadastrado! ID: " + id + ", Tipo: " + Voto.class.getName());
        }
    }

    public List<Voto> findAll() {
        return repository.findAll();
    }

    public Voto insert(Voto obj) {
        //return repository.save(obj);
        obj.setId(null);
        try{
            if (verificarRegrasDeNegocio(obj)) {
                obj.setId(null);
                return repository.save(obj);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Escolha uma opção para efetivar o voto!");
        }
    }

    public Voto update(Voto obj) {
        findById(obj.getId());
        //return repository.save(obj);
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Escolha uma opção para efetivar o voto!");
        }
    }

    public void delete(Integer id) {
        // findById(id);
        // repository.deleteById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um voto!");
        }
    }

    public boolean verificarRegrasDeNegocio(Voto obj) {
        //RN 1: Usuário não pode votar em enquetes que já votou
        boolean R1 = false;
        Collection <Voto> Col = votoRepository.findByEnqueteId(obj.getEnquete().getId(), obj.getUsuario().getId());
        if (col.size > 0) {
            R1 = true;
        }
        if (R1) {
            throw new BusinessRuleException("Usuario ja votou nesta enquete!");
        }

        //RN 2: Usuário só pode votar em enquetes abertas
        Integer aux = 0;
        Collection <CompraTema> Col = compraTemaRepository.findByEnqueteAberta(obj.getEnquete().getId());
        if (col.size>0) {
            throw new BusinessRuleException("Não é possível votar pois essa enquete está fechada!");
        }
	}
}
=======
package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.Voto;
import edu.ifes.ci.si.les.sgcgs.repositories.VotoRepository;

@Service
public class VotoService {
    @Autowired
    private VotoRepository repository;

    public Voto findById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Voto> findAll() {
        return repository.findAll();
    }

    public Voto insert(Voto obj) {
        return repository.save(obj);
    }

    public Voto update(Voto obj) {
        findById(obj.getId());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
>>>>>>> refs/remotes/origin/main
