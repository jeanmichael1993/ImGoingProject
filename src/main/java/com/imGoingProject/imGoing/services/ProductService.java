package com.imGoingProject.imGoing.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imGoingProject.imGoing.DTO.CategoryDTO;
import com.imGoingProject.imGoing.DTO.ProductCategoriesDTO;
import com.imGoingProject.imGoing.DTO.ProductDTO;
import com.imGoingProject.imGoing.DTO.UserDTO;
import com.imGoingProject.imGoing.Repositories.CategoryRepository;
import com.imGoingProject.imGoing.Repositories.ProductRepository;
import com.imGoingProject.imGoing.entities.Category;
import com.imGoingProject.imGoing.entities.Product;
import com.imGoingProject.imGoing.entities.User;
import com.imGoingProject.imGoing.services.exceptions.DatabaseException;
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

	//criado novo metodo para auxiliar o insert
	private void setProductCategories(Product entity, List<CategoryDTO> categories) {
		entity.getCategories().clear();
		for(CategoryDTO  dto : categories) {
			Category category = categoryRepository.getOne(dto.getId());
			entity.getCategories().add(category);
			}
	}
	
	public void deleted(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductCategoriesDTO dto) {
		try {
			Product entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, ProductCategoriesDTO dto) {
	 entity.setName(dto.getName());
	 entity.setDescription(dto.getDescription());
	 entity.setPrice(dto.getPrice());
	 entity.setImgUrl(dto.getImgUrl());
	 if(dto.getCategories() != null && dto.getCategories().size()>0) {
		 setProductCategories(entity, dto.getCategories());
	 }
		
	}
	
}
