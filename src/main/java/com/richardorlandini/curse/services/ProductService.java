package com.richardorlandini.curse.services;

import com.richardorlandini.curse.entities.Product;
import com.richardorlandini.curse.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //spring vai instanciar automaticamene fazendo a injecão da dependencia
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
       Optional<Product> obj = repository.findById(id);
       return obj.get();//retornando um obj do tipo Product
    }


}
