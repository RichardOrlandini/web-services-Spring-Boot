package com.richardorlandini.curse.resources;

import com.richardorlandini.curse.entities.User;
import com.richardorlandini.curse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired // -> anotation
    private UserService service;
    //Gets: recuperar dados do bd
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Post: inserir dados no bd

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){ //definindo da onde o obj user vai vir.
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri(); // para codigos 201
        return ResponseEntity.created(uri).body(obj);
    }

    //End point para deletar:

    @DeleteMapping(value = "/{id}")
    // a resposta da requisição não vai devolver nada.
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    //No padrão rest para atualizar um recurso:

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj ){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}

