package com.richardorlandini.curse.services;

import com.richardorlandini.curse.entities.User;
import com.richardorlandini.curse.repositories.UserRepository;
import com.richardorlandini.curse.services.exceptions.DatabaseException;
import com.richardorlandini.curse.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired //spring vai instanciar automaticamene fazendo a injecão da dependencia
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
       Optional<User> obj = repository.findById(id);
       return obj.orElseThrow( () -> new ResourceNotFoundException(id)); //tentantiva de buscar o user.
        //retornando um obj do tipo user
    }

    public User insert(User obj){
       return repository.save(obj); // o salve por padrão retorna um obj salvo
    }
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);  // o getReferenceById serve instanciar um obj, para trabalharmos e depois efetuarmos uma operação no bd
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }

}
