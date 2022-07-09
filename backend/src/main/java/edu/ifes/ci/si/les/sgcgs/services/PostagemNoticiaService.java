package edu.ifes.ci.si.les.sgcgs.services;

// import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ifes.ci.si.les.sgcgs.model.PostagemNoticia;
import edu.ifes.ci.si.les.sgcgs.model.Usuario;
import edu.ifes.ci.si.les.sgcgs.repositories.PostagemNoticiaRepository;


import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
import java.util.NoSuchElementException;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/** @author Júlia de Souza Borges */

@Service
public class PostagemNoticiaService {
    @Autowired
    private PostagemNoticiaRepository repository;

    public PostagemNoticia findById(Integer id) {
        // return repository.findById(id).get();
        try{
            PostagemNoticia obj = repository.findById(id).get();
            return obj;
        }catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Notícia não encontrada! ID: " + id + ", Tipo: " + PostagemNoticia.class.getName());
        }
    }

    public List<PostagemNoticia> findAll() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) 
    public PostagemNoticia insert(PostagemNoticia obj) {
        // return repository.save(obj);
        // obj.setId(null);
        try{
            if(NoticiaDestaque(obj) != true){
                obj.setId(null);
                // obj.setNoticia(obj.getNoticia());
                obj.setDestaque(false);
                repository.save(obj);
                throw new BusinessRuleException("Limite máximo de notícias em destaque atingido! Tente novamente");
            }
            return repository.save(obj);
        }catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        }
    }

    public PostagemNoticia update(PostagemNoticia obj) {
        findById(obj.getId());
        // return repository.save(obj);
        try{
            if(NoticiaDestaque(obj) != true){
                throw new BusinessRuleException("Não é possível atualizar. Limite máximo de notícias em destaque atingido!");
            }
                return repository.save(obj);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Campo obrigatório de notícia não foi preenchido!");
        } 
    }


    public void delete(Integer id) {
        PostagemNoticia obj = repository.findById(id).get();
        Integer idNoticia = obj.getNoticia().getId();
        //Usuario idAutor = obj.getNoticia().getUsuario();
        
        // System.out.println(idNoticia); //1
        // System.out.println(idAutor);   //Usuario(id=4, nome=Júlia, email=julia@sgcgs.com.br, senha=1234, tipo=REDATOR)
        // System.out.println(id);        // 3
        
        // findById(id);
        // repository.deleteById(id);
        try {
            if(verificaUsuario(id, idNoticia) == true){
                repository.deleteById(id);
            }else{
                throw new BusinessRuleException("Não é possível excluir! Usuário não possui permissão!");
            }
            // repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma notícia de um outro autor!");
        }
    }
    
    
    private boolean verificaUsuario(Integer id_usuario, Integer id_noticia) {
        //Regra 1:  só autor que criou a notícia podem postar ou excluir a postagem
        if(repository.findUsuario(id_usuario, id_noticia) != true){
            return false;
        }
        return true; 
    }

    public boolean NoticiaDestaque(PostagemNoticia obj) {
        // Regra 2: validar a quantidade máxima de 3 notícias destaque
        if(repository.findNoticiaDestaque() != true){
            //throw new BusinessRuleException("Limite máximo de notícias em destaque atingido!");
            return false;
        }else{
           return true;
        }
    }
}