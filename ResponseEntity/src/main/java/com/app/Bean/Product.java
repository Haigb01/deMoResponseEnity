package com.app.Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
@Table(name="products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer productid;
	String productname;
	String productimage;
	
	Double productprice;
	@Temporal(TemporalType.DATE)
	@Column(name="productcreatedate")
	Date productcreatedate = new Date();
	Boolean available;
	@ManyToOne @JoinColumn(name="categoryid")
	Category category;
	//sử dụng JsonIgnore đối với tất cả các mối quan hệ OneToMany
	//để ngăn chặn truy suất ( kiểu bỏ qua cái phần dưới )
	// khi trả về json thì không quan tâm cái field này ( ở đây là orderdetails)
	@JsonIgnore
	@OneToMany(mappedBy="product")
	List<OrderDetail> orderdetails;
	
	
}
