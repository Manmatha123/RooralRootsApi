package com.ecommerce.ecommerce.customizeOrder.model;


import java.util.Date;
import com.ecommerce.ecommerce.users.Entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomizeOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private Integer qty;
    private Date orderdate;
    private Float totalprice;
    private String orderid;
    private String description;
    private String status="PENDING";

    public CustomizeOrder(CustomizeOrderDTO order) {
        this.id = order.getId();
        this.seller = new User(order.getBuyer());
        this.buyer = new User(order.getSeller());
        this.totalprice = order.getTotalprice();
        this.orderdate = order.getOrderdate();
        this.orderid = order.getOrderid();
        this.status = order.getStatus();
        this.image=order.getImage();
        this.qty=order.getQty();
        this.description=order.getDescription();
    }

}
