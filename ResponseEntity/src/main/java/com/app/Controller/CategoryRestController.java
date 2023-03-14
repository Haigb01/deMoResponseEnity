package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Bean.Category;
import com.app.DAO.CategoryDAO;

@CrossOrigin("*")
@RestController
public class CategoryRestController {
	@Autowired
	CategoryDAO dao;

	@RequestMapping("/")
	public String index() {
		List<Category> list = dao.findAll();
		list.forEach(item -> System.out.println(item.getCategoryid()));
		return "";
	}

	@GetMapping("/rest/categories")
	public ResponseEntity<List<Category>> getAll(Model model) {
		return ResponseEntity.ok(dao.findAll());
	}

	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Category> geOne(@PathVariable("id") String id) {
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok(dao.findById(id).get());
	}

	@PostMapping("/rest/categories")
	public ResponseEntity<Category> post(@RequestBody Category category) {
		if (dao.existsById(category.getCategoryid())) {
			return ResponseEntity.badRequest().build();

		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}

	@PutMapping("/rest/categories/{id}")
	public ResponseEntity<Category> put(@PathVariable("id") String id, @RequestBody Category category) {
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();

		}
		dao.save(category);
		return ResponseEntity.ok(category);
	}

	@DeleteMapping("/rest/categories/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		if (!dao.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		dao.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
