package com.richardorlandini.curse.repositories;

import com.richardorlandini.curse.entities.OrderItem;
import com.richardorlandini.curse.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
