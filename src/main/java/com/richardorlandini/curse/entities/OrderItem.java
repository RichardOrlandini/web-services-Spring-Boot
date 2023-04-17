package com.richardorlandini.curse.entities;

import com.richardorlandini.curse.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrderItemPk id;

    private Integer quantity;

    private double price;

    public OrderItem() {
    }
    //instânciando o pedido passando o produto, quantidade e preço.
    public OrderItem(Order order, Product product,Integer quantity, double price) {
        super();
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
