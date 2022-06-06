package edu.ifes.ci.si.les.sgcgs.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemAnuncioRepository;

import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

@Service
public class PostagemAnuncioService {
    @Autowired
    private PostagemAnuncioRepository repository;

    public PostagemAnuncio findById(Integer id) {
        try{
            PostagemAnuncio obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e){
            throw new ObjectNotFoundException("Postagem de Anuncio não encontrada! ID: " + id + ", Tipo: " + PostagemAnuncio.class.getName());
        }
    }

    public List<PostagemAnuncio> findAll() {
        return repository.findAll();
    }

    public PostagemAnuncio insert(PostagemAnuncio obj) {
        obj.setId(null);
        try{
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public PostagemAnuncio update(PostagemAnuncio obj) {
        findById(obj.getId());
        try{
            return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma postagem ativo!");
        }
    }
}