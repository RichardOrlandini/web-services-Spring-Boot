package com.richardorlandini.curse.services;

import com.richardorlandini.curse.entities.Order;
import com.richardorlandini.curse.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired //spring vai instanciar automaticamene fazendo a injecão da dependencia
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
       Optional<Order> obj = repository.findById(id);
       return obj.get();//retornando um obj do tipo user
    }


}
