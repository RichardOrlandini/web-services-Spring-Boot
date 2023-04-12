package com.richardorlandini.curse.resources;

import com.richardorlandini.curse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "joao", "joao@ddsd", "343434", "assas");
        return ResponseEntity.ok().body(u);
    }
}
