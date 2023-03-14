package com.app.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.Bean.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
//	@Query(value = "select p from Product p where p.productprice between ?1 and ?2")
//	public List<Product> searchByPrice(double minPrice, double maxPrice);
	
	//Cach 2
	List<Product> findByProductpriceBetween(double minPrice, double maxPrice);

//	@Query("select p from Product p where p.productname like ?1")
//	Page<Product> searchByName(String keyWords, Pageable pageble);
	
	//Cach 2
	Page<Product> findAllByProductnameLike(String keyWords, Pageable pageable);
	
	
	//de tam o muc ban chay la tat ca san pham
	
	Page<Product> findAll(Pageable pageable);
	
	//xem san pham theo loai
	@Query(value = "select p from Product p where p.category.categoryid = ?1 ")
	public Page<Product> xemTheoLoai(String categoryId, Pageable pageable);
	
	//Tim kiem san pham theo ten hoac id
	@Query(value = "select p from Product p where p.productname like ?1 and p.category.categoryid = ?2 ")
	public Page<Product> timTheoTen(String name,String categoryId, Pageable pageable);
	
	
//
//	@Query("select new com.example.demo.Model.Report(p.category.categoryid,sum(p.productprice),count(p))" + " from Product p" + " group by p.category.categoryid"
//			+ " order by sum(p.productprice) DESC")
//	List<Report> getInventoryByCategory();

}
