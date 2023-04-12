package com.richardorlandini.curse.repositoryes;

import com.richardorlandini.curse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
