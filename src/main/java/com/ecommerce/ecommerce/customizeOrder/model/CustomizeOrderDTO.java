package com.ecommerce.ecommerce.customizeOrder.model;

import java.util.Date;
import com.ecommerce.ecommerce.users.Entity.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomizeOrderDTO {
    
       private Long id;
    private UserDTO buyer;
    private UserDTO seller;
    private String image;
    private Integer qty;
    private Date orderdate;
    private Float totalprice;
    private String orderid;
    private String description;
    private String status="PENDING";

        public CustomizeOrderDTO(CustomizeOrder order) {
        this.id = order.getId();
        this.seller = new UserDTO(order.getBuyer());
        this.buyer = new UserDTO(order.getSeller());
        this.totalprice = order.getTotalprice();
        this.orderdate = order.getOrderdate();
        this.orderid = order.getOrderid();
        this.status = order.getStatus();
        this.image=order.getImage();
        this.qty=order.getQty();
        this.description=order.getDescription();
    }
}
