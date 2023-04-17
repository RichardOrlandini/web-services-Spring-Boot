package com.richardorlandini.curse.repositories;

import com.richardorlandini.curse.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
