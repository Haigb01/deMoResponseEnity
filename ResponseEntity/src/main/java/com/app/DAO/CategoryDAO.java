package com.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Bean.Category;


public interface CategoryDAO extends JpaRepository<Category, String>{

	
	
}
