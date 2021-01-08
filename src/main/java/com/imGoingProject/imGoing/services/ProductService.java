package com.imGoingProject.imGoing.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imGoingProject.imGoing.DTO.CategoryDTO;
import com.imGoingProject.imGoing.DTO.ProductCategoriesDTO;
import com.imGoingProject.imGoing.DTO.ProductDTO;
import com.imGoingProject.imGoing.Repositories.CategoryRepository;
import com.imGoingProject.imGoing.Repositories.ProductRepository;
import com.imGoingProject.imGoing.entities.Category;
import com.imGoingProject.imGoing.entities.Product;
import com.imGoingProject.imGoing.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findAll() {
		List<Product> list =  repository.findAll();
		return list.stream().map(e -> new ProductDTO(e)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new ProductDTO(entity);
	}
	
	//metodo executado de forma total
	@Transactional
	public ProductDTO insert(ProductCategoriesDTO dto) {
		Product entity = dto.toEntity();
		setProductCategories(entity, dto.getCategories());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	private void setProductCategories(Product entity, List<CategoryDTO> categories) {
		entity.getCategories().clear();
		for(CategoryDTO  dto : categories) {
			Category category = categoryRepository.getOne(dto.getId());
			entity.getCategories().add(category);
			}
	}
	
}
