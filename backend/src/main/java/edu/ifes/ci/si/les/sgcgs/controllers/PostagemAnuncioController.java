// package edu.ifes.ci.si.les.sgcgs.controllers;

// import java.util.Collection;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import edu.ifes.ci.si.les.sgcgs.model.PostagemAnuncio;
// import edu.ifes.ci.si.les.sgcgs.services.PostagemAnuncioService;

<<<<<<< HEAD
// @RestController
// @RequestMapping(value = "/postagem-anuncios")
=======
<<<<<<< HEAD
// @RestController
// @RequestMapping(value = "/postagem-anuncios")
=======
// /** @author Lincoln Silva Bazoni */

// @RestController
// @RequestMapping(value = "/postagem-anuncio")
>>>>>>> 79434596674b0fe6c609495fb58b3e15a983acd3
>>>>>>> 0b4bb853824feb2698ec9cd3945b021723c5718d
// public class PostagemAnuncioController {
//     @Autowired
//     private PostagemAnuncioService service;

//     @RequestMapping(method = RequestMethod.GET)
//     public ResponseEntity<Collection<PostagemAnuncio>> findAll() {
//         Collection<PostagemAnuncio> Collection = service.findAll();
//         return ResponseEntity.ok().body(Collection);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//     public ResponseEntity<PostagemAnuncio> find(@PathVariable Integer id) {
//         PostagemAnuncio obj = service.findById(id);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(method = RequestMethod.POST)
//     public ResponseEntity<PostagemAnuncio> insert(@RequestBody PostagemAnuncio obj) {
//         obj = service.insert(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//     public ResponseEntity<PostagemAnuncio> update(@RequestBody PostagemAnuncio obj) {
//         obj = service.update(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//     public ResponseEntity<Void> delete(@PathVariable Integer id) {
//         service.delete(id);
//         return ResponseEntity.noContent().build();
//     }
// }
