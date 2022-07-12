// package edu.ifes.ci.si.les.sgcgs.services;

// import java.util.List;
// import java.util.Collection;
// import java.util.NoSuchElementException;

// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Propagation;
// import org.springframework.transaction.annotation.Transactional;

// import edu.ifes.ci.si.les.sgcgs.model.Enquete;
// import edu.ifes.ci.si.les.sgcgs.model.Voto;
// import edu.ifes.ci.si.les.sgcgs.repositories.VotoRepository;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ObjectNotFoundException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.BusinessRuleException;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.DataIntegrityException;



// /** @author Hilda Biazatti */

// @Service
// public class VotoService {
//     @Autowired
//     private VotoRepository repository;

//     public Voto findById(Integer id) {
//         //return repository.findById(id).get();
//         try{
//             Voto obj = repository.findById(id).get();
//             return obj;
//         }catch (NoSuchElementException e) {
//             throw new ObjectNotFoundException("Voto não cadastrado! ID: " + id + ", Tipo: " + Voto.class.getName());
//         }
//     }

//     public List<Voto> findAll() {
//         return repository.findAll();
//     }


//     @Transactional(propagation = Propagation.REQUIRES_NEW)
//     public Voto insert(Voto obj) {
//         //return repository.save(obj);
//         obj.setId(null);
//         try{
//             if (verificarRegrasDeNegocio(obj)) {
//                 obj.setId(null);
//                 return repository.save(obj);
//             }
//         }catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Escolha uma opção para efetivar o voto!");
//         }
//     }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    // public Voto insert(Voto obj) {
    //     //return repository.save(obj);
    //     obj.setId(null);
    //     try{
    //         if (verificarRegrasDeNegocio(obj)) {
    //             obj.setId(null);
    //             return repository.save(obj);
    //         }
    //     }catch (DataIntegrityViolationException e) {
    //         throw new DataIntegrityException("Escolha uma opção para efetivar o voto!");
    //     }
    //     return null;
    // }
    

//     public Voto update(Voto obj) {
//         findById(obj.getId());
//         //return repository.save(obj);
//         try{
//             return repository.save(obj);
//         } catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Escolha uma opção para efetivar o voto!");
//         }
//     }

//     public void delete(Integer id) {
//         // findById(id);
//         // repository.deleteById(id);
//         try {
//             repository.deleteById(id);
//         } catch (DataIntegrityViolationException e) {
//             throw new DataIntegrityException("Não é possível excluir o voto!");
//         }
//     }

//     public boolean verificarRegrasDeNegocio(Voto obj) {
//         boolean real = true;
//         //RN 1: Usuário não pode votar em enquetes que já votou
//         boolean R1 = false;
//         Collection <Voto> Col = repository.findByEnqueteId(obj.getEnquete().getId(), obj.getUsuario().getId());
//         if (Col.size() > 0) {
//             R1 = true;

//             real = false;
//         }
//         if (R1) {
//             throw new BusinessRuleException("Usuario já votou nesta enquete!");
//         }

//         //RN 2: Usuário só pode votar em enquetes abertas
//         Enquete e = repository.findByEnqueteAberta(obj.getEnquete().getId());
//         if (e.getEstado() == false) {
//             real = false;
//             throw new BusinessRuleException("Não é possível votar pois essa enquete está fechada!");
//         }
//         return real;
// 	}
// }
