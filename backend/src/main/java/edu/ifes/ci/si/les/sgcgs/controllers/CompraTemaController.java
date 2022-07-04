// package edu.ifes.ci.si.les.scv.controllers;

// import java.util.Collection;

// import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import edu.ifes.ci.si.les.scv.model.Tema;
// import edu.ifes.ci.si.les.scv.model.Usuario;
// import edu.ifes.ci.si.les.scv.model.CompraTema;
// import edu.ifes.ci.si.les.scv.services.CompraTemaService;
// import edu.ifes.ci.si.les.scv.services.exceptions.ConstraintException;

// @RestController
// @RequestMapping(value = "/compratema")
// public class CompraTemaController {

//     @Autowired
//     private CompraTemaService service;

//     @RequestMapping(method = RequestMethod.GET)
//     public ResponseEntity<Collection<CompraTema>> findAll() {
//         Collection<CompraTema> collection = service.findAll();
//         return ResponseEntity.ok().body(collection);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//     public ResponseEntity<CompraTema> find(@PathVariable Integer id) {
//         CompraTema obj = service.findById(id);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(method = RequestMethod.POST)
//     public ResponseEntity<CompraTema> insert(@Valid @RequestBody CompraTema obj, BindingResult br) {
//         if (br.hasErrors())
//         	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
//         obj = service.insert(obj);
//         return ResponseEntity.ok().body(obj);
//     }
    
//     @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//     public ResponseEntity<CompraTema> update(@Valid @RequestBody CompraTema obj, BindingResult br) {
//         if (br.hasErrors())
//         	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
//     	obj = service.update(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//     public ResponseEntity<Void> delete(@PathVariable Integer id) {
//         service.delete(id);
//         return ResponseEntity.noContent().build();
<<<<<<< HEAD
//     }
=======
//     }


//     @RequestMapping(value = "/findByUsuario/{idUsuario}", method = RequestMethod.GET)
//     public ResponseEntity<Collection<Emprestimo>> findByUsuario(@PathVariable Integer idUsuario) {
//         Usuario usuario = new Usuario();
//         Usuario.setId(idUsuario);
//         Collection<Usuario> collection = service.findByUsuario(usuario);
//         return ResponseEntity.ok().body(collection);
//     }

// }

//     }

>>>>>>> 0b4bb853824feb2698ec9cd3945b021723c5718d
