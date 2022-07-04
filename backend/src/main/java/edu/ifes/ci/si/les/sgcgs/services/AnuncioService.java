// package edu.ifes.ci.si.les.sgcgs.services;

// import java.util.List;
// import java.util.NoSuchElementException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import edu.ifes.ci.si.les.sgcgs.model.Anuncio;
// import edu.ifes.ci.si.les.sgcgs.repositories.AnuncioRepository;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

// import org.springframework.dao.DataIntegrityViolationException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;

// @Service
// public class AnuncioService {
//     @Autowired
//     private AnuncioRepository repository;

//     public Anuncio findById(Integer id) {
//         try{
//             Anuncio obj = repository.findById(id).get();
//             return obj;
//         }catch (NoSuchElementException e){
//             throw new ObjectNotFoundException("Anuncio não encontrado! ID: " + id + ", Tipo: " + Anuncio.class.getName());
//         }
//     }

//     public List<Anuncio> findAll() {
//         return repository.findAll();
//     }

//     public Anuncio insert(Anuncio obj) {
//         obj.setId(null);
//         try{
//             return repository.save(obj);
//         }catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
//         }
//     }

//     public Anuncio update(Anuncio obj) {
//         findById(obj.getId());
//         try{
//             return repository.save(obj);
//         } catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Campo obrigatorio não foi preenchido!");
//         }
//     }

//     public void delete(Integer id) {
//         findById(id);
//         try {
//             repository.deleteById(id);
//         } catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Não é possível excluir um Anuncio ativo!");
//         }
//     }
// }