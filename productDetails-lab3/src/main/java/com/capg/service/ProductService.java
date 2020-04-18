package com.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Product;
import com.capg.repo.ProductRepo;
@Service
public class ProductService {
	@Autowired
	ProductRepo  productRepo;
	public List<Product> findAll()
	{
		return productRepo.findAll();
	}
    
	public Product getOne(int productId)
	{
        return productRepo.getOne(productId);
	}
	
	@Transactional
	public Product save(Product product)
	{
		return productRepo.save(product);
	}
	
	@Transactional
	public boolean deleteById(int productId)
	{
		productRepo.deleteById(productId);
		return !productRepo.existsById(productId);
	}
	
	@Transactional
	public Product updateProduct(Product newProduct)
	{
		Product oldProduct=getOne(newProduct.getProductId());
		oldProduct.setProductName(newProduct.getProductName());
		oldProduct.setPrice(newProduct.getPrice());
		productRepo.save(oldProduct);
		return oldProduct;
	}

}
