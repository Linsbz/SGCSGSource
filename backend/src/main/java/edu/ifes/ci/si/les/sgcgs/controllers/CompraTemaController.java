// package edu.ifes.ci.si.les.sgcgs.controllers;

// import java.util.Collection;
// import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.validation.BindingResult;

// import edu.ifes.ci.si.les.sgcgs.model.CompraTema;
// import edu.ifes.ci.si.les.sgcgs.services.CompraTemaService;
// import edu.ifes.ci.si.les.sgcgs.services.exceptions.ConstraintException;

// @RestController
// @RequestMapping(value = "/CompraTemas")
// public class CompraTemaController {
//     @Autowired
//     private CompraTemaService service;

//     @RequestMapping(method = RequestMethod.GET)
//     public ResponseEntity<Collection<CompraTema>> findAll() {
//         Collection<CompraTema> Collection = service.findAll();
//         return ResponseEntity.ok().body(Collection);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//     public ResponseEntity<CompraTema> find(@PathVariable Integer id) {
//         Tema obj = service.findById(id);
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
//     public ResponseEntity<CompraTema> update(@RequestBody Tema obj) {
//         obj = service.update(obj);
//         return ResponseEntity.ok().body(obj);
//     }

//     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//     public ResponseEntity<Void> delete(@PathVariable Integer id) {
//         service.delete(id);
//         return ResponseEntity.noContent().build();
//     }