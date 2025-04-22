package com.ecommerce.ecommerce.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerce.ecommerce.users.Entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "my_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Orderproduct> orderProducts = new ArrayList<>();
    
    private Date orderdate;
    private Float finalprice;
    private boolean onlineDeliver;

    private String orderid;
    private String status="pending";

    public Order(OrderDto order) {
        this.id = order.getId();
        this.seller = new User(order.getBuyer());
        this.buyer = new User(order.getSeller());
        this.finalprice = order.getFinalprice();
        this.orderdate = order.getOrderdate();
        this.orderProducts = order.getOrderProducts();
        this.orderid = order.getOrderid();
        this.status = order.getStatus();
        this.onlineDeliver = order.isOnlineDeliver();
    }

    // public Order(Order order) {
    //     this.seller = order.getBuyer();
    //     this.buyer = order.getSeller();
    //     this.finalprice = order.getFinalprice();
    //     this.orderdate = new Date();
    //     this.orderProducts = order.getOrderProducts().stream().toList();
    // }
}
