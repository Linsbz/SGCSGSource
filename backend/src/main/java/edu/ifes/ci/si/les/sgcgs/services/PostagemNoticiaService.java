package edu.ifes.ci.si.les.sgcgs.services;

// import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import edu.ifes.ci.si.les.sgcgs.model.Noticia;
// import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
// import edu.ifes.ci.si.les.sgcgs.repositories.NoticiaRepository;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemNoticiaRepository;
// import edu.ifes.ci.si.les.sgcgs.repositories.UsuarioRepository;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;

import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import java.util.NoSuchElementException;

/** @author Júlia de Souza Borges */

@Service
public class PostagemNoticiaService {
    @Autowired
    private PostagemNoticiaRepository repositoryPN;

    // @Autowired
    // private NoticiaRepository repositoryNot;

    // @Autowired
    // private UsuarioRepository repositoryUsr;

    public PostagemNoticia findById(Integer id) {
        // return repository.findById(id).get();
        try{
            PostagemNoticia obj = repositoryPN.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Notícia não encontrada! ID: " + id + ", Tipo: " + PostagemNoticia.class.getName());
        }
    }

    public List<PostagemNoticia> findAll() {
        return repositoryPN.findAll();
    }

    public PostagemNoticia insert(PostagemNoticia obj) {
        // return repository.save(obj);
        // obj.setId(null);
        try{
            if (verificaQuantidadeDestaque(obj)){
                return repositoryPN.save(obj);
                // obj.setId(null);
            }
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("222 Campo obrigatório de notícia não foi preenchido!");
        }
        return null;
        // return repository.save(obj);
    }

    public PostagemNoticia update(PostagemNoticia obj) {
        findById(obj.getId());
        // return repository.save(obj);
        try{
            return repositoryPN.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public void delete(Integer id) {
        // findById(id);
        // repository.deleteById(id);
        try {
            repositoryPN.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma notícia de um outro autor!");
        }
    }

    // Regras de Negócio referente ao processo de negócio Postagem de Notícias
    // Regra 1: só autor que criou a notícia ou administrador  podem postar ou excluir a postagem
    // Regra 2: validar a quantidade máxima de 3 notícias destaque

    
    public boolean verificaUsuarioNoticia(PostagemNoticia obj){
        // Regra 1: só autor que criou a notícia ou administrador  podem postar ou excluir a postagem
        if (!repositoryPN.findUsuario(obj.getUsuario().getId(), obj.getNoticia().getId())){
            throw new BusinessRuleException("Não é possível excluir uma notícia de um outro autor!");
        }
        return true;
    }

    public boolean verificaQuantidadeDestaque(PostagemNoticia obj){
        // Regra 2: validar a quantidade máxima de 3 notícias destaque
        if (!repositoryPN.findNoticiaDestaque()){
            throw new BusinessRuleException("Não é possível adicionar mais notícias em destaque. Limite atingido!");
        }
        return true;
    }
}
