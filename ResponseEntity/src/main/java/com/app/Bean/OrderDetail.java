package com.app.Bean;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orderdetails")
public class OrderDetail implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long orderdetailid;
  private Double orderdetailprice;
  private Integer quantity;
  private Boolean status;
  @ManyToOne @JoinColumn(name="productid")
  Product product;
  @ManyToOne @JoinColumn(name="orderid")
  Order order;
}
