package com.app.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderid;
	private String address;
	private String sdt;
	private Boolean status;
	private Integer soluong;
	private double tongtien;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="ordercreatedate")
	Date ordercreatedate = new Date();
	@ManyToOne@JoinColumn(name="username")
	Account account;
	
	@JsonIgnore
	@OneToMany(mappedBy="order")
	List<OrderDetail> orderdetails;
}
